<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Crear Nou Post</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" th:href="@{/css/styles.css}">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script></head>
<body>
<div class="d-flex align-items-stretch h-100">
    <div class="h-100">
        <jsp:include page="includes/header.jsp" />
    </div>

    <div class="container-fluid">
        <form action="/admin/${blog.slug}/createPost" method="post">
            <div class="form-group">
                <label for="title">Títol del post</label>
                <input type="text" class="form-control" name="title" id="title" aria-describedby="name">
            </div>
            <div class="form-group">
                <label for="content">Contingut del post</label>
                <textarea class="form-control" name="content" id="content"></textarea>
            </div>
            <%--<div class="form-group">
                <label for="category">Categoría</label>
                <select name="category" id="category">
                    <option value=""></option>
                </select>
            </div>--%>
            <button type="submit" class="btn btn-primary">Crear blog</button>
        </form>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
