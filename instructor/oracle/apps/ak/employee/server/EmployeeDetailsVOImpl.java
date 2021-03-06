package instructor.oracle.apps.ak.employee.server;

import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.apps.fnd.framework.OAException;

import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeeDetailsVOImpl extends OAViewObjectImpl {
    /**This is the default constructor (do not remove)
     */
    public EmployeeDetailsVOImpl() {


    }

    public void initQuery(String employeeNumber) {
        if ((employeeNumber != null) &&
            (!("".equals(employeeNumber.trim())))) {
            // Do the following conversion for type consistency.
            Number empNum = null;

            try {
                empNum = new Number(employeeNumber);
            } catch (Exception e) {
                throw new OAException("AK", "FWK_TBX_INVALID_EMP_NUMBER");
            }
            setWhereClause("EMPLOYEE_ID = :1");
            setWhereClauseParams(null); // Always reset
            setWhereClauseParam(0, empNum);
            executeQuery();

        }
    } // end initQuery()

}
