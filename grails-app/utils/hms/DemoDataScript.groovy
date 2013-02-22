package hms

import org.joda.time.DateTime
import org.joda.time.Duration
import org.joda.time.Interval
import org.apache.commons.logging.LogFactory

class DemoDataScript {

	private static final log = LogFactory.getLog(this.getClass())

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
				invoiceSuffix: ""
				//license: license
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
				
		h.addToRoomCategories(rc).save()

		RoomFeature rf = new RoomFeature(
			name: "Hair-dryer",
			shortDescription: "Excellent hair-dryer",
			description: "I do not know what to put here"
			).save()

		rc.addToRoomFeatures(rf).save()
		rf.addToRoomCategories(rc).save()

		Room r = new Room(
			name: "Room 401",
			roomCategory: rc,
			description: "",
			adults: 2
			).save()

		rc.addToRooms(r).save()

		Reservation res = new Reservation(
			fromDate: new Date() + 1,
			toDate: new Date() + 7,
			roomCategory: rc,
			adults: 2
			).save()
		
		h.addToReservations(res).save()		
			
		//r.addToReservations(res).save()
		//res.addToRooms(r).save()
			
		
		
		
		new RateCode(
				name: "Normal rate",
				shortDescription: "",
				description: ""
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

		h
	}
	
	static def generateRandomData(License license) {
		int NUMBER_OF_ROOMS = 15
		int NUMBER_OF_RESERVATIONS = 30
		
		def today = new DateTime()

		def years = today.year..today.year
		def months = today.monthOfYear..today.monthOfYear
		def days = 15..30
		int ADULTS_MAX = 3
		def roomCategoriesIndex = 1..5
		int MAX_DURATION_DAYS = 7
		
		def seed = new Random()
		
		Hotel h = new Hotel(
				name: randomString(8),
				phone: randomString(8),
				fax: randomString(8),
				eMail: randomString(20),
				webSite: randomString(20),
				registrationNr: randomString(20),
				taxNr: randomString(20),
				bankName: randomString(20),
				bankCode: randomString(10),
				accountNr: randomString(20),
				bicCode: randomString(10),
				iban: randomString(10),
				countryCode: randomString(2),
				invoicePrefix: randomString(3),
				invoiceStartId: randomString(2),
				invoiceSuffix: randomString(2),
			)
		
		// generate room categories
		roomCategoriesIndex.each {
			def rc = new RoomCategory(
				name: randomString(8),
				description: randomString(120),
				shortDescription: randomString(30),
				isBookableOnline: true
			).save()
			h.addToRoomCategories(rc)
		}
		
		def rcList = h.roomCategories.asList()
		
		// generate rooms
		for (i in 1..NUMBER_OF_ROOMS) {
			def rc = rcList[seed.nextInt(rcList.size())]
			Room r = new Room(
				name: randomString(8),
				roomCategory: rc,
				adults: seed.nextInt(ADULTS_MAX)+1
			).save()
			rc.addToRooms(r)
		}
		
		// generate reservations
		for (i in 1..NUMBER_OF_RESERVATIONS) {
			DateTime fromDate = new DateTime().minusDays(seed.nextInt(MAX_DURATION_DAYS))
						// years[seed.nextInt(years.size())],
						// months[seed.nextInt(months.size())],
						// days[seed.nextInt(days.size())],
						// 12,
						// 0,
						// 0,
						// 0
						// )
			DateTime toDate = fromDate.plusDays(seed.nextInt(MAX_DURATION_DAYS)+1)
			Reservation r = new Reservation(
				fromDate: fromDate.toDate(),
				toDate: toDate.toDate(),
				roomCategory: rcList[seed.nextInt(rcList.size())],
				adults: seed.nextInt(ADULTS_MAX)+1
			).save()
			h.addToReservations(r)
		}
		
		h.save()

		h
	}

private static String randomString(long max_length) {
	def seed = new Random()
	def alphabet = 'A'..'z'
	def result = ""
	(1..max_length).each {
		result = result + alphabet[seed.nextInt(alphabet.size())]
	}	
	result
}
}
