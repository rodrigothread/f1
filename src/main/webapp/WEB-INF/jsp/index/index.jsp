<%@ include file="../header.jsp" %> 

<body>
	<!--It works!! {variable} {linkTo[IndexController].index}-->
        
        <br>
        
        <!--a href="{linkTo[IndexController].user}">Ir para o cadastro de municipio</a-->
        <a href="${pageContext.request.contextPath}/register/piloto/create/">Ir para o cadastro de pilotos</a> |
                  
        <a href="${pageContext.request.contextPath}/register/piloto/list/">Ir para a lista de pilotos</a>
               
        
</body>

<%@ include file="../footer.jsp" %> 