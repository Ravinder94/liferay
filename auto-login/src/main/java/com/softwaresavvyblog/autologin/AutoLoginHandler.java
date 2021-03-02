package com.softwaresavvyblog.autologin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true)
public class AutoLoginHandler implements AutoLogin{

	@Override
	public String[] login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AutoLoginException {
		
		
		String email="";
		String password="";
		User user=null;
		
		// read email and password from request
		email= ParamUtil.getString(httpServletRequest, "ulm");
		password=ParamUtil.getString(httpServletRequest, "ulp");
		
		// check did we get credentials or not, if not return null to  continue as guest
		
		if(Validator.isNull(email) || Validator.isNull(password)) {
			return null;
		}
		
		
		// check is user exist with given email or not
		
		
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getCompanyId(httpServletRequest), email);
			
			
			// prepare login params array
			String[] autoLoginParams = new String[] {Long.toString(user.getUserId()),password,Boolean.FALSE.toString()};
			
			
			// if you want to redirect user to landing page, use below code
			
			LastPath lastPath = new LastPath(StringPool.BLANK, "/practice","");
			
			httpServletRequest.getSession().setAttribute(WebKeys.LAST_PATH, lastPath);
			
			
			
			return autoLoginParams;
		}//try 
		catch (PortalException e) {
			// return null when there is no user with give email
			return null;
		}//catch
		
	
	}

}
