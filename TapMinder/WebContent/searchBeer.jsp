
 <%@include file="/includes/header.jsp"%>
 
		<c:if test="${searchSetting == ''}">
			<form name="searchBy" action="findBeersPage.do" method="GET">
				<select name="findBy">
					<option value="">SELECT ONE</option>
					<option value="name">Name</option>
					<option value="abv">ABV</option>
					<option value="hop">Hop Count</option>
					<option value="style">Style</option>
					<option value="rating">Rating</option>
					<option value="brewery">brewery</option>
				</select>

				<button class="btn btn-primary btn page-scroll" type="submit">Search</button>

			</form>
		</c:if>

		<form:form action="searchBeers.do" modelAttribute="BeerParameters">
	<c:choose>
		<c:when test="${searchSetting == 'name' }">
			BEER NAME <form:input style="color:black" type="text" path="name" placeholder="Beer name"/><form:errors path="name" />
		</c:when>
		<c:when test="${searchSetting == 'abv' }">
			ABV Low <form:input style="color:black" type="text" path="abvLow" /> <form:errors path="abvLow" />
			ABV High <form:input style="color:black" type="text" path="abvHigh" /><form:errors path="abvHigh" />
		</c:when>
		<c:when test="${searchSetting == 'hop' }">
			Hop Count Low  <form:input style="color:black" type="text" path="hopCountLow" /> <form:errors path="hopCountLow" />
			Hope Count High <form:input style="color:black" type="text" path="hopCountHigh" /><form:errors path="hopCountHigh" />
		</c:when>
		<c:when test="${searchSetting == 'style' }">
			Style <form:input style="color:black" type="text" path="style" placeholder="style"/><form:errors path="style" />
		</c:when>
		<c:when test="${searchSetting ==  'rating'}">
			Rating Low<form:input style="color:black" type="text" path="ratingLow" placeholder="Number 1-5" /><form:errors path="ratingLow" />
			Rating High <form:input style="color:black" type="text" path="ratingHigh" placeholder="Number 1-5" /><form:errors path="ratingHigh" />
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${searchSetting ==  'brewery'}">
		<select name="breweryId">
			<c:forEach var="b" items="${Breweries}">
				<option value="${b.id}">${b.name}</option>
			</c:forEach>
		</select>
		</c:when>
		<c:otherwise>
			<!-- set to zero as a default -->
			<input type="hidden" name="breweryId" value="0" />
		</c:otherwise>
		
	
	
	</c:choose>
		<c:if test="${!empty(errorMessage)}">
			${errorMessage}
		</c:if>
		
	<c:if test="${searchSetting != '' }">
	<button class="btn btn-primary btn page-scroll" type="submit">Search</button>
	</c:if>	
		</form:form>

<%@include file="/includes/footer.jsp"%>

<!-- 		
</body>
</html> -->