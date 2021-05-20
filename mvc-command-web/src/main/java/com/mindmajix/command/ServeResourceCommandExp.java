package com.mindmajix.command;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.mindmajix.mvccommand.constants.MvcCommandPortletKeys;

@Component(
		property = {
				"javax.portlet.name=" + MvcCommandPortletKeys.MVCCOMMAND,
				"mvc.command.name=resource/example"
				
		},
		service = MVCResourceCommand.class
)
public class ServeResourceCommandExp extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		_log.info("doServeResource(-,) called ");
		
		// TODO : read request param
		// TODO : do service call
		
		List<User> userList = UserLocalServiceUtil.getUsers(1, 10000);
		PrintWriter writter = resourceResponse.getWriter();
		
		_log.info(userList);
		
		writter.println(userList);
		 
		writter.flush();
		
		
	}
	
	private Log _log= LogFactoryUtil.getLog(ServeResourceCommandExp.class);
	

}
