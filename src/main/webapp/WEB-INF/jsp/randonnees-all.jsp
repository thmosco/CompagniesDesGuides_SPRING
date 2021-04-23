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
	
	<jsp:include page="header.jsp" />
	<h1 class="my-4 text-center">Mes randonnées</h1>
	<%
	
		//récupérer les données transmises dans la requête (objet ModelAndView)
		Iterable<RandonneesModel> randonnees = (Iterable<RandonneesModel>)request.getAttribute("randonnees");
		if(request.getAttribute("erreur") != null) {out.print("<div class='h5 font-weight-bold text-warning'>"+request.getAttribute("erreur")+"</div>");};
		out.print("<table class='table'><thead><tr><th class='border h3'>Randonnées</th><th class='border h3'>Abris</th><th class='border h3'>Sommets</th></tr></thead></tbody>");
		for (RandonneesModel r:randonnees){
			out.print("<tr>");
			out.print("<td class='border'><div class='card bg-secondary text-white mx-auto'><div class='card-header'>Randonnée "+r.getId()+"</div><div class='card-body'><form action='/CompagnieDesGuides/randonnees-update-form/"+r.getId()+"' method='post'>");
			out.print("<div class='card-body'>Date Debut<input type='date' class='form-control' placeholder='Date' name='dateDebut' value='" + r.getDate_debut() + "'><br>");
			out.print("Date Fin<input type='date' name='dateFin' class='form-control' placeholder='Date' value='" + r.getDate_fin() + "'><br>");
			out.print("Nb personnes <input type='number' class='form-control' placeholder='Number' name='nbPersonne' value='" + r.getNombres_personnes() + "'>");
			out.print("<input type='submit' value='Modifier' class='btn btn-info mt-3'>");
			out.print("</form></div></div></td>");
			Set<ReserverModel> reserver = r.getReserver();
			out.print("<td class='border'>");
			out.print("<div class='card bg-light text-dark mx-auto'><form action='/CompagnieDesGuides/reserver-ajout-form/"+r.getId()+"' method='post'><div class='card-header'>Ajout d'abris</div><div class='card-body'> <select name='ajoutAbris'  class='form-control'>");
			Iterable<AbrisModel> tousAbris = (Iterable<AbrisModel>)request.getAttribute("abris");
			for (AbrisModel a:tousAbris){
				out.print("<option value='"+a.getId()+"'>"+a.getNom_abris()+"</option>");
			}

			out.print("</select><br>");
			out.print("<input type='date' hidden name='dateDebut' value='" + r.getDate_debut() + "'>");
			out.print("<input type='date' hidden name='dateFin' value='" + r.getDate_fin() + "'>");
			out.print("Date Reservation : <input type='date' class='form-control' placeholder='Date' name='dateReservation' min='"+r.getDate_debut()+"' max='"+r.getDate_fin()+"'>");
			out.print("<input type='submit' value='Ajouter' class='btn btn-info mt-3'>");
			
			out.print("</div></div>	</form><br>");
			for (ReserverModel re:reserver) {
				AbrisModel abris = re.getAbris();
				out.print("<div class='card bg-dark text-white mx-auto'><div class='card-header'>" + abris.getNom_abris() + " --- "+abris.getType_abris() +" </div><div class='card-body'> ");
				out.print("<ul class='list-group list-group-flush'><li class='list-group-item list-group-item-dark'>TypeAbris : " + abris.getType_abris() + " --- </li>");
				out.print("<li class='list-group-item list-group-item-dark'>Altitude : " + abris.getAltitude() + " --- </li>");
				out.print("<li class='list-group-item list-group-item-dark'>Prix Nuit : " + abris.getPrix_nuit() + " --- </li>");
				out.print("<li class='list-group-item list-group-item-dark'>Prix Repas : " + abris.getPrix_repas() + " --- </li>");
				out.print("<li class='list-group-item list-group-item-dark'>Tel Gardien : " + abris.getTel_gardien() + " --- </li></ul>");
				int i = 0;
				ArrayList<String> tab = new ArrayList<String>();
				tab.add("Enlever réservation");
				tab.add("en attente");
				tab.add("confirmé");
				out.print("<form action='/CompagnieDesGuides/reserver-update-form/"+abris.getId()+"/"+r.getId()+"' method='post' accept-charset='UTF-8'>Statut Reservation<select name='statutReservation' class='form-control'>");
				while (i < 3){
					String reservation = "";
					if(tab.get(i).equals(re.getStatut_Reserver())){reservation = "selected";}
					out.print("<option valeur='"+tab.get(i)+"' "+reservation+">"+tab.get(i)+"</option>");
					i++;
				}
				out.print("</select class='form-control'><br>");
				out.print("<input type='date' hidden name='dateDebut' value='" + r.getDate_debut() + "'>");
				out.print("<input type='date' hidden name='dateFin' value='" + r.getDate_fin() + "'>");
				out.print("Date Reservation : <input type='date' class='form-control' placeholder='Date' name='dateReservation' value='" + re.getDate_Reserver()+ "'>");
				out.print("<input type='submit' value='modifier' class='btn btn-info mt-3'>");
				out.print("</div></div></form> ");
				out.print("<br>");
			}
			out.print("</td>");
			Set<ConcernerModel> concerner = r.getConcerner();
			out.print("<td>");
			out.print("<div class='card bg-light text-dark mx-auto'><form action='/CompagnieDesGuides/concerner-ajout-form/"+r.getId()+"' method='post'><div class='card-header'>Ajout Sommet</div><div class='card-body'><select name='ajoutSommet' class='form-control'>");
			Iterable<SommetsModel> tousSommets = (Iterable<SommetsModel>)request.getAttribute("sommets");
			for (SommetsModel s:tousSommets){
				out.print("<option value='"+s.getId()+"'>"+s.getNom()+ " " + s.getAltitude()+"</option>");
			}
			out.print("</select><br>");
			out.print("<input type='date' hidden name='dateDebut' value='" + r.getDate_debut() + "'>");
			out.print("<input type='date' hidden name='dateFin' value='" + r.getDate_fin() + "'>");
			out.print("Date Exploration: <input type='date' name='dateConcerner' class='form-control' placeholder='Date' min='"+r.getDate_debut()+"' max='"+r.getDate_fin()+"'>");
			out.print("<input type='submit' value='Ajouter' class='btn btn-info mt-3'>");
			out.print("</form></div></div><br>");
			for (ConcernerModel co:concerner) {
				SommetsModel sommet = co.getSommets();
				out.print("<div class='card bg-dark text-light mb-4 mx-auto'><div class='card-header'>"+sommet.getNom()+" --- "+sommet.getAltitude()+ "</div><div class='card-body'>");
				out.print("<ul class='list-group list-group-flush'>");
				out.print("<li class='list-group-item list-group-item-dark'>Altitude : " + sommet.getAltitude() + " --- </li></ul>");
				out.print("<form action='/CompagnieDesGuides/concerner-update-form/"+sommet.getId()+"/"+r.getId()+"' method='post'>");
				out.print("<input type='date' hidden name='dateDebut' value='" + r.getDate_debut() + "'>");
				out.print("<input type='date' hidden name='dateFin' value='" + r.getDate_fin() + "'>");
				out.print("Date exploration <input type='date' name='dateConcerner' class='form-control' placeholder='Date' value='" + co.getDate_concerner() + "'>");
				out.print("<input type='submit' value='modifier' class='btn btn-info mt-3'>");
				out.print("</form>");
				out.print("<a type='button' class='btn btn-warning mt-3' href='/CompagnieDesGuides/concerner-delete/"+sommet.getId()+"/"+r.getId()+"'>Effacer</a>");
				out.print("<br></div></div>");
			}
			out.print("</td>");
			out.print("<td><a href='/CompagnieDesGuides/randonnees-delete/"+r.getId()+"' type='button' class='btn btn-warning mt-3'>Effacer Randonnée</a></td>");
			out.print("<tr>");
		}
	%>
	<jsp:include page="footer.jsp" />
</body>
</html>