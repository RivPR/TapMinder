<%@include file="/includes/header.jsp"%>
<title>Search results!</title>
</head>
<body>
<c:forEach var="beer" items="${beerList}">
	Name: ${beer.name} <br>
	ABV: ${beer.abv} <br>
	HopCount: ${beer.hopCount} <br>
	Style: ${beer.beerStyle} <br>
	Brewery: ${beer.brewery.name} <br>
	Rating: ${beer.averageRating}<br/>
				<c:if test="${currentUser.usertype.accessLevel > 0}">
	<form action="rateABeer.do">
		<input type="hidden" name="beerId" value="${beer.id}" />
		<button type="submit">Rate This Beer</button>
	</form>
	</c:if>
	<img src="${beer.imageLink}" />
	<br>
	
				<c:if test="${currentUser.usertype.accessLevel > 1}">
	
			<form action="modifyBeerPage.do">
				<input type="hidden" name="beerId" value="${beer.id}" />

				<button type="submit">Modify</button>
			</form>
			<form action="deleteBeer.do">
				<input type="hidden" name="beerId" value="${beer.id}" />

				<button type="submit">Delete</button>
			</form>
			
			</c:if>
</c:forEach>


</body>
</html>