package ws.roomplanner;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-12-01T12:09:51.787+04:00
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://roomplanner/", name = "RoomPlannerSoapService")
@XmlSeeAlso({ObjectFactory.class})
public interface RoomPlannerSoapService {

    @WebResult(name = "status", targetNamespace = "")
    @RequestWrapper(localName = "getStatus", targetNamespace = "http://roomplanner/", className = "ws.roomplanner.GetStatus")
    @WebMethod
    @ResponseWrapper(localName = "getStatusResponse", targetNamespace = "http://roomplanner/", className = "ws.roomplanner.GetStatusResponse")
    public ws.roomplanner.Status getStatus();

    @WebResult(name = "plan", targetNamespace = "")
    @RequestWrapper(localName = "doPlan", targetNamespace = "http://roomplanner/", className = "ws.roomplanner.DoPlan")
    @WebMethod
    @ResponseWrapper(localName = "doPlanResponse", targetNamespace = "http://roomplanner/", className = "ws.roomplanner.DoPlanResponse")
    public ws.roomplanner.Plan doPlan(
        @WebParam(name = "license", targetNamespace = "")
        ws.roomplanner.License license,
        @WebParam(name = "roomList", targetNamespace = "")
        java.util.List<ws.roomplanner.Room> roomList,
        @WebParam(name = "roomCategoryList", targetNamespace = "")
        java.util.List<ws.roomplanner.RoomCategory> roomCategoryList,
        @WebParam(name = "reservationList", targetNamespace = "")
        java.util.List<ws.roomplanner.Reservation> reservationList,
        @WebParam(name = "roomAssignmentList", targetNamespace = "")
        java.util.List<ws.roomplanner.RoomAssignment> roomAssignmentList,
        @WebParam(name = "priceList", targetNamespace = "")
        ws.roomplanner.Pricelist priceList
    );
}
