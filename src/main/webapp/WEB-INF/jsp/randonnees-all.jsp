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
<%@ page import="java.util.ArrayList" %>


<%@ page import="java.util.Set" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo Spring MVC</title>
</head>
<body>
	<h1>Mes randonnées</h1>
	<%
	
		//récupérer les données transmises dans la requête (objet ModelAndView)
		Iterable<RandonneesModel> randonnees = (Iterable<RandonneesModel>)request.getAttribute("randonnees");
		if(request.getAttribute("erreur") != null) {out.print(request.getAttribute("erreur"));};
		//Afficher les employés
		out.print("<table><thead><tr><th>ID</th><th>Date de début</th><th>Date de fin</th><th>Nombres de personnes</th><th></th><th>Nom du guide</th><th>Abris</th><th>Sommets</th></tr></thead></tbody>");
		for (RandonneesModel r:randonnees){
			out.print("<tr>");
			out.print("<td>"+r.getId()+"</td>");
			out.print("<form action='/CompagnieDesGuides/randonnees-update-form/"+r.getId()+"' method='post'>");
			out.print("<td><input type='date' name='dateDebut' value='" + r.getDate_debut() + "'></td>");
			out.print("<td><input type='date' name='dateFin' value='" + r.getDate_fin() + "'></td>");
			out.print("<td><input type='number' name='nbPersonne' value='" + r.getNombres_personnes() + "'></td>");
			out.print("<td><input type='submit' value='Modifier'></td>");
			out.print("</form>");
			out.print("<td>"+r.getGuide().getNom()+"</td>");
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
				int i = 0;
				ArrayList<String> tab = new ArrayList<String>();
				tab.add("Enlever réservation");
				tab.add("en attente");
				tab.add("confirmé");
				out.print("<form action='/CompagnieDesGuides/reserver-update-form/"+abris.getId()+"/"+r.getId()+"' method='post' accept-charset='UTF-8'>Statut Reservation<select name='statutReservation'>");
				while (i < 3){
					String reservation = "";
					if(tab.get(i).equals(re.getStatut_Reserver())){reservation = "selected";}
					out.print("<option valeur='"+tab.get(i)+"' "+reservation+">"+tab.get(i)+"</option>");
					i++;
				}
				out.print("</select>");
				out.print("<input type='date' hidden name='dateDebut' value='" + r.getDate_debut() + "'>");
				out.print("<input type='date' hidden name='dateFin' value='" + r.getDate_fin() + "'>");
				out.print("Date Reservation : <input type='date' name='dateReservation' value='" + re.getDate_Reserver()+ "'>");
				out.print("<input type='submit' value='modifier'>");
				out.print("</form>");
				out.print("<br>");
			}
			out.print("</td>");
			Set<ConcernerModel> concerner = r.getConcerner();
			out.print("<td>");
			for (ConcernerModel co:concerner) {
				SommetsModel sommet = co.getSommets();
				out.print("Nom : " + sommet.getNom() + " --- ");
				out.print("Altitude : " + sommet.getAltitude() + " --- ");
				out.print("<form action='/CompagnieDesGuides/concerner-update-form/"+sommet.getId()+"/"+r.getId()+"' method='post'>");
				out.print("<input type='date' hidden name='dateDebut' value='" + r.getDate_debut() + "'>");
				out.print("<input type='date' hidden name='dateFin' value='" + r.getDate_fin() + "'>");
				out.print("Date exploration <input type='date' name='dateConcerner' value='" + co.getDate_concerner() + "'>");
				out.print("<input type='submit' value='modifier'>");
				out.print("</form>");
				out.print("<a href='/CompagnieDesGuides/concerner-delete/"+sommet.getId()+"/"+r.getId()+"'>Effacer</a>");
				out.print("<br>");
			}
			out.print("</td>");
			out.print("<td><a href='/CompagnieDesGuides/randonnees-delete/"+r.getId()+"'>Effacer</a></td>");
			out.print("<tr>");
		}
	%>
</body>
</html>