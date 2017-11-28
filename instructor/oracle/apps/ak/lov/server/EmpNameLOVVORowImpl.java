package instructor.oracle.apps.ak.lov.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmpNameLOVVORowImpl extends OAViewRowImpl {
    public static final int EMPLOYEENAME = 0;
    public static final int EMPLOYEENUMBER = 1;
    public static final int EMAILADDRESS = 2;

    /**This is the default constructor (do not remove)
     */
    public EmpNameLOVVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute EmployeeName
     */
    public String getEmployeeName() {
        return (String) getAttributeInternal(EMPLOYEENAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute EmployeeName
     */
    public void setEmployeeName(String value) {
        setAttributeInternal(EMPLOYEENAME, value);
    }

    /**Gets the attribute value for the calculated attribute EmployeeNumber
     */
    public Number getEmployeeNumber() {
        return (Number) getAttributeInternal(EMPLOYEENUMBER);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute EmployeeNumber
     */
    public void setEmployeeNumber(Number value) {
        setAttributeInternal(EMPLOYEENUMBER, value);
    }

    /**Gets the attribute value for the calculated attribute EmailAddress
     */
    public String getEmailAddress() {
        return (String) getAttributeInternal(EMAILADDRESS);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute EmailAddress
     */
    public void setEmailAddress(String value) {
        setAttributeInternal(EMAILADDRESS, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case EMPLOYEENAME:
            return getEmployeeName();
        case EMPLOYEENUMBER:
            return getEmployeeNumber();
        case EMAILADDRESS:
            return getEmailAddress();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}