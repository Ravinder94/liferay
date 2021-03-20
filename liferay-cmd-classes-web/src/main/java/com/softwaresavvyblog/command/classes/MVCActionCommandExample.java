package com.softwaresavvyblog.command.classes;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.softwaresavvyblog.command.classes.constants.LiferayCommandClassExamplePortletKeys;

@Component(
		property = {
			"javax.portlet.name="+LiferayCommandClassExamplePortletKeys.LIFERAYCOMMANDCLASSEXAMPLE,
			"mvc.command.name=/commands/action_command"
		},
		service = MVCActionCommand.class 
)
public class MVCActionCommandExample extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
	
		_log.info("From doProcessAction(-,-)");
		
		// TODO : Place here your intermediate logic to interact with backend services
		
	}

	// place service references here with @Reference annotation
	
	private static final Log _log = LogFactoryUtil.getLog(MVCActionCommandExample.class);
}
