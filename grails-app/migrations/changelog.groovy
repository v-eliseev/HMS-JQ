databaseChangeLog = {

	changeSet(author: "evv (generated)", id: "1377597384573-1") {
		createTable(tableName: "article") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "articlePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "article_group_id", type: "bigint")

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "is_bookable_online", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "number", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "double") {
				constraints(nullable: "false")
			}

			column(name: "tax_code_id", type: "bigint")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-2") {
		createTable(tableName: "article_group") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "article_groupPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-3") {
		createTable(tableName: "article_package") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "article_packaPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "article_group_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "is_bookable_online", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "number", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-4") {
		createTable(tableName: "article_package_article") {
			column(name: "article_package_articles_id", type: "bigint")

			column(name: "article_id", type: "bigint")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-5") {
		createTable(tableName: "cancellation_reason") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cancellation_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-6") {
		createTable(tableName: "confirmation_request") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "confirmation_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "data", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "expires", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "license_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-7") {
		createTable(tableName: "customer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "customerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address1", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "address2", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "address3", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "address_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "car_license_plate", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "city", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "company", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "default_rate_code_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "dob", type: "timestamp")

			column(name: "e_mail", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "fax_nr", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "passport_nr", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "phone_nr", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "salutation", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "zip_code", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-8") {
		createTable(tableName: "distribution_channel") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "distribution_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-9") {
		createTable(tableName: "domain_hotel_class") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "domain_hotel_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "hotel_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-10") {
		createTable(tableName: "event_log_item") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "event_log_itePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "timestamp", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "binary(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-11") {
		createTable(tableName: "hotel") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "hotelPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_nr", type: "varchar(255)")

			column(name: "bank_code", type: "varchar(255)")

			column(name: "bank_name", type: "varchar(255)")

			column(name: "bic_code", type: "varchar(255)")

			column(name: "country_code", type: "varchar(255)")

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "e_mail", type: "varchar(255)")

			column(name: "fax", type: "varchar(255)")

			column(name: "iban", type: "varchar(255)")

			column(name: "invoice_prefix", type: "varchar(255)")

			column(name: "invoice_start_id", type: "varchar(255)")

			column(name: "invoice_suffix", type: "varchar(255)")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)")

			column(name: "phone", type: "varchar(255)")

			column(name: "registration_nr", type: "varchar(255)")

			column(name: "tax_nr", type: "varchar(255)")

			column(name: "web_site", type: "varchar(255)")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-12") {
		createTable(tableName: "license") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "licensePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "demo_mode", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)")

			column(name: "expires", type: "timestamp")

			column(name: "hotel_id", type: "bigint")

			column(name: "issued", type: "timestamp")

			column(name: "key", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "owner_id", type: "bigint")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-13") {
		createTable(tableName: "owner") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "ownerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address1", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "address2", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "city", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "firstname", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "lastname", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "state", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "zip", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-14") {
		createTable(tableName: "rate_code") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rate_codePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-15") {
		createTable(tableName: "reservation") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "reservationPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "adults", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "from_date", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "hotel_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(255)")

			column(name: "room_category_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "status_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "to_date", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-16") {
		createTable(tableName: "reservation_motive") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "reservation_mPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-17") {
		createTable(tableName: "reservation_status") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "reservation_sPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "varchar(12)") {
				constraints(nullable: "false")
			}

			column(name: "color_code", type: "varchar(255)")

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "is_active", type: "boolean")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "varchar(255)")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-18") {
		createTable(tableName: "reservation_type") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "reservation_tPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "is_active", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-19") {
		createTable(tableName: "room") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "roomPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "adults", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "room_category_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-20") {
		createTable(tableName: "room_category") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "room_categoryPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "hotel_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "is_bookable_online", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "varchar(255)")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-21") {
		createTable(tableName: "room_category_room_features") {
			column(name: "room_category_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "room_feature_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-22") {
		createTable(tableName: "room_feature") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "room_featurePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-23") {
		createTable(tableName: "sec_role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sec_rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-24") {
		createTable(tableName: "sec_user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sec_userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "expire_account", type: "timestamp")

			column(name: "expire_password", type: "timestamp")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "license_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-25") {
		createTable(tableName: "sec_user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-26") {
		createTable(tableName: "system_user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "system_userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(44)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "salt", type: "varchar(64)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-27") {
		createTable(tableName: "tax_code") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tax_codePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "amount_text", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "units", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "value", type: "double") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-28") {
		addPrimaryKey(columnNames: "room_category_id, room_feature_id", tableName: "room_category_room_features")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-29") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "sec_user_rolePK", tableName: "sec_user_role")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-50") {
		createIndex(indexName: "authority_uniq_1377597384368", tableName: "sec_role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-51") {
		createIndex(indexName: "unique_username", tableName: "sec_user", unique: "true") {
			column(name: "license_id")

			column(name: "username")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-52") {
		createIndex(indexName: "username_uniq_1377597384383", tableName: "system_user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "evv (generated)", id: "1377597384573-30") {
		addForeignKeyConstraint(baseColumnNames: "article_group_id", baseTableName: "article", constraintName: "FKD458CCF61FC6652D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "article_group", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-31") {
		addForeignKeyConstraint(baseColumnNames: "tax_code_id", baseTableName: "article", constraintName: "FKD458CCF6196A4E51", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tax_code", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-32") {
		addForeignKeyConstraint(baseColumnNames: "article_group_id", baseTableName: "article_package", constraintName: "FK5B0451FD1FC6652D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "article_group", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-33") {
		addForeignKeyConstraint(baseColumnNames: "article_id", baseTableName: "article_package_article", constraintName: "FKA6AD78B46C813FA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "article", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-34") {
		addForeignKeyConstraint(baseColumnNames: "article_package_articles_id", baseTableName: "article_package_article", constraintName: "FKA6AD78B42D0A478B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "article_package", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-35") {
		addForeignKeyConstraint(baseColumnNames: "license_id", baseTableName: "confirmation_request", constraintName: "FK6BDC2085DEBACC1A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "license", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-36") {
		addForeignKeyConstraint(baseColumnNames: "default_rate_code_id", baseTableName: "customer", constraintName: "FK24217FDE2DD86A79", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rate_code", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-37") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "domain_hotel_class", constraintName: "FK618FE4327BC5733A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "hotel", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-38") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "license", constraintName: "FK9F084417BC5733A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "hotel", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-39") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "license", constraintName: "FK9F08441F04B5EDA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "owner", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-40") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "reservation", constraintName: "FKA2D543CC7BC5733A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "hotel", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-41") {
		addForeignKeyConstraint(baseColumnNames: "room_category_id", baseTableName: "reservation", constraintName: "FKA2D543CC6E652391", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "room_category", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-42") {
		addForeignKeyConstraint(baseColumnNames: "status_id", baseTableName: "reservation", constraintName: "FKA2D543CC4F6D0966", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "reservation_status", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-43") {
		addForeignKeyConstraint(baseColumnNames: "room_category_id", baseTableName: "room", constraintName: "FK3580DB6E652391", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "room_category", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-44") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "room_category", constraintName: "FK273633E27BC5733A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "hotel", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-45") {
		addForeignKeyConstraint(baseColumnNames: "room_category_id", baseTableName: "room_category_room_features", constraintName: "FK3EC2ED846E652391", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "room_category", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-46") {
		addForeignKeyConstraint(baseColumnNames: "room_feature_id", baseTableName: "room_category_room_features", constraintName: "FK3EC2ED845A101C83", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "room_feature", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-47") {
		addForeignKeyConstraint(baseColumnNames: "license_id", baseTableName: "sec_user", constraintName: "FK375DF2F9DEBACC1A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "license", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-48") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "sec_user_role", constraintName: "FK7DE039FCF0E53165", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_role", referencesUniqueColumn: "false")
	}

	changeSet(author: "evv (generated)", id: "1377597384573-49") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "sec_user_role", constraintName: "FK7DE039FC960FF545", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_user", referencesUniqueColumn: "false")
	}
}
