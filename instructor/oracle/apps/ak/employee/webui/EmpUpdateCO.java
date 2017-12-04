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

import java.io.Serializable;


/**
 * Controller for ...
 */
public class EmpUpdateCO extends OAControllerImpl {
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

        // Put a transaction value indicating that the update transaction
        // is now in progress.
        TransactionUnitHelper.startTransactionUnit(pageContext,
                                                   "empUpdateTxn");

        String empNum = pageContext.getParameter("empNum");
        // You will use this at the end of the flow for a confirmation
        // message.
        String empName = pageContext.getParameter("empName");
        pageContext.putTransactionValue("empName", empName);
        Serializable[] params = { empNum };
        // For the update, since you're using the same VO as the Details
        // page, you can use the same initialization logic.
        am.invokeMethod("initDetails", params);


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

        if (pageContext.getParameter("Apply") != null) {
            OAViewObject vo =
                (OAViewObject)am.findViewObject("EmployeeDetailsVO1");
            String employeeName =
                (String)vo.getCurrentRow().getAttribute("FirstName") + " " +
                (String)vo.getCurrentRow().getAttribute("LastName");
            Number employeeNumber =
                (Number)vo.getCurrentRow().getAttribute("EmployeeId");
            String employeeNum = String.valueOf(employeeNumber.intValue());
            MessageToken[] tokens =
            { new MessageToken("EMP_NAME", employeeName),
              new MessageToken("EMP_NUMBER", employeeNum) };
            OAException confirmMessage =
                new OAException("AK", "FWK_TBX_T_EMP_UPDATE_CONFIRM", tokens,
                                OAException.CONFIRMATION, null);
            am.invokeMethod("apply");
            OADialogPage dialogPage =
                new OADialogPage(OAException.CONFIRMATION, confirmMessage,
                                 null,
                                 "OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmployeePG",
                                 "OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmployeePG");
            dialogPage.setOkButtonItemName("CreateOKButton");
            dialogPage.setOkButtonLabel("OK");
            dialogPage.setNoButtonLabel("No");
            dialogPage.setPostToCallingPage(true);
            pageContext.redirectToDialogPage(dialogPage);
        }
        if (pageContext.getParameter("Cancel") != null) {
            am.invokeMethod("rollbackEmployee");
            TransactionUnitHelper.endTransactionUnit(pageContext,
                                                     "empUpdateTxn");
            pageContext.forwardImmediately("OA.jsp?page=/instructor/oracle/apps/ak/employee/webui/EmployeePG",
                                           null,
                                           OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                           null, null, false,
                                           OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
        } else if ("positionChange".equals(pageContext.getParameter(OAWebBeanConstants.EVENT_PARAM))) {
            am.invokeMethod("handlePositionChangeEvent");
        }


    }

}
