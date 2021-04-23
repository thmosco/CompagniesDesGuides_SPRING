<%@ page import="projet.cdg.compagnieDesGuides.model.GuidesModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compagnie des Guides</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    </head>
    <body>
        <header>
<div class='container '>
<h1 class="text-center" style='margin-top: 10%;'>Bienvenue sur la compagnie des guides</h1>

<p class='text-center'> Vous devez vous identifier pour accéder à votre espace</p>
<div class='form-group text-center'>
<form method="post" action="/compagnieDesGuides/login" >
	<label for="Adresse mail">Adresse mail :
	<input type="text" class="form-control" name="email">
	<label for="Mot de passe">Mot de passe : </label>
	<input type="password" class="form-control"  name="password">
	<% if(request.getAttribute("erreur") != null) {out.print("<p class='text-danger'>"+request.getAttribute("erreur")+"</p>");};%>
	<input type="submit" value="Se connecter" class="btn btn-primary btn-lg btn-block mb-2 mt-2"/>
</form>
</div>
</div>
<jsp:include page="footer.jsp" />
