delete from customer;
delete from rate_code;
delete from room;
delete from room_category_room_feature;
delete from room_feature;
delete from room_category;
delete from rate_code;
delete from article_package_article;
delete from article_package;
delete from article;
delete from article_group;
delete from tax_code;
delete from hotel;
delete from reservation_motive;
delete from distribution_channel;
delete from reservation_status;

insert into room_feature (id, name, short_description, description, date_created, last_updated) values (1, "Hair-dryer", "Excellent hair-dryer", "I don not know what to put here", now(), now());

insert into room_category(id, name, short_description, description, is_bookable_online, date_created, last_updated) values (1, "Standard", "Standard twin bed room", "Standard twin bed room with bathroom", true, now(), now());
insert into room_category(id, name, short_description, description, is_bookable_online, date_created, last_updated) values (2, "Suite", "Luxury double bed room", "Luxury double bed room with bathroom", true, now(), now());
insert into room_category(id, name, short_description, description, is_bookable_online, date_created, last_updated) values (3, "President apartments", "King size double bed room", "Superior King size double bed room with bathroom and a balcony", false, now(), now());

insert into room_category_room_feature(room_category_room_features_id, room_feature_id) values (3 ,1);

insert into rate_code(id, name, short_description, description, date_created, last_updated) values (1, "Normal rate", "", "", now(), now());

insert into room(id, name, room_category_id, description, max_occupants, date_created, last_updated) values (1, "Room 401", 1, "", 2, now(), now());

insert into tax_code(id, name, amount_text, description, value, units, date_created, last_updated) values (1, "VAT 18%", "18%", "Normal VAT", 18, "%", now(), now());

insert into article_group(id, name, date_created, last_updated) values (1, "Outdoor", now(), now());

insert into article(id, number, name, description, is_bookable_online, price, article_group_id, tax_code_id, date_created, last_updated) values (1, "31002", "Moutain bike", "27-speed mountain bike", true, 50, 1, 1, now(), now());
insert into article(id, number, name, description, is_bookable_online, price, article_group_id, tax_code_id, date_created, last_updated) values (2, "31003", "Street bike", "Ordinary street bike", true, 10, 1, 1, now(), now());
insert into article(id, number, name, description, is_bookable_online, price, article_group_id, tax_code_id, date_created, last_updated) values (3, "32001", "Helmet", "", true, 10, 1, 1, now(), now());

insert into article_package(id, number, name, description, article_group_id, is_bookable_online, date_created, last_updated) values (1, "PK001", "Bike set", "", 1, true, now(), now());

insert into article_package_article(article_package_articles_id, article_id) values (1, 1);
insert into article_package_article(article_package_articles_id, article_id) values (1, 3);

insert into hotel(id, name, phone, fax, e_mail, web_site, registration_nr, tax_nr, bank_name, bank_code, account_nr, biccode, iban, country_code, invoice_prefix, invoice_start_id, invoice_suffix) values (1, "My Hotel", "123-45-67-89", "987-65-43-21","aa@bb.cc", "http://www.bb.cc", "993279938", "7748399256-AQ", "The Bank",	"BNK", "9848990293664",	"67432", "THEBANK",	"RU", "Inv.2012-", "35", "");

insert into rate_code(id, name, short_description, description, date_created, last_updated) values (1, "Standard", "Normal rate", "Normal rate applied diring low season",  now(), now());
insert into customer(id, name, salutation, phoneNr, faxNr, eMail, address_type, address1, address2, address3, zipCode, city, country, company, dob, carLicensePlate, passportNr,  date_created, last_updated) values (1, "Moriarti", "Prof.", "32-0270-2266", "32-0270-2267", "moriarti@univerity.com", "Private", "Reichenbach", "Wasserfall", "Jaegerhaus", "3216", "Reichenbach", "Austria", "XX", "22.04.1870", "L35XF178", "32554872", 1, now(), now());

insert into reservation_motive(id, name, short_description, description, date_created, last_updated) values (1, "Business", "Business trip", "Business trip"), now(), now();

insert into distribution_channel(id, name, short_description, description, date_created, last_updated) values (1, "Phone", "Phone call", "Phone call"), now(), now();

insert into reservation_status(id, name, short_description, description, color_code, is_active, date_created, last_updated) values (1, "New", "", "", "0x00FF00", true, now(), now());
insert into reservation_status(id, name, short_description, description, color_code, is_active, date_created, last_updated) values (1, "Assigned", "", "", "0x0000FF", true, now(), now());
insert into reservation_status(id, name, short_description, description, color_code, is_active, date_created, last_updated) values (1, "Cancelled", "", "", "0x999999", true, now(), now());
