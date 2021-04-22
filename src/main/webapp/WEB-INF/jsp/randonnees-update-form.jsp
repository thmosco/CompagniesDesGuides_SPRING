<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="projet.cdg.compagnieDesGuides.model.RandonneesModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.GuidesModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.ReserverModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.AbrisModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.ConcernerModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.SommetsModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.ValleesModel" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='' method='post'>
		NbPersonnes : <input type='number' name='nbPersonnes_Randonnees' value="${randonnees.getNombres_personnes()}"><br>
		dateDebut_Randonnees : <input type='date' name='dateDebut_Randonnees' value='${randonnees.getDate_debut()}'><br>
		dateFin_Randonnees : <input type='date' name='dateFin_Randonnees' value='${randonnees.getDate_fin()}'><br>
		<%
			Set<ReserverModel> reserver = ((RandonneesModel)request.getAttribute("randonnees")).getReserver();
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
		%>
		<input type=submit>
	</form>
</body>
</html>