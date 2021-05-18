package com.mj.acec.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mj.acec.constants.ACEPortletKeys;
import com.mx.ace.model.Branch;
import com.mx.ace.model.Student;
import com.mx.ace.service.BranchLocalService;
import com.mx.ace.service.StudentLocalService;

/**
 * @author ravinder
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ACE",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ACEPortletKeys.ACE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ACEPortlet extends MVCPortlet {
	
	
	
	public void addBranch(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		String name=StringPool.BLANK;
		ServiceContext serviceContext=null;
		
		name = ParamUtil.getString(actionRequest, "name");
		
		
		
		try {
			
			serviceContext= ServiceContextFactory.getInstance(Branch.class.getName(), actionRequest);
		
			
			
			_branchLocalService.addBranch(name, serviceContext);
			
			
			SessionMessages.add(actionRequest, "added");
			
			actionResponse.setRenderParameter("mvcPath", "/branch.jsp");
			
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "failure");
		}
		
		
	}
	
	
	
		public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse)
				throws IOException, PortletException {
			
			
			String name=ParamUtil.getString(actionRequest, "name");
			String email=ParamUtil.getString(actionRequest, "email");
			long mbnumber=ParamUtil.getLong(actionRequest, "mbnumber");
			long branchId=ParamUtil.getLong(actionRequest, "branchId");
			
			try {
				ServiceContext serviceContext= ServiceContextFactory.getInstance(Student.class.getName(),actionRequest);
				
				_studentLocalService.addStudent(name,email,mbnumber,branchId,serviceContext);
				
				SessionMessages.add(actionRequest, "added");
				
				actionResponse.setRenderParameter("mvcPath", "/student.jsp");
				
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "failure");
			}
		}
	
	@Reference
	private BranchLocalService _branchLocalService;
	
	@Reference
	private StudentLocalService _studentLocalService;
	
	private Log _log = LogFactoryUtil.getLog(ACEPortlet.class);
	
}