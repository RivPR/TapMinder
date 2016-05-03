<!-- 
In order to access header.jsp and footer.jsp from drama.jsp which exists at the same level as index jsp you need the "/" forward slash in order to path into the headers/footers 
 -->
 
 <%@include file="/includes/header.jsp"%>

<p>Johhny Drama</p>

<%@include file="/includes/footer.jsp"%>