
package ws.roomplanner;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doPlan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="license" type="{http://roomplanner/}license" minOccurs="0"/>
 *         &lt;element name="roomList" type="{http://roomplanner/}room" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="roomCategoryList" type="{http://roomplanner/}roomCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reservationList" type="{http://roomplanner/}reservation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="roomAssignmentList" type="{http://roomplanner/}roomAssignment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="priceList" type="{http://roomplanner/}pricelist" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doPlan", propOrder = {
    "license",
    "roomList",
    "roomCategoryList",
    "reservationList",
    "roomAssignmentList",
    "priceList"
})
public class DoPlan {

    protected License license;
    protected List<Room> roomList;
    protected List<RoomCategory> roomCategoryList;
    protected List<Reservation> reservationList;
    protected List<RoomAssignment> roomAssignmentList;
    protected Pricelist priceList;

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link License }
     *     
     */
    public License getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link License }
     *     
     */
    public void setLicense(License value) {
        this.license = value;
    }

    /**
     * Gets the value of the roomList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Room }
     * 
     * 
     */
    public List<Room> getRoomList() {
        if (roomList == null) {
            roomList = new ArrayList<Room>();
        }
        return this.roomList;
    }

    /**
     * Gets the value of the roomCategoryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomCategoryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomCategoryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomCategory }
     * 
     * 
     */
    public List<RoomCategory> getRoomCategoryList() {
        if (roomCategoryList == null) {
            roomCategoryList = new ArrayList<RoomCategory>();
        }
        return this.roomCategoryList;
    }

    /**
     * Gets the value of the reservationList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservationList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservationList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reservation }
     * 
     * 
     */
    public List<Reservation> getReservationList() {
        if (reservationList == null) {
            reservationList = new ArrayList<Reservation>();
        }
        return this.reservationList;
    }

    /**
     * Gets the value of the roomAssignmentList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomAssignmentList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomAssignmentList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomAssignment }
     * 
     * 
     */
    public List<RoomAssignment> getRoomAssignmentList() {
        if (roomAssignmentList == null) {
            roomAssignmentList = new ArrayList<RoomAssignment>();
        }
        return this.roomAssignmentList;
    }

    /**
     * Gets the value of the priceList property.
     * 
     * @return
     *     possible object is
     *     {@link Pricelist }
     *     
     */
    public Pricelist getPriceList() {
        return priceList;
    }

    /**
     * Sets the value of the priceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pricelist }
     *     
     */
    public void setPriceList(Pricelist value) {
        this.priceList = value;
    }

}
