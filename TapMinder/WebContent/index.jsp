<%@include file="/includes/header.jsp"%>


<header>
	<div class="header-content">
		<div class="header-content-inner">

			<h1>TapMinder2</h1>
			<p>Finding craft beer in the Denver area has never been easier!</p>

			<h6>To browse the site as a guest just press "LOGIN"</h6>
			<c:if test="${currentUser.id < 1 }">
				<form:form action="login.do" modelAttribute="user">
				Username: <form:input type="email" name="email"
						value="guest@example.com" path="email" />
					<br>
					<br>
				Password: <form:input type="password" name="password" value="Guest"
						path="password" />
					<br>
					<br>
					<button class="btn btn-warning" type="submit">Login</button>
				</form:form>
				<%-- <div class="facebook-login-button-container">
					Not yet functional <%@include	file="/includes/facebook-login-button-with-script.html"%></div> --%>
			</c:if>
			<c:if test="${currentUser.id > 0 }">
				<form action="mainPage.jsp">
					<button class="btn btn-success" type="submit">GO!</button>
				</form>
				<br>
				<br>
			</c:if>
			<form action="menu.do" method="POST">
				<br>

				<c:if test="${currentUser.id < 1 }">
					<button class="btn btn-success" type="submit" name="menuChoice"
						value="signUp">sign up</button>
				</c:if>
			</form>
			<c:if test="${!empty(LoginError)}">
				<span class="alert-text">ERROR: ${LoginError}</span>
			</c:if>
			<br>

		</div>
	</div>
</header>
<%@include file="/includes/footer.jsp"%>





