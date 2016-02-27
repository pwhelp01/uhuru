//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.27 at 06:26:30 PM GMT 
//


package generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{}HUSID"/>
 *         &lt;element ref="{}OWNSTU" minOccurs="0"/>
 *         &lt;element ref="{}BIRTHDTE"/>
 *         &lt;element ref="{}FNAMES"/>
 *         &lt;element ref="{}SSN" minOccurs="0"/>
 *         &lt;element ref="{}SURNAME"/>
 *         &lt;element ref="{}ULN" minOccurs="0"/>
 *         &lt;element ref="{}EntryProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Instance" maxOccurs="unbounded"/>
 *         &lt;element ref="{}StudentEquality" minOccurs="0"/>
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
    "husid",
    "ownstu",
    "birthdte",
    "fnames",
    "ssn",
    "surname",
    "uln",
    "entryProfile",
    "instance",
    "studentEquality"
})
@XmlRootElement(name = "Student")
@Entity(name = "Student")
@Table(name = "STUDENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student
    implements Serializable, Equals, HashCode
{

    @XmlElement(name = "HUSID", required = true)
    protected String husid;
    @XmlElement(name = "OWNSTU")
    protected String ownstu;
    @XmlElement(name = "BIRTHDTE", required = true)
    protected String birthdte;
    @XmlElement(name = "FNAMES", required = true)
    protected String fnames;
    @XmlElement(name = "SSN")
    protected String ssn;
    @XmlElement(name = "SURNAME", required = true)
    protected String surname;
    @XmlElement(name = "ULN")
    protected String uln;
    @XmlElement(name = "EntryProfile")
    protected List<EntryProfile> entryProfile;
    @XmlElement(name = "Instance", required = true)
    protected List<Instance> instance;
    @XmlElement(name = "StudentEquality")
    protected StudentEquality studentEquality;

    /**
     * Gets the value of the husid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "HUSID", length = 255)
    public String getHUSID() {
        return husid;
    }

    /**
     * Sets the value of the husid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHUSID(String value) {
        this.husid = value;
    }

    /**
     * Gets the value of the ownstu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Id
    @Column(name = "OWNSTU", length = 20)
    public String getOWNSTU() {
        return ownstu;
    }

    /**
     * Sets the value of the ownstu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOWNSTU(String value) {
        this.ownstu = value;
    }

    /**
     * Gets the value of the birthdte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "BIRTHDTE")
    public String getBIRTHDTE() {
        return birthdte;
    }

    /**
     * Sets the value of the birthdte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIRTHDTE(String value) {
        this.birthdte = value;
    }

    /**
     * Gets the value of the fnames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "FNAMES", length = 100)
    public String getFNAMES() {
        return fnames;
    }

    /**
     * Sets the value of the fnames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNAMES(String value) {
        this.fnames = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "SSN", length = 255)
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "SURNAME", length = 100)
    public String getSURNAME() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSURNAME(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the uln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "ULN", length = 255)
    public String getULN() {
        return uln;
    }

    /**
     * Sets the value of the uln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setULN(String value) {
        this.uln = value;
    }

    /**
     * Gets the value of the entryProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryProfile }
     * 
     * 
     */
    @OneToMany(targetEntity = EntryProfile.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "ENTRYPROFILE_STUDENT_OWNSTU")
    public List<EntryProfile> getEntryProfile() {
        if (entryProfile == null) {
            entryProfile = new ArrayList<EntryProfile>();
        }
        return this.entryProfile;
    }

    /**
     * 
     * 
     */
    public void setEntryProfile(List<EntryProfile> entryProfile) {
        this.entryProfile = entryProfile;
    }

    /**
     * Gets the value of the instance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Instance }
     * 
     * 
     */
    @OneToMany(targetEntity = Instance.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "INSTANCE__STUDENT_OWNSTU")
    public List<Instance> getInstance() {
        if (instance == null) {
            instance = new ArrayList<Instance>();
        }
        return this.instance;
    }

    /**
     * 
     * 
     */
    public void setInstance(List<Instance> instance) {
        this.instance = instance;
    }

    /**
     * Gets the value of the studentEquality property.
     * 
     * @return
     *     possible object is
     *     {@link StudentEquality }
     *     
     */
    @ManyToOne(targetEntity = StudentEquality.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENTEQUALITY_STUDENT_HJID")
    public StudentEquality getStudentEquality() {
        return studentEquality;
    }

    /**
     * Sets the value of the studentEquality property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentEquality }
     *     
     */
    public void setStudentEquality(StudentEquality value) {
        this.studentEquality = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Student)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Student that = ((Student) object);
        {
            String lhsHUSID;
            lhsHUSID = this.getHUSID();
            String rhsHUSID;
            rhsHUSID = that.getHUSID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "husid", lhsHUSID), LocatorUtils.property(thatLocator, "husid", rhsHUSID), lhsHUSID, rhsHUSID)) {
                return false;
            }
        }
        {
            String lhsOWNSTU;
            lhsOWNSTU = this.getOWNSTU();
            String rhsOWNSTU;
            rhsOWNSTU = that.getOWNSTU();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ownstu", lhsOWNSTU), LocatorUtils.property(thatLocator, "ownstu", rhsOWNSTU), lhsOWNSTU, rhsOWNSTU)) {
                return false;
            }
        }
        {
            String lhsBIRTHDTE;
            lhsBIRTHDTE = this.getBIRTHDTE();
            String rhsBIRTHDTE;
            rhsBIRTHDTE = that.getBIRTHDTE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "birthdte", lhsBIRTHDTE), LocatorUtils.property(thatLocator, "birthdte", rhsBIRTHDTE), lhsBIRTHDTE, rhsBIRTHDTE)) {
                return false;
            }
        }
        {
            String lhsFNAMES;
            lhsFNAMES = this.getFNAMES();
            String rhsFNAMES;
            rhsFNAMES = that.getFNAMES();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fnames", lhsFNAMES), LocatorUtils.property(thatLocator, "fnames", rhsFNAMES), lhsFNAMES, rhsFNAMES)) {
                return false;
            }
        }
        {
            String lhsSSN;
            lhsSSN = this.getSSN();
            String rhsSSN;
            rhsSSN = that.getSSN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ssn", lhsSSN), LocatorUtils.property(thatLocator, "ssn", rhsSSN), lhsSSN, rhsSSN)) {
                return false;
            }
        }
        {
            String lhsSURNAME;
            lhsSURNAME = this.getSURNAME();
            String rhsSURNAME;
            rhsSURNAME = that.getSURNAME();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "surname", lhsSURNAME), LocatorUtils.property(thatLocator, "surname", rhsSURNAME), lhsSURNAME, rhsSURNAME)) {
                return false;
            }
        }
        {
            String lhsULN;
            lhsULN = this.getULN();
            String rhsULN;
            rhsULN = that.getULN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "uln", lhsULN), LocatorUtils.property(thatLocator, "uln", rhsULN), lhsULN, rhsULN)) {
                return false;
            }
        }
        {
            List<EntryProfile> lhsEntryProfile;
            lhsEntryProfile = (((this.entryProfile!= null)&&(!this.entryProfile.isEmpty()))?this.getEntryProfile():null);
            List<EntryProfile> rhsEntryProfile;
            rhsEntryProfile = (((that.entryProfile!= null)&&(!that.entryProfile.isEmpty()))?that.getEntryProfile():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "entryProfile", lhsEntryProfile), LocatorUtils.property(thatLocator, "entryProfile", rhsEntryProfile), lhsEntryProfile, rhsEntryProfile)) {
                return false;
            }
        }
        {
            List<Instance> lhsInstance;
            lhsInstance = (((this.instance!= null)&&(!this.instance.isEmpty()))?this.getInstance():null);
            List<Instance> rhsInstance;
            rhsInstance = (((that.instance!= null)&&(!that.instance.isEmpty()))?that.getInstance():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "instance", lhsInstance), LocatorUtils.property(thatLocator, "instance", rhsInstance), lhsInstance, rhsInstance)) {
                return false;
            }
        }
        {
            StudentEquality lhsStudentEquality;
            lhsStudentEquality = this.getStudentEquality();
            StudentEquality rhsStudentEquality;
            rhsStudentEquality = that.getStudentEquality();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "studentEquality", lhsStudentEquality), LocatorUtils.property(thatLocator, "studentEquality", rhsStudentEquality), lhsStudentEquality, rhsStudentEquality)) {
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
            String theHUSID;
            theHUSID = this.getHUSID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "husid", theHUSID), currentHashCode, theHUSID);
        }
        {
            String theOWNSTU;
            theOWNSTU = this.getOWNSTU();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ownstu", theOWNSTU), currentHashCode, theOWNSTU);
        }
        {
            String theBIRTHDTE;
            theBIRTHDTE = this.getBIRTHDTE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "birthdte", theBIRTHDTE), currentHashCode, theBIRTHDTE);
        }
        {
            String theFNAMES;
            theFNAMES = this.getFNAMES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fnames", theFNAMES), currentHashCode, theFNAMES);
        }
        {
            String theSSN;
            theSSN = this.getSSN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ssn", theSSN), currentHashCode, theSSN);
        }
        {
            String theSURNAME;
            theSURNAME = this.getSURNAME();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "surname", theSURNAME), currentHashCode, theSURNAME);
        }
        {
            String theULN;
            theULN = this.getULN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "uln", theULN), currentHashCode, theULN);
        }
        {
            List<EntryProfile> theEntryProfile;
            theEntryProfile = (((this.entryProfile!= null)&&(!this.entryProfile.isEmpty()))?this.getEntryProfile():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entryProfile", theEntryProfile), currentHashCode, theEntryProfile);
        }
        {
            List<Instance> theInstance;
            theInstance = (((this.instance!= null)&&(!this.instance.isEmpty()))?this.getInstance():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instance", theInstance), currentHashCode, theInstance);
        }
        {
            StudentEquality theStudentEquality;
            theStudentEquality = this.getStudentEquality();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "studentEquality", theStudentEquality), currentHashCode, theStudentEquality);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
