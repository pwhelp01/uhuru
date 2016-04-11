//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.28 at 06:11:46 PM GMT 
//


package generated;

import java.io.Serializable;
import javax.persistence.Basic;
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
 *         &lt;element ref="{}SBJCA"/>
 *         &lt;element ref="{}SBJPCNT"/>
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
    "sbjca",
    "sbjpcnt"
})
@XmlRootElement(name = "CourseSubject")
@Entity(name = "CourseSubject")
@Table(name = "COURSESUBJECT")
@Inheritance(strategy = InheritanceType.JOINED)
public class CourseSubject
    implements Serializable, Equals, HashCode
{

    @XmlElement(name = "SBJCA", required = true)
    protected SBJCACodeType sbjca;
    @XmlElement(name = "SBJPCNT")
    protected int sbjpcnt;
    @XmlTransient
    protected Long hjid;

    /**
     * Gets the value of the sbjca property.
     * 
     * @return
     *     possible object is
     *     {@link SBJCACodeType }
     *     
     */
    @ManyToOne(targetEntity = SBJCACodeType.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SBJCA")
    public SBJCACodeType getSBJCA() {
        return sbjca;
    }

    /**
     * Sets the value of the sbjca property.
     * 
     * @param value
     *     allowed object is
     *     {@link SBJCACodeType }
     *     
     */
    public void setSBJCA(SBJCACodeType value) {
        this.sbjca = value;
    }

    /**
     * Gets the value of the sbjpcnt property.
     * 
     */
    @Basic
    @Column(name = "SBJPCNT", precision = 20, scale = 0)
    public int getSBJPCNT() {
        return sbjpcnt;
    }

    /**
     * Sets the value of the sbjpcnt property.
     * 
     */
    public void setSBJPCNT(int value) {
        this.sbjpcnt = value;
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
        if (!(object instanceof CourseSubject)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CourseSubject that = ((CourseSubject) object);
        {
            SBJCACodeType lhsSBJCA;
            lhsSBJCA = this.getSBJCA();
            SBJCACodeType rhsSBJCA;
            rhsSBJCA = that.getSBJCA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sbjca", lhsSBJCA), LocatorUtils.property(thatLocator, "sbjca", rhsSBJCA), lhsSBJCA, rhsSBJCA)) {
                return false;
            }
        }
        {
            int lhsSBJPCNT;
            lhsSBJPCNT = (true?this.getSBJPCNT(): 0);
            int rhsSBJPCNT;
            rhsSBJPCNT = (true?that.getSBJPCNT(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sbjpcnt", lhsSBJPCNT), LocatorUtils.property(thatLocator, "sbjpcnt", rhsSBJPCNT), lhsSBJPCNT, rhsSBJPCNT)) {
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
            SBJCACodeType theSBJCA;
            theSBJCA = this.getSBJCA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sbjca", theSBJCA), currentHashCode, theSBJCA);
        }
        {
            int theSBJPCNT;
            theSBJPCNT = (true?this.getSBJPCNT(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sbjpcnt", theSBJPCNT), currentHashCode, theSBJPCNT);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
