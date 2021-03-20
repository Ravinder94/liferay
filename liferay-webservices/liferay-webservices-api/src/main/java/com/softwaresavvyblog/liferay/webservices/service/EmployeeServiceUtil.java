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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Employee. This utility wraps
 * <code>com.softwaresavvyblog.liferay.webservices.service.impl.EmployeeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ravinder
 * @see EmployeeService
 * @generated
 */
public class EmployeeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.softwaresavvyblog.liferay.webservices.service.impl.EmployeeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Method to add employee
	 *
	 * @param empName
	 * @return Employee
	 */
	public static com.softwaresavvyblog.liferay.webservices.model.Employee
		addEmployee(String empName) {

		return getService().addEmployee(empName);
	}

	/**
	 * Method to return total number of employees count
	 *
	 * @return int
	 */
	public static int getEmployeeCount() {
		return getService().getEmployeeCount();
	}

	/**
	 * Method to retrun list of employees
	 *
	 * @return List<Employee>
	 */
	public static java.util.List
		<com.softwaresavvyblog.liferay.webservices.model.Employee>
			getEmployees() {

		return getService().getEmployees();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static EmployeeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeService, EmployeeService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeService.class);

		ServiceTracker<EmployeeService, EmployeeService> serviceTracker =
			new ServiceTracker<EmployeeService, EmployeeService>(
				bundle.getBundleContext(), EmployeeService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}