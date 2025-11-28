<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erro!</title>
</head>
<body>
<h1>Error, please contact the support team</h1>

<%
out.print(request.getParameter("msg")); 
%>


<form action="index.jsp">

<input type="submit" value="Go Back"/>

</form>
</body>
</html>