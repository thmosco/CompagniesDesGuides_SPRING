<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compagnie des guides</title>
</head>
<body>
<h1>Cr�ation de la randonn�es</h1>
<p>Sur cette page, vous trouverez les sommets (et abris) que vous avez s�lectionner sur votre page pr�c�dente. Merci de saisir des dates coh�rentes pour votre randonn�es. Apr�s validation de votre randonn�es, vous pourrez la consulter via Mes Randonn�es ainsi que la modifier</p>



<form action="/compagnieDesGuides/randonnees/creation" method="post">

	<p>
		<label for="Nombres de personnes">Nombres de personnes</label>
		<input type="number" name="personnes">
		<label for="Date de d�but">Date de d�but</label>
		<input type="date" name="debut">
		<label for="Date de Fin">Date de Fin</label>
		<input type="date" name="fin">
	</p>
	
	<p>
		<h4>Les sommets</h4>
		
		
		<input type="hidden" value="sommetID">
		<label for="Date">Date d'arriv� au sommet SOMMET_A</label>
		<input type="date" name="dateSommet">
	</p>
	
	<p>
		<h4>Les abris</h4>
		<input type="hidden" value="abrisID">
		<label for="Date">Date nuit abris ABRIS_2</label>
		<input type="date" name="dateAbris">
	</p>
	
	<input type="submit" value="Valider votre randonn�e">
	
</form>

</body>
</html>