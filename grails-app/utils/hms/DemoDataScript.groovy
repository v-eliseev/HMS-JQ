package hms

import hms.Article
import hms.ArticleGroup
import hms.ArticlePackage
import hms.Customer
import hms.DistributionChannel
import hms.Hotel
import hms.RateCode
import hms.ReservationMotive
import hms.ReservationStatus
import hms.Room
import hms.RoomCategory
import hms.RoomFeature
import hms.TaxCode

class DemoDataScript {

	static def createDemoData(License license) {

		Hotel h = new Hotel (
				name: "My Hotel",
				phone: "123-45-67-89",
				fax: "987-65-43-21",
				eMail: "aa@bb.cc",
				webSite: "http://www.bb.cc",
				registrationNr: "993279938",
				taxNr: "7748399256-AQ",
				bankName: "The Bank",
				bankCode: "BNK",
				accountNr: "9848990293664",
				bicCode: "67432",
				iban: "THEBANK",
				countryCode: "RU",
				invoicePrefix: "Inv.2012-",
				invoiceStartId: "35",
				invoiceSuffix: "",
				license: license
				)

		h.addToRoomCategories(new RoomCategory(
				name: "Standard",
				shortDescription: "Stardard twin bed room",
				description: "Standard twin bed room with bathroom",
				isBookableOnline: true
				).save())

		h.addToRoomCategories(new RoomCategory(
				name: "Suite",
				shortDescription: "Luxury double bed room",
				description: "Luxury double bed room with bathroom",
				isBookableOnline: true
				).save())

		RoomCategory rc = new RoomCategory(
				name: "President apartments",
				shortDescription: "King size double bed room",
				description: "Superior King size double bed room with bathroom and a balcony",
				isBookableOnline: false
				).save()
				
		h.addToRoomCategories(rc)

		RoomFeature rf = new RoomFeature(
			name: "Hair-dryer",
			shortDescription: "Excellent hair-dryer",
			description: "I do not know what to put here"
			).save()

		rc.addToRoomFeatures(rf).save()
		RoomCategoryRoomFeature.create(rc, rf)
		

		
			
		new RateCode(
				name: "Normal rate",
				shortDescription: "",
				description: ""
				).save()

		new Room(
				name: "Room 401",
				roomCategory: rc,
				description: "",
				maxOccupants: 2
				).save()

		TaxCode tc = new TaxCode(
				name: "VAT 18%",
				amountText: "18%",
				description: "Normal VAT",
				value: 0.2,
				units: "%"
				).save()

		ArticleGroup ag = new ArticleGroup(
				name: "Outdoor"
				).save()

		Article a1 = new Article(
				number: "31002",
				name: "Mountain Bike",
				description: "27-speed mountain bike",
				isBookableOnline: true,
				price: 50,
				articleGroup: ag
				).save()

		Article a2 = new Article(
				number: "31003",
				name: "Street Bike",
				description: "Ordinary street bike",
				isBookableOnline: true,
				price: 25,
				articleGroup: ag
				).save()

		Article a3 = new Article(
				number: "32001",
				name: "Helmet",
				description: "",
				isBookableOnline: true,
				price: 10,
				articleGroup: ag
				).save()

		new ArticlePackage(
				number: "PK001",
				name: "Bike set",
				description: "",
				articleGroup: ag,
				articles: [a1, a3],
				isBookableOnline: true
				).save()

		RateCode rc1 = new RateCode(
				name: "Standard",
				shortDescription: "Normal rate",
				description: "Normal rate applied diring low season"
				).save()

		Customer c = new Customer(
				name: "Moriarti",
				salutation: "Prof.",
				phoneNr: "32-0270-2266",
				faxNr: "32-0270-2267",
				eMail: "moriarti@univerity.com",

				addressType: "Private",
				address1: "Reichenbach",
				address2: "Wassrefall",
				address3: "Jaegerhaus",
				zipCode: "3216",
				city: "Reichenbach",
				country: "Austria",

				company: "XX",
				/* dob: "22.04.1870", */
				carLicensePlate: "L35XF178",
				passportNr: "32554872",

				defaultRateCode: rc1
				)
		c.save()

		new ReservationMotive(
				name: "Business",
				shortDescription: "Business trip",
				description: "Business trip"
				).save()

		new DistributionChannel(
				name: "Phone",
				shortDescription: "Phone call",
				description: "Phone call"
				).save()

		new ReservationStatus(
				name: "New",
				shortDescription: "",
				description: "",
				colorCode: "0x00FF00",
				isActive: true
				).save()

		new ReservationStatus(
				name: "Assigned",
				shortDescription: "",
				description: "",
				colorCode: "0x0000FF",
				isActive: true
				).save()

		new ReservationStatus(
				name: "Cancelled",
				shortDescription: "",
				description: "",
				colorCode: "0x999999",
				isActive: true
				).save()

		h.save() // Save all data cascaded
	}
}
