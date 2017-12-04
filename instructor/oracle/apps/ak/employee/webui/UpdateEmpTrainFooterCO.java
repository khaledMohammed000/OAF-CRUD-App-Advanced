/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package instructor.oracle.apps.ak.employee.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.form.OASubmitButtonBean;
import oracle.apps.fnd.framework.webui.beans.nav.OATrainBean;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OADialogPage;

/**
 * Controller for ...
 */
public class UpdateEmpTrainFooterCO extends OAControllerImpl {
    public static final String RCS_ID = "$Header$";
    public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

    /**
     * Layout and page setup logic for a region.
     * @param pageContext the current OA page context
     * @param webBean the web bean corresponding to the region
     */
    public void processRequest(OAPageContext pageContext, OAWebBean webBean) {
        super.processRequest(pageContext, webBean);
        // Figure out whether the Submit button should be rendered or
        // not; this should appear only on the final page (Step 3).
        // The OATrainBean is a named component of the page layout, so
        // you have a special way of getting a handle to it (you can't
        // "find" it like you do for normal, indexed children that would
        // be below the current region in the hierarchy.
        OATrainBean trainBean =
            (OATrainBean)pageContext.getPageLayoutBean().getLocation();
        // You must call the following before getting the target page
        // index.
        trainBean.prepareForRendering(pageContext);
        int step = trainBean.getSelectedTrainStepRenderedIndex();
        if (step + 1 != trainBean.getNumberOfRenderedTrainSteps()) {
            OASubmitButtonBean submitButton =
                (OASubmitButtonBean)webBean.findIndexedChildRecursive("Submit");
            submitButton.setRendered(false);
        }

    }

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

        // This button should only be displayed on the final page...
        if (pageContext.getParameter("Submit") != null) {
            am.invokeMethod("apply");

            String employeeName =
                (String)pageContext.getTransactionValue("empName");

            // Assuming the commit succeeds, you'll display a Confirmation
            // dialog that takes the user back to the Query.

            MessageToken[] tokens =
            { new MessageToken("EMP_NAME", employeeName) };

            OAException confirmMessage =
                new OAException("AK", "FWK_TBX_T_EMP_UPDATE_CONFIRM", tokens);

            OADialogPage dialogPage =
                new OADialogPage(OAException.CONFIRMATION, confirmMessage,
                                 null,
                                 "OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmployeePG",
                                 null);

            // Note that we release the root "UI" application module
            // so we can correctly handle any subsequent "Back" button
            // navigation and attempts to resubmit the transaction.

            pageContext.releaseRootApplicationModule();
            pageContext.redirectToDialogPage(dialogPage);

        } else if (pageContext.getParameter("Cancel") != null) {
            // Cancel button handling is required for Back button support.
            am.invokeMethod("rollbackEmployee");

            // Remove the "in transaction" indicator
            pageContext.removeTransactionValue("empInUpdateTxn");

            // retain AM
            pageContext.forwardImmediately("OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmployeePG",
                                           null,
                                           OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                           null, null, true,
                                           OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
        }
    }

}
