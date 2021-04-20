<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Collection" %>
<%@ page import="compaguides.CompagniesDesGuides.model.RandonneesModel" %>
<%@ page import="compaguides.CompagniesDesGuides.model.GuidesModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Spring MVC</title>
</head>
<body>
	<h1>Mes randonnées</h1>
	<%
	
		//récupérer les données transmises dans la requête (objet ModelAndView)
		Iterable<RandonneesModel> randonnees = (Iterable<RandonneesModel>)request.getAttribute("randonnees");
		
		//Afficher les employés
		out.print("<table><thead><tr><th>ID</th><th>Nombres de personnes</th><th>Date de début</th><th>Date de fin</th><th>Nom du guide</th><th></th><th></th></tr></thead></tbody>");
		for (RandonneesModel r:randonnees){
			out.print("<tr>");
			out.print("<td>"+r.getId()+"</td>");
			out.print("<td>"+r.getNombres_personnes()+"</td>");
			out.print("<td>"+r.getDate_debut()+"</td>");
			out.print("<td>"+r.getDate_fin()+"</td>");
			out.print("<td>"+r.get_guide().getNom()+"</td>");
			out.print("<td><a href='employes-update-form/"+r.getId()+"'>Modifier</a></td>");
			out.print("<td><a href='employes-delete/"+r.getId()+"'>Effacer</a></td>");
			out.print("<tr>");
		}
	%>
</body>
</html>