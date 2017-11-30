package instructor.oracle.apps.ak.schema.server;

import oracle.jbo.domain.Number;

import oracle.apps.fnd.framework.server.OAEntityExpert;

public class EmployeeEntityExpert extends OAEntityExpert {

    /*
     *****************************************************************
     * Returns true if the given employee is currently active and
     * false if not.
    *****************************************************************
     */

    public boolean isEmployeeActive(Number employeeId) {
        boolean isActive = false;
        EmployeeVVOImpl empVO =
            (EmployeeVVOImpl)findValidationViewObject("EmployeeVVO1");
        empVO.initQuery(employeeId);

        // Just doing a simple existence check. If you don't find a
        // match, return false.
        if (empVO.hasNext()) {
            isActive = true;
        }
        return isActive;
    } // end isEmployeeActive()


    /*
            *****************************************************************
             * Returns true if the given position is valid.
            *****************************************************************
             */

    public boolean isPositionValid(String position) {
        boolean isActive = false;
        PositionVVOImpl positionVO =
            (PositionVVOImpl)findValidationViewObject("PositionVVO1");
        positionVO.initQuery(position);

        // Just do a simple existence check. If you don't find a
        // match, return false.
        if (positionVO.hasNext()) {
            isActive = true;
        }
        return isActive;
    } // end isPositionValid()


}
