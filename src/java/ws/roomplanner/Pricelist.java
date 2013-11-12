
package ws.roomplanner;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for pricelist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pricelist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="licenseId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dateFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="items" type="{http://roomplanner/}pricelistItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pricelist", propOrder = {
    "licenseId",
    "dateFrom",
    "dateTo",
    "items"
})
public class Pricelist {

    protected Long licenseId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTo;
    protected List<PricelistItem> items;

    /**
     * Gets the value of the licenseId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLicenseId() {
        return licenseId;
    }

    /**
     * Sets the value of the licenseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLicenseId(Long value) {
        this.licenseId = value;
    }

    /**
     * Gets the value of the dateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets the value of the dateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFrom(XMLGregorianCalendar value) {
        this.dateFrom = value;
    }

    /**
     * Gets the value of the dateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTo() {
        return dateTo;
    }

    /**
     * Sets the value of the dateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTo(XMLGregorianCalendar value) {
        this.dateTo = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PricelistItem }
     * 
     * 
     */
    public List<PricelistItem> getItems() {
        if (items == null) {
            items = new ArrayList<PricelistItem>();
        }
        return this.items;
    }

}
