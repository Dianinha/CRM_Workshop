INSERT INTO `priorities` VALUES (1,'','Low'),(2,'','Medium'),(3,'\0','High'),(4,'','Bug'),(5,'','Blocking'),(6,'','High'),(7,'','Error'),(8,'','Very low');
INSERT INTO `projects` VALUES (1,'2018-01-26 19:14:56.340000','My webpage','dianinha-page','','Dianinha page','https://dianinhapage.com'),(2,'2018-01-26 19:15:21.650000','Give food to the people. No taxes','food-to-the-people','','Food To the people','http://sheerwoodforest.com');
INSERT INTO `statuses` VALUES (1,'','Not approved',1),(2,'','Approved',2),(3,'','To do',3),(4,'','Done',4),(5,'','In review',5),(6,'','Send for corrections',6),(7,'','Done reviewing',7),(8,'','Abandoned',8);
INSERT INTO `crm2`.`userRoles` (`role`) VALUES ('ROLE_ADMIN');
INSERT INTO `crm2`.`userRoles` (`role`) VALUES ('ROLE_USER');
INSERT INTO `users` VALUES (1,'dianinha','Diana','$2a$10$ra9NU4gw6lwPw6bY/Ymz1eRopQZMlJypBzK5U0k7awrQ7UcI1dKRq','Wiszowata', 2),(2,'robinHood','Robin','$2a$10$XFFz13TGRq5L7NB1nt54suxm2wALHSLaPZ4PkrcgTpOt/G7FWeo1i','Hood', 2),(3,'admin','Admin','$2a$10$x/ejXuDpqYnebFMM6Hpx9O14UT/nzB1M6xzhdkL8cX4Cl2fACvjQy','Very Admin', 1);
INSERT INTO `crm2`.`projects_users` (`projects_id`, `users_id`) VALUES ('1', '3');
INSERT INTO `crm2`.`projects_users` (`projects_id`, `users_id`) VALUES ('2', '3');

