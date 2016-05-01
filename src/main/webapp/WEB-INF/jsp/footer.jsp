<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<c:if test="${not empty error}">
    ${error}
</c:if>

<c:if test="${not empty success}">
    ${success}
</c:if>

    </body>
</html>
