<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Collection" %>
    <%@ page import="java.util.ArrayList" %>
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
<h1>Les sommets par rapport à la vallée</h1>
	<%

		Iterable<AbrisModel> abris = (Iterable<AbrisModel>)request.getAttribute("abris");

		for (AbrisModel a:abris){
			out.print("<p>");
			
			out.print(a.getNom_abris());
			
			//Set<AscensionsModel> ascensions = s.getAscensions();
			
			//for (AscensionsModel a:ascensions) {
			//	  out.print(a.getDuree());
			//	  out.print(a.getDifficulte());
			//	}
			
			out.print("</p>");
		}
	%>
</body>
</html>