
<%@include file="/includes/header.jsp"%>



<header>
	<div class="header-content">
		<div class="header-content-inner">
		<div class="container text-center">



<c:if test="${searchSetting == ''}">
<div class="row">
<div class="col-xs-0 col-md-3"> </div>
<div class="col-xs-12 col-md-3">
	<form name="searchBy" action="findBeersPage.do" method="GET">
<span class="search-title">Find Beer:</span>
		<select name="findBy">
			<option value="">SELECT ONE</option>
			<option value="name">Name</option>
			<option value="abv">ABV</option>
			<option value="hop">Hop Count</option>
			<option value="style">Style</option>
			<option value="rating">Rating</option>
			<option value="brewery">brewery</option>
		</select>
	<br>
		<button class="btn btn-warning" type="submit">Search</button>

	</form>
</div>
</div>
</c:if>
<div class="row">
<div class="col-xs-0 col-md-4"> </div>
<div class="col-xs-12 col-md-2">
<form:form action="searchBeers.do" modelAttribute="BeerParameters">
	<c:choose>
		
		<c:when test="${searchSetting == 'name' }">
			BEER NAME <form:input type="text" path="name"
				placeholder="Beer name" />
			<form:errors path="name" />
		</c:when>
		<c:when test="${searchSetting == 'abv' }">
			ABV Low <form:input type="number" path="abvLow" />
			<form:errors path="abvLow" />
			ABV High <form:input  type="number" path="abvHigh" />
			<form:errors path="abvHigh" />
		</c:when>
		<c:when test="${searchSetting == 'hop' }">
			Hop Count Low  <form:input type="number"
				path="hopCountLow" />
			<form:errors path="hopCountLow" />
			Hope Count High <form:input  type="number"
				path="hopCountHigh" />
			<form:errors path="hopCountHigh" />
		</c:when>
		<c:when test="${searchSetting == 'style' }">
			Style <form:input type="text" path="style"
				placeholder="style" />
			<form:errors path="style" />
		</c:when>
		<c:when test="${searchSetting ==  'rating'}">
			Rating Low<form:input  type="number"
				path="ratingLow" placeholder="Number 1-5" />
			<form:errors path="ratingLow" />
			Rating High <form:input type="number"
				path="ratingHigh" placeholder="Number 1-5" />
			<form:errors path="ratingHigh" />
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
		<button class="btn btn-warning" type="submit">Search</button>
	</c:if>
</form:form>
		
	</div>
</div>	
		
		</div>
		</div>
	</div>
</header>

<%@include file="/includes/footer.jsp"%>
