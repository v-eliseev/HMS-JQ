databaseChangeLog = {

	changeSet(author: "vlad (generated)", id: "1394475472405-1") {
		createTable(tableName: "article") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "article_group_id", type: "BIGINT")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)")

			column(name: "is_bookable_online", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "number", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "DOUBLE") {
				constraints(nullable: "false")
			}

			column(name: "tax_code_id", type: "BIGINT")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-2") {
		createTable(tableName: "article_group") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-3") {
		createTable(tableName: "article_package") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "article_group_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)")

			column(name: "is_bookable_online", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "number", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-4") {
		createTable(tableName: "article_package_article") {
			column(name: "article_package_articles_id", type: "BIGINT")

			column(name: "article_id", type: "BIGINT")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-5") {
		createTable(tableName: "cancellation_reason") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-6") {
		createTable(tableName: "configuration") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "KEY", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "VALUE", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-7") {
		createTable(tableName: "confirmation_request") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "data", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "expires", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "license_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-8") {
		createTable(tableName: "customer") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "address1", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "address2", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "address3", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "address_type", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "car_license_plate", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "city", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "company", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "default_rate_code_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "dob", type: "DATETIME")

			column(name: "e_mail", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "fax_nr", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "passport_nr", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "phone_nr", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "salutation", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "zip_code", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-9") {
		createTable(tableName: "distribution_channel") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-10") {
		createTable(tableName: "domain_hotel_class") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "hotel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-11") {
		createTable(tableName: "event_log_item") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "timestamp", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "TINYBLOB") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-12") {
		createTable(tableName: "hotel") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "account_nr", type: "VARCHAR(255)")

			column(name: "bank_code", type: "VARCHAR(255)")

			column(name: "bank_name", type: "VARCHAR(255)")

			column(name: "bic_code", type: "VARCHAR(255)")

			column(name: "country_code", type: "VARCHAR(255)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "e_mail", type: "VARCHAR(255)")

			column(name: "fax", type: "VARCHAR(255)")

			column(name: "iban", type: "VARCHAR(255)")

			column(name: "invoice_prefix", type: "VARCHAR(255)")

			column(name: "invoice_start_id", type: "VARCHAR(255)")

			column(name: "invoice_suffix", type: "VARCHAR(255)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)")

			column(name: "phone", type: "VARCHAR(255)")

			column(name: "registration_nr", type: "VARCHAR(255)")

			column(name: "tax_nr", type: "VARCHAR(255)")

			column(name: "web_site", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-13") {
		createTable(tableName: "license") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)")

			column(name: "enabled", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "expires", type: "DATETIME")

			column(name: "hotel_id", type: "BIGINT")

			column(name: "issued", type: "DATETIME")

			column(name: "KEY", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "mode", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "owner_id", type: "BIGINT")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-14") {
		createTable(tableName: "license_user") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "PASSWORD", type: "VARCHAR(100)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "salt", type: "VARCHAR(64)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-15") {
		createTable(tableName: "owner") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "address1", type: "VARCHAR(255)")

			column(name: "address2", type: "VARCHAR(255)")

			column(name: "city", type: "VARCHAR(255)")

			column(name: "country", type: "VARCHAR(255)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)")

			column(name: "phone", type: "VARCHAR(255)")

			column(name: "state", type: "VARCHAR(255)")

			column(name: "zip", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-16") {
		createTable(tableName: "permanent_room_assignment") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "reservation_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "room_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-17") {
		createTable(tableName: "rate_code") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-18") {
		createTable(tableName: "reservation") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "adults", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "from_date", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "hotel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "VARCHAR(255)")

			column(name: "room_category_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "status_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "to_date", type: "DATETIME") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-19") {
		createTable(tableName: "reservation_motive") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-20") {
		createTable(tableName: "reservation_status") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "color_code", type: "VARCHAR(255)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)")

			column(name: "is_active", type: "BIT")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-21") {
		createTable(tableName: "reservation_type") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "is_active", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-22") {
		createTable(tableName: "room") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "adults", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "room_category_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-23") {
		createTable(tableName: "room_category") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)")

			column(name: "hotel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "is_bookable_online", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-24") {
		createTable(tableName: "room_category_room_features") {
			column(name: "room_category_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "room_feature_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-25") {
		createTable(tableName: "room_feature") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "short_description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-26") {
		createTable(tableName: "sec_request_map") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "config_attribute", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "http_method", type: "VARCHAR(255)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-27") {
		createTable(tableName: "sec_role") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-28") {
		createTable(tableName: "sec_user") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "expire_account", type: "DATETIME")

			column(name: "expire_account_every_code", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "expire_account_type", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "expire_password", type: "DATETIME")

			column(name: "expire_password_every_code", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "expire_password_type", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "license_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "PASSWORD", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-29") {
		createTable(tableName: "sec_user_role") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-30") {
		createTable(tableName: "system_user") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "PASSWORD", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "realm_code", type: "BIGINT")

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-31") {
		createTable(tableName: "tax_code") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "amount_text", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "units", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "VALUE", type: "DOUBLE") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-32") {
		addPrimaryKey(columnNames: "room_category_id, room_feature_id", tableName: "room_category_room_features")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-33") {
		addPrimaryKey(columnNames: "role_id, user_id", tableName: "sec_user_role")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-57") {
		createIndex(indexName: "KEY", tableName: "license", unique: "true") {
			column(name: "KEY")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-58") {
		createIndex(indexName: "username", tableName: "license_user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-59") {
		createIndex(indexName: "http_method", tableName: "sec_request_map", unique: "true") {
			column(name: "http_method")

			column(name: "url")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-60") {
		createIndex(indexName: "authority", tableName: "sec_role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-61") {
		createIndex(indexName: "license_id", tableName: "sec_user", unique: "true") {
			column(name: "license_id")

			column(name: "username")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-62") {
		createIndex(indexName: "username", tableName: "system_user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-34") {
		addForeignKeyConstraint(baseColumnNames: "article_group_id", baseTableName: "article", baseTableSchemaName: "hms", constraintName: "FKD458CCF61FC6652D", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "article_group", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-35") {
		addForeignKeyConstraint(baseColumnNames: "tax_code_id", baseTableName: "article", baseTableSchemaName: "hms", constraintName: "FKD458CCF6196A4E51", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "tax_code", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-36") {
		addForeignKeyConstraint(baseColumnNames: "article_group_id", baseTableName: "article_package", baseTableSchemaName: "hms", constraintName: "FK5B0451FD1FC6652D", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "article_group", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-37") {
		addForeignKeyConstraint(baseColumnNames: "article_id", baseTableName: "article_package_article", baseTableSchemaName: "hms", constraintName: "FKA6AD78B46C813FA", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "article", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-38") {
		addForeignKeyConstraint(baseColumnNames: "article_package_articles_id", baseTableName: "article_package_article", baseTableSchemaName: "hms", constraintName: "FKA6AD78B42D0A478B", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "article_package", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-39") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "configuration", baseTableSchemaName: "hms", constraintName: "FK733374F6960FF545", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "sec_user", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-40") {
		addForeignKeyConstraint(baseColumnNames: "license_id", baseTableName: "confirmation_request", baseTableSchemaName: "hms", constraintName: "FK6BDC2085DEBACC1A", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "license", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-41") {
		addForeignKeyConstraint(baseColumnNames: "default_rate_code_id", baseTableName: "customer", baseTableSchemaName: "hms", constraintName: "FK24217FDE2DD86A79", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "rate_code", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-42") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "domain_hotel_class", baseTableSchemaName: "hms", constraintName: "FK618FE4327BC5733A", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "hotel", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-43") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "license", baseTableSchemaName: "hms", constraintName: "FK9F084417BC5733A", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "hotel", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-44") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "license", baseTableSchemaName: "hms", constraintName: "FK9F08441F04B5EDA", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "owner", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-45") {
		addForeignKeyConstraint(baseColumnNames: "reservation_id", baseTableName: "permanent_room_assignment", baseTableSchemaName: "hms", constraintName: "FKDFA3632049769C3A", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "reservation", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-46") {
		addForeignKeyConstraint(baseColumnNames: "room_id", baseTableName: "permanent_room_assignment", baseTableSchemaName: "hms", constraintName: "FKDFA36320D2AD71DA", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "room", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-47") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "reservation", baseTableSchemaName: "hms", constraintName: "FKA2D543CC7BC5733A", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "hotel", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-48") {
		addForeignKeyConstraint(baseColumnNames: "room_category_id", baseTableName: "reservation", baseTableSchemaName: "hms", constraintName: "FKA2D543CC6E652391", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "room_category", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-49") {
		addForeignKeyConstraint(baseColumnNames: "status_id", baseTableName: "reservation", baseTableSchemaName: "hms", constraintName: "FKA2D543CC4F6D0966", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "reservation_status", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-50") {
		addForeignKeyConstraint(baseColumnNames: "room_category_id", baseTableName: "room", baseTableSchemaName: "hms", constraintName: "FK3580DB6E652391", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "room_category", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-51") {
		addForeignKeyConstraint(baseColumnNames: "hotel_id", baseTableName: "room_category", baseTableSchemaName: "hms", constraintName: "FK273633E27BC5733A", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "hotel", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-52") {
		addForeignKeyConstraint(baseColumnNames: "room_category_id", baseTableName: "room_category_room_features", baseTableSchemaName: "hms", constraintName: "FK3EC2ED846E652391", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "room_category", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-53") {
		addForeignKeyConstraint(baseColumnNames: "room_feature_id", baseTableName: "room_category_room_features", baseTableSchemaName: "hms", constraintName: "FK3EC2ED845A101C83", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "room_feature", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-54") {
		addForeignKeyConstraint(baseColumnNames: "license_id", baseTableName: "sec_user", baseTableSchemaName: "hms", constraintName: "FK375DF2F9DEBACC1A", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "license", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-55") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "sec_user_role", baseTableSchemaName: "hms", constraintName: "FK7DE039FCF0E53165", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "sec_role", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	changeSet(author: "vlad (generated)", id: "1394475472405-56") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "sec_user_role", baseTableSchemaName: "hms", constraintName: "FK7DE039FC960FF545", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "sec_user", referencedTableSchemaName: "hms", referencesUniqueColumn: "false")
	}

	include file: 'dbm-changeset001.groovy'
}
