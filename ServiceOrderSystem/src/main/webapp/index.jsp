<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SisVirtual - Início </title>
</head>
<body>

<h1> Sistema de Ordem de Serviço - Subseção de Simulação Virtual </h1>

<form action="servlogin" method="post">

<label> Login: </label> <input type="text" name="Login"/>  <br><br>

<label> Senha: </label>  
<input type="password" name="Senha"/> <br> 

<input type="submit" value="Entrar"/>

</form>

<h4>${msg}</h4>


</body>
</html>