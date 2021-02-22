<%@ include file="/init.jsp"%>

<div class="row">
	<div class="col-md-12 heading-div">
		<!-- adding heading by getting value from language.properties file -->
		<span><liferay-ui:message key="view.page.heading"></liferay-ui:message></span>
	</div>
	<div class="col-md-12">
		<!-- define table to align data properly -->
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Implicit object</th>
		        <th>Values from object</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td><span>account object</span></td>
		        <td>
			        <span>account id : <%=account.getAccountId() %></span><br/>
		        </td>
		       </tr>
		       <tr>
		        <td><span>color scheme</span></td>
		        <td>
			        <span>colorScheme name : <%=colorScheme.getName() %></span><br/>
		        </td>
		       </tr>
		       <tr>
		        <td><span>company</span></td>
		        <td>
			        <span>company id : <%=company.getCompanyId() %></span><br/>
		        </td>
		       </tr>
		       <tr>
		        <td><span>contact</span></td>
		        <td>
			        <span>contact id : <%=contact.getContactId() %></span><br/>
			        <span>getEmailAddress : <%=contact.getEmailAddress() %></span><br/>
		        </td>
		       </tr>
		        <tr>
		        <td><span>layout</span></td>
		        <td>
			        <span>layout id : <%=layout.getLayoutId() %></span><br/>
			        <span>layout name : <%=layout.getName() %></span><br/>
		        </td>
		       </tr>
		        <tr>
		        <td><span>locale</span></td>
		        <td>
			        <span>country   : <%=locale.getCountry() %></span><br/>
			        <span>getLanguage : <%=locale.getLanguage() %></span><br/>
		        </td>
		       </tr>
		        <tr>
		        <td><span>time zone</span></td>
		        <td>
			        <span>time zone name   : <%=timeZone.getDisplayName() %></span><br/>
		        </td>
		       </tr>
		        <tr>
		        <td><span>permissionChecker</span></td>
		        <td>
			        <span>is company admin  : <%=permissionChecker.isCompanyAdmin() %></span><br/>
		        </td>
		       </tr>
		       <!-- Try to add other objects on  your own here to get hands on practice -->
		    </tbody>
		 </table>
	</div>
</div>