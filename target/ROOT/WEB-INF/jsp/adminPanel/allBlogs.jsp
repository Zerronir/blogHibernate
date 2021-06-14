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
<div class="d-flex align-items-stretch h-100">

    <div class="container">
        <div>
            <h2>Llistat de blogs</h2>
        </div>

        <div class="container">
            <div class="d-flex row justify-content-between">
                <c:forEach items="${blogList}" var="blog">
                    <div class="card col-lg-5 mb-3">
                        <div class="card-body">
                            <h5 class="card-title">${blog.name}</h5>
                            <p class="card-text">Creat per ${blog.userSet.nickname}</p>
                            <p class="card-text">${blog.category}</p>
                            <a href="/${blog.slug}" class="btn btn-primary">Entrar al blog</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

</body>
</html>
