<%@include file="/includes/header.jsp"%>



<header>
<div class="header-content">
	<div class="header-content-inner">
	<div class="col-xs-1 col-md-4"> </div>
	<div class="col-xs-11 col-md-6">
		<form:form action="addUser.do" modelAttribute="User">
		
		<table>
		<tr>
			<td></td>
			<td></td>
			<td></td>

		</tr>
		<tr>
			<td>First</td>
			<td><form:input type="text" path="firstname" required="required" /></td>
			<td><form:errors path="firstname" /></td>

		</tr>
		<tr>
			<td>Last</td>
			<td><form:input type="text" path="lastname" required="required" /></td>
			<td><form:errors path="lastname" /></td>

		</tr>
		<tr>
			<td>Email</td>
			<td><form:input type="email" path="email" required="required" /></td>
			<td><form:errors path="email" /></td>

		</tr>
		<tr>
			<td>Password</td>
			<td><form:input type="text" path="password" required="required" /></td>
			<td><form:errors path="password" /></td>

		</tr>
		<tr>
			<td colspan="2">
						<select name="userTypeId" required="required">

				<option value="">User Type (choose one):</option>
				<option value="1">Standard</option>
				<option value="2">Moderator</option>
				<option value="3">Admin</option>

			</select></td>
			<td></td>
			
		</tr>
		<tr>
			
			<td colspan="2">
						
			<button class="btn btn-warning" type=submit>Add New User</button>

			</td>
			
		</tr>


		</table>

		</form:form>

</div>
</div>


	</div>
</div>
</header>
<%@include file="/includes/footer.jsp"%>