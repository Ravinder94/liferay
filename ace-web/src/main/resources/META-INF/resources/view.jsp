<%@ include file="/init.jsp" %>



<clay:container-fluid>
	<liferay-ui:tabs names="<%="Student,Branch"%>" 
	refresh="<%= false %>"
    type="tabs nav-tabs-default"
    >
	
		<liferay-ui:section >
			<%@ include file="/student.jsp" %>
		</liferay-ui:section>
		<liferay-ui:section>
			<%@ include file="/branch.jsp" %>
		</liferay-ui:section>
		
	</liferay-ui:tabs>
</clay:container-fluid>

