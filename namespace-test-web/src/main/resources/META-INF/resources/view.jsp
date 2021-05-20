<%@ include file="/init.jsp" %>

<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<clay:container>
	<clay:row>
		<p>
			<b><liferay-ui:message key="namespacetestweb.caption"/></b>
		</p>
	</clay:row>
	<clay:row>
		<label for="name">Name:</label>
		<input name="name" id="<portlet:namespace/>name" type="text" value="ravinder"/>
	</clay:row>
</clay:container>
<script>




	
	
var tid = setInterval( function () {
    if ( document.readyState !== 'complete' ) return;
    clearInterval( tid );       
    
    
    //alert(document.getElementById("<portlet:namespace/>name").value)
    
}, 10 );
	
</script>