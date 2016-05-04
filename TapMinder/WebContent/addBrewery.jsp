<%@include file="/includes/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Brewery</title>
</head>

<body>

<form:form action="addBrewery.do" modelAttribute="Brewery">
<form:input type="hidden" path="id"/>
	name	<form:input type="text" path="name" /><form:errors path="name" /><br>
	addr<form:input type="text" path="streetAddress" /><form:errors path="streetAddress" /><br>
	city<form:input type="text" path="city" /><form:errors path="city" /><br>
<%-- state<form:input type="text" path="state" /><form:errors path="state" /><br> --%>
	<form:input type="text" path="state" value="CO"/><form:errors path="state" /><br>
	zip<form:input type="text" path="zip" /><form:errors path="zip" /><br>
	im link<form:input type="text" path="imageLink" /><form:errors path="imageLink" /><br>
	b link<form:input type="text" path="breweryLink" /><form:errors path="breweryLink" /><br>
	ngbh<select name="neighboorHoodId"><br>
	
		
		<c:forEach var="hood" items="${neighborhoodList}">
				<option value="${hood.id}"
				
				<c:if test="${Brewery.neighborhood.id == hood.id}">
		selected
		</c:if>
				
				
				>${hood.name}</option>

		
		
		</c:forEach>
		
	</select>
	<%-- <form:input type="text" path="neighborhood" /> --%>
		
	<button type="submit">Add</button>
</form:form>

</body>
</html>