/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Maytopacka
 */
public class test_barcodes {
    public static void main(String[] args) {
         String barcode="a";
         String[] aw=barcode.split(",", barcode.length());
         for(String s:aw){
             System.out.println(s);
         }
    }
    public static void main2(String[] args) {
        String barcode="a,aaa,a";
       
        List<String> stop=new ArrayList();
        int i=0;
        for(i=0;i<barcode.length();i++){
             String charac=""+barcode.charAt(i);
            if(charac.equals(",")){
                stop.add(""+i);
            }       
        }
         String new_code="";
         int end=0;
         int o=0;
         for(String s:stop){
            if(end==0){
                 new_code=barcode.substring(end, FitIn.toInt(s));
            }else{
                 new_code=barcode.substring(end+1, FitIn.toInt(s));
            }           
            System.out.println(new_code);
            end=FitIn.toInt(s);
//             System.out.println(end);
            o++;
        }
         if(o!=0){
             new_code=barcode.substring(end+1, barcode.length());
             System.out.println(new_code);
         }else{
             if(barcode.length()!=0){
                 new_code=barcode.substring(0, barcode.length());
                 System.out.println(new_code);
             }
         }
        
    }
}
