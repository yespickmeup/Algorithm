

update sale_items st set st.status=(select s.status from sales s where s.sales_no=st.sales_no);
