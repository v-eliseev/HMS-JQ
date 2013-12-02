package hms

class RoomPlannerWatchdogJob {

    static triggers = {
      //simple repeatInterval: 1*60*1000l // execute job once in 1 minute
      cron name: 'watchdog', startDelay:600000, cronExpression: "0 */10 * * * ?"  //every 10 minutes
    }

    def execute() {
        // execute job
        log.debug("Roomplanner Watchdog job started...")

		def remoteService = RoomPlannerServiceFactory.getService()
		def status = remoteService.getStatus()
		def uptime = MillisToSpanConverter.getDurationBreakdown(status.uptime)
		def requestsServed = status.requestsServed
		log.error("Uptime: $uptime RequestsServed: $requestsServed")

		log.debug("...done.")
    }
}
