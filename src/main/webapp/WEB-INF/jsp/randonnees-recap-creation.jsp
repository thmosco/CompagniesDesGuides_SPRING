<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="projet.cdg.compagnieDesGuides.model.SommetsModel" %>
    <%@ page import="projet.cdg.compagnieDesGuides.model.AbrisModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compagnie des guides</title>
</head>
<body>
<h1>Création de la randonnées</h1>
<p>Sur cette page, vous trouverez les sommets (et abris) que vous avez sélectionner sur votre page précédente. Merci de saisir des dates cohérentes pour votre randonnées. Après validation de votre randonnées, vous pourrez la consulter via Mes Randonnées ainsi que la modifier</p>

<%

	Iterable<SommetsModel> sommets = (Iterable<SommetsModel>)request.getAttribute("sommets");

	Iterable<AbrisModel> abris = (Iterable<AbrisModel>)request.getAttribute("abris");

%>


<form action="/compagnieDesGuides/randonnees/creation" method="post">

	<p>
		<label for="Nombres de personnes">Nombres de personnes</label>
		<input type="number" name="personnes">
		<label for="Date de début">Date de début</label>
		<input type="date" name="debut">
		<label for="Date de Fin">Date de fin</label>
		<input type="date" name="fin">
	</p>
	
	<p>
		<h4>Les sommets</h4>
		<%
		for(SommetsModel s:sommets){
		%>
		<p>
		<input type="hidden" name="sommets" value="<% out.print(s.getId());%>">
		<label for="Date">Date d'arrivé au sommet <% out.print(s.getNom());%></label>
		<input type="date" name="dateSommet">
		<p>Le sommet <% out.print(s.getNom());%> a une altitude de <% out.print(s.getAltitude());%> m</p>
		</p>
		<% 
		}
	%>
	</p>
	<%
	
	if(abris != null){
		%><p>
			<h4>Les abris</h4>
		<%
		for(AbrisModel a:abris){
		%>
		<input type="hidden" name="abris" value="<% out.print(a.getId());%>">
		<label for="Date">Date nuit abris <% out.print(a.getNom_abris());%></label>
		<input type="date" name="dateAbris">
		<p>L'abris <% out.print(a.getNom_abris());%> a une altitude de <% out.print(a.getAltitude());%> m. C'est un(e) <% out.print(a.getType_abris());%></p>
		</p>
		<%
		}
		out.print("</p>");
	}
	
	
	%>
	
	
	
	<input type="submit" value="Valider votre randonnée">
	
</form>

</body>
</html>