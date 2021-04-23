<%@ page import="projet.cdg.compagnieDesGuides.model.ValleesModel" %>
<jsp:include page="header.jsp" />


<div class="container">

<h1 class="text-center" style='margin-top: 10%;'>Choisir une vall�e</h1>

<p>Choisissez une vall�e par laquel commencer votre ascension, vous pourriez par la suite s�lectionner un ou plusieurs sommets de cette vall�e</p>

<div class="row">

<%

Iterable<ValleesModel> vallees = (Iterable<ValleesModel>)request.getAttribute("vallees");

for (ValleesModel v:vallees){
		
%>
 <div class="col-sm-6 mb-4">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Voir les sommets par la rapport � la vall�e <% out.print(v.getNom()); %></h5>
        <a href="vallee/<% out.print(v.getId()); %>" class="btn btn-primary">Choisir cette vall�e</a>
      </div>
    </div>
  </div>

<% 
}
%>

</div>
</div>
<jsp:include page="footer.jsp" />