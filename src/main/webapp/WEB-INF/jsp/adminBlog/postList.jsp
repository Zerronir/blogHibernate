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
    <div class="d-flex flex-column">
        <h3>${blog.name}</h3>
            <c:choose>
                <c:when test="${postCount > 0}">
                    <div>
                        <a href="/admin/${blog.slug}/createPost">Crear un nou post</a>
                    </div>
                    <div class="d-flex row justify-content-between">
                        <c:forEach var="post" items="${postList}">
                            <div class="card col-lg-5 mb-3">
                                <div class="card-body">
                                    <p class="card-text">${post.name}</p>
                                    <a href="/${blog.slug}/${post.slug}" class="btn btn-primary">Veure el post</a>
                                    <a href="/admin/${blog.slug}/updatePost/${post.slug}" class="btn btn-secondary">Actualitzar post</a>
                                    <a href="/${blog.slug}/deletePost/${post.slug}" class="btn btn-danger">Eliminar post</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
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
