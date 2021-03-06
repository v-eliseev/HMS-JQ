
package ws.roomplanner;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for score complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="score">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feasible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hardScoreConstraints" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="softScoreConstraints" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="scoreDetails" type="{http://roomplanner/}scoreDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "score", propOrder = {
    "feasible",
    "hardScoreConstraints",
    "softScoreConstraints",
    "scoreDetails"
})
public class Score {

    protected Boolean feasible;
    protected Double hardScoreConstraints;
    protected Double softScoreConstraints;
    protected List<ScoreDetail> scoreDetails;

    /**
     * Gets the value of the feasible property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFeasible() {
        return feasible;
    }

    /**
     * Sets the value of the feasible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFeasible(Boolean value) {
        this.feasible = value;
    }

    /**
     * Gets the value of the hardScoreConstraints property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHardScoreConstraints() {
        return hardScoreConstraints;
    }

    /**
     * Sets the value of the hardScoreConstraints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHardScoreConstraints(Double value) {
        this.hardScoreConstraints = value;
    }

    /**
     * Gets the value of the softScoreConstraints property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSoftScoreConstraints() {
        return softScoreConstraints;
    }

    /**
     * Sets the value of the softScoreConstraints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSoftScoreConstraints(Double value) {
        this.softScoreConstraints = value;
    }

    /**
     * Gets the value of the scoreDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scoreDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScoreDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScoreDetail }
     * 
     * 
     */
    public List<ScoreDetail> getScoreDetails() {
        if (scoreDetails == null) {
            scoreDetails = new ArrayList<ScoreDetail>();
        }
        return this.scoreDetails;
    }

}
