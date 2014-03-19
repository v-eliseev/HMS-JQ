package hms

class RoomPlannerWatchdogJob {

    static triggers = {
      cron name: 'watchdog', startDelay:600000, cronExpression: "0 */10 * * * ?"  //every 10 minutes
    }

    def execute() {
        // execute job
        log.debug("Roomplanner Watchdog job started...")
        try {
    		def remoteService = RoomPlannerServiceFactory.getService()
    		def status = remoteService.getStatus()
    		def uptime = MillisToSpanConverter.getDurationBreakdown(status.uptime)
    		def requestsServed = status.requestsServed
    		log.debug("Uptime: $uptime RequestsServed: $requestsServed")
            log.debug("...done.")
        } catch (Exception e) {
            log.error("Failed to execute watchdog job")
        }
    }
}
