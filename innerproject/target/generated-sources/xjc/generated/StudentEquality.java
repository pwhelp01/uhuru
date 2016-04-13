//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.13 at 09:26:51 PM BST 
//


package generated;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}DISABLE" minOccurs="0"/>
 *         &lt;element ref="{}ETHNIC" minOccurs="0"/>
 *         &lt;element ref="{}GENDERID" minOccurs="0"/>
 *         &lt;element ref="{}NATION" minOccurs="0"/>
 *         &lt;element ref="{}RELBLF" minOccurs="0"/>
 *         &lt;element ref="{}SEXID" minOccurs="0"/>
 *         &lt;element ref="{}SEXORT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "disable",
    "ethnic",
    "genderid",
    "nation",
    "relblf",
    "sexid",
    "sexort"
})
@XmlRootElement(name = "StudentEquality")
@Entity(name = "StudentEquality")
@Table(name = "STUDENTEQUALITY")
@Inheritance(strategy = InheritanceType.JOINED)
public class StudentEquality
    implements Serializable, Equals, HashCode
{

    @XmlElement(name = "DISABLE")
    protected DISABLECodeType disable;
    @XmlElement(name = "ETHNIC")
    protected ETHNICCodeType ethnic;
    @XmlElement(name = "GENDERID")
    protected GENDERIDCodeType genderid;
    @XmlElement(name = "NATION")
    protected NATIONCodeType nation;
    @XmlElement(name = "RELBLF")
    protected RELBLFCodeType relblf;
    @XmlElement(name = "SEXID")
    protected SEXIDCodeType sexid;
    @XmlElement(name = "SEXORT")
    protected SEXORTCodeType sexort;
    @XmlTransient
    protected Long hjid;

    /**
     * Gets the value of the disable property.
     * 
     * @return
     *     possible object is
     *     {@link DISABLECodeType }
     *     
     */
    @ManyToOne(targetEntity = DISABLECodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "DISABLE")
    public DISABLECodeType getDISABLE() {
        return disable;
    }

    /**
     * Sets the value of the disable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DISABLECodeType }
     *     
     */
    public void setDISABLE(DISABLECodeType value) {
        this.disable = value;
    }

    /**
     * Gets the value of the ethnic property.
     * 
     * @return
     *     possible object is
     *     {@link ETHNICCodeType }
     *     
     */
    @ManyToOne(targetEntity = ETHNICCodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "ETHNIC")
    public ETHNICCodeType getETHNIC() {
        return ethnic;
    }

    /**
     * Sets the value of the ethnic property.
     * 
     * @param value
     *     allowed object is
     *     {@link ETHNICCodeType }
     *     
     */
    public void setETHNIC(ETHNICCodeType value) {
        this.ethnic = value;
    }

    /**
     * Gets the value of the genderid property.
     * 
     * @return
     *     possible object is
     *     {@link GENDERIDCodeType }
     *     
     */
    @ManyToOne(targetEntity = GENDERIDCodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "GENDERID")
    public GENDERIDCodeType getGENDERID() {
        return genderid;
    }

    /**
     * Sets the value of the genderid property.
     * 
     * @param value
     *     allowed object is
     *     {@link GENDERIDCodeType }
     *     
     */
    public void setGENDERID(GENDERIDCodeType value) {
        this.genderid = value;
    }

    /**
     * Gets the value of the nation property.
     * 
     * @return
     *     possible object is
     *     {@link NATIONCodeType }
     *     
     */
    @ManyToOne(targetEntity = NATIONCodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "NATION")
    public NATIONCodeType getNATION() {
        return nation;
    }

    /**
     * Sets the value of the nation property.
     * 
     * @param value
     *     allowed object is
     *     {@link NATIONCodeType }
     *     
     */
    public void setNATION(NATIONCodeType value) {
        this.nation = value;
    }

    /**
     * Gets the value of the relblf property.
     * 
     * @return
     *     possible object is
     *     {@link RELBLFCodeType }
     *     
     */
    @ManyToOne(targetEntity = RELBLFCodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "RELBLF")
    public RELBLFCodeType getRELBLF() {
        return relblf;
    }

    /**
     * Sets the value of the relblf property.
     * 
     * @param value
     *     allowed object is
     *     {@link RELBLFCodeType }
     *     
     */
    public void setRELBLF(RELBLFCodeType value) {
        this.relblf = value;
    }

    /**
     * Gets the value of the sexid property.
     * 
     * @return
     *     possible object is
     *     {@link SEXIDCodeType }
     *     
     */
    @ManyToOne(targetEntity = SEXIDCodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SEXID")
    public SEXIDCodeType getSEXID() {
        return sexid;
    }

    /**
     * Sets the value of the sexid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SEXIDCodeType }
     *     
     */
    public void setSEXID(SEXIDCodeType value) {
        this.sexid = value;
    }

    /**
     * Gets the value of the sexort property.
     * 
     * @return
     *     possible object is
     *     {@link SEXORTCodeType }
     *     
     */
    @ManyToOne(targetEntity = SEXORTCodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SEXORT")
    public SEXORTCodeType getSEXORT() {
        return sexort;
    }

    /**
     * Sets the value of the sexort property.
     * 
     * @param value
     *     allowed object is
     *     {@link SEXORTCodeType }
     *     
     */
    public void setSEXORT(SEXORTCodeType value) {
        this.sexort = value;
    }

    /**
     * 
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "hjid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long gethjid() {
        return hjid;
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void sethjid(Long value) {
        this.hjid = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof StudentEquality)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final StudentEquality that = ((StudentEquality) object);
        {
            DISABLECodeType lhsDISABLE;
            lhsDISABLE = this.getDISABLE();
            DISABLECodeType rhsDISABLE;
            rhsDISABLE = that.getDISABLE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "disable", lhsDISABLE), LocatorUtils.property(thatLocator, "disable", rhsDISABLE), lhsDISABLE, rhsDISABLE)) {
                return false;
            }
        }
        {
            ETHNICCodeType lhsETHNIC;
            lhsETHNIC = this.getETHNIC();
            ETHNICCodeType rhsETHNIC;
            rhsETHNIC = that.getETHNIC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ethnic", lhsETHNIC), LocatorUtils.property(thatLocator, "ethnic", rhsETHNIC), lhsETHNIC, rhsETHNIC)) {
                return false;
            }
        }
        {
            GENDERIDCodeType lhsGENDERID;
            lhsGENDERID = this.getGENDERID();
            GENDERIDCodeType rhsGENDERID;
            rhsGENDERID = that.getGENDERID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genderid", lhsGENDERID), LocatorUtils.property(thatLocator, "genderid", rhsGENDERID), lhsGENDERID, rhsGENDERID)) {
                return false;
            }
        }
        {
            NATIONCodeType lhsNATION;
            lhsNATION = this.getNATION();
            NATIONCodeType rhsNATION;
            rhsNATION = that.getNATION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nation", lhsNATION), LocatorUtils.property(thatLocator, "nation", rhsNATION), lhsNATION, rhsNATION)) {
                return false;
            }
        }
        {
            RELBLFCodeType lhsRELBLF;
            lhsRELBLF = this.getRELBLF();
            RELBLFCodeType rhsRELBLF;
            rhsRELBLF = that.getRELBLF();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "relblf", lhsRELBLF), LocatorUtils.property(thatLocator, "relblf", rhsRELBLF), lhsRELBLF, rhsRELBLF)) {
                return false;
            }
        }
        {
            SEXIDCodeType lhsSEXID;
            lhsSEXID = this.getSEXID();
            SEXIDCodeType rhsSEXID;
            rhsSEXID = that.getSEXID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sexid", lhsSEXID), LocatorUtils.property(thatLocator, "sexid", rhsSEXID), lhsSEXID, rhsSEXID)) {
                return false;
            }
        }
        {
            SEXORTCodeType lhsSEXORT;
            lhsSEXORT = this.getSEXORT();
            SEXORTCodeType rhsSEXORT;
            rhsSEXORT = that.getSEXORT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sexort", lhsSEXORT), LocatorUtils.property(thatLocator, "sexort", rhsSEXORT), lhsSEXORT, rhsSEXORT)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            DISABLECodeType theDISABLE;
            theDISABLE = this.getDISABLE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "disable", theDISABLE), currentHashCode, theDISABLE);
        }
        {
            ETHNICCodeType theETHNIC;
            theETHNIC = this.getETHNIC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ethnic", theETHNIC), currentHashCode, theETHNIC);
        }
        {
            GENDERIDCodeType theGENDERID;
            theGENDERID = this.getGENDERID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genderid", theGENDERID), currentHashCode, theGENDERID);
        }
        {
            NATIONCodeType theNATION;
            theNATION = this.getNATION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nation", theNATION), currentHashCode, theNATION);
        }
        {
            RELBLFCodeType theRELBLF;
            theRELBLF = this.getRELBLF();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "relblf", theRELBLF), currentHashCode, theRELBLF);
        }
        {
            SEXIDCodeType theSEXID;
            theSEXID = this.getSEXID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sexid", theSEXID), currentHashCode, theSEXID);
        }
        {
            SEXORTCodeType theSEXORT;
            theSEXORT = this.getSEXORT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sexort", theSEXORT), currentHashCode, theSEXORT);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
