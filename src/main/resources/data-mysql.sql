insert into user_info (id,username,password,telephone,entry_date,isadmin) values(1,'总裁','e10adc3949ba59abbe56e057f20f883e','13811111111',CURRENT_TIMESTAMP(),1);
insert into user_info (id,username,password,telephone,entry_date,isadmin) values(2,'总监','e10adc3949ba59abbe56e057f20f883e','13822222222',CURRENT_TIMESTAMP(),1);
insert into user_info (id,username,password,telephone,entry_date,isadmin) values(3,'经理','e10adc3949ba59abbe56e057f20f883e','13833333333',CURRENT_TIMESTAMP(),1);
insert into user_info (id,username,password,telephone,entry_date,isadmin) values(4,'员工','e10adc3949ba59abbe56e057f20f883e','13844444444',CURRENT_TIMESTAMP(),1);

insert into role(id,name) values(1,'总裁');
insert into role(id,name) values(2,'总监');
insert into role(id,name) values(3,'经理');
insert into role(id,name) values(4,'员工');

insert into urls(id,name,link_url) values(1,'查询用户','/user/list');
insert into urls(id,name,link_url) values(2,'新增用户','/user/add');
insert into urls(id,name,link_url) values(3,'删除用户','/user/del');
insert into urls(id,name,link_url) values(4,'修改用户','/user/mod');

insert into user_role(id,userid,roleid) values(1,1,1);
insert into user_role(id,userid,roleid) values(2,2,2);
insert into user_role(id,userid,roleid) values(3,3,3);
insert into user_role(id,userid,roleid) values(4,4,4);

insert into user_urls(id,userid,urlsid) values(1,1,1);
insert into user_urls(id,userid,urlsid) values(2,1,2);
insert into user_urls(id,userid,urlsid) values(3,1,3);
insert into user_urls(id,userid,urlsid) values(4,1,4);
insert into user_urls(id,userid,urlsid) values(5,2,1);
insert into user_urls(id,userid,urlsid) values(6,2,2);
insert into user_urls(id,userid,urlsid) values(7,2,4);
insert into user_urls(id,userid,urlsid) values(8,3,1);
insert into user_urls(id,userid,urlsid) values(9,3,2);
insert into user_urls(id,userid,urlsid) values(10,4,1);

insert into role_urls(id,roleid,urlsid) values(1,1,1);
insert into role_urls(id,roleid,urlsid) values(2,1,2);
insert into role_urls(id,roleid,urlsid) values(3,1,3);
insert into role_urls(id,roleid,urlsid) values(4,1,4);
insert into role_urls(id,roleid,urlsid) values(5,2,1);
insert into role_urls(id,roleid,urlsid) values(6,2,2);
insert into role_urls(id,roleid,urlsid) values(7,2,4);
insert into role_urls(id,roleid,urlsid) values(8,3,1);
insert into role_urls(id,roleid,urlsid) values(9,3,2);
insert into role_urls(id,roleid,urlsid) values(10,4,1);