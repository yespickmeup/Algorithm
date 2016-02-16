drop table if exists main_branch_query_uploads;
create table main_branch_query_uploads(
id int auto_increment primary_key
,query longtext
,query_module varchar(255)
,from_branch_id varchar(255);
,from_branch varchar(255)
,to_branch_id varchar(255)
,to_branch varchar(255)
,date_added datetime
,status int
);


update sale_items st set st.status=(select s.status from sales s where s.sales_no=st.sales_no);
