
alter table cash_drawer add user_id varchar(100);
alter table cash_drawer add user_screen_name varchar(100);

update cash_drawer c set c.user_id=(select u.id from users u where u.user_name=c.user_name);
update cash_drawer c set c.user_screen_name=(select u.screen_name from users u where u.user_name=c.user_name);


update cash_drawer set branch="Dumaguete", branch_id="12", location="Selling Area", location_id="24";

alter table sale_item_replacements add reason text;

