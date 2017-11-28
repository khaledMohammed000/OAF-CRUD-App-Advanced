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
import oracle.apps.fnd.framework.webui.beans.layout.OAPageLayoutBean;
import oracle.apps.fnd.common.MessageToken;

import java.io.Serializable;

import oracle.apps.fnd.framework.OAApplicationModule;

/**
 * Controller for ...
 */
public class EmpDetailsCO extends OAControllerImpl {
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
        // Get the employeeNumber parameter from the URL
        String employeeNumber = pageContext.getParameter("employeeNumber");
        // Now we want to initialize the query for our single employee
        //with all of it's details
        OAApplicationModule am = pageContext.getApplicationModule(webBean);
        Serializable[] parameters = { employeeNumber };
        am.invokeMethod("initDetails", parameters);
        //Here we are going to set the selected name in the header
        //Always use a translated value from the message Dictionary when setting
        //strings in your controllers.
        //Instantiate an array of message tokens and set the value for the
        //EMP_NAME token.
        String employeeName = pageContext.getParameter("employeeName");
        MessageToken[] tokens = { new MessageToken("EMP_NAME", employeeName) };
        // Now, get the translated message text including the token value.
        String pageHeaderText =
            pageContext.getMessage("AK", "FWK_TBX_T_EMP_HEADER_TEXT", tokens);
        // Set the employee-specific page title (which also appears in the breadcrumbs).
        //Note that we know this controller is associated with the pageLayout region, which is why we cast the
        //webbean to an OAPageLayoutBean before calling the setTitle.
        ((OAPageLayoutBean)webBean).setTitle(pageHeaderText);
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
    }

}
