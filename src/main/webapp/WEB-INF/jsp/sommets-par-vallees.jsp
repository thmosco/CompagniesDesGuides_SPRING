
    <%@ page import="java.util.Collection" %>
    <%@ page import="java.util.Set" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.SommetsModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.AbrisModel" %>
<%@ page import="projet.cdg.compagnieDesGuides.model.AscensionsModel" %>
<jsp:include page="header.jsp" />
<div class="container">
<h1 class="text-center" style='margin-top: 10%;'>Sommets disponible depuis cette Vallée</h1>
<p>Vous pouvez choisir des sommets et des abris. Lorsque vous avez faits votre choix utiliser le boutton en bas de page "Passez au choix des dates" pour configurer votre randonnée.</p>
	<form action='/CompagnieDesGuides/randonnees/recap' method='POST'>
	<%

		Iterable<SommetsModel> sommets = (Iterable<SommetsModel>)request.getAttribute("sommets");
	
		Iterable<AbrisModel> abris = (Iterable<AbrisModel>)request.getAttribute("abris");

		out.print("<p>Il est possible qu'il n'y ai pas de sommets associé à cette vallées, dans ce cas vous pouvez <a href='/CompagnieDesGuides/randonnees/vallees'>choisir une autre vallée</a></p>");
	%>
	
	
	<div class='card-columns'>
	<%
		for (SommetsModel s:sommets){
			%>
			<div class="card bg-dark text-white">
	  				<div class="card-header">Sommet</div>
	  				<div class="card-body">
	  					<h5 class="card-title">Sommet <% out.print(s.getNom());%></h5>
	  					<p class="card-text">Ce sommet culmine à <% out.print(s.getAltitude());%> mètres</p>
	  					<p class="card-text">Ce sommet est accessible depuis cette vallée.</p>
	  					<label class="switch">
							<input type='checkbox' name="sommets" value='<% out.print(s.getId());%>'>
							<span class="slider round"></span>
						</label>
					</div>
			</div>
	
				<%
				
			}
	%>
		</div>
		<h3>Abris dans cette vallée</h3>
		<p>Le choix d'un abri n'est pas obligatoire, mais il est conseiller d'en prendre si votre ascension dure plusieurs jours.</p>
		<div class="text-center mb-5">
			  <a class="btn btn-secondary " data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
			    Voir les abris de cette vallée
			  </a>
		</div>
		 <div class="collapse" id="collapseExample">

		<div class='card-columns'>
	<% 
					
					for (AbrisModel a:abris) {
						  %>
						<div class="card bg-light" style="min-height: 266px">
			  				<div class="card-header">Abris</div>
			  				<div class="card-body">
			  				<h5 class="card-title"><% out.print(a.getNom_abris());%></h5>
			  				<h6 class="card-title">Cette abris est un(e) <% out.print(a.getType_abris());%></h6>
			  				<h6 class="card-title">Le prix de la nuit est <% out.print(a.getPrix_nuit());%> euros</h6>
			  				<%
			  				if(!a.getAscensions().isEmpty()){//Si j'ai des ascensions lié à cette abris, je conseil cette abri pour des sommets
							  Set<AscensionsModel> ascensions = a.getAscensions();
							  String lesSommets = "Cette abris vous est conseillez si vous faites le(s) sommet(s) ";
							  for(AscensionsModel as:ascensions){lesSommets = lesSommets + as.getSommets().getNom()+", ";}
							  
							  out.print("<p class='card-text'>"+lesSommets+"</p>");
						  }
			  				%>
			  				<label class="switch">
							<input type='checkbox' name="abris" value='<% out.print(a.getId());%>'>
							<span class="slider round"></span>
							</label>
							</div> 
						</div>
						  <% 
						  
					}
						  
						  %>
					</div>
			</div>
						  <input type="submit" class="btn btn-primary btn-lg btn-block mb-2" value="Passer aux choix des dates">
				</form>
	</div>
<jsp:include page="footer.jsp" />