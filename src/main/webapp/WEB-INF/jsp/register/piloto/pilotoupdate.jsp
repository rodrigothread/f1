<%@ include file="../../header.jsp" %> 

<h1>Atualização de Pilotos</h1>
<br>
<form action="${pageContext.request.contextPath}/register/piloto/marge/${tbPiloto.idPiloto}" method="post">
  <fieldset>
    <legend>Informações do Piloto:</legend>
    Equipe do Piloto:
    <br>
    <input type="text" name="tbPiloto.idPiloto" value="${tbPiloto.idEquipe}" maxlength="40">
    <br>
    Nome do Piloto:
    <br>
    <input type="text" name="tbPiloto.nomePiloto" value="${tbPiloto.nomePiloto}" maxlength="100">
    <br><br>
    <button type="submit" name="_method" value="PUT">Salvar</button>
  </fieldset>
</form>
  
    <a href="${linkTo[IndexController].index}">voltar index</a>
<%@ include file="../../footer.jsp" %> 
   