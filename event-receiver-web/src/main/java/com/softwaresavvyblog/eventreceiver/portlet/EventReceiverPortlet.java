package com.softwaresavvyblog.eventreceiver.portlet;

import javax.portlet.Portlet;
import javax.portlet.ProcessEvent;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.softwaresavvyblog.eventreceiver.constants.EventReceiverPortletKeys;

/**
 * @author ravinder
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EventReceiver",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventReceiverPortletKeys.EVENTRECEIVER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=userEmailAddress;http://dreamguytechnologies:9080/apply-job",
		"javax.portlet.supported-publishing-event=userName;http://dreamguytechnologies:9080/apply-job"
	},
	service = Portlet.class
)
public class EventReceiverPortlet extends MVCPortlet {
	
	@ProcessEvent(qname = "{http://dreamguytechnologies:9080/apply-job}userEmailAddress,{http://dreamguytechnologies:9080/apply-job}userName")
	public void handleProcesseuserEmailAddressEvent(javax.portlet.EventRequest request, javax.portlet.EventResponse response)
	throws javax.portlet.PortletException, java.io.IOException {
	javax.portlet.Event event = request.getEvent();
	String userEmailAddress = (String)event.getValue();
	String name = (String)event.getValue();
	
	
	
	response.getRenderParameters().setValue("userEmailAddress", userEmailAddress);
	response.getRenderParameters().setValue("name", name);
	
	//response.setRenderParameter("userEmailAddress",userEmailAddress);
	
	
	

	}
	
	Log _log=LogFactoryUtil.getLog(EventReceiverPortlet.class);
	
}