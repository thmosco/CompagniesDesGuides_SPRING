<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Une Erreur c'est produite lors de l'exécution du formulaire</h4>

<p>Raison : ${erreur}</p>
<input type="button" value="Revenir à l'édition du formulaire" onclick="history.back(-1)" />
</body>
</html>