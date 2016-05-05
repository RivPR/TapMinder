<%@include file="/includes/header.jsp"%>


<header>
	<div class="header-content">
		<div class="header-content-inner">


<div class="container">
<h1>Welcome to TapMinder!</h1>
<h4>Please sign up.</h4>


<div class="signupcard col-xs-12 col-med-4 col-lg-4">
<div class="row">
<div class="col-md-6 col-center">

	<form:form action="signUp.do" modelAttribute="User">

	<table>
		<tr>
			<td>First</td>
			<td><form:input type="text" path="firstname" placeholder="First" required="required"/></td>
		</tr>
		<tr>
			<td>Last</td>
			<td><form:input type="text" path="lastname" placeholder="Last" required="required"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input type="email" path="email" placeholder="email@example.com" required="required"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:input type="password" path="password" required="required"/></td>
		</tr>
	</table>


	<c:if test="${!empty(errorMessage)}">
		${errorMessage}
	</c:if>
	<button class="btn btn-warning" type=submit class="addbutton1">Add</button>
</form:form>
</div>
</div> <!-- SIGNUPCARD -->



		</div>
	</div>
</header>

<%@include file="/includes/footer.jsp"%>
