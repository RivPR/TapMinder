<!-- 
In order to access header.jsp and footer.jsp from drama.jsp which exists at the same level as index jsp you need the "/" forward slash in order to path into the headers/footers 
 -->
 
 <%@include file="/includes/header.jsp"%>

<p>Johhny Drama</p>
<h3>
ID: ${br.id}
User: ${br.user}
Beer: ${br.beer}
Rating: ${br.rating}
</h3>


<%@include file="/includes/footer.jsp"%>