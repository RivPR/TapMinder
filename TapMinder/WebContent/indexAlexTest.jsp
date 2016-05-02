<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TapMinder Test</title>
</head>
<body>

<form action="menu.do" method="POST">

	<!-- 		if logged in, show loggout instead (destory session or something) -->
	<button type="submit" name="menuChoice" value="login">Login</button>
	<button type="submit" name="menuChoice" value="findBeers">Find
		Beers</button>
	<button type="submit" name="menuChoice" value="findBreweries">Find
		Breweries</button>
	<button type="submit" name="menuChoice" value="viewUserBeers">View
		User Beers</button>
	<button type="submit" name="menuChoice" value="myAccount">View
		User Account</button>
	<!-- moderators and up only -->
	<button type="submit" name="menuChoice" value="modifyBreweries">edit
		brews</button>
	<!-- admin and up only -->
	<button type="submit" name="menuChoice" value="modifyUsers">edit
		moderators</button>
		
	<button type="submit" name="menuChoice" value="logout">logout</button>
		

</form>

<c:if test="${currentUser.id > 0}"> 
	${currentUser.firstname}
	${currentUser.email}
	${currentUser.lastname}
	${currentUser.password}
	${currentUser.firstname}
	${currentUser.firstname}
</c:if>

</body>
</html>
