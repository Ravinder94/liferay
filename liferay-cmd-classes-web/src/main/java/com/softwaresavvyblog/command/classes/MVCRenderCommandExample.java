package com.softwaresavvyblog.command.classes;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.softwaresavvyblog.command.classes.constants.LiferayCommandClassExamplePortletKeys;

@Component(
		property = {
				"javax.portlet.name="+LiferayCommandClassExamplePortletKeys.LIFERAYCOMMANDCLASSEXAMPLE,
				"mvc.command.name=/command/render_command"
		},
		service = MVCRenderCommand.class
)
public class MVCRenderCommandExample implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	
		_log.info("MVCRenderCommandExample : render(-,-)");
		
		// TODO : Place your logic here
		
		return "/view.jsp";
	}
	
	// TODO : place here your service reference var's here with @Reference

	private static final Log _log=LogFactoryUtil.getLog(MVCRenderCommandExample.class);
}
