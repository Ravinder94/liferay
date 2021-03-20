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

package com.softwaresavvyblog.liferay.webservices.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeService}.
 *
 * @author Ravinder
 * @see EmployeeService
 * @generated
 */
public class EmployeeServiceWrapper
	implements EmployeeService, ServiceWrapper<EmployeeService> {

	public EmployeeServiceWrapper(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	/**
	 * Method to add employee
	 *
	 * @param empName
	 * @return Employee
	 */
	@Override
	public com.softwaresavvyblog.liferay.webservices.model.Employee addEmployee(
		String empName) {

		return _employeeService.addEmployee(empName);
	}

	/**
	 * Method to return total number of employees count
	 *
	 * @return int
	 */
	@Override
	public int getEmployeeCount() {
		return _employeeService.getEmployeeCount();
	}

	/**
	 * Method to retrun list of employees
	 *
	 * @return List<Employee>
	 */
	@Override
	public java.util.List
		<com.softwaresavvyblog.liferay.webservices.model.Employee>
			getEmployees() {

		return _employeeService.getEmployees();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeService getWrappedService() {
		return _employeeService;
	}

	@Override
	public void setWrappedService(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	private EmployeeService _employeeService;

}