<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="addBranch" var="addBranchURL">
</portlet:actionURL>





<aui:form  action="${addBranchURL }">
	
	<aui:input name="name" type="text" placeholder="Enter branch name" cssClass="branch-name-filed">
		<aui:validator name="required" errorMessage="Branch name required"/>
	</aui:input>
	
	<aui:button class="btn btn-primary" value="Add Branch" type="submit"/>
	
</aui:form>
