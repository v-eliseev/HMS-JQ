insert into system_user (`password`,username) values ("password","superuser");

insert into sec_role(authority, date_created, last_updated) values('ROLE_ADMIN', now(), now());
insert into sec_role(authority, date_created, last_updated) values('ROLE_USER', now(), now());