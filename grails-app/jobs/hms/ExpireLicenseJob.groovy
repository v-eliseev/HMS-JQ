package hms



class ExpireLicenseJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        // execute job
        log.debug("Expire license job started")
    }
}
