<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
	if(SessionErrors.contains(request, NoSuchLayoutException.class)){
			
%>
		<div class="container pb-3 pt-3" style="text-align:center;">
			<%@ include file="/html/portal/status.jsp" %>
		</div>
<%
	}
	else{
		StringBundler sb = (StringBundler)request.getAttribute(WebKeys.LAYOUT_CONTENT);
		sb.writeTo(out);

		request.removeAttribute(WebKeys.LAYOUT_CONTENT);
	}
%>