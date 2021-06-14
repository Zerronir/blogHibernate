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
<jsp:include page="includes/header.jsp" />
<div class="d-flex align-items-stretch h-100">
    <div>
        <c:if test="${errorTitol eq true}">
            <div style="margin-top: 20px;" class="alert alert-warning fade show">
                <strong>Alerta!</strong> El títol no pot estar buit.
                <button type="button" class="close" data-dismiss="alert"></button>
            </div>
        </c:if>
    </div>
    <div class="container-fluid">
        <form action="/admin/${blog.slug}/createPost" method="post">
            <input type="text" name="_csrfToken" value="${csrfToken}" hidden>
            <div class="form-group">
                <label for="title">Títol del post</label>
                <input type="text" class="form-control" name="title" id="title" onkeyup="changeSubmit(this.value)" aria-describedby="name">
            </div>
            <div class="form-group">
                <label for="content">Contingut del post</label>
                <textarea onkeyup="checkTextArea(this.value)" class="form-control" name="content" id="content" cols="10" rows="20"></textarea>
            </div>
            <%--<div class="form-group">
                <label for="category">Categoría</label>
                <select name="category" id="category">
                    <option value=""></option>
                </select>
            </div>--%>
            <button type="submit" id="postSubmit" class="btn btn-primary" disabled>Crear post</button>
        </form>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>

    const changeSubmit = (text) => {
        let chars = text.length;
        let textArea = $('#content').val().length;
        if (chars > 0 && textArea > 0) {
            $('#postSubmit').attr('disabled', false);
        } else {
            $('#postSubmit').attr('disabled', true);
        }
    }

    const checkTextArea = (text) => {
        let chars = text.length;
        let title = $('#title').val().length;

        if (chars > 0 && title > 0) {
            $('#postSubmit').attr('disabled', false);
        } else {
            $('#postSubmit').attr('disabled', true);
        }
    }
</script>
</body>
</html>
