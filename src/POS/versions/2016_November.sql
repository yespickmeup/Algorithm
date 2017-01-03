/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  synsoftech
 * Created: 11 23, 16
 */



alter table household_members add local_id int default 0 after id;
alter table household_members add cloud_id int default 0 after local_id;

alter table household_member_competence_certificates add local_id int default 0 after id;
alter table household_member_competence_certificates add cloud_id int default 0 after local_id;

alter table household_member_educational_backgrounds add local_id int default 0 after id;
alter table household_member_educational_backgrounds add cloud_id int default 0 after local_id;

alter table household_member_educational_backgrounds add local_id int default 0 after id;
alter table household_member_educational_backgrounds add cloud_id int default 0 after local_id;



alter table household_members drop local_id;
alter table household_members drop cloud_id;

alter table household_member_competence_certificates drop local_id;
alter table household_member_competence_certificates drop cloud_id;

alter table household_member_educational_backgrounds drop local_id;
alter table household_member_educational_backgrounds drop cloud_id;

alter table household_member_educational_backgrounds drop local_id;
alter table household_member_educational_backgrounds drop cloud_id;
