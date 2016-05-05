<%@include file="/includes/header.jsp"%>


<c:if test="${empty(userList)}">
	<header>

		<div class="header-content">
			<div class="header-content-inner">

				<div class="col-xs-1 col-md-5"></div>
				<div class="col-xs-11 col-md-5">
					<form:form action="findUsers.do" modelAttribute="User">
						<table>
							<tr>
								<td>First</td>
								<td><form:input type="text" path="firstname" /></td>
							</tr>

							<tr>
								<td>Last</td>
								<td><form:input type="text" path="lastname" /></td>
							</tr>

							<tr>
								<td>Email</td>
								<td><form:input type="text" path="email" /></td>
							</tr>
							<tr>
								<br>
								<td colspan="2"><button class="btn btn-success" type=submit>Search</button>
									<hr /></td>
							</tr>
						</table>
						<c:if test="${!empty(errorMessage) }">
		${errorMessage}
	</c:if>

					</form:form>

					<form action="menu.do" name="menuChoice">
						<button class="btn btn-warning" type="submit" name="menuChoice"
							value="addUser">New User</button>
					</form>










				</div>
			</div>
		</div>
	</header>
</c:if>


<c:if test="${!empty(userList)}">
<div class="container userList center-text">

	<c:forEach var="user" items="${userList}">
	
	<div class="col-xs-12 col-md-3 user">
	${user.firstname}
	${user.lastname}<br>
	${user.email}<br>
	${user.password}<br>
	${user.usertype.typeName}

	<form action="modifyUserPage.do">
			<input type="hidden" name="userId" value="${user.id}" />

			<button class="btn btn-warning" type="submit">Modify</button>
		</form>
		<form action="deleteUser.do">
			<input type="hidden" name="userId" value="${user.id}" />

			<button class="btn btn-warning" onclick="if (confirm('Are you sure you want to delete ${user.firstname}'s account?')) commentDelete(1); return false" type="submit">Delete</button>
		</form>


	</div>

	</c:forEach>
</div>
</c:if>
<%@include file="/includes/footer.jsp"%>