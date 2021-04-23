
    <%@ page import="projet.cdg.compagnieDesGuides.model.SommetsModel" %>
    <%@ page import="projet.cdg.compagnieDesGuides.model.AbrisModel" %>
<jsp:include page="header.jsp" />
<div class="container">
<h1 class="text-center" style='margin-top: 10%;'>Cr�ation de la randonn�e</h1>
<p>Sur cette page, vous trouverez les sommets (et abris) que vous avez s�lectionner sur la page pr�c�dente. Merci de saisir des dates coh�rentes pour votre randonn�es. Apr�s validation de votre randonn�es, vous pourrez la consulter via Mes Randonn�es ainsi que la modifier</p>

<%

	Iterable<SommetsModel> sommets = (Iterable<SommetsModel>)request.getAttribute("sommets");

	Iterable<AbrisModel> abris = (Iterable<AbrisModel>)request.getAttribute("abris");

%>

<form action="/compagnieDesGuides/randonnees/creation" method="post">
	<h3 class="text-center">Ma randonn�e</h1>
	<div class='form-group'>
		<label for="Nombres de personnes">Nombres de personnes</label>
		<input class="form-control" type="text" name="personnes">
		<small class="form-text text-muted">Entrez le nombre de personnes qui seront � la randonn�e.</small>
		<div class='row'>
			<div class='col-md-6'>
			<label for="Date de d�but">Date de d�but</label>
			<input class="form-control" type="date" name="debut">
			<small class="form-text text-muted">Merci de mettre des dates coh�rentes, et de ne pas exc�der les 15 jours de randonn�es.</small>
			</div>
			<div class='col-md-6'>
			<label for="Date de Fin">Date de fin</label>
			<input class="form-control" type="date" name="fin">
			</div>
			
		</div>
		<div class="row">
		<div class='col-md-6'>
		<h4>Les sommets</h4>
		<div class='card-columns row'>
		<%
		for(SommetsModel s:sommets){
		%>
		
		<div class="card bg-dark text-white col-md-9 mx-auto">
	  				<div class="card-header">Sommet</div>
	  				<div class="card-body">
	  				<input type="hidden" name="sommets" value="<% out.print(s.getId());%>">
	  					<h5 class="card-title">Sommet <% out.print(s.getNom());%></h5>
	  					<p class="card-text">Le sommet <% out.print(s.getNom());%> a une altitude de <% out.print(s.getAltitude());%> m</p>
	  					<label for="Date">Date d'arriv� au sommet <% out.print(s.getNom());%></label>
						<input type="date" name="dateSommet" class="form-control">
					</div>
			</div>
		<% 
		}
	%>
			</div>
		</div>
	<%
	
	if(abris != null){
		%>
		<div class='col-md-6'>
			<h4>Les abris</h4>
		<div class="card-columns row">	
		<%
		for(AbrisModel a:abris){
		%>
		<div class="card bg-light col-md-9 mx-auto">
			  				<div class="card-header">Abris</div>
			  				<div class="card-body">
			  				<h5 class="card-title"><% out.print(a.getNom_abris());%></h5>
			  				<h6 class="card-title">Cette abris est un(e) <% out.print(a.getType_abris());%></h6>
			  				<h6 class="card-title">Les prix de la nuit est <% out.print(a.getPrix_nuit());%> euros</h6>
							<input type="hidden" name="abris" value="<% out.print(a.getId());%>">
							<p class="card-text">L'abris <% out.print(a.getNom_abris());%> a une altitude de <% out.print(a.getAltitude());%> m.</p>
							<label for="Date">Date r�servation abris <% out.print(a.getNom_abris());%></label>
							<input type="date" name="dateAbris" class="form-control">
						
							</div> 
						</div>

		<%
		}
		%>
		
			</div>
		</div>
		<%
	}
	
	
	%>
	</div>
	
	
	<input type="submit" class="btn btn-primary btn-lg btn-block mb-2"  value="Valider votre randonn�e">
	
</form>
</div>


<jsp:include page="footer.jsp" />