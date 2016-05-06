<%@include file="/includes/header.jsp"%>



<header>
	<div class="header-content">
		<div class="header-content-inner">

	<form:form action="modifyUser.do" modelAttribute="User">
		<form:input type="hidden" path="id" />
		<table>
			<tr>
				<td>First</td>
				<td><form:input type="text" path="firstname" /></td>
				<td><form:errors path="firstname" /></td>
				
			</tr>
			<tr>
				<td>Last</td>
				<td><form:input type="text" path="lastname" /></td>
				<td><form:errors path="lastname" /></td>
				
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input type="text" path="email" /></td>
				<td><form:errors path="email" /></td>
				
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input type="text" path="password" /></td>
				<td><form:errors path="password" /></td>
				
			</tr>
			<tr>
				<td>User Type</td>
				<td colspan="2"><select name="userTypeId">

			<option value="">pick one</option>
			<option value="1"
			<c:if test="${User.usertype.accessLevel == 1  }">
			selected
			</c:if>
			
			>Standard</option>
			<option value="2"
			<c:if test="${User.usertype.accessLevel == 2}">
			selected
			</c:if>
			
			>Moderator</option>
			<option value="3"
			
			<c:if test="${User.usertype.accessLevel == 3}">
			selected
			</c:if>
			
			>Admin</option>

		</select></td>
				
			</tr>
			<tr>
				<td colspan="2"><button class="btn btn-warning" type=submit>Submit Changes</button></td>
				<td></td>
				<td></td>
				
			</tr>
		
		</table>
		


		
	</form:form>
	
	<c:if test="${!empty(errorMessage) }">
		${errorMessage}
	</c:if>




		</div>
	</div>
</header>

<%@include file="/includes/footer.jsp"%>