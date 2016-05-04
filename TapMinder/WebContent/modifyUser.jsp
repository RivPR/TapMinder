<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


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

		<button type=submit>Submit Changes</button>
	</form:form>
	
	<c:if test="${!empty(errorMessage) }">
		${errorMessage}
	</c:if>

</body>
</html>