
    alter table article 
        drop 
        foreign key FKD458CCF61FC6652D;

    alter table article 
        drop 
        foreign key FKD458CCF6196A4E51;

    alter table article_package 
        drop 
        foreign key FK5B0451FD1FC6652D;

    alter table article_package_article 
        drop 
        foreign key FKA6AD78B46C813FA;

    alter table article_package_article 
        drop 
        foreign key FKA6AD78B42D0A478B;

    alter table configuration 
        drop 
        foreign key FK733374F6960FF545;

    alter table confirmation_request 
        drop 
        foreign key FK6BDC2085DEBACC1A;

    alter table customer 
        drop 
        foreign key FK24217FDE2DD86A79;

    alter table domain_hotel_class 
        drop 
        foreign key FK618FE4327BC5733A;

    alter table license 
        drop 
        foreign key FK9F084417BC5733A;

    alter table license 
        drop 
        foreign key FK9F08441F04B5EDA;

    alter table reservation 
        drop 
        foreign key FKA2D543CC7BC5733A;

    alter table reservation 
        drop 
        foreign key FKA2D543CC6E652391;

    alter table reservation 
        drop 
        foreign key FKA2D543CC4F6D0966;

    alter table room 
        drop 
        foreign key FK3580DB6E652391;

    alter table room_category 
        drop 
        foreign key FK273633E27BC5733A;

    alter table room_category_room_features 
        drop 
        foreign key FK3EC2ED845A101C83;

    alter table room_category_room_features 
        drop 
        foreign key FK3EC2ED846E652391;

    alter table sec_user 
        drop 
        foreign key FK375DF2F9DEBACC1A;

    alter table sec_user_role 
        drop 
        foreign key FK7DE039FCF0E53165;

    alter table sec_user_role 
        drop 
        foreign key FK7DE039FC960FF545;

    drop table if exists article;

    drop table if exists article_group;

    drop table if exists article_package;

    drop table if exists article_package_article;

    drop table if exists cancellation_reason;

    drop table if exists configuration;

    drop table if exists confirmation_request;

    drop table if exists customer;

    drop table if exists distribution_channel;

    drop table if exists domain_hotel_class;

    drop table if exists event_log_item;

    drop table if exists hotel;

    drop table if exists license;

    drop table if exists license_user;

    drop table if exists owner;

    drop table if exists rate_code;

    drop table if exists reservation;

    drop table if exists reservation_motive;

    drop table if exists reservation_status;

    drop table if exists reservation_type;

    drop table if exists room;

    drop table if exists room_category;

    drop table if exists room_category_room_features;

    drop table if exists room_feature;

    drop table if exists sec_role;

    drop table if exists sec_user;

    drop table if exists sec_user_role;

    drop table if exists system_user;

    drop table if exists tax_code;

    create table article (
        id bigint not null auto_increment,
        version bigint not null,
        article_group_id bigint,
        date_created datetime not null,
        description varchar(255),
        is_bookable_online boolean not null,
        last_updated datetime not null,
        name varchar(255) not null,
        number varchar(255) not null,
        price double precision not null,
        tax_code_id bigint,
        primary key (id)
    );

    create table article_group (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        last_updated datetime not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table article_package (
        id bigint not null auto_increment,
        version bigint not null,
        article_group_id bigint not null,
        date_created datetime not null,
        description varchar(255),
        is_bookable_online boolean not null,
        last_updated datetime not null,
        name varchar(255) not null,
        number varchar(255) not null,
        primary key (id)
    );

    create table article_package_article (
        article_package_articles_id bigint,
        article_id bigint
    );

    create table cancellation_reason (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        description varchar(255) not null,
        last_updated datetime not null,
        name varchar(255) not null,
        short_description varchar(255) not null,
        primary key (id)
    );

    create table configuration (
        id bigint not null auto_increment,
        version bigint not null,
        `key` varchar(255) not null,
        user_id bigint not null,
        `value` varchar(255),
        primary key (id)
    );

    create table confirmation_request (
        id bigint not null auto_increment,
        version bigint not null,
        data varchar(255) not null,
        date_created datetime not null,
        expires datetime not null,
        last_updated datetime not null,
        license_id bigint not null,
        type integer not null,
        uuid varchar(255) not null,
        primary key (id)
    );

    create table customer (
        id bigint not null auto_increment,
        version bigint not null,
        address1 varchar(255) not null,
        address2 varchar(255) not null,
        address3 varchar(255) not null,
        address_type varchar(255) not null,
        car_license_plate varchar(255) not null,
        city varchar(255) not null,
        company varchar(255) not null,
        country varchar(255) not null,
        date_created datetime not null,
        default_rate_code_id bigint not null,
        dob datetime,
        e_mail varchar(255) not null,
        fax_nr varchar(255) not null,
        last_updated datetime not null,
        name varchar(255) not null,
        passport_nr varchar(255) not null,
        phone_nr varchar(255) not null,
        salutation varchar(255) not null,
        zip_code varchar(255) not null,
        primary key (id)
    );

    create table distribution_channel (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        description varchar(255) not null,
        last_updated datetime not null,
        name varchar(255) not null,
        short_description varchar(255) not null,
        primary key (id)
    );

    create table domain_hotel_class (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        hotel_id bigint not null,
        last_updated datetime not null,
        primary key (id)
    );

    create table event_log_item (
        id bigint not null auto_increment,
        version bigint not null,
        notes varchar(255) not null,
        timestamp datetime not null,
        type tinyblob not null,
        primary key (id)
    );

    create table hotel (
        id bigint not null auto_increment,
        version bigint not null,
        account_nr varchar(255),
        bank_code varchar(255),
        bank_name varchar(255),
        bic_code varchar(255),
        country_code varchar(255),
        date_created datetime not null,
        e_mail varchar(255),
        fax varchar(255),
        iban varchar(255),
        invoice_prefix varchar(255),
        invoice_start_id varchar(255),
        invoice_suffix varchar(255),
        last_updated datetime not null,
        name varchar(255),
        phone varchar(255),
        registration_nr varchar(255),
        tax_nr varchar(255),
        web_site varchar(255),
        primary key (id)
    );

    create table license (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        demo_mode boolean not null,
        email varchar(255),
        expires datetime,
        hotel_id bigint,
        issued datetime,
        `key` varchar(255) not null,
        last_updated datetime not null,
        owner_id bigint,
        primary key (id)
    );

    create table license_user (
        id bigint not null auto_increment,
        version bigint not null,
        account_expired boolean not null,
        account_locked boolean not null,
        date_created datetime not null,
        enabled boolean not null,
        last_updated datetime not null,
        `password` varchar(44) not null,
        password_expired boolean not null,
        salt varchar(64) not null,
        username varchar(50) not null,
        primary key (id)
    );

    create table owner (
        id bigint not null auto_increment,
        version bigint not null,
        address1 varchar(255) not null,
        address2 varchar(255) not null,
        city varchar(255) not null,
        country varchar(255) not null,
        date_created datetime not null,
        firstname varchar(255) not null,
        last_updated datetime not null,
        lastname varchar(255) not null,
        phone varchar(255) not null,
        state varchar(255) not null,
        zip varchar(255) not null,
        primary key (id)
    );

    create table rate_code (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        description varchar(255) not null,
        last_updated datetime not null,
        name varchar(255) not null,
        short_description varchar(255) not null,
        primary key (id)
    );

    create table reservation (
        id bigint not null auto_increment,
        version bigint not null,
        adults integer not null,
        date_created datetime not null,
        from_date datetime not null,
        hotel_id bigint not null,
        last_updated datetime not null,
        notes varchar(255),
        room_category_id bigint not null,
        status_id bigint not null,
        to_date datetime not null,
        primary key (id)
    );

    create table reservation_motive (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        description varchar(255) not null,
        last_updated datetime not null,
        name varchar(255) not null,
        short_description varchar(255) not null,
        primary key (id)
    );

    create table reservation_status (
        id bigint not null auto_increment,
        version bigint not null,
        code varchar(12) not null,
        color_code varchar(255),
        date_created datetime not null,
        description varchar(255),
        is_active boolean,
        last_updated datetime not null,
        short_description varchar(255),
        primary key (id)
    );

    create table reservation_type (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        description varchar(255) not null,
        is_active boolean not null,
        last_updated datetime not null,
        name varchar(255) not null,
        short_name varchar(255) not null,
        primary key (id)
    );

    create table room (
        id bigint not null auto_increment,
        version bigint not null,
        adults integer not null,
        date_created datetime not null,
        description varchar(255),
        last_updated datetime not null,
        name varchar(255) not null,
        room_category_id bigint not null,
        primary key (id)
    );

    create table room_category (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        description varchar(255),
        hotel_id bigint not null,
        is_bookable_online boolean not null,
        last_updated datetime not null,
        name varchar(255) not null,
        short_description varchar(255),
        primary key (id)
    );

    create table room_category_room_features (
        room_category_id bigint not null,
        room_feature_id bigint not null,
        primary key (room_category_id, room_feature_id)
    );

    create table room_feature (
        id bigint not null auto_increment,
        version bigint not null,
        date_created datetime not null,
        description varchar(255) not null,
        last_updated datetime not null,
        name varchar(255) not null,
        short_description varchar(255) not null,
        primary key (id)
    );

    create table sec_role (
        id bigint not null auto_increment,
        version bigint not null,
        authority varchar(255) not null,
        date_created datetime not null,
        last_updated datetime not null,
        primary key (id)
    );

    create table sec_user (
        id bigint not null auto_increment,
        version bigint not null,
        account_expired boolean not null,
        account_locked boolean not null,
        date_created datetime not null,
        email varchar(255) not null,
        enabled boolean not null,
        expire_account datetime,
        expire_password datetime,
        last_updated datetime not null,
        license_id bigint not null,
        `password` varchar(255) not null,
        password_expired boolean not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table sec_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    create table system_user (
        id bigint not null auto_increment,
        version bigint not null,
        `password` varchar(255) not null,
        realm_code bigint,
        username varchar(255) not null,
        primary key (id)
    );

    create table tax_code (
        id bigint not null auto_increment,
        version bigint not null,
        amount_text varchar(255) not null,
        date_created datetime not null,
        description varchar(255) not null,
        last_updated datetime not null,
        name varchar(255) not null,
        units varchar(255) not null,
        `value` double precision not null,
        primary key (id)
    );

    alter table article 
        add index FKD458CCF61FC6652D (article_group_id), 
        add constraint FKD458CCF61FC6652D 
        foreign key (article_group_id) 
        references article_group (id);

    alter table article 
        add index FKD458CCF6196A4E51 (tax_code_id), 
        add constraint FKD458CCF6196A4E51 
        foreign key (tax_code_id) 
        references tax_code (id);

    alter table article_package 
        add index FK5B0451FD1FC6652D (article_group_id), 
        add constraint FK5B0451FD1FC6652D 
        foreign key (article_group_id) 
        references article_group (id);

    alter table article_package_article 
        add index FKA6AD78B46C813FA (article_id), 
        add constraint FKA6AD78B46C813FA 
        foreign key (article_id) 
        references article (id);

    alter table article_package_article 
        add index FKA6AD78B42D0A478B (article_package_articles_id), 
        add constraint FKA6AD78B42D0A478B 
        foreign key (article_package_articles_id) 
        references article_package (id);

    alter table configuration 
        add index FK733374F6960FF545 (user_id), 
        add constraint FK733374F6960FF545 
        foreign key (user_id) 
        references sec_user (id);

    alter table confirmation_request 
        add index FK6BDC2085DEBACC1A (license_id), 
        add constraint FK6BDC2085DEBACC1A 
        foreign key (license_id) 
        references license (id);

    alter table customer 
        add index FK24217FDE2DD86A79 (default_rate_code_id), 
        add constraint FK24217FDE2DD86A79 
        foreign key (default_rate_code_id) 
        references rate_code (id);

    alter table domain_hotel_class 
        add index FK618FE4327BC5733A (hotel_id), 
        add constraint FK618FE4327BC5733A 
        foreign key (hotel_id) 
        references hotel (id);

    alter table license 
        add index FK9F084417BC5733A (hotel_id), 
        add constraint FK9F084417BC5733A 
        foreign key (hotel_id) 
        references hotel (id);

    alter table license 
        add index FK9F08441F04B5EDA (owner_id), 
        add constraint FK9F08441F04B5EDA 
        foreign key (owner_id) 
        references owner (id);

    alter table license_user 
        add constraint uc_license_user_1 unique (username);

    alter table reservation 
        add index FKA2D543CC7BC5733A (hotel_id), 
        add constraint FKA2D543CC7BC5733A 
        foreign key (hotel_id) 
        references hotel (id);

    alter table reservation 
        add index FKA2D543CC6E652391 (room_category_id), 
        add constraint FKA2D543CC6E652391 
        foreign key (room_category_id) 
        references room_category (id);

    alter table reservation 
        add index FKA2D543CC4F6D0966 (status_id), 
        add constraint FKA2D543CC4F6D0966 
        foreign key (status_id) 
        references reservation_status (id);

    alter table room 
        add index FK3580DB6E652391 (room_category_id), 
        add constraint FK3580DB6E652391 
        foreign key (room_category_id) 
        references room_category (id);

    alter table room_category 
        add index FK273633E27BC5733A (hotel_id), 
        add constraint FK273633E27BC5733A 
        foreign key (hotel_id) 
        references hotel (id);

    alter table room_category_room_features 
        add index FK3EC2ED845A101C83 (room_feature_id), 
        add constraint FK3EC2ED845A101C83 
        foreign key (room_feature_id) 
        references room_feature (id);

    alter table room_category_room_features 
        add index FK3EC2ED846E652391 (room_category_id), 
        add constraint FK3EC2ED846E652391 
        foreign key (room_category_id) 
        references room_category (id);

    alter table sec_role 
        add constraint uc_sec_role_1 unique (authority);

    alter table sec_user 
        add constraint `unique-username` unique (license_id, username);

    alter table sec_user 
        add index FK375DF2F9DEBACC1A (license_id), 
        add constraint FK375DF2F9DEBACC1A 
        foreign key (license_id) 
        references license (id);

    alter table sec_user_role 
        add index FK7DE039FCF0E53165 (role_id), 
        add constraint FK7DE039FCF0E53165 
        foreign key (role_id) 
        references sec_role (id);

    alter table sec_user_role 
        add index FK7DE039FC960FF545 (user_id), 
        add constraint FK7DE039FC960FF545 
        foreign key (user_id) 
        references sec_user (id);

    alter table system_user 
        add constraint uc_system_user_1 unique (username);
