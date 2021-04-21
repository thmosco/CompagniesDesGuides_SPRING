<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="projet.cdg.compagnieDesGuides.model.ValleesModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compagnie des guides</title>
</head>
<body>
<h1>Choisir une vall�e</h1>
<p>Choisissez une vall�e par laquel commencer votre ascension, vous pourriez par la suite s�lectionner un ou plusieurs sommets de cette vall�e</p>
<%

Iterable<ValleesModel> vallees = (Iterable<ValleesModel>)request.getAttribute("vallees");

for (ValleesModel v:vallees){
	out.print("<p><a href=vallee/"+ v.getId()+">Acc�der � la partie "+v.getNom()+"</a></p>");
		}

%>
</body>
</html>