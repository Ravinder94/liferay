<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="liferaycommandclassexample.caption"/></b>
</p>

<!-- Id is mandatory to call our resource command  -->
<portlet:resourceURL id="/command/resource_command" var="resourceURL" />


<aui:button type="button" onClick="doSomthing()" value="Do resource command req"></aui:button>

<aui:script>

function doSomthing() {
	AUI().use("aui-io-request", function(A){
		A.io.request("${resourceURL }",{
			method: "post",
			on : {
			 success: function() {
                        alert('ok');
                    }
              }
		})
	})
	
}

</aui:script>