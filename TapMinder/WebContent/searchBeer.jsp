<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="searchBy" action="findBeersPage.do" method="GET">
	<select name="findBy">
		<option value="">SELECT ONE</option>
		<option value="name">Name</option>
		<option value="abv">ABV</option>
		<option value="hop">Hop Count</option>
		<option value="style">Style</option>
		<option value="rating">Rating</option>
	</select>
	
	<button type="submit">GO SEARCH</button>

</form>


</body>
</html>