<%@ include file="/init.jsp" %>

<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>

<clay:container>
	<clay:row>
		<p>
			<b><liferay-ui:message key="namespaceweb.caption"/></b>
		</p>
	</clay:row>
	<clay:row>
		<label for="name">Name:</label>
		<input name="name" id="name" type="text" value="ravi"/>
	</clay:row>
</clay:container>


