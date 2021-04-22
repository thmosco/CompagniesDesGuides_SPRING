<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Collection" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.RandonneesModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.GuidesModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.ReserverModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.AbrisModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.ConcernerModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.SommetsModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.ValleesModel" %>


<%@ page import="java.util.Set" %>

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
		out.print("<table><thead><tr><th>ID</th><th>Nombres de personnes</th><th>Date de début</th><th>Date de fin</th><th>Nom du guide</th><th>Abris</th><th>Sommets</th></tr></thead></tbody>");
		for (RandonneesModel r:randonnees){
			out.print("<tr>");
			out.print("<td>"+r.getId()+"</td>");
			out.print("<td>"+r.getNombres_personnes()+"</td>");
			out.print("<td>"+r.getDate_debut()+"</td>");
			out.print("<td>"+r.getDate_fin()+"</td>");
			out.print("<td>"+r.get_guide()+"</td>");
			Set<ReserverModel> reserver = r.getReserver();
			out.print("<td>");
			for (ReserverModel re:reserver) {
				AbrisModel abris = re.getAbris();
				out.print("Nom : " + abris.getNom_abris() + " --- ");
				out.print("TypeAbris : " + abris.getType_abris() + " --- ");
				out.print("Altitude : " + abris.getAltitude() + " --- ");
				out.print("Prix Nuit : " + abris.getPrix_nuit() + " --- ");
				out.print("Prix Repas : " + abris.getPrix_repas() + " --- ");
				out.print("Tel Gardien : " + abris.getTel_gardien() + " --- ");
				out.print("Statut Reservation : " + re.getDate_Reserver()+ " --- ");
				out.print("Date Reservation : " + re.getStatut_Reserver()+ " --- ");
				out.print("<br>");
			}
			out.print("</td>");
			Set<ConcernerModel> concerner = r.getConcerner();
			out.print("<td>");
			for (ConcernerModel co:concerner) {
				SommetsModel sommet = co.getSommets();
				out.print("Nom : " + sommet.getNom() + " --- ");
				out.print("Altitude : " + sommet.getAltitude() + " --- ");
				out.print("Date concerner : " + co.getDate_concerner() + " --- ");
				out.print("<br>");
			}
			out.print("</td>");
			out.print("<td><a href='randonnees-update-form/"+r.getId()+"'>Modifier</a></td>");
			out.print("<td><a href='randonnees-delete/"+r.getId()+"'>Effacer</a></td>");
			out.print("<tr>");
		}
	%>
</body>
</html>