<%@include file="/includes/header.jsp"%>



<header>
	<div class="header-content">
		<div class="header-content-inner">

	<form:form action="modifyUser.do" modelAttribute="User">
		<form:input type="hidden" path="id" />
	First <form:input type="text" path="firstname" /><form:errors path="firstname" />
	Last <form:input type="text" path="lastname" /><form:errors path="lastname" />
	Email <form:input type="text" path="email" /><form:errors path="email" />
	Password <form:input type="text" path="password" /><form:errors path="password" />
		<select name="userTypeId">

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

		</select>

		<button class="btn btn-warning" type=submit>Submit Changes</button>
	</form:form>
	
	<c:if test="${!empty(errorMessage) }">
		${errorMessage}
	</c:if>




		</div>
	</div>
</header>

<%@include file="/includes/footer.jsp"%>