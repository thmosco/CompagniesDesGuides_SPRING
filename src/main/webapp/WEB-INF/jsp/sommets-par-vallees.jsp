<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Collection" %>
    <%@ page import="java.util.Set" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.SommetsModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.AbrisModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.AscensionsModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compagnies des guides</title>
</head>
<body>
<h1>Sommets disponible depuis cette Vallée</h1>

	<form action='/compagnieDesGuides/randonnees/recap' method='POST'>
	<%

		Iterable<SommetsModel> sommets = (Iterable<SommetsModel>)request.getAttribute("sommets");
	
		Iterable<AscensionsModel> ascensions = (Iterable<AscensionsModel>)request.getAttribute("ascensions");
	%>
	<div>
	<%
		for (SommetsModel s:sommets){
			
			out.print("<p>Nom du sommet : "+s.getNom()+"</p>");

			%>
			
			<input type='checkbox' name="sommets" value='<% out.print(s.getId());%>'>
			
	</div>
				<%
				
			}
			out.print("<p>Abris dans cette vallée</p>");
					
					for (AscensionsModel a:ascensions) {
						  
						out.print("<div style = 'border: 1px solid black' >");

						  out.print("<p>"+a.getAbris().getNom_abris()+"</p>");
						  out.print("<p>"+a.getAbris().getType_abris()+"</p>");
						  out.print("<p>"+a.getAbris().getPrix_nuit()+"</p>");
						  
						  out.print("<p>Cette abris vous est conseillez si vous faites le sommet "+a.getSommets().getNom() +"</p>");
						  
						  %>
						  
						  <input type='checkbox' name="abris" value='<% out.print(a.getAbris().getId());%>'>
						  
						  </div>
						  <% 
						  
					}
						  
						  %>
						  <input type="submit" value="Passer aux choix des dates">
				</form>
</body>
</html>