//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.28 at 06:11:46 PM GMT 
//


package generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _MODE_QNAME = new QName("", "MODE");
    private final static QName _PERIODEND_QNAME = new QName("", "PERIODEND");
    private final static QName _HEAPESPOP_QNAME = new QName("", "HEAPESPOP");
    private final static QName _CLASS_QNAME = new QName("", "CLASS");
    private final static QName _UNITLGTH_QNAME = new QName("", "UNITLGTH");
    private final static QName _NATION_QNAME = new QName("", "NATION");
    private final static QName _PERIODSTART_QNAME = new QName("", "PERIODSTART");
    private final static QName _REGBODY_QNAME = new QName("", "REGBODY");
    private final static QName _QUALSIT_QNAME = new QName("", "QUALSIT");
    private final static QName _ULN_QNAME = new QName("", "ULN");
    private final static QName _SPLENGTH_QNAME = new QName("", "SPLENGTH");
    private final static QName _HUSID_QNAME = new QName("", "HUSID");
    private final static QName _DISABLE_QNAME = new QName("", "DISABLE");
    private final static QName _LOCSDY_QNAME = new QName("", "LOCSDY");
    private final static QName _DOMICILE_QNAME = new QName("", "DOMICILE");
    private final static QName _RECID_QNAME = new QName("", "RECID");
    private final static QName _SBJPCNT_QNAME = new QName("", "SBJPCNT");
    private final static QName _NUMHUS_QNAME = new QName("", "NUMHUS");
    private final static QName _YEARPRG_QNAME = new QName("", "YEARPRG");
    private final static QName _QUALSBJ_QNAME = new QName("", "QUALSBJ");
    private final static QName _SSELIG_QNAME = new QName("", "SSELIG");
    private final static QName _YEARSTU_QNAME = new QName("", "YEARSTU");
    private final static QName _STULOAD_QNAME = new QName("", "STULOAD");
    private final static QName _PREVINST_QNAME = new QName("", "PREVINST");
    private final static QName _LOCATION_QNAME = new QName("", "LOCATION");
    private final static QName _CTITLE_QNAME = new QName("", "CTITLE");
    private final static QName _OWNINST_QNAME = new QName("", "OWNINST");
    private final static QName _NETFEE_QNAME = new QName("", "NETFEE");
    private final static QName _NOTACT_QNAME = new QName("", "NOTACT");
    private final static QName _POSTCODE_QNAME = new QName("", "POSTCODE");
    private final static QName _COURSEID_QNAME = new QName("", "COURSEID");
    private final static QName _SBJCA_QNAME = new QName("", "SBJCA");
    private final static QName _RSNEND_QNAME = new QName("", "RSNEND");
    private final static QName _ETHNIC_QNAME = new QName("", "ETHNIC");
    private final static QName _OWNCOURSEID_QNAME = new QName("", "OWNCOURSEID");
    private final static QName _SEXID_QNAME = new QName("", "SEXID");
    private final static QName _OWNSTU_QNAME = new QName("", "OWNSTU");
    private final static QName _BIRTHDTE_QNAME = new QName("", "BIRTHDTE");
    private final static QName _QUALGRADE_QNAME = new QName("", "QUALGRADE");
    private final static QName _TTCID_QNAME = new QName("", "TTCID");
    private final static QName _SEXORT_QNAME = new QName("", "SEXORT");
    private final static QName _COURSEAIM_QNAME = new QName("", "COURSEAIM");
    private final static QName _SURNAME_QNAME = new QName("", "SURNAME");
    private final static QName _COMDATE_QNAME = new QName("", "COMDATE");
    private final static QName _SUBPURPOSE_QNAME = new QName("", "SUBPURPOSE");
    private final static QName _GENDERID_QNAME = new QName("", "GENDERID");
    private final static QName _UKPRN_QNAME = new QName("", "UKPRN");
    private final static QName _DISALL_QNAME = new QName("", "DISALL");
    private final static QName _QUAL_QNAME = new QName("", "QUAL");
    private final static QName _EXCHIND_QNAME = new QName("", "EXCHIND");
    private final static QName _SSN_QNAME = new QName("", "SSN");
    private final static QName _ENDDATE_QNAME = new QName("", "ENDDATE");
    private final static QName _MSTUFEE_QNAME = new QName("", "MSTUFEE");
    private final static QName _QUALYEAR_QNAME = new QName("", "QUALYEAR");
    private final static QName _PRIPROV_QNAME = new QName("", "PRIPROV");
    private final static QName _QUALTYPE_QNAME = new QName("", "QUALTYPE");
    private final static QName _GROSSFEE_QNAME = new QName("", "GROSSFEE");
    private final static QName _QUALENT3_QNAME = new QName("", "QUALENT3");
    private final static QName _RELBLF_QNAME = new QName("", "RELBLF");
    private final static QName _FNAMES_QNAME = new QName("", "FNAMES");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentEquality }
     * 
     */
    public StudentEquality createStudentEquality() {
        return new StudentEquality();
    }

    /**
     * Create an instance of {@link DISABLECodeType }
     * 
     */
    public DISABLECodeType createDISABLECodeType() {
        return new DISABLECodeType();
    }

    /**
     * Create an instance of {@link ETHNICCodeType }
     * 
     */
    public ETHNICCodeType createETHNICCodeType() {
        return new ETHNICCodeType();
    }

    /**
     * Create an instance of {@link GENDERIDCodeType }
     * 
     */
    public GENDERIDCodeType createGENDERIDCodeType() {
        return new GENDERIDCodeType();
    }

    /**
     * Create an instance of {@link NATIONCodeType }
     * 
     */
    public NATIONCodeType createNATIONCodeType() {
        return new NATIONCodeType();
    }

    /**
     * Create an instance of {@link RELBLFCodeType }
     * 
     */
    public RELBLFCodeType createRELBLFCodeType() {
        return new RELBLFCodeType();
    }

    /**
     * Create an instance of {@link SEXIDCodeType }
     * 
     */
    public SEXIDCodeType createSEXIDCodeType() {
        return new SEXIDCodeType();
    }

    /**
     * Create an instance of {@link SEXORTCodeType }
     * 
     */
    public SEXORTCodeType createSEXORTCodeType() {
        return new SEXORTCodeType();
    }

    /**
     * Create an instance of {@link MODECodeType }
     * 
     */
    public MODECodeType createMODECodeType() {
        return new MODECodeType();
    }

    /**
     * Create an instance of {@link APStudentRecord }
     * 
     */
    public APStudentRecord createAPStudentRecord() {
        return new APStudentRecord();
    }

    /**
     * Create an instance of {@link Provider }
     * 
     */
    public Provider createProvider() {
        return new Provider();
    }

    /**
     * Create an instance of {@link RECIDCodeType }
     * 
     */
    public RECIDCodeType createRECIDCodeType() {
        return new RECIDCodeType();
    }

    /**
     * Create an instance of {@link SUBPURPOSECodeType }
     * 
     */
    public SUBPURPOSECodeType createSUBPURPOSECodeType() {
        return new SUBPURPOSECodeType();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link COURSEAIMCodeType }
     * 
     */
    public COURSEAIMCodeType createCOURSEAIMCodeType() {
        return new COURSEAIMCodeType();
    }

    /**
     * Create an instance of {@link REGBODYCodeType }
     * 
     */
    public REGBODYCodeType createREGBODYCodeType() {
        return new REGBODYCodeType();
    }

    /**
     * Create an instance of {@link TTCIDCodeType }
     * 
     */
    public TTCIDCodeType createTTCIDCodeType() {
        return new TTCIDCodeType();
    }

    /**
     * Create an instance of {@link CourseSubject }
     * 
     */
    public CourseSubject createCourseSubject() {
        return new CourseSubject();
    }

    /**
     * Create an instance of {@link SBJCACodeType }
     * 
     */
    public SBJCACodeType createSBJCACodeType() {
        return new SBJCACodeType();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link EntryProfile }
     * 
     */
    public EntryProfile createEntryProfile() {
        return new EntryProfile();
    }

    /**
     * Create an instance of {@link DOMICILECodeType }
     * 
     */
    public DOMICILECodeType createDOMICILECodeType() {
        return new DOMICILECodeType();
    }

    /**
     * Create an instance of {@link QUALENT3CodeType }
     * 
     */
    public QUALENT3CodeType createQUALENT3CodeType() {
        return new QUALENT3CodeType();
    }

    /**
     * Create an instance of {@link QualificationsOnEntry }
     * 
     */
    public QualificationsOnEntry createQualificationsOnEntry() {
        return new QualificationsOnEntry();
    }

    /**
     * Create an instance of {@link QUALGRADECodeType }
     * 
     */
    public QUALGRADECodeType createQUALGRADECodeType() {
        return new QUALGRADECodeType();
    }

    /**
     * Create an instance of {@link QUALSBJCodeType }
     * 
     */
    public QUALSBJCodeType createQUALSBJCodeType() {
        return new QUALSBJCodeType();
    }

    /**
     * Create an instance of {@link QUALSITCodeType }
     * 
     */
    public QUALSITCodeType createQUALSITCodeType() {
        return new QUALSITCodeType();
    }

    /**
     * Create an instance of {@link QUALTYPECodeType }
     * 
     */
    public QUALTYPECodeType createQUALTYPECodeType() {
        return new QUALTYPECodeType();
    }

    /**
     * Create an instance of {@link Instance }
     * 
     */
    public Instance createInstance() {
        return new Instance();
    }

    /**
     * Create an instance of {@link HEAPESPOPCodeType }
     * 
     */
    public HEAPESPOPCodeType createHEAPESPOPCodeType() {
        return new HEAPESPOPCodeType();
    }

    /**
     * Create an instance of {@link RSNENDCodeType }
     * 
     */
    public RSNENDCodeType createRSNENDCodeType() {
        return new RSNENDCodeType();
    }

    /**
     * Create an instance of {@link UNITLGTHCodeType }
     * 
     */
    public UNITLGTHCodeType createUNITLGTHCodeType() {
        return new UNITLGTHCodeType();
    }

    /**
     * Create an instance of {@link InstancePeriod }
     * 
     */
    public InstancePeriod createInstancePeriod() {
        return new InstancePeriod();
    }

    /**
     * Create an instance of {@link DISALLCodeType }
     * 
     */
    public DISALLCodeType createDISALLCodeType() {
        return new DISALLCodeType();
    }

    /**
     * Create an instance of {@link EXCHINDCodeType }
     * 
     */
    public EXCHINDCodeType createEXCHINDCodeType() {
        return new EXCHINDCodeType();
    }

    /**
     * Create an instance of {@link LOCSDYCodeType }
     * 
     */
    public LOCSDYCodeType createLOCSDYCodeType() {
        return new LOCSDYCodeType();
    }

    /**
     * Create an instance of {@link MSTUFEECodeType }
     * 
     */
    public MSTUFEECodeType createMSTUFEECodeType() {
        return new MSTUFEECodeType();
    }

    /**
     * Create an instance of {@link NOTACTCodeType }
     * 
     */
    public NOTACTCodeType createNOTACTCodeType() {
        return new NOTACTCodeType();
    }

    /**
     * Create an instance of {@link SSELIGCodeType }
     * 
     */
    public SSELIGCodeType createSSELIGCodeType() {
        return new SSELIGCodeType();
    }

    /**
     * Create an instance of {@link QualificationsAwarded }
     * 
     */
    public QualificationsAwarded createQualificationsAwarded() {
        return new QualificationsAwarded();
    }

    /**
     * Create an instance of {@link CLASSCodeType }
     * 
     */
    public CLASSCodeType createCLASSCodeType() {
        return new CLASSCodeType();
    }

    /**
     * Create an instance of {@link QUALCodeType }
     * 
     */
    public QUALCodeType createQUALCodeType() {
        return new QUALCodeType();
    }

    /**
     * Create an instance of {@link PREVINSTCodeType }
     * 
     */
    public PREVINSTCodeType createPREVINSTCodeType() {
        return new PREVINSTCodeType();
    }

    /**
     * Create an instance of {@link PRIPROVCodeType }
     * 
     */
    public PRIPROVCodeType createPRIPROVCodeType() {
        return new PRIPROVCodeType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MODECodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MODE")
    public JAXBElement<MODECodeType> createMODE(MODECodeType value) {
        return new JAXBElement<MODECodeType>(_MODE_QNAME, MODECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PERIODEND")
    public JAXBElement<XMLGregorianCalendar> createPERIODEND(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PERIODEND_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HEAPESPOPCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HEAPESPOP")
    public JAXBElement<HEAPESPOPCodeType> createHEAPESPOP(HEAPESPOPCodeType value) {
        return new JAXBElement<HEAPESPOPCodeType>(_HEAPESPOP_QNAME, HEAPESPOPCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CLASSCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CLASS")
    public JAXBElement<CLASSCodeType> createCLASS(CLASSCodeType value) {
        return new JAXBElement<CLASSCodeType>(_CLASS_QNAME, CLASSCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UNITLGTHCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UNITLGTH")
    public JAXBElement<UNITLGTHCodeType> createUNITLGTH(UNITLGTHCodeType value) {
        return new JAXBElement<UNITLGTHCodeType>(_UNITLGTH_QNAME, UNITLGTHCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NATIONCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NATION")
    public JAXBElement<NATIONCodeType> createNATION(NATIONCodeType value) {
        return new JAXBElement<NATIONCodeType>(_NATION_QNAME, NATIONCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PERIODSTART")
    public JAXBElement<XMLGregorianCalendar> createPERIODSTART(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PERIODSTART_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link REGBODYCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "REGBODY")
    public JAXBElement<REGBODYCodeType> createREGBODY(REGBODYCodeType value) {
        return new JAXBElement<REGBODYCodeType>(_REGBODY_QNAME, REGBODYCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QUALSITCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QUALSIT")
    public JAXBElement<QUALSITCodeType> createQUALSIT(QUALSITCodeType value) {
        return new JAXBElement<QUALSITCodeType>(_QUALSIT_QNAME, QUALSITCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ULN")
    public JAXBElement<String> createULN(String value) {
        return new JAXBElement<String>(_ULN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SPLENGTH")
    public JAXBElement<String> createSPLENGTH(String value) {
        return new JAXBElement<String>(_SPLENGTH_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HUSID")
    public JAXBElement<String> createHUSID(String value) {
        return new JAXBElement<String>(_HUSID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DISABLECodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DISABLE")
    public JAXBElement<DISABLECodeType> createDISABLE(DISABLECodeType value) {
        return new JAXBElement<DISABLECodeType>(_DISABLE_QNAME, DISABLECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LOCSDYCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LOCSDY")
    public JAXBElement<LOCSDYCodeType> createLOCSDY(LOCSDYCodeType value) {
        return new JAXBElement<LOCSDYCodeType>(_LOCSDY_QNAME, LOCSDYCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DOMICILECodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DOMICILE")
    public JAXBElement<DOMICILECodeType> createDOMICILE(DOMICILECodeType value) {
        return new JAXBElement<DOMICILECodeType>(_DOMICILE_QNAME, DOMICILECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RECIDCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RECID")
    public JAXBElement<RECIDCodeType> createRECID(RECIDCodeType value) {
        return new JAXBElement<RECIDCodeType>(_RECID_QNAME, RECIDCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SBJPCNT")
    public JAXBElement<Integer> createSBJPCNT(Integer value) {
        return new JAXBElement<Integer>(_SBJPCNT_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NUMHUS")
    public JAXBElement<String> createNUMHUS(String value) {
        return new JAXBElement<String>(_NUMHUS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "YEARPRG")
    public JAXBElement<BigInteger> createYEARPRG(BigInteger value) {
        return new JAXBElement<BigInteger>(_YEARPRG_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QUALSBJCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QUALSBJ")
    public JAXBElement<QUALSBJCodeType> createQUALSBJ(QUALSBJCodeType value) {
        return new JAXBElement<QUALSBJCodeType>(_QUALSBJ_QNAME, QUALSBJCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SSELIGCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SSELIG")
    public JAXBElement<SSELIGCodeType> createSSELIG(SSELIGCodeType value) {
        return new JAXBElement<SSELIGCodeType>(_SSELIG_QNAME, SSELIGCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "YEARSTU")
    public JAXBElement<Integer> createYEARSTU(Integer value) {
        return new JAXBElement<Integer>(_YEARSTU_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "STULOAD")
    public JAXBElement<BigDecimal> createSTULOAD(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_STULOAD_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PREVINST")
    public JAXBElement<String> createPREVINST(String value) {
        return new JAXBElement<String>(_PREVINST_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LOCATION")
    public JAXBElement<String> createLOCATION(String value) {
        return new JAXBElement<String>(_LOCATION_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CTITLE")
    public JAXBElement<String> createCTITLE(String value) {
        return new JAXBElement<String>(_CTITLE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OWNINST")
    public JAXBElement<String> createOWNINST(String value) {
        return new JAXBElement<String>(_OWNINST_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NETFEE")
    public JAXBElement<BigInteger> createNETFEE(BigInteger value) {
        return new JAXBElement<BigInteger>(_NETFEE_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NOTACTCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NOTACT")
    public JAXBElement<NOTACTCodeType> createNOTACT(NOTACTCodeType value) {
        return new JAXBElement<NOTACTCodeType>(_NOTACT_QNAME, NOTACTCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "POSTCODE")
    public JAXBElement<String> createPOSTCODE(String value) {
        return new JAXBElement<String>(_POSTCODE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "COURSEID")
    public JAXBElement<String> createCOURSEID(String value) {
        return new JAXBElement<String>(_COURSEID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBJCACodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SBJCA")
    public JAXBElement<SBJCACodeType> createSBJCA(SBJCACodeType value) {
        return new JAXBElement<SBJCACodeType>(_SBJCA_QNAME, SBJCACodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RSNENDCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RSNEND")
    public JAXBElement<RSNENDCodeType> createRSNEND(RSNENDCodeType value) {
        return new JAXBElement<RSNENDCodeType>(_RSNEND_QNAME, RSNENDCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ETHNICCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ETHNIC")
    public JAXBElement<ETHNICCodeType> createETHNIC(ETHNICCodeType value) {
        return new JAXBElement<ETHNICCodeType>(_ETHNIC_QNAME, ETHNICCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OWNCOURSEID")
    public JAXBElement<String> createOWNCOURSEID(String value) {
        return new JAXBElement<String>(_OWNCOURSEID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SEXIDCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SEXID")
    public JAXBElement<SEXIDCodeType> createSEXID(SEXIDCodeType value) {
        return new JAXBElement<SEXIDCodeType>(_SEXID_QNAME, SEXIDCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OWNSTU")
    public JAXBElement<String> createOWNSTU(String value) {
        return new JAXBElement<String>(_OWNSTU_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BIRTHDTE")
    public JAXBElement<String> createBIRTHDTE(String value) {
        return new JAXBElement<String>(_BIRTHDTE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QUALGRADECodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QUALGRADE")
    public JAXBElement<QUALGRADECodeType> createQUALGRADE(QUALGRADECodeType value) {
        return new JAXBElement<QUALGRADECodeType>(_QUALGRADE_QNAME, QUALGRADECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTCIDCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TTCID")
    public JAXBElement<TTCIDCodeType> createTTCID(TTCIDCodeType value) {
        return new JAXBElement<TTCIDCodeType>(_TTCID_QNAME, TTCIDCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SEXORTCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SEXORT")
    public JAXBElement<SEXORTCodeType> createSEXORT(SEXORTCodeType value) {
        return new JAXBElement<SEXORTCodeType>(_SEXORT_QNAME, SEXORTCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link COURSEAIMCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "COURSEAIM")
    public JAXBElement<COURSEAIMCodeType> createCOURSEAIM(COURSEAIMCodeType value) {
        return new JAXBElement<COURSEAIMCodeType>(_COURSEAIM_QNAME, COURSEAIMCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SURNAME")
    public JAXBElement<String> createSURNAME(String value) {
        return new JAXBElement<String>(_SURNAME_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "COMDATE")
    public JAXBElement<XMLGregorianCalendar> createCOMDATE(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_COMDATE_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUBPURPOSECodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SUBPURPOSE")
    public JAXBElement<SUBPURPOSECodeType> createSUBPURPOSE(SUBPURPOSECodeType value) {
        return new JAXBElement<SUBPURPOSECodeType>(_SUBPURPOSE_QNAME, SUBPURPOSECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GENDERIDCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GENDERID")
    public JAXBElement<GENDERIDCodeType> createGENDERID(GENDERIDCodeType value) {
        return new JAXBElement<GENDERIDCodeType>(_GENDERID_QNAME, GENDERIDCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UKPRN")
    public JAXBElement<Integer> createUKPRN(Integer value) {
        return new JAXBElement<Integer>(_UKPRN_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DISALLCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DISALL")
    public JAXBElement<DISALLCodeType> createDISALL(DISALLCodeType value) {
        return new JAXBElement<DISALLCodeType>(_DISALL_QNAME, DISALLCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QUALCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QUAL")
    public JAXBElement<QUALCodeType> createQUAL(QUALCodeType value) {
        return new JAXBElement<QUALCodeType>(_QUAL_QNAME, QUALCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EXCHINDCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EXCHIND")
    public JAXBElement<EXCHINDCodeType> createEXCHIND(EXCHINDCodeType value) {
        return new JAXBElement<EXCHINDCodeType>(_EXCHIND_QNAME, EXCHINDCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SSN")
    public JAXBElement<String> createSSN(String value) {
        return new JAXBElement<String>(_SSN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ENDDATE")
    public JAXBElement<String> createENDDATE(String value) {
        return new JAXBElement<String>(_ENDDATE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MSTUFEECodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MSTUFEE")
    public JAXBElement<MSTUFEECodeType> createMSTUFEE(MSTUFEECodeType value) {
        return new JAXBElement<MSTUFEECodeType>(_MSTUFEE_QNAME, MSTUFEECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QUALYEAR")
    public JAXBElement<Integer> createQUALYEAR(Integer value) {
        return new JAXBElement<Integer>(_QUALYEAR_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PRIPROV")
    public JAXBElement<String> createPRIPROV(String value) {
        return new JAXBElement<String>(_PRIPROV_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QUALTYPECodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QUALTYPE")
    public JAXBElement<QUALTYPECodeType> createQUALTYPE(QUALTYPECodeType value) {
        return new JAXBElement<QUALTYPECodeType>(_QUALTYPE_QNAME, QUALTYPECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GROSSFEE")
    public JAXBElement<BigInteger> createGROSSFEE(BigInteger value) {
        return new JAXBElement<BigInteger>(_GROSSFEE_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QUALENT3CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QUALENT3")
    public JAXBElement<QUALENT3CodeType> createQUALENT3(QUALENT3CodeType value) {
        return new JAXBElement<QUALENT3CodeType>(_QUALENT3_QNAME, QUALENT3CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RELBLFCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RELBLF")
    public JAXBElement<RELBLFCodeType> createRELBLF(RELBLFCodeType value) {
        return new JAXBElement<RELBLFCodeType>(_RELBLF_QNAME, RELBLFCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FNAMES")
    public JAXBElement<String> createFNAMES(String value) {
        return new JAXBElement<String>(_FNAMES_QNAME, String.class, null, value);
    }

}
