<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ofn" uri="/WEB-INF/utils/funcs.tld" %>

<html>
<head>
    <title>${blog.name} - Llistat de posts</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<jsp:include page="includes/header.jsp" />
<div class="d-flex align-items-center container">
    <div class="container-fluid">
        <div class="mt-3 mb-3">
            <h3 class="display-3 text-uppercase">Llistat de posts del blog ${blog.name}</h3>
            <c:if test="${blog.userSet.id eq user.id}">
                <a href="/admin/${blog.slug}/createPost">Crear un nou post</a>
            </c:if>
        </div>
        <div class="d-flex row justify-content-between">

            <c:forEach var="post" items="${postList}">
                <div class="card col-lg-5 d-flex flex-column mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${post.name}</h5>
                        <p class="card-text">${fn:substring(ofn:renderPost(post.content), 0, 20)}... </p>
                        <a href="/${blog.slug}/${post.slug}"
                           class="btn btn-primary">Veure més</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
