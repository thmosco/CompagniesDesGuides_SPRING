<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

<div class="container">
				<h1 class="text-center" style='margin-top: 10%;'>Bienvenue sur la compagnie des guides</h1>
				
				<p>Vous �tes sur le site de la compagnie des guides. Vous pouvez sur ce site cr�er des randonn�es qui vous correspondent, et ainsi assurer le suivi de celle-ci. 
				Vous pouvez consulter vos randonn�es dans mes randonn�es. Pour en cr�er, vous pouvez passer par une vall�e pour voir les abris et sommets associ�s � celle-ci ou bien avoir 
				acc�es � tous les sommets et abris pour la customiser d'A � Z.</p>
				
				<div class="row"style='margin-bottom: 30%;'>
					<div class="col-md-12 text-center">
					<a class="btn btn-dark btn-lg" href="randonnees/vallees">Ajouter une randonn�es � partir d'une vall�e</a>
					<a class="btn btn-secondary btn-lg" href="/compagnieDesGuides/randonnees">Voir mes randonn�es</a>
					</div>
				</div>
</div>

<jsp:include page="footer.jsp" />