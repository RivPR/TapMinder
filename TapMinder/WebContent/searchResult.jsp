<%@include file="/includes/header.jsp"%>

		

		<div class="container beer-list">
			<c:forEach var="beer" items="${beerList}">
			
				<div class="col-xs-12, col-md-4">
				<div class="beer text-center">
					Name: ${beer.name} <br> ABV: ${beer.abv} <br> HopCount:
					${beer.hopCount} <br> Style: ${beer.beerStyle} <br>
					Brewery: ${beer.brewery.name} <br> Rating:
					${beer.averageRating}<br />

					<c:if test="${currentUser.usertype.accessLevel > 0}">
						<form action="rateABeer.do">
							<input type="hidden" name="beerId" value="${beer.id}" />
							<!-- 	<button type="submit">Rate This Beer</button> -->
							<br><button class="btn btn-success" type="submit">Rate this beer</button><br><br>
						</form>
					</c:if>
					<img class="med-beer" src="${beer.imageLink}" /> <br>

					<c:if test="${currentUser.usertype.accessLevel > 1}">
						<form action="modifyBeerPage.do">
							<input type="hidden" name="beerId" value="${beer.id}" />
							<br><button class="btn btn-warning" type="submit">Modify</button><br><br>
						</form>
						<form action="deleteBeer.do">
							<input type="hidden" name="beerId" value="${beer.id}" />
							<button class="btn btn-warning" type="submit">Delete</button>
						</form>
					</c:if>
		</div>
		</div>
			</c:forEach>


</div>




<%@include file="/includes/footer.jsp"%>
