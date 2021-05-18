/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mx.ace.service.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.mx.ace.model.Student;
import com.mx.ace.service.base.StudentLocalServiceBaseImpl;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mx.ace.service.StudentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ravinder
 * @see StudentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.mx.ace.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.mx.ace.service.StudentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.mx.ace.service.StudentLocalServiceUtil</code>.
	 */
	
	
	public Student addStudent(String name,String email,long mobileNumber,long branchId,ServiceContext serviceContext) throws PortalException {
		
		Student student=null;
		long id=0;
		User user=null;
		
		id= _counterLocalService.increment();
		
		student = studentPersistence.create(id);
		
		student.setName(name);
		student.setEmail(email);
		student.setMobileNumber(mobileNumber);
		student.setBranchId(branchId);
		
		user = _userLocalService.getUser(serviceContext.getUserId());
		
		student.setUserId(user.getUserId());
		student.setUserName(user.getFullName());
		
		student.setGroupId(serviceContext.getScopeGroupId());
		student.setCompanyId(serviceContext.getCompanyId());
		
		student.setCreateDate(serviceContext.getCreateDate());
		student.setModifiedDate(serviceContext.getCreateDate());
				
		studentPersistence.update(student);
		return student;
	}
	
	@Reference
	private CounterLocalService _counterLocalService;
	
	@Reference
	private UserLocalService _userLocalService;
	
}