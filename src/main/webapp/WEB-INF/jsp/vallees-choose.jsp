<%@ page import="projet.cdg.compagnieDesGuides.model.ValleesModel" %>
<jsp:include page="header.jsp" />


<div class="container">

<h1 class="text-center" style='margin-top: 10%;'>Choisir une vallée</h1>

<p>Choisissez une vallée par laquel commencer votre ascension, vous pourriez par la suite sélectionner un ou plusieurs sommets de cette vallée</p>

<div class="row">

<%

Iterable<ValleesModel> vallees = (Iterable<ValleesModel>)request.getAttribute("vallees");

for (ValleesModel v:vallees){
		
%>
 <div class="col-sm-6 mb-4">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Voir les sommets par la rapport à la vallée <% out.print(v.getNom()); %></h5>
        <a href="vallee/<% out.print(v.getId()); %>" class="btn btn-primary">Choisir cette vallée</a>
      </div>
    </div>
  </div>

<% 
}
%>

</div>
</div>
<jsp:include page="footer.jsp" />