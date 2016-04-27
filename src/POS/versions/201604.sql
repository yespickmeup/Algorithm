/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Apr 26, 2016
 */

SELECT count(*), transaction_no
FROM my_services
GROUP BY transaction_no
HAVING COUNT(*) > 1;

