insert into system_user (`password`, username, date_created, last_updated, version) values ("password", "superuser", now(), now(), 0);

insert into sec_role(authority, date_created, last_updated, version) values('ROLE_ADMIN', now(), now(), 0);
insert into sec_role(authority, date_created, last_updated, version) values('ROLE_USER', now(), now(), 0);

insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/index.gsp', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/index', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/**/assets/**', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/**/fonts/**', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/**/js/**', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/**/favicon.ico', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/login', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/login.*', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/login/*', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/logout', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/logout.*', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/logout/*', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/superuser/**', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/user/**', 'ROLE_USER', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/admin/**', 'ROLE_ADMIN', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/monitoring', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/monitoring.*', 'permitAll', null, now(), now(), 0);
insert into sec_request_map(url, config_attribute, http_method, date_created, last_updated, version) values ('/monitoring/*', 'permitAll', null, now(), now(), 0);
