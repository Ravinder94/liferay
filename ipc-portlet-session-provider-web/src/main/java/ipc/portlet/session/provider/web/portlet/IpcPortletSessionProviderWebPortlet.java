package ipc.portlet.session.provider.web.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import ipc.portlet.session.provider.web.constants.IpcPortletSessionProviderWebPortletKeys;

/**
 * @author ravinder
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=IpcPortletSessionProviderWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + IpcPortletSessionProviderWebPortletKeys.IPCPORTLETSESSIONPROVIDERWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=flase",
		"javax.portlet.supported-public-render-parameter=name"
	},
	service = Portlet.class
)
public class IpcPortletSessionProviderWebPortlet extends MVCPortlet {
	
	
	@ProcessAction(name = "sendData")
	public void sendData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		String name= ParamUtil.getString(actionRequest, "name");
		String email= ParamUtil.getString(actionRequest, "email");
		String mobilenum= ParamUtil.getString(actionRequest, "mobilenum");
		
//		PortletSession portletSession= actionRequest.getPortletSession();
//		
//		portletSession.setAttribute("name", name, PortletSession.APPLICATION_SCOPE);
//		portletSession.setAttribute("email", email, PortletSession.APPLICATION_SCOPE);
//		portletSession.setAttribute("mobilenum", mobilenum, PortletSession.APPLICATION_SCOPE);
		
		log.info("name : "+name);

		actionResponse.getRenderParameters().setValue("name",name);
		
		
	}
	
	Log log = LogFactoryUtil.getLog(IpcPortletSessionProviderWebPortlet.class);
	
}