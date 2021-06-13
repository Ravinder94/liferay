package com.softwaresavvyblog.eventproducer.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.softwaresavvyblog.eventproducer.constants.EventProducerPortletKeys;

/**
 * @author ravinder
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EventProducer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventProducerPortletKeys.EVENTPRODUCER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=userEmailAddress;http://dreamguytechnologies:9080/apply-job",
		"javax.portlet.supported-publishing-event=userName;http://dreamguytechnologies:9080/apply-job"
	},
	service = Portlet.class
)
public class EventProducerPortlet extends MVCPortlet {
	
	@ProcessAction(name = "sendEvent")
	public void sendEvent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		String email=ParamUtil.getString(actionRequest, "email");
		String name=ParamUtil.getString(actionRequest, "name");
		
		
		javax.xml.namespace.QName qName = new javax.xml.namespace.QName("http://dreamguytechnologies:9080/apply-job", "userEmailAddress", "event");
		javax.xml.namespace.QName qName1 = new javax.xml.namespace.QName("http://dreamguytechnologies:9080/apply-job", "name", "event");
		
		actionResponse.setEvent(qName,email);
		actionResponse.setEvent(qName1,name);
		
		
		
	}
	
	Log _log=LogFactoryUtil.getLog(EventProducerPortlet.class);
}