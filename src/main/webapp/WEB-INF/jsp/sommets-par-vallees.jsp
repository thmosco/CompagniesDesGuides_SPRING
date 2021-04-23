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
	
		Iterable<AbrisModel> abris = (Iterable<AbrisModel>)request.getAttribute("abris");
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
					
					for (AbrisModel a:abris) {
						  
						out.print("<div style = 'border: 1px solid black' >");

						  out.print("<p>"+a.getNom_abris()+"</p>");
						  out.print("<p>"+a.getType_abris()+"</p>");
						  out.print("<p>"+a.getPrix_nuit()+"</p>");
						  
						  if(!a.getAscensions().isEmpty()){//Si j'ai des ascensions lié à cette abris, je conseil cette abri pour des sommets
							  Set<AscensionsModel> ascensions = a.getAscensions();
							  String lesSommets = "Cette abris vous est conseillez si vous faites le(s) sommet(s) ";
							  for(AscensionsModel as:ascensions){lesSommets = lesSommets + as.getSommets().getNom();}
							  
							  out.print("<p>"+lesSommets+"</p>");
						  }
						  %>
						  
						  <input type='checkbox' name="abris" value='<% out.print(a.getId());%>'>
						  
						  </div>
						  <% 
						  
					}
						  
						  %>
						  <input type="submit" value="Passer aux choix des dates">
				</form>
</body>
</html>