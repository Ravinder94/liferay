package com.mindmajix.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mindmajix.mvccommand.constants.MvcCommandPortletKeys;

@Component(
		property = {
				"javax.portlet.name=" + MvcCommandPortletKeys.MVCCOMMAND,
				"mvc.command.name=action/example"
				
		},
		service = MVCActionCommand.class
)
public class ActionCommandExp extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		_log.info("doProcessAction(-,-) called "); 
		
		// TODO : request values
		// TODO : prepare user Object
		
		
		actionResponse.setRenderParameter("respone", "value");
		
		_userLocalService.addUser(null);

	}
	
	
	private  final Log _log= LogFactoryUtil.getLog(ActionCommandExp.class);
	
	@Reference
	private UserLocalService _userLocalService;

}
