package instructor.oracle.apps.ak.schema.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PositionVVORowImpl extends OAViewRowImpl {
    public static final int LOOKUPCODE = 0;

    /**This is the default constructor (do not remove)
     */
    public PositionVVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute LookupCode
     */
    public String getLookupCode() {
        return (String) getAttributeInternal(LOOKUPCODE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute LookupCode
     */
    public void setLookupCode(String value) {
        setAttributeInternal(LOOKUPCODE, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case LOOKUPCODE:
            return getLookupCode();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case LOOKUPCODE:
            setLookupCode((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
