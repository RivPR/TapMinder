<%@include file="includes/header.jsp"%>

<form:form action="login.do" modelAttribute="user">
	<form:input type="text" name="email" placeholder="email@example.com" path="email" />
	<form:input type="password" name="password" path="password" />
	<button type="submit">LOGIN</button>
</form:form>

<c:if test="${!empty(LoginError)}">
	ERROR: ${LoginError}
</c:if>



<%@include file="includes/footer.jsp"%>
