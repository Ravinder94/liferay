create table WebServices_Employee (
	uuid_ VARCHAR(75) null,
	empId LONG not null primary key,
	empName VARCHAR(75) null
);

create table WebServices_Employee_Department (
	uuid_ VARCHAR(75) null,
	dptId LONG not null primary key,
	dptName VARCHAR(75) null
);