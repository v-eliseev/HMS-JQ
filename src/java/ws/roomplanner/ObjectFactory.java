
package ws.roomplanner;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.roomplanner package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DoPlan_QNAME = new QName("http://roomplanner/", "doPlan");
    private final static QName _GetStatusResponse_QNAME = new QName("http://roomplanner/", "getStatusResponse");
    private final static QName _GetStatus_QNAME = new QName("http://roomplanner/", "getStatus");
    private final static QName _DoPlanResponse_QNAME = new QName("http://roomplanner/", "doPlanResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.roomplanner
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStatus }
     * 
     */
    public GetStatus createGetStatus() {
        return new GetStatus();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link DoPlan }
     * 
     */
    public DoPlan createDoPlan() {
        return new DoPlan();
    }

    /**
     * Create an instance of {@link DoPlanResponse }
     * 
     */
    public DoPlanResponse createDoPlanResponse() {
        return new DoPlanResponse();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link Score }
     * 
     */
    public Score createScore() {
        return new Score();
    }

    /**
     * Create an instance of {@link Pricelist }
     * 
     */
    public Pricelist createPricelist() {
        return new Pricelist();
    }

    /**
     * Create an instance of {@link RoomAssignment }
     * 
     */
    public RoomAssignment createRoomAssignment() {
        return new RoomAssignment();
    }

    /**
     * Create an instance of {@link RoomCategory }
     * 
     */
    public RoomCategory createRoomCategory() {
        return new RoomCategory();
    }

    /**
     * Create an instance of {@link Plan }
     * 
     */
    public Plan createPlan() {
        return new Plan();
    }

    /**
     * Create an instance of {@link ScoreDetail }
     * 
     */
    public ScoreDetail createScoreDetail() {
        return new ScoreDetail();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link PricelistItem }
     * 
     */
    public PricelistItem createPricelistItem() {
        return new PricelistItem();
    }

    /**
     * Create an instance of {@link License }
     * 
     */
    public License createLicense() {
        return new License();
    }

    /**
     * Create an instance of {@link Room }
     * 
     */
    public Room createRoom() {
        return new Room();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://roomplanner/", name = "doPlan")
    public JAXBElement<DoPlan> createDoPlan(DoPlan value) {
        return new JAXBElement<DoPlan>(_DoPlan_QNAME, DoPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://roomplanner/", name = "getStatusResponse")
    public JAXBElement<GetStatusResponse> createGetStatusResponse(GetStatusResponse value) {
        return new JAXBElement<GetStatusResponse>(_GetStatusResponse_QNAME, GetStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://roomplanner/", name = "getStatus")
    public JAXBElement<GetStatus> createGetStatus(GetStatus value) {
        return new JAXBElement<GetStatus>(_GetStatus_QNAME, GetStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://roomplanner/", name = "doPlanResponse")
    public JAXBElement<DoPlanResponse> createDoPlanResponse(DoPlanResponse value) {
        return new JAXBElement<DoPlanResponse>(_DoPlanResponse_QNAME, DoPlanResponse.class, null, value);
    }

}
