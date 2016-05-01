<%@ include file="../../header.jsp" %> 

<h1>Cadastro do piloto</h1>

<form action="${pageContext.request.contextPath}/register/piloto/persist/" method="post">
    <fieldset>
        <legend>Informações do Piloto</legend>
        Equipe:
        
            
        <div class="row">               
                    <label>Equipes:</label>
                    
                        <div class="custom-select">
                            <select id="modality" class="select required" name="tbPiloto.idequipe" data-placeholder="Selecione uma equipe">
                                <option selected value=''></option>
                                <c:forEach items="${lista}" var="l">    
                                    <option value="${l.nomeEquipe}">${l}</option>  
                                </c:forEach> 
                                    
                            </select>
                        </div>
                                      
        </div>           
        <br>
        Nome do Piloto:
        <br>
        <input type="text" name="tbPiloto.nomePiloto" value="" maxlength="100">
        <br><br>
        <input type="submit" value="Cadastrar">
    </fieldset>
</form>

<br>

<a href="${linkTo[IndexController].index}">voltar index</a>

<%@ include file="../../footer.jsp" %> 
