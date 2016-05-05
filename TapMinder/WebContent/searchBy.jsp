<%@include file="/includes/header.jsp"%>

			<header>
	<div class="header-content">
		<div class="header-content-inner">
	<div class="text-center">
			<form name="searchBy" action="searchBeers.do" method="GET">
				<select name="findBy">
					<option value="">SELECT ONE</option>
					<option value="name">Name</option>
					<option value="abv">ABV</option>
					<option value="hop">Hop Count</option>
					<option value="style">Style</option>
					<option value="rating">Rating</option>
					
				</select>
				<input type="hidden" name="findBy" value="${searchSetting}">
				<button class="btn btn-warning" type="submit">GO SEARCH</button>

			</form>
			



</div>
		</div>
	</div>
</header>
			
			
<%@include file="/includes/footer.jsp"%>