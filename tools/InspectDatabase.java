import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;

/** Metadata-only inspection. Never prints credentials or application rows. */
public class InspectDatabase {
    static Properties defaults = new Properties();
    static PrintWriter status;
    static String clean(String s) { return s == null ? "" : s.replace("\t", " ").replace("\r", " ").replace("\n", " "); }
    static Connection connect(Properties p, String prefix) throws Exception {
        String host=p.getProperty(prefix+"host", "localhost");
        String port=p.getProperty(prefix+"port", "3306");
        String db=p.getProperty(prefix+"db", "db_smis");
        Properties auth=new Properties();
        auth.setProperty("user",p.getProperty(prefix+"user", "root"));
        auth.setProperty("password",p.getProperty(prefix+"password", ""));
        Connection c=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?connectTimeout=10000&socketTimeout=20000&zeroDateTimeBehavior=convertToNull", auth);
        c.setReadOnly(true);
        return c;
    }
    static void dump(Connection c,String label,String db,String name,String sql) throws Exception {
        try (PreparedStatement s=c.prepareStatement(sql)) {
            s.setString(1,db); s.setQueryTimeout(20);
            try(ResultSet r=s.executeQuery(); PrintWriter w=new PrintWriter("docs/"+label+"-"+name+".tsv","UTF-8")) {
                int n=r.getMetaData().getColumnCount();
                for(int i=1;i<=n;i++) w.print((i>1?"\t":"")+r.getMetaData().getColumnLabel(i)); w.println();
                int rows=0;
                while(r.next()) { for(int i=1;i<=n;i++) w.print((i>1?"\t":"")+clean(r.getString(i))); w.println(); rows++; }
                status.println(label+" "+name+": "+rows+" metadata rows");
            }
        }
    }
    static void inspect(Connection c,String label,String db) throws Exception {
        status.println(label+" database: "+db);
        status.println(label+" server: "+c.getMetaData().getDatabaseProductVersion());
        dump(c,label,db,"tables","SELECT TABLE_NAME,TABLE_TYPE,ENGINE,TABLE_ROWS,TABLE_COLLATION FROM information_schema.TABLES WHERE TABLE_SCHEMA=? ORDER BY TABLE_NAME");
        dump(c,label,db,"columns","SELECT TABLE_NAME,ORDINAL_POSITION,COLUMN_NAME,COLUMN_TYPE,IS_NULLABLE,COLUMN_KEY,EXTRA FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=? ORDER BY TABLE_NAME,ORDINAL_POSITION");
        dump(c,label,db,"indexes","SELECT TABLE_NAME,INDEX_NAME,NON_UNIQUE,SEQ_IN_INDEX,COLUMN_NAME,SUB_PART FROM information_schema.STATISTICS WHERE TABLE_SCHEMA=? ORDER BY TABLE_NAME,INDEX_NAME,SEQ_IN_INDEX");
        dump(c,label,db,"foreign-keys","SELECT TABLE_NAME,CONSTRAINT_NAME,COLUMN_NAME,REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_SCHEMA=? AND REFERENCED_TABLE_NAME IS NOT NULL ORDER BY TABLE_NAME,CONSTRAINT_NAME,ORDINAL_POSITION");
    }
    static void failure(String label,Exception e) {
        status.println(label+" FAILED: "+e.getClass().getSimpleName()+(e instanceof SQLException?" SQLState="+((SQLException)e).getSQLState()+" code="+((SQLException)e).getErrorCode():""));
        status.flush();
    }
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String source=new String(Files.readAllBytes(Paths.get("src/POS/util/MyConnection.java")),StandardCharsets.UTF_8);
        Matcher m=Pattern.compile("System\\.getProperty\\(\"((?:pool|cloud)_[^\"]+)\",\\s*\"([^\"]*)\"\\)").matcher(source);
        while(m.find()) if(!defaults.containsKey(m.group(1))) defaults.setProperty(m.group(1),m.group(2));
        String main=new String(Files.readAllBytes(Paths.get("src/POS/main/MyMain.java")),StandardCharsets.UTF_8);
        m=Pattern.compile("prop\\.getProperty\\(\"(pool_[^\"]+)\",\\s*\"([^\"]*)\"\\)").matcher(main);
        while(m.find()) defaults.setProperty(m.group(1),m.group(2));
        Properties local=new Properties(defaults);
        File config=args.length>0?new File(args[0]):new File(System.getProperty("user.home"),"my_config.conf");
        if(!config.exists()) config=new File("my_config.conf");
        try(InputStream in=new FileInputStream(config)) { local.load(in); }
        status=new PrintWriter("docs/database-inspection-status.txt","UTF-8");
        status.println("Inspected: "+new java.util.Date());
        status.println("Config: "+config.getAbsolutePath());
        Properties cloud=new Properties();
        try(Connection c=connect(local,"pool_")) {
            inspect(c,"local",local.getProperty("pool_db"));
            try(Statement s=c.createStatement();ResultSet r=s.executeQuery("SELECT cloud_host,cloud_port,cloud_user,cloud_password,cloud_db FROM settings LIMIT 1")) {
                if(r.next()) for(String k:new String[]{"host","port","user","password","db"}) cloud.setProperty("cloud_"+k,r.getString("cloud_"+k)==null?"":r.getString("cloud_"+k));
            }
        } catch(Exception e) { failure("local",e); }
        if(!cloud.containsKey("cloud_host")) status.println("cloud SKIPPED: active settings unavailable; no fallback endpoint assumed");
        else {
            status.println("cloud endpoint: "+clean(cloud.getProperty("cloud_host"))+":"+clean(cloud.getProperty("cloud_port")));
            try(Connection c=connect(cloud,"cloud_")) { inspect(c,"cloud",cloud.getProperty("cloud_db")); }
            catch(Exception e) { failure("cloud",e); }
        }
        status.close();
    }
}
