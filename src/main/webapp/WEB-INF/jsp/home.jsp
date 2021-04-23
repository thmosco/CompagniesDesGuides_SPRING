<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

<div class="container">
				<h1 class="text-center" style='margin-top: 10%;'>Bienvenue sur la compagnie des guides</h1>
				
				<p>Vous êtes sur le site de la compagnie des guides. Vous pouvez sur ce site créer des randonnées qui vous correspondent, et ainsi assurer le suivi de celle-ci. 
				Vous pouvez consulter vos randonnées dans mes randonnées. Pour en créer, vous pouvez passer par une vallée pour voir les abris et sommets associés à celle-ci ou bien avoir 
				accées à tous les sommets et abris pour la customiser d'A à Z.</p>
				
				<div class="row"style='margin-bottom: 30%;'>
					<div class="col-md-12 text-center">
					<a class="btn btn-dark btn-lg" href="randonnees/vallees">Ajouter une randonnées à partir d'une vallée</a>
					<a class="btn btn-secondary btn-lg" href="/compagnieDesGuides/randonnees">Voir mes randonnées</a>
					</div>
				</div>
</div>

<jsp:include page="footer.jsp" />