package com.mindmajix.command;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.mindmajix.mvccommand.constants.MvcCommandPortletKeys;

@Component(
		property = {
				"javax.portlet.name=" + MvcCommandPortletKeys.MVCCOMMAND,
				"mvc.command.name=render/example"
				
		},
		service = MVCRenderCommand.class
)
public class RenderCommandExp implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		return "/render-cmd.jsp";
		
	}

}
