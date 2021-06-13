<%@ include file="/init.jsp" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>

<p>
	<b><liferay-ui:message key="ipcportletsessionreceiverweb.caption"/></b>
</p>

<clay:container>
	<clay:row>
		<h5>Hi, ${name}</h5>
	
	</clay:row>
	<clay:row>
		<h5>I recevied you mail : ${email}</h5>
	
	</clay:row>
	<clay:row>
		<h5>I recevied you mobile number : ${mobilnum}</h5>
	
	</clay:row>
	
	
	
</clay:container>
