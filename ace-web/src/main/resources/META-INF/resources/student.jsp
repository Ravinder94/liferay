<%@page import="com.mx.ace.service.StudentLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<portlet:renderURL var="addStuURL">
	<portlet:param name="mvcPath" value="/addStudent.jsp"/>
</portlet:renderURL>
<liferay-ui:success key="added" message="Student saved successfully!"
/>

<liferay-ui:error key="failure" message="Problem occured while adding student" />

<clay:container-fluid>
	<clay:row>
		
		<aui:button value="Add Student" type="button" href="${addStuURL }" class="btn btn-primary" />
	</clay:row>
	<clay:row>
		<liferay-ui:search-container total="<%= StudentLocalServiceUtil.getStudentsCount()%>">
				
				<liferay-ui:search-container-results results="<%= StudentLocalServiceUtil.getStudents(searchContainer.getStart(), searchContainer.getEnd()) %>"/>
				
				<liferay-ui:search-container-row className="com.mx.ace.model.Student" modelVar="student">
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="email" />
					<liferay-ui:search-container-column-text property="mobileNumber" />
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator />
				
			</liferay-ui:search-container>
	</clay:row>
</clay:container-fluid>