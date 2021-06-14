<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ofn" uri="/WEB-INF/utils/funcs.tld" %>

<html>
<head>
    <title>${blog.name}</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" th:href="@{/css/styles.css}">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="d-flex align-items-center container">

    <div class="container-fluid">
        <div class="mt-3 mb-3">
            <h3 class="display-3 text-uppercase">${blog.name}</h3>
        </div>
        <div class="d-flex row justify-content-between">

            <c:forEach items="${postList}" var="post">
                <div class="card col-lg-5 d-flex flex-column mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${post.name}</h5>
                        <p class="card-text">${fn:substring(ofn:renderPost(post.content), 0, 20)}...</p>
                        <a href="/${blog.slug}/${post.slug}"
                           class="btn btn-primary">Veure més</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
