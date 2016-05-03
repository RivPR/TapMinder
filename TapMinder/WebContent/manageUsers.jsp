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

manage users jsp

search

<form:form action="findUsers.do" modelAttribute="User">
	First <form:input type="text" path="firstname" />
	Last <form:input type="text" path="lastname" />
	Email <form:input type="text" path="email" />
	<%-- First <form:input type="text" path="firstname" />
	First <form:input type="text" path="firstname" />
	First <form:input type="text" path="firstname" />
	First <form:input type="text" path="firstname" /> --%>
	<button type=submit>Search</button>
</form:form>


display


edit





</body>
</html>