<%@include file="/includes/header.jsp"%>
<link rel="stylesheet" href="/css/stylesheet.css" type="text/css">

<title>Search results!</title>
</head>
<body>
	
	<div class="container-fluid wrapperPage">
	
	<c:forEach var="beer" items="${beerList}">

			<!-- <div class="row">  -->
				
				<%--  <% for(int i=0; i < 3; i+=1) { %>  --%>

				<div class="col-xs-6"><div class="classWithPad">

					Name: ${beer.name} <br> ABV: ${beer.abv} <br> HopCount:
					${beer.hopCount} <br> Style: ${beer.beerStyle} <br>
					Brewery: ${beer.brewery.name} <br> Rating:
					${beer.averageRating}<br />

					<c:if test="${currentUser.usertype.accessLevel > 0}">
						<form action="rateABeer.do">
							<input type="hidden" name="beerId" value="${beer.id}" />
							<!-- 	<button type="submit">Rate This Beer</button> -->
							<button class="btn btn-primary btn page-scroll" type="submit">Rate
								this beer</button>
						</form>
					</c:if>
					<img src="${beer.imageLink}" /> <br>

					<c:if test="${currentUser.usertype.accessLevel > 1}">
						<form action="modifyBeerPage.do">
							<input type="hidden" name="beerId" value="${beer.id}" />
							<button class="btn btn-primary btn page-scroll" type="submit">Modify</button>
						</form>
						<form action="deleteBeer.do">
							<input type="hidden" name="beerId" value="${beer.id}" />
							<button class="btn btn-primary btn page-scroll" type="submit">Delete</button>
						</form>
					</c:if>
				</div></div>
			<%-- 	<% } %>  --%>
			<!--  </div>  -->
	</c:forEach>
	
		</div>
		

	<%@include file="/includes/footer.jsp"%>
<!-- </body>
</html> -->