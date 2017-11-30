/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package instructor.oracle.apps.ak.employee.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;


/**
 * Controller for ...
 */
public class EmpResultsCO extends OAControllerImpl {
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
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        // The following checks to see if the user navigated back to this
        // page without taking actions that cleared an "in transaction"
        // indicator. If so, we want to rollback any abandoned changes to
        // ensure they aren't left lingering in the BC4J cache to cause
        // problems with subsequent transactions.  For example, if the
        // user navigates to the Create Employee page where you start a
        // "create" transaction unit, then navigates back to this page
        // using the browser Back button and selects the Create Employee
        // button again, OA Framework detects this Back button nav. And
        // steps through processRequest() so this code is executed before
        // you try to create another new employee.

        if (TransactionUnitHelper.isTransactionUnitInProgress(pageContext,
                                                              "empCreateTxn",
                                                              false)) {
            am.invokeMethod("rollbackEmployee");
            TransactionUnitHelper.endTransactionUnit(pageContext,
                                                     "empCreateTxn");
        } else if (TransactionUnitHelper.isTransactionUnitInProgress(pageContext,
                                                                     "empUpdateTxn",
                                                                     false)) {
            am.invokeMethod("rollbackEmployee");
            TransactionUnitHelper.endTransactionUnit(pageContext,
                                                     "empUpdateTxn");
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
        if (pageContext.getParameter("Create") != null) {
            pageContext.setForwardURL("OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmpCreatePG",
                                      null,
                                      OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                      null, null, false,
                                      OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
                                      OAWebBeanConstants.IGNORE_MESSAGES);

        }
    }

}
