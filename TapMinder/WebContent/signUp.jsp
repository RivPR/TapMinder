<%@include file="/includes/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up for TapMinder!</title>
</head>
<body>
<div class="container">
<h1>Welcome to TapMinder!</h1>
<h4>Please sign up.</h4>




<div class="filler col-xs-12 col-med-4 col-lg-4">

</div>

<div class="signupcard col-xs-12 col-med-4 col-lg-4">
<form:form action="signUp.do" modelAttribute="User">
	First <form:input type="text" path="firstname" /><br/>
	Last <form:input type="text" path="lastname" /><br/>
	Email <form:input type="text" path="email" /><br/>
	Password <form:input type="text" path="password" /><br/>

	<c:if test="${!empty(errorMessage)}">
		${errorMessage}
	</c:if>
	<button type=submit class="addbutton1">Add</button>
</form:form>
</div> <!-- SIGNUPCARD -->

<div class="filler col-xs-12 col-med-4 col-lg-4">


</div>



</div> <!-- CONTAINER -->

</body>
</html>