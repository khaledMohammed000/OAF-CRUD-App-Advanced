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

import oracle.cabo.ui.data.DictionaryData;
import oracle.cabo.ui.data.DataObjectList;

import oracle.apps.fnd.framework.webui.beans.table.OATableBean;

import oracle.cabo.ui.data.BoundValue;
import oracle.cabo.ui.data.bind.ConcatBoundValue;
import oracle.cabo.ui.data.bind.FixedBoundValue;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OADataBoundValueViewObject;
import oracle.apps.fnd.framework.webui.beans.OAImageBean;

import oracle.apps.fnd.framework.webui.OADialogPage;

import java.io.Serializable;


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

        // This controller is associated with the table.
        OATableBean table = (OATableBean)webBean;
        // You need to format the Switcher image column so the image
        // is centered (this isn't done automatically for Switchers
        // as it is for plain image columns). Start by getting the
        // table's column formats.

        // NOTE!!! You must call the prepareForRendering() method on
        // the table *before* formatting columns. Furthermore, the
        // call must be sequenced *after* the table is queried,
        // and *after* you do any control bar manipulation.
        table.prepareForRendering(pageContext);
        DataObjectList columnFormats = table.getColumnFormats();
        DictionaryData columnFormat = null;
        int childIndex = pageContext.findChildIndex(table, "DeleteSwitcherRN");
        columnFormat = (DictionaryData)columnFormats.getItem(childIndex);
        columnFormat.put(COLUMN_DATA_FORMAT_KEY, ICON_BUTTON_FORMAT);

        // Implement the bound value for the Status Image
        OAImageBean statusImageBean =
            (OAImageBean)table.findIndexedChildRecursive("EmpStatus");
        if (statusImageBean == null) {
            MessageToken[] tokens =
            { new MessageToken("OBJECT_NAME", "EmpStatus") };
            throw new OAException("AK", "FWK_TBX_OBJECT_NOT_FOUND", tokens);
        }
        // Define the OA Framework image directory
        FixedBoundValue imageDirectory =
            new FixedBoundValue(APPS_MEDIA_DIRECTORY);

        // Define a binding between the image bean and the VO attribute
        // that it will reference to get the .gif image value name.
        // Note that the corresponding attribute values are obtained using a
        // decode() in the QueryVO view object.
        OADataBoundValueViewObject statusBinding =
            new OADataBoundValueViewObject(statusImageBean, "EmployeeStatus");

        // Concatenate the image directory with the actual image name
        // (as retrieved from the VO attribute decode() statement)
        ConcatBoundValue statusCBV =
            new ConcatBoundValue(new BoundValue[] { imageDirectory,
                                                    statusBinding });
        // Tell the image bean where to get the image source attribute
        statusImageBean.setAttributeValue(SOURCE_ATTR, statusCBV);

        // For accessibility compliance, you specify the alternate text
        // for an image.  Note you should never use static text as shown
        // (always source translatable text from Message Dictionary when
        // setting display text values programmatically), and ideally,
        // the alternate text should in this case should clearly indicate
        // the status the image represents. Generally, we recommend that
        // you use a Switcher as shown for the Delete column to easily
        // show different images with associated alternate text, but we
        // wanted to show how to use a bound value also in this lab.
        statusImageBean.setAttributeValue(SHORT_DESC_ATTR,
                                          "Employee status indicator");


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
        
        if ("delete".equals(pageContext.getParameter(EVENT_PARAM))) {
                // The user has clicked a delete icon so display a Warning
                // dialog asking to confirm deleting the employee. Note you 
                // configure the dialog so the "Yes" button submits to 
                // this page so you handle the action in processFormRequest()

                String employeeNumber = pageContext.getParameter("empNum");
                String employeeName = pageContext.getParameter("empName");

                MessageToken[] tokens = 
                { new MessageToken("EMP_NAME", employeeName) };
                OAException mainMessage = 
                    new OAException("AK", "FWK_TBX_T_EMP_DELETE_WARN", tokens);

                // Note even though you're going to make your Yes/No buttons
                // submit a form, you still need some non-null value in the
                // constructor's Yes/No URL parameters for the buttons to render,
                // so just pass empty Strings for this.
                OADialogPage dialogPage = 
                    new OADialogPage(OAException.WARNING, mainMessage, null, "", 
                                     "");

                // Always use Message Dictionary for any Strings you want
                // to display.
                String yes = pageContext.getMessage("AK", "FWK_TBX_T_YES", null);
                String no = pageContext.getMessage("AK", "FWK_TBX_T_NO", null);

                // Set this value so the code that handles this button press
                // is descriptive.
                dialogPage.setOkButtonItemName("DeleteYesButton");

                // The following configures the Yes/No buttons to be submit
                // buttons, and handles the form submit in the originating
                // page (EmployeesPG) so you can handle the "Yes" button selection
                // in this controller.
                dialogPage.setOkButtonToPost(true);
                dialogPage.setNoButtonToPost(true);
                dialogPage.setPostToCallingPage(true);

                // Set your Yes/No labels instead of the default OK/Cancel.
                dialogPage.setOkButtonLabel(yes);
                dialogPage.setNoButtonLabel(no);

                // You need to keep hold of the employeeNumber and employeeName.
                // The OADialogPage gives us a convenient means 
                // of doing this. Note that the use of the Hashtable is  
                // most appropriate for passing multiple parameters. See the
                // OADialogPage javadoc for an alternative when dealing with
                // a single parameter.
                java.util.Hashtable formParams = new java.util.Hashtable(1);
                formParams.put("empNum", employeeNumber);
                formParams.put("empName", employeeName);
                dialogPage.setFormParameters(formParams);

                pageContext.redirectToDialogPage(dialogPage);
            } else if (pageContext.getParameter("DeleteYesButton") != null) {

                // User has confirmed that they want to delete this
                // employee. Invoke a method on the AM to set the current
                // row in the VO and call remove() on this row. 
                String employeeNumber = pageContext.getParameter("empNum");
                String employeeName = pageContext.getParameter("empName");
                Serializable[] parameters = { employeeNumber };
                OAApplicationModule am = pageContext.getApplicationModule(webBean);
                am.invokeMethod("deleteEmployee", parameters);

                // Now, redisplay the page with a confirmation message at
                // the top. Note that the deleteEmployee() method in the AM
                // commits, and our code won't get this far if any exceptions
                // are thrown.

                MessageToken[] tokens = 
                { new MessageToken("EMP_NAME", employeeName) };
                OAException message = 
                    new OAException("AK", "FWK_TBX_T_EMP_DELETE_CONFIRM", tokens, 
                                    OAException.CONFIRMATION, null);
                pageContext.putDialogMessage(message);
            }
        
        
    }

}
