package hms

import static org.junit.Assert.*
import hms.AdminService
import hms.Hotel
import hms.License
import hms.LicenseService
import hms.auth.SecUser

import org.junit.*

class LicenseIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
	void testCascadeDelete() {

		License license = new LicenseService().createDemoLicense()
		SecUser admin = new AdminService().createUser("admin", "admin", license)
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
				).save()
				
		license.addToHotels(h).save()
		
				
		assert License.list().size() == 1
		assert SecUser.list().size() == 1
		assert Hotel.list().size() == 1

		license.delete()

		assert License.list().size() == 0
		assert SecUser.list().size() == 0
		assert Hotel.list().size() == 0
	}
}
