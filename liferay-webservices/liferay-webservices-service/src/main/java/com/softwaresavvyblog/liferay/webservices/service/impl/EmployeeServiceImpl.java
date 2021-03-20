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

package com.softwaresavvyblog.liferay.webservices.service.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.softwaresavvyblog.liferay.webservices.model.Employee;
import com.softwaresavvyblog.liferay.webservices.service.base.EmployeeServiceBaseImpl;

/**
 * The implementation of the employee remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.softwaresavvyblog.liferay.webservices.service.EmployeeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ravinder
 * @see EmployeeServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=webservices",
		"json.web.service.context.path=Employee"
	},
	service = AopService.class
)
public class EmployeeServiceImpl extends EmployeeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.softwaresavvyblog.liferay.webservices.service.EmployeeServiceUtil</code> to access the employee remote service.
	 */
	/**
	 * Method to add employee
	 * 
	 * @param empName
	 * @return Employee
	 */
	public Employee addEmployee(String empName) {
		
		Employee employee= employeePersistence.create(CounterLocalServiceUtil.increment());
		
		employee.setEmpName(empName);
		
		employeePersistence.update(employee);
		
		return employee;
		
	}
	
	/**
	 * Method to return total number of employees count
	 * @return int
	 */
	public int getEmployeeCount() {
		return employeePersistence.countAll();
	}
	
	/**
	 * Method to retrun list of employees
	 * 
	 * @return List<Employee>
	 */
	public List<Employee> getEmployees(){
		return employeePersistence.findAll();
	}
}