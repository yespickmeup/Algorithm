/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Mar 4, 2020
 */



/*  update refreshment items */


update cash_drawer  set time_out = (select time_out from cash_drawer  where id>c.id limit 1) 
where cd.time_out is null;


update cash_drawer as  cd1, cash_drawer as cd2 
    set cd1.time_out = (select cd2.time_out from cash_drawer as cd2 where cd2.id>cc1.id limit 1) 
where cd1.time_out is null;

