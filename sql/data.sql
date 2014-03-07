insert into system_user (`password`,username) values ("password","superuser");

insert into sec_role(authority, date_created, last_updated) values('ROLE_ADMIN', now(), now());
insert into sec_role(authority, date_created, last_updated) values('ROLE_USER', now(), now());

insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/index.gsp', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/index', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/**/assets/**', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/**/favicon.ico', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/login', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/login.*', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/login/*', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/logout', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/logout.*', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/logout/*', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/superuser/**', 'permitAll', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/user/**', 'ROLE_USER', null, now(), now());
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated) values ('/admin/**', 'ROLE_ADMIN', null, now(), now());
