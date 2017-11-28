package instructor.oracle.apps.ak.first.server;

import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class FirstAMImpl extends OAApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public FirstAMImpl() {
    }

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("instructor.oracle.apps.ak.first.server", /* package name */
      "FirstAMLocal" /* Configuration Name */);
    }

    /**Container's getter for AddressVO1
     */
    public OAViewObjectImpl getAddressVO1() {
        return (OAViewObjectImpl)findViewObject("AddressVO1");
    }
}