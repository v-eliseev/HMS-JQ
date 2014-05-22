package hms

class RoomPlannerRemoteService {

//	static def grailsApplication

    static remote = [
        protocol: 'hessian',
        iface: roomplanner.api.IRoomPlannerService,
        host: 'planner.roombix.ru',
        port: '80',
        webcontext: ''// 'RoomPlanner'
        //url: grailsApplication.config.service.roomplanner.hessian.url
    ]
}
