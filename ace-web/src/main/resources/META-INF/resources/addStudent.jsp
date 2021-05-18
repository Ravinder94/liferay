<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:actionURL name="addStudent" var="addStuURL"></portlet:actionURL>


<aui:form action="${addStuURL }">
	
		<aui:fieldset>
			<aui:row>
				<aui:col width="50">
					<aui:input name="name" type="text" placeholder="Enter name" label="Name"></aui:input>
				</aui:col>
				<aui:col  width="50">
					<aui:input name="email" type="text" placeholder="Enter email" label="Email"></aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input name="mbnumber" type="text" placeholder="Enter number" label="Mobile Number"></aui:input>
				</aui:col>
				<aui:col  width="50">
					<aui:input name="branchId" type="text" placeholder="Enter branch id"  label="Branch Id"></aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		
		<aui:button-row>
			<aui:button value="Save" type="submit" class="btn btn-primary"/>
		</aui:button-row>
	
</aui:form>