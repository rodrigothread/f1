<%@ include file="../../header.jsp" %> 

<h1>Lista de Pilotos</h1>
<br>
    
    <table style="width:25%">
        <!--tr>
            <th>Sigla</th>
            <th>Nome</th>
        </tr-->
        <c:forEach items="${lista}" var="l">
            <tr>
                <td>${l.idPiloto}</td>
                <td>${l.nomePiloto}</td> 
                <td>          
                    <form action="${pageContext.request.contextPath}/register/piloto/update/" method="post">
                        <input name="idPiloto" value="${l.idPiloto}" type="hidden" />
                        <button type="submit">editar</button>
                    </form>
                </td> 
                <td>          
                    <form action="${pageContext.request.contextPath}/register/piloto/remove/" method="post">
                        <input name="idPiloto" value="${l.idPiloto}" type="hidden" />
                        <button type="submit" name="_method" value="DELETE">remover</button>
                    </form>
                </td>
                                         
            </tr>
        </c:forEach>
        
    </table>

    <a href="${linkTo[IndexController].index}">voltar index</a>

<%@ include file="../../footer.jsp" %> 
   