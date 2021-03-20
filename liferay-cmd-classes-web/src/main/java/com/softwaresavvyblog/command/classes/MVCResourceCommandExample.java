package com.softwaresavvyblog.command.classes;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.softwaresavvyblog.command.classes.constants.LiferayCommandClassExamplePortletKeys;

@Component(
		property = {
				"javax.portlet.name="+LiferayCommandClassExamplePortletKeys.LIFERAYCOMMANDCLASSEXAMPLE,
				"mvc.command.name=/command/resource_command"
		},
		service = MVCResourceCommand.class
)
public class MVCResourceCommandExample extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// TODO : Place your ajax processing logic here
		
		_log.info("MVCResourceCommandExample : doServeResource(-,-) ");
		PrintWriter printWriter= resourceResponse.getWriter();
		
		printWriter.write("ok");
		printWriter.flush();

	}
	
	// TODO : Place here your service reference here using @Reference 
	
	
	private static final Log _log= LogFactoryUtil.getLog(MVCResourceCommandExample.class);

}
