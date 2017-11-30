package instructor.oracle.apps.ak.employee.server;

import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;

import oracle.jbo.Row;

import oracle.apps.fnd.framework.OAViewObject;

import oracle.jbo.Transaction;
import oracle.jbo.domain.Number;

import oracle.apps.fnd.framework.OARow;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmpCreateAMImpl extends OAApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public EmpCreateAMImpl() {
    }

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) { /* package name */
        /* Configuration Name */launchTester("instructor.oracle.apps.ak.employee.server",
                                             "EmpCreateAMLocal");
    }

    /**Container's getter for EmployeeDetailsVO1
     */
    public EmployeeDetailsVOImpl getEmployeeDetailsVO1() {
        return (EmployeeDetailsVOImpl)findViewObject("EmployeeDetailsVO1");
    }

    /**Container's getter for PositionsVO1
     */
    public OAViewObjectImpl getPositionsVO1() {
        return (OAViewObjectImpl)findViewObject("PositionsVO1");
    }


    public void createEmployee() {
        OAViewObject vo = (OAViewObject)getEmployeeDetailsVO1();

        // Per the coding standards, this is the proper way to
        // initialize a VO that is used for both inserts and
        // queries.  See View Objects in Detail in the Developer's
        // Guide for additional information.
        if (!vo.isPreparedForExecution()) {
            vo.executeQuery();
        }

        Row row = vo.createRow();
        vo.insertRow(row);
        // Required per OA Framework Model Coding Standard M69
        row.setNewRowState(Row.STATUS_INITIALIZED);
    } // end createEmployee()

    public void apply() {
        getTransaction().commit();
    } // end apply()

    public void rollbackEmployee() {
        Transaction txn = getTransaction();
        // This small optimization ensures you don't perform a rollback
        // if you don't have to.
        if (txn.isDirty()) {
            txn.rollback();
        }
    } // end rollbackEmployee()

    /**Container's getter for EmpCreatePVO1
     */
    public OAViewObjectImpl getEmpCreatePVO1() {
        return (OAViewObjectImpl)findViewObject("EmpCreatePVO1");
    }

    /*
         *********************************************************************
         * Handles changes of the position poplist to set the application
         * properties VO value for PPR.
         *********************************************************************
         */

    public void handlePositionChangeEvent() {
        // Get the special, single-row application properties and make
        // the first (only) row current.
        OAViewObject vo = (OAViewObject)findViewObject("EmpCreatePVO1");
        OARow row = (OARow)vo.first();

        // Get the value of the view object attribute with the position
        // code.
        OAViewObject detailsVO =
            (OAViewObject)findViewObject("EmployeeDetailsVO1");
        OARow detailsRow = (OARow)detailsVO.getCurrentRow();
        String position = (String)detailsRow.getAttribute("PositionCode");
        if ((position == null) || ("PRESIDENT".equals(position))) {
            row.setAttribute("ManagerRendered", Boolean.FALSE);
        } else {
            row.setAttribute("ManagerRendered", Boolean.TRUE);
        }
    } // end handlePositionChangeEvent()

    /*
          *********************************************************************
          * Initializes the transient application properties VO.
          *********************************************************************
          */

    public void init() {
        OAViewObject appPropsVO =
            (OAViewObject)findViewObject("EmpCreatePVO1");
        if (appPropsVO != null) {
            // Do not reinitialize the VO unless needed. Note that
            // this method call does not try to query the database for
            // VOs with no SELECT statement and only transient attributes.
            if (appPropsVO.getFetchedRowCount() == 0) {
                // Setting the match fetch size to 0 for an in-memory VO
                // prevents it from trying to query rows.  Calling
                // executeQuery() ensures that rows aren't lost after
                // a commit in the transaction (BC4J known issue
                // workaround).
                appPropsVO.setMaxFetchSize(0);
                appPropsVO.executeQuery();
                // You must create and insert a row in the VO before you
                // can start setting properties.
                appPropsVO.insertRow(appPropsVO.createRow());
                // Set the primary key value for this single-rwo VO.
                OARow row = (OARow)appPropsVO.first();
                row.setAttribute("RowKey", new Number(1));
            }
        }
        // Initialize the application properties VO (and the UI) based
        // on the default employee position value set on the underlying
        // object.
        handlePositionChangeEvent();
    } // end init()

}