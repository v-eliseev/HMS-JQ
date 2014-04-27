databaseChangeLog = {

	changeSet(author: "vlad (generated)", id: "1398573251153-1") {
		addColumn(tableName: "permanent_room_assignment") {
			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1398573251153-2") {
		addColumn(tableName: "permanent_room_assignment") {
			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1398573251153-3") {
		addColumn(tableName: "system_user") {
			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vlad (generated)", id: "1398573251153-4") {
		addColumn(tableName: "system_user") {
			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}
}
