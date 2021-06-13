package ipc.portlet.session.receiver.web.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import ipc.portlet.session.receiver.web.constants.IpcPortletSessionReceiverWebPortletKeys;

/**
 * @author ravinder
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=IpcPortletSessionReceiverWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + IpcPortletSessionReceiverWebPortletKeys.IPCPORTLETSESSIONRECEIVERWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=flase",
		"javax.portlet.supported-public-render-parameter=name"
	},
	service = Portlet.class
)
public class IpcPortletSessionReceiverWebPortlet extends MVCPortlet {
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
//		 PortletSession portletSession=renderRequest.getPortletSession();
		
//		String name= (String) portletSession.getAttribute("name", PortletSession.APPLICATION_SCOPE);
//		String email= (String) portletSession.getAttribute("email", PortletSession.APPLICATION_SCOPE);
//		String mobilnum= (String) portletSession.getAttribute("mobilenum", PortletSession.APPLICATION_SCOPE);
//		
		
		String name= ParamUtil.getString(renderRequest, "name");
		
		log.info("name : "+name);
//		log.info("email : "+email);
//		log.info("mobilnum : "+mobilnum);
//		
		renderRequest.setAttribute("name", name);
//		renderRequest.setAttribute("email", email);
//		renderRequest.setAttribute("mobilnum", mobilnum);
//		
		super.render(renderRequest, renderResponse);
	}
	
	Log log = LogFactoryUtil.getLog(IpcPortletSessionReceiverWebPortlet.class);
	
}