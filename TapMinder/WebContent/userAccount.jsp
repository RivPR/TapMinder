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
<title>USR Account</title>
</head>
<body>
USER INFO (WHEN SIGNED IN)
${currentUser.firstname}
${currentUser.lastname}
${currentUser.email}
${currentUser.password}
${currentUser.usertype.typeName}
${currentUser.ratings.size()}
<form action="deleteCurrentUser.do">
	<input type="hidden" name="userId" value="${currentUser.id}">
	<button type="submit">DELETE</button>
</form>
add delete account


</body>
</html>