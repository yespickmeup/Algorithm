

/* */
drop table if exists main_branch_query_uploads;
create table main_branch_query_uploads(
id int auto_increment primary key
,branch_query longtext
,query_module varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,date_added datetime
,status int
);


