
package sif3.infra.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for provisionedZonesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="provisionedZonesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="provisionedZone" type="{http://www.sifassociation.org/infrastructure/3.2}provisionedZoneType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "provisionedZonesType", namespace = "http://www.sifassociation.org/infrastructure/3.2", propOrder = {
    "provisionedZone"
})
public class ProvisionedZonesType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    protected List<ProvisionedZoneType> provisionedZone;

    /**
     * Gets the value of the provisionedZone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the provisionedZone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProvisionedZone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProvisionedZoneType }
     * 
     * 
     */
    public List<ProvisionedZoneType> getProvisionedZone() {
        if (provisionedZone == null) {
            provisionedZone = new ArrayList<ProvisionedZoneType>();
        }
        return this.provisionedZone;
    }

    public boolean isSetProvisionedZone() {
        return ((this.provisionedZone!= null)&&(!this.provisionedZone.isEmpty()));
    }

    public void unsetProvisionedZone() {
        this.provisionedZone = null;
    }

}
