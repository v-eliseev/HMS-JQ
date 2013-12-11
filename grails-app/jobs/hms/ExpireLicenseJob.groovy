package hms



class ExpireLicenseJob {
    static triggers = {
      cron name: 'expire', startDelay:600000, cronExpression: "0 0 0 * * ?"  // daily at 12 a.m.
    }

    def execute() {
        // execute job
        log.debug("Expire license job started")
    }
}
