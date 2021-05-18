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
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.mx.ace.model.Branch;
import com.mx.ace.service.base.BranchLocalServiceBaseImpl;

/**
 * The implementation of the branch local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mx.ace.service.BranchLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ravinder
 * @see BranchLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.mx.ace.model.Branch",
	service = AopService.class
)
public class BranchLocalServiceImpl extends BranchLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.mx.ace.service.BranchLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.mx.ace.service.BranchLocalServiceUtil</code>.
	 */
	
	
	public Branch addBranch(String name,ServiceContext serviceContext) throws PortalException {
		
		Branch branch=null;
		long branchId=0;
		User user=null;
		
		
		branchId = CounterLocalServiceUtil.increment();
		
		branch= branchPersistence.create(branchId);
		
		branch.setName(name);
		
		user= _userLocalServiceS.getUser(serviceContext.getUserId());
		
		branch.setUserId(user.getUserId());
		branch.setUserName(user.getLastName());
		
		branch.setGroupId(serviceContext.getScopeGroupId());
		
		branch.setCompanyId(serviceContext.getCompanyId());
		
		branch.setCreateDate(serviceContext.getCreateDate());
		branch.setModifiedDate(serviceContext.getCreateDate());
		
		branchPersistence.update(branch);
		
		return branch;
	}
	
	

	
	@Reference
	private UserLocalService _userLocalServiceS;
}