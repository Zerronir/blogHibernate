<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Admin</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="d-flex align-items-center">

    <div class="container d-flex flex-column">
        <div class="d-flex flex-column mb-5">
            <h2>Llistat de blogs</h2>
            <a href="/createBlog" class="btn btn-secondary">Crear nou blog</a>
        </div>

        <div class="container">
            <div class="d-flex row justify-content-between">
                <c:choose>

                    <c:when test="${blogCounter > 0}">

                        <c:forEach items="${blogList}" var="blog">
                            <div class="card col-lg-5 mb-3">
                                <div class="card-body">
                                    <h5 class="card-title">${blog.name}</h5>
                                    <p class="card-text">${blog.category}</p>
                                    <a href="/admin/${blog.slug}" class="btn btn-primary">Entrar al blog</a>
                                    <a href="/admin/deleteBlog/${blog.id}" class="btn btn-danger">Eliminar el blog</a>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>


                    <c:otherwise>
                        <c:if test="${user != null}">
                            <a href="/createBlog">Crear nou blog</a>
                        </c:if>
                    </c:otherwise>

                </c:choose>
            </div>
        </div>
    </div>
</div>

</body>
</html>
