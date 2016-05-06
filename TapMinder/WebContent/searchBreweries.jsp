
<%@include file="/includes/header.jsp"%>



<c:if test="${empty(breweryList)}">


	<header>
		<div class="header-content">
			<div class="header-content-inner">

				<c:if test="${ !empty(searchSubmitted) && searchSubmitted == true}">
					<div
						class="col-xs-offset-2 col-md-offset-4 col-md-4 col-xs-10 center-text">
						<br> <br> <br> <br> <br>Your search
						returned no results.
						<form action="menu.do">
							<button class="btn btn-link return-link" name="menuChoice"
								value="findBreweries">Return to search.</button>
						</form>
					</div>
				</c:if>
				<c:if test="${searchSetting == ''}">
					<span class="search-title">Find a Brewery:</span>
					<form name="searchBy" action="searchBreweriesPage.do" method="GET">
						<select name="findBy">
							<option value="">SELECT ONE</option>
							<option value="name">Name</option>
							<option value="street">Street</option>
							<option value="city">city</option>
							<option value="zip">Zip</option>
							<option value="neighborhood">Neighborhood</option>
						</select> <br>
						<button class="btn btn-warning" type="submit">GO SEARCH</button>

					</form>
				</c:if>


				<form:form action="searchBreweries.do"
					modelAttribute="BreweryParameters">
					<c:choose>

						<c:when test="${searchSetting == 'name' }">
				Brewery name <form:input type="text" path="name"
								placeholder="Type name here" />
							<form:errors path="name" />
						</c:when>
						<c:when test="${searchSetting == 'street' }">
				Street Address <form:input type="text" path="streetAddress" />
							<form:errors path="streetAddress" />
						</c:when>
						<c:when test="${searchSetting == 'city' }">
				City<form:input type="text" path="city" />
							<form:errors path="city" />
						</c:when>


						<c:when test="${searchSetting ==  'zipcode'}">
				Zip <form:input type="number" path="zipcode"
								placeholder="Number 1-5" />
							<form:errors path="zipcode" />
						</c:when>
						<c:when test="${searchSetting ==  'neighborhood'}">
				Neigborhood<select name="neighboorHoodId"><option value="">Pick
									one</option>
								<c:forEach var="hood" items="${neighborhoodList}">
									<option value="${hood.id}"
										<c:if test="${Brewery.neighborhood.id == hood.id}">
								Selected
							</c:if>>${hood.name}</option>
								</c:forEach>
							</select>
						</c:when>


					</c:choose>
					<c:if test="${!empty(searchSetting)}">
						<button class="btn btn-warning" type="submit">search</button>
					</c:if>
					<c:if test="${!empty(errorMessage)}">
		${errorMessage}
		</c:if>

				</form:form>

			</div>
		</div>
	</header>
</c:if>
<div class="container brewery-list text-center">


	<c:if test="${!empty(breweryList)}">
		<h2>BREWERIES</h2>
		<c:forEach var="b" items="${breweryList}">
			<div class="col-xs-12 col-md-4 brewery">
				Name: ${b.name} <br> Address: ${b.streetAddress} <br>
				${b.city} <br> ${b.state} <br> ${b.zip} <br>
				${b.neighborhood.name}" <br>

				<c:if test="${ currentUser.usertype.accessLevel > 0}">

					<form action="addBeerPage.do">
						<input type="hidden" name="breweryId" value="${b.id}" />
						<button class="btn btn-add" type="submit">Add Beer to
							this brewery</button>
					</form>
				</c:if>

				<c:if test="${ currentUser.usertype.accessLevel > 1}">

					<form action="modifyBreweryPage.do">
						<input type="hidden" name="breweryId" value="${b.id}" />
						<button class="btn btn-warning" type="submit">Modify</button>
					</form>
					<form action="deleteBrewery.do">
						<input type="hidden" name="breweryId" value="${b.id}" />
						<button class="btn btn-warning" type="submit">Delete</button>
					</form>
				</c:if>
				<br> <br>
			</div>
		</c:forEach>
	</c:if>
</div>

<%@include file="/includes/footer.jsp"%>