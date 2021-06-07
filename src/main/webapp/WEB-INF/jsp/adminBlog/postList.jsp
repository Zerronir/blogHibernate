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
<jsp:include page="includes/header.jsp" />
<div class="d-flex align-items-center container">
    <div>
        <h3>${blog.name}</h3>
        <ul>
            <c:choose>
                <c:when test="${postCount > 0}">
                    <li><a href="/admin/${blog.slug}/createPost">Crear un nou post</a></li>
                    <c:forEach var="post" items="${postList}">
                        <li>${post.name} <a href="/${post.slug}">Veure blog</a></li>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <a href="/admin/${blog.slug}/createPost">Crear un nou post</a>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>

</body>
</html>
