<jsp:include page="header.jsp" />
<div class="container">
<h4 class="text-center" style='margin-top: 10%;'>Une erreur c'est produite lors de l'ex�cution du formulaire</h4>

<p class="text-center text-danger">Raison : ${erreur}</p>
<div class="text-center">
<div><input type="button" class="btn btn-info btn-lg mb-1" value="Revenir � l'�dition du formulaire" onclick="history.back(-1)" /></div>
<div><a class="btn btn-secondary btn-lg mb-5" href="Revenir � l'�dition du formulaire">Revenir � l'accueil</a></div>
</div>
</div>
<jsp:include page="footer.jsp" />