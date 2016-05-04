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


<form:form action="addUser.do" modelAttribute="User">
	First <form:input type="text" path="firstname"  required="required"/><form:errors path="firstname" /><br>
	Last <form:input type="text" path="lastname"  required="required"/><form:errors path="lastname" /><br>
	Email <form:input type="text" path="email"  required="required"/><form:errors path="email" /><br>
	Password <form:input type="text" path="password"  required="required"/><form:errors path="password" /><br>
		<select name="userTypeId" required="required">
	
		<option value="">pick one</option>
		<option value="1">Standard</option>
		<option value="2">Moderator</option>
		<option value="3">Admin</option>

	</select>

	<button type=submit>Add</button>
</form:form>


</body>
</html>