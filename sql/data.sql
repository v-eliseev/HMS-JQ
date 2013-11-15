insert into system_user (version,`password`,username) values (0,"password","superuser");

insert into sec_role(authority) values('ROLE_ADMIN');
insert into sec_role(authority) values('ROLE_USER');