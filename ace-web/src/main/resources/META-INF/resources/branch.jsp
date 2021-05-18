<%@page import="com.mx.ace.service.BranchLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<liferay-ui:success key="added" message="Branch saved successfully!"
/>

<liferay-ui:error key="failure" message="Problem occured while adding branch" />


<portlet:renderURL var="addBranchURL">
	<portlet:param name="mvcPath" value="/add-branch.jsp"/>
</portlet:renderURL>

<clay:container-fluid>
	<clay:row>
		
		<aui:button value="Add Branch" type="button" href="${addBranchURL }"/>
		
	</clay:row>
	<clay:row>

			<liferay-ui:search-container total="<%= BranchLocalServiceUtil.getBranchesCount()%>">
				
				<liferay-ui:search-container-results results="<%= BranchLocalServiceUtil.getBranches(searchContainer.getStart(), searchContainer.getEnd()) %>"/>
				
				<liferay-ui:search-container-row className="com.mx.ace.model.Branch" modelVar="branch">
					<liferay-ui:search-container-column-text property="name" />
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator />
				
			</liferay-ui:search-container>
	</clay:row>	
</clay:container-fluid>

