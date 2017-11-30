/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package instructor.oracle.apps.ak.employee.webui;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;

import oracle.jbo.domain.Number;


/**
 * Controller for ...
 */
public class EmpCreateCO extends OAControllerImpl {
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

    /**
     * Layout and page setup logic for a region.
     * @param pageContext the current OA page context
     * @param webBean the web bean corresponding to the region
     */
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        //Always call this first
        super.processRequest(pageContext, webBean);
        OAApplicationModule am = pageContext.getApplicationModule(webBean);

        if (!pageContext.isFormSubmission()) {
            am.invokeMethod("createEmployee", null);
            // Initialize the PVO for PPR.
            am.invokeMethod("init");

        }

        // If isBackNavigationFired = false, we're here after a valid
        // navigation (the user selected the Create Empoyee button) and
        // we should proceed normally and initialize a new employee.

        if (!pageContext.isBackNavigationFired(false)) {
            // We indicate that we are starting the create transaction
            // (this  is used to ensure correct Back button behavior).
            TransactionUnitHelper.startTransactionUnit(pageContext,
                                                       "empCreateTxn");
            // This test ensures that we don't try to create a new
            // employee if we had a JVM failover, or if a recyled
            // application module is activated after passivation.
            // If these things happen, BC4J will be able to find
            // the row that you created so the user can resume work.
        } else {
            if (!TransactionUnitHelper.isTransactionUnitInProgress(pageContext,
                                                                   "empCreateTxn",
                                                                   true)) {
                // We got here through some use of the browser "Back"
                // button, so we want to display a stale data error and
                // disallow access to the page. If this were a real
                // application, we would probably display a more
                // context-specific message telling the user she can't
                // use the browser "Back" button and the "Create" page.
                // Instead, we wanted to illustrate how to display the
                // Applications standard NAVIGATION ERROR message.

                OADialogPage dialogPage = new OADialogPage(NAVIGATION_ERROR);
                pageContext.redirectToDialogPage(dialogPage);
            }
        }


    } //  end processRequest

    /**
     * Procedure to handle form submissions for form elements in
     * a region.
     * @param pageContext the current OA page context
     * @param webBean the web bean corresponding to the region
     */
    public void processFormRequest(OAPageContext pageContext,
                                   OAWebBean webBean) {
        super.processFormRequest(pageContext, webBean);

        OAApplicationModule am = pageContext.getApplicationModule(webBean);

        //Handle the PPR for position change
        if ("positionChange".equals(pageContext.getParameter(OAWebBeanConstants.EVENT_PARAM))) {
            // The PositionCode PPR change event has fired.
            am.invokeMethod("handlePositionChangeEvent");
        }

        // Pressing the "Apply" button means the transaction should be
        // validated and committed.
        if (pageContext.getParameter("Apply") != null) {
            // Generally in the tutorial and the labs, we've illustrated
            // all BC4J interaction on the server (except for the AMs).
            // Here, we deal with the VO directly so the comments about
            // the reasons why we're getting values from the VO, not the
            // request, make sense in context.
            OAViewObject vo =
                (OAViewObject)am.findViewObject("EmployeeDetailsVO1");

            // Note that we have to get this value from the VO because the
            // EO will assemble it during its validation cycle.
            // For performance reasons, we should generally be calling
            // getEmployeeName() on the DetailsVORowImpl object, but we
            // don't want to do this on the client so we're illustrating
            // the interface-appropriate call. If we implemented this code
            // in the AM where it belongs, we would use the other
            // approach.
            String employeeName =
                (String)vo.getCurrentRow().getAttribute("FirstName") + " " +
                (String)vo.getCurrentRow().getAttribute("LastName");
            // We need to get a String so we can pass it to the
            // MessageToken array below. Note that we are getting this
            // value from the VO (we could also get it from the Bean as
            // shown in the Drilldown to Details lab) because the item
            // style is messageStyledText, so the value isn't put on the
            // request like a messaqeTextInput value is.
            Number employeeNumber =
                (Number)vo.getCurrentRow().getAttribute("EmployeeId");
            String employeeNum = String.valueOf(employeeNumber.intValue());

            MessageToken[] tokens =
            { new MessageToken("EMP_NAME", employeeName),
              new MessageToken("EMP_NUMBER", employeeNum) };
            OAException confirmMessage =
                new OAException("AK", "FWK_TBX_T_EMP_CREATE_CONFIRM", tokens,
                                OAException.CONFIRMATION, null);

            am.invokeMethod("apply");

            OADialogPage dialogPage =
                new OADialogPage(OAException.CONFIRMATION, confirmMessage,
                                 null,
                                 "OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmployeePG",
                                 "OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmpCreatePG");
            // We set this value so the code that handles this button
            // press is descriptive.
            dialogPage.setOkButtonItemName("CreateOKButton");
            dialogPage.setOkButtonLabel("To Employee Query Page");
            dialogPage.setNoButtonLabel("Add Another Employee");
            dialogPage.setPostToCallingPage(true);

            pageContext.redirectToDialogPage(dialogPage);

        }

        if (pageContext.getParameter("Cancel") != null) {
            am.invokeMethod("rollbackEmployee");
            // Indicate that the Create transaction is complete.
            TransactionUnitHelper.endTransactionUnit(pageContext,
                                                     "empCreateTxn");
            pageContext.forwardImmediately("OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmployeePG",
                                           null,
                                           OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                           null, null, false,
                                           OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
        }


    }

}
