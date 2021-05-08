<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Hello World!</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<div class="d-flex align-items-stretch h-100">
    <div class="h-100">
        <jsp:include page="includes/header.jsp" />
    </div>

    <div class="mt-3">
        <div>
            <h2>Llistat de blogs</h2>
        </div>

        <div>
            <c:choose>
                <c:when test="${blogCounter > 0}">
                    <c:forEach items="${blogList}" var="blog" >
                        <div>
                            <h2>${blog}</h2>
                        </div>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <a href="/createBlog">Crear nou blog</a>
                </c:otherwise>

            </c:choose>

        </div>


    </div>
</div>

</body>
</html>