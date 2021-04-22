<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compagnie des guides</title>
</head>
<body>
<h1>Création de la randonnées</h1>
<p>Sur cette page, vous trouverez les sommets (et abris) que vous avez sélectionner sur votre page précédente. Merci de saisir des dates cohérentes pour votre randonnées. Après validation de votre randonnées, vous pourrez la consulter via Mes Randonnées ainsi que la modifier</p>



<form action="/compagnieDesGuides/randonnees/creation" method="post">

	<p>
		<label for="Nombres de personnes">Nombres de personnes</label>
		<input type="number" name="personnes">
		<label for="Date de début">Date de début</label>
		<input type="date" name="debut">
		<label for="Date de Fin">Date de Fin</label>
		<input type="date" name="fin">
	</p>
	
	<p>
		<h4>Les sommets</h4>
		
		
		<input type="hidden" value="sommetID">
		<label for="Date">Date d'arrivé au sommet SOMMET_A</label>
		<input type="date" name="dateSommet">
	</p>
	
	<p>
		<h4>Les abris</h4>
		<input type="hidden" value="abrisID">
		<label for="Date">Date nuit abris ABRIS_2</label>
		<input type="date" name="dateAbris">
	</p>
	
	<input type="submit" value="Valider votre randonnée">
	
</form>

</body>
</html>