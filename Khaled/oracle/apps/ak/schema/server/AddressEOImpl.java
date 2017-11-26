package instructor.oracle.apps.ak.schema.server;

import oracle.apps.fnd.framework.server.OAEntityDefImpl;
import oracle.apps.fnd.framework.server.OAEntityImpl;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AddressEOImpl extends OAEntityImpl {
    public static final int ADDRESSID = 0;
    public static final int ADDRESSLINE1 = 1;
    public static final int ADDRESSLINE2 = 2;
    public static final int ADDRESSLINE3 = 3;
    public static final int ADDRESSNAME = 4;
    public static final int ATTRIBUTE1 = 5;
    public static final int ATTRIBUTE10 = 6;
    public static final int ATTRIBUTE11 = 7;
    public static final int ATTRIBUTE12 = 8;
    public static final int ATTRIBUTE13 = 9;
    public static final int ATTRIBUTE14 = 10;
    public static final int ATTRIBUTE15 = 11;
    public static final int ATTRIBUTE2 = 12;
    public static final int ATTRIBUTE3 = 13;
    public static final int ATTRIBUTE4 = 14;
    public static final int ATTRIBUTE5 = 15;
    public static final int ATTRIBUTE6 = 16;
    public static final int ATTRIBUTE7 = 17;
    public static final int ATTRIBUTE8 = 18;
    public static final int ATTRIBUTE9 = 19;
    public static final int ATTRIBUTECATEGORY = 20;
    public static final int COUNTRY = 21;
    public static final int CREATEDBY = 22;
    public static final int CREATIONDATE = 23;
    public static final int DESCRIPTION = 24;
    public static final int EMAILADDRESS = 25;
    public static final int ENDDATE = 26;
    public static final int LASTUPDATEDBY = 27;
    public static final int LASTUPDATEDATE = 28;
    public static final int LASTUPDATELOGIN = 29;
    public static final int POSTALCODE = 30;
    public static final int STARTDATE = 31;
    public static final int TELEPHONENUMBER1 = 32;
    public static final int TELEPHONENUMBER2 = 33;
    public static final int TELEPHONENUMBER3 = 34;
    public static final int TOWNORCITY = 35;
    private static OAEntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public AddressEOImpl() {
    }

    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject =
                    (OAEntityDefImpl)EntityDefImpl.findDefObject("instructor.oracle.apps.ak.schema.server.AddressEO");
        }
        return mDefinitionObject;
    }

    /**Add attribute defaulting logic in this method.
     */
    public void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**Add Entity validation code in this method.
     */
    protected void validateEntity() {
        super.validateEntity();
    }

    /**Gets the attribute value for AddressId, using the alias name AddressId
     */
    public Number getAddressId() {
        return (Number)getAttributeInternal(ADDRESSID);
    }

    /**Sets <code>value</code> as the attribute value for AddressId
     */
    public void setAddressId(Number value) {
        setAttributeInternal(ADDRESSID, value);
    }

    /**Gets the attribute value for AddressLine1, using the alias name AddressLine1
     */
    public String getAddressLine1() {
        return (String)getAttributeInternal(ADDRESSLINE1);
    }

    /**Sets <code>value</code> as the attribute value for AddressLine1
     */
    public void setAddressLine1(String value) {
        setAttributeInternal(ADDRESSLINE1, value);
    }

    /**Gets the attribute value for AddressLine2, using the alias name AddressLine2
     */
    public String getAddressLine2() {
        return (String)getAttributeInternal(ADDRESSLINE2);
    }

    /**Sets <code>value</code> as the attribute value for AddressLine2
     */
    public void setAddressLine2(String value) {
        setAttributeInternal(ADDRESSLINE2, value);
    }

    /**Gets the attribute value for AddressLine3, using the alias name AddressLine3
     */
    public String getAddressLine3() {
        return (String)getAttributeInternal(ADDRESSLINE3);
    }

    /**Sets <code>value</code> as the attribute value for AddressLine3
     */
    public void setAddressLine3(String value) {
        setAttributeInternal(ADDRESSLINE3, value);
    }

    /**Gets the attribute value for AddressName, using the alias name AddressName
     */
    public String getAddressName() {
        return (String)getAttributeInternal(ADDRESSNAME);
    }

    /**Sets <code>value</code> as the attribute value for AddressName
     */
    public void setAddressName(String value) {
        setAttributeInternal(ADDRESSNAME, value);
    }

    /**Gets the attribute value for Attribute1, using the alias name Attribute1
     */
    public String getAttribute1() {
        return (String)getAttributeInternal(ATTRIBUTE1);
    }

    /**Sets <code>value</code> as the attribute value for Attribute1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**Gets the attribute value for Attribute10, using the alias name Attribute10
     */
    public String getAttribute10() {
        return (String)getAttributeInternal(ATTRIBUTE10);
    }

    /**Sets <code>value</code> as the attribute value for Attribute10
     */
    public void setAttribute10(String value) {
        setAttributeInternal(ATTRIBUTE10, value);
    }

    /**Gets the attribute value for Attribute11, using the alias name Attribute11
     */
    public String getAttribute11() {
        return (String)getAttributeInternal(ATTRIBUTE11);
    }

    /**Sets <code>value</code> as the attribute value for Attribute11
     */
    public void setAttribute11(String value) {
        setAttributeInternal(ATTRIBUTE11, value);
    }

    /**Gets the attribute value for Attribute12, using the alias name Attribute12
     */
    public String getAttribute12() {
        return (String)getAttributeInternal(ATTRIBUTE12);
    }

    /**Sets <code>value</code> as the attribute value for Attribute12
     */
    public void setAttribute12(String value) {
        setAttributeInternal(ATTRIBUTE12, value);
    }

    /**Gets the attribute value for Attribute13, using the alias name Attribute13
     */
    public String getAttribute13() {
        return (String)getAttributeInternal(ATTRIBUTE13);
    }

    /**Sets <code>value</code> as the attribute value for Attribute13
     */
    public void setAttribute13(String value) {
        setAttributeInternal(ATTRIBUTE13, value);
    }

    /**Gets the attribute value for Attribute14, using the alias name Attribute14
     */
    public String getAttribute14() {
        return (String)getAttributeInternal(ATTRIBUTE14);
    }

    /**Sets <code>value</code> as the attribute value for Attribute14
     */
    public void setAttribute14(String value) {
        setAttributeInternal(ATTRIBUTE14, value);
    }

    /**Gets the attribute value for Attribute15, using the alias name Attribute15
     */
    public String getAttribute15() {
        return (String)getAttributeInternal(ATTRIBUTE15);
    }

    /**Sets <code>value</code> as the attribute value for Attribute15
     */
    public void setAttribute15(String value) {
        setAttributeInternal(ATTRIBUTE15, value);
    }

    /**Gets the attribute value for Attribute2, using the alias name Attribute2
     */
    public String getAttribute2() {
        return (String)getAttributeInternal(ATTRIBUTE2);
    }

    /**Sets <code>value</code> as the attribute value for Attribute2
     */
    public void setAttribute2(String value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**Gets the attribute value for Attribute3, using the alias name Attribute3
     */
    public String getAttribute3() {
        return (String)getAttributeInternal(ATTRIBUTE3);
    }

    /**Sets <code>value</code> as the attribute value for Attribute3
     */
    public void setAttribute3(String value) {
        setAttributeInternal(ATTRIBUTE3, value);
    }

    /**Gets the attribute value for Attribute4, using the alias name Attribute4
     */
    public String getAttribute4() {
        return (String)getAttributeInternal(ATTRIBUTE4);
    }

    /**Sets <code>value</code> as the attribute value for Attribute4
     */
    public void setAttribute4(String value) {
        setAttributeInternal(ATTRIBUTE4, value);
    }

    /**Gets the attribute value for Attribute5, using the alias name Attribute5
     */
    public String getAttribute5() {
        return (String)getAttributeInternal(ATTRIBUTE5);
    }

    /**Sets <code>value</code> as the attribute value for Attribute5
     */
    public void setAttribute5(String value) {
        setAttributeInternal(ATTRIBUTE5, value);
    }

    /**Gets the attribute value for Attribute6, using the alias name Attribute6
     */
    public String getAttribute6() {
        return (String)getAttributeInternal(ATTRIBUTE6);
    }

    /**Sets <code>value</code> as the attribute value for Attribute6
     */
    public void setAttribute6(String value) {
        setAttributeInternal(ATTRIBUTE6, value);
    }

    /**Gets the attribute value for Attribute7, using the alias name Attribute7
     */
    public String getAttribute7() {
        return (String)getAttributeInternal(ATTRIBUTE7);
    }

    /**Sets <code>value</code> as the attribute value for Attribute7
     */
    public void setAttribute7(String value) {
        setAttributeInternal(ATTRIBUTE7, value);
    }

    /**Gets the attribute value for Attribute8, using the alias name Attribute8
     */
    public String getAttribute8() {
        return (String)getAttributeInternal(ATTRIBUTE8);
    }

    /**Sets <code>value</code> as the attribute value for Attribute8
     */
    public void setAttribute8(String value) {
        setAttributeInternal(ATTRIBUTE8, value);
    }

    /**Gets the attribute value for Attribute9, using the alias name Attribute9
     */
    public String getAttribute9() {
        return (String)getAttributeInternal(ATTRIBUTE9);
    }

    /**Sets <code>value</code> as the attribute value for Attribute9
     */
    public void setAttribute9(String value) {
        setAttributeInternal(ATTRIBUTE9, value);
    }

    /**Gets the attribute value for AttributeCategory, using the alias name AttributeCategory
     */
    public String getAttributeCategory() {
        return (String)getAttributeInternal(ATTRIBUTECATEGORY);
    }

    /**Sets <code>value</code> as the attribute value for AttributeCategory
     */
    public void setAttributeCategory(String value) {
        setAttributeInternal(ATTRIBUTECATEGORY, value);
    }

    /**Gets the attribute value for Country, using the alias name Country
     */
    public String getCountry() {
        return (String)getAttributeInternal(COUNTRY);
    }

    /**Sets <code>value</code> as the attribute value for Country
     */
    public void setCountry(String value) {
        setAttributeInternal(COUNTRY, value);
    }

    /**Gets the attribute value for CreatedBy, using the alias name CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**Sets <code>value</code> as the attribute value for CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**Gets the attribute value for CreationDate, using the alias name CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**Sets <code>value</code> as the attribute value for CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**Gets the attribute value for Description, using the alias name Description
     */
    public String getDescription() {
        return (String)getAttributeInternal(DESCRIPTION);
    }

    /**Sets <code>value</code> as the attribute value for Description
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**Gets the attribute value for EmailAddress, using the alias name EmailAddress
     */
    public String getEmailAddress() {
        return (String)getAttributeInternal(EMAILADDRESS);
    }

    /**Sets <code>value</code> as the attribute value for EmailAddress
     */
    public void setEmailAddress(String value) {
        setAttributeInternal(EMAILADDRESS, value);
    }

    /**Gets the attribute value for EndDate, using the alias name EndDate
     */
    public Date getEndDate() {
        return (Date)getAttributeInternal(ENDDATE);
    }

    /**Sets <code>value</code> as the attribute value for EndDate
     */
    public void setEndDate(Date value) {
        setAttributeInternal(ENDDATE, value);
    }

    /**Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**Sets <code>value</code> as the attribute value for LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**Sets <code>value</code> as the attribute value for LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**Gets the attribute value for LastUpdateLogin, using the alias name LastUpdateLogin
     */
    public Number getLastUpdateLogin() {
        return (Number)getAttributeInternal(LASTUPDATELOGIN);
    }

    /**Sets <code>value</code> as the attribute value for LastUpdateLogin
     */
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**Gets the attribute value for PostalCode, using the alias name PostalCode
     */
    public String getPostalCode() {
        return (String)getAttributeInternal(POSTALCODE);
    }

    /**Sets <code>value</code> as the attribute value for PostalCode
     */
    public void setPostalCode(String value) {
        setAttributeInternal(POSTALCODE, value);
    }

    /**Gets the attribute value for StartDate, using the alias name StartDate
     */
    public Date getStartDate() {
        return (Date)getAttributeInternal(STARTDATE);
    }

    /**Sets <code>value</code> as the attribute value for StartDate
     */
    public void setStartDate(Date value) {
        setAttributeInternal(STARTDATE, value);
    }

    /**Gets the attribute value for TelephoneNumber1, using the alias name TelephoneNumber1
     */
    public String getTelephoneNumber1() {
        return (String)getAttributeInternal(TELEPHONENUMBER1);
    }

    /**Sets <code>value</code> as the attribute value for TelephoneNumber1
     */
    public void setTelephoneNumber1(String value) {
        setAttributeInternal(TELEPHONENUMBER1, value);
    }

    /**Gets the attribute value for TelephoneNumber2, using the alias name TelephoneNumber2
     */
    public String getTelephoneNumber2() {
        return (String)getAttributeInternal(TELEPHONENUMBER2);
    }

    /**Sets <code>value</code> as the attribute value for TelephoneNumber2
     */
    public void setTelephoneNumber2(String value) {
        setAttributeInternal(TELEPHONENUMBER2, value);
    }

    /**Gets the attribute value for TelephoneNumber3, using the alias name TelephoneNumber3
     */
    public String getTelephoneNumber3() {
        return (String)getAttributeInternal(TELEPHONENUMBER3);
    }

    /**Sets <code>value</code> as the attribute value for TelephoneNumber3
     */
    public void setTelephoneNumber3(String value) {
        setAttributeInternal(TELEPHONENUMBER3, value);
    }

    /**Gets the attribute value for TownOrCity, using the alias name TownOrCity
     */
    public String getTownOrCity() {
        return (String)getAttributeInternal(TOWNORCITY);
    }

    /**Sets <code>value</code> as the attribute value for TownOrCity
     */
    public void setTownOrCity(String value) {
        setAttributeInternal(TOWNORCITY, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case ADDRESSID:
            return getAddressId();
        case ADDRESSLINE1:
            return getAddressLine1();
        case ADDRESSLINE2:
            return getAddressLine2();
        case ADDRESSLINE3:
            return getAddressLine3();
        case ADDRESSNAME:
            return getAddressName();
        case ATTRIBUTE1:
            return getAttribute1();
        case ATTRIBUTE10:
            return getAttribute10();
        case ATTRIBUTE11:
            return getAttribute11();
        case ATTRIBUTE12:
            return getAttribute12();
        case ATTRIBUTE13:
            return getAttribute13();
        case ATTRIBUTE14:
            return getAttribute14();
        case ATTRIBUTE15:
            return getAttribute15();
        case ATTRIBUTE2:
            return getAttribute2();
        case ATTRIBUTE3:
            return getAttribute3();
        case ATTRIBUTE4:
            return getAttribute4();
        case ATTRIBUTE5:
            return getAttribute5();
        case ATTRIBUTE6:
            return getAttribute6();
        case ATTRIBUTE7:
            return getAttribute7();
        case ATTRIBUTE8:
            return getAttribute8();
        case ATTRIBUTE9:
            return getAttribute9();
        case ATTRIBUTECATEGORY:
            return getAttributeCategory();
        case COUNTRY:
            return getCountry();
        case CREATEDBY:
            return getCreatedBy();
        case CREATIONDATE:
            return getCreationDate();
        case DESCRIPTION:
            return getDescription();
        case EMAILADDRESS:
            return getEmailAddress();
        case ENDDATE:
            return getEndDate();
        case LASTUPDATEDBY:
            return getLastUpdatedBy();
        case LASTUPDATEDATE:
            return getLastUpdateDate();
        case LASTUPDATELOGIN:
            return getLastUpdateLogin();
        case POSTALCODE:
            return getPostalCode();
        case STARTDATE:
            return getStartDate();
        case TELEPHONENUMBER1:
            return getTelephoneNumber1();
        case TELEPHONENUMBER2:
            return getTelephoneNumber2();
        case TELEPHONENUMBER3:
            return getTelephoneNumber3();
        case TOWNORCITY:
            return getTownOrCity();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case ADDRESSID:
            setAddressId((Number)value);
            return;
        case ADDRESSLINE1:
            setAddressLine1((String)value);
            return;
        case ADDRESSLINE2:
            setAddressLine2((String)value);
            return;
        case ADDRESSLINE3:
            setAddressLine3((String)value);
            return;
        case ADDRESSNAME:
            setAddressName((String)value);
            return;
        case ATTRIBUTE1:
            setAttribute1((String)value);
            return;
        case ATTRIBUTE10:
            setAttribute10((String)value);
            return;
        case ATTRIBUTE11:
            setAttribute11((String)value);
            return;
        case ATTRIBUTE12:
            setAttribute12((String)value);
            return;
        case ATTRIBUTE13:
            setAttribute13((String)value);
            return;
        case ATTRIBUTE14:
            setAttribute14((String)value);
            return;
        case ATTRIBUTE15:
            setAttribute15((String)value);
            return;
        case ATTRIBUTE2:
            setAttribute2((String)value);
            return;
        case ATTRIBUTE3:
            setAttribute3((String)value);
            return;
        case ATTRIBUTE4:
            setAttribute4((String)value);
            return;
        case ATTRIBUTE5:
            setAttribute5((String)value);
            return;
        case ATTRIBUTE6:
            setAttribute6((String)value);
            return;
        case ATTRIBUTE7:
            setAttribute7((String)value);
            return;
        case ATTRIBUTE8:
            setAttribute8((String)value);
            return;
        case ATTRIBUTE9:
            setAttribute9((String)value);
            return;
        case ATTRIBUTECATEGORY:
            setAttributeCategory((String)value);
            return;
        case COUNTRY:
            setCountry((String)value);
            return;
        case CREATEDBY:
            setCreatedBy((Number)value);
            return;
        case CREATIONDATE:
            setCreationDate((Date)value);
            return;
        case DESCRIPTION:
            setDescription((String)value);
            return;
        case EMAILADDRESS:
            setEmailAddress((String)value);
            return;
        case ENDDATE:
            setEndDate((Date)value);
            return;
        case LASTUPDATEDBY:
            setLastUpdatedBy((Number)value);
            return;
        case LASTUPDATEDATE:
            setLastUpdateDate((Date)value);
            return;
        case LASTUPDATELOGIN:
            setLastUpdateLogin((Number)value);
            return;
        case POSTALCODE:
            setPostalCode((String)value);
            return;
        case STARTDATE:
            setStartDate((Date)value);
            return;
        case TELEPHONENUMBER1:
            setTelephoneNumber1((String)value);
            return;
        case TELEPHONENUMBER2:
            setTelephoneNumber2((String)value);
            return;
        case TELEPHONENUMBER3:
            setTelephoneNumber3((String)value);
            return;
        case TOWNORCITY:
            setTownOrCity((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number addressId) {
        return new Key(new Object[]{addressId});
    }
}
