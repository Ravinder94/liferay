<%@ include file="/init.jsp" %>



<portlet:actionURL name="action/example" var="actionMVCUrl" ></portlet:actionURL>

<portlet:renderURL var="renderMVCURL" >
	<portlet:param name="mvcRenderCommandName" value="render/example"></portlet:param>
</portlet:renderURL>


<portlet:resourceURL id="resource/example" var="resourceURL" ></portlet:resourceURL>

<clay:container>
	<clay:row>
		<p>
			<b><liferay-ui:message key="mvccommand.caption"/></b>
		</p>
	</clay:row>
	<clay:row>
		<aui:button-row>
			<aui:button href="${actionMVCUrl }" value="Do Action" class="btn btn-primary" type="button"></aui:button>
			<aui:button href="${renderMVCURL }" value="Do Render" class="btn btn-primary" type="button"></aui:button>
			<aui:button value="Do Resource" class="btn btn-primary" type="button" onClick="serveResourceEx()"></aui:button>
		</aui:button-row>
	</clay:row>
</clay:container>

<aui:script>
	function serveResourceEx(){
		AUI().use('aui-io-request', function(A){
	        A.io.request('${resourceURL}', {
	               method: 'post',
	               on: {
	                       success: function() {
	                        alert(this.get('responseData'));
	                        
	                    }
	              }
	        });
	    });
	}
</aui:script>
