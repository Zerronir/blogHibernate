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
        <h3>${post.name}</h3>
        <p>${post.content}</p>
    </div>
    <div>
        <c:choose>
            <c:when test="${comments != null}">
                <div>
                    <form action="/postComment" method="post">
                        <div class="form-group">
                            <label for="commentContent">Comentari</label>
                            <textarea class="form-control" name="commentContent" id="commentContent"></textarea>
                        </div>
                    </form>
                </div>

                <c:forEach items="${comments}" var="comment">
                    <div>
                        <h3>${comment.comment_author}</h3>
                        <p>${comment.posted_at}</p>
                        <p>${comment.text}</p>
                    </div>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <form action="/postComment" method="post">
                    <div class="form-group">
                        <label for="commentContent">Comentari</label>
                        <textarea class="form-control" name="commentContent" id="commentContent"></textarea>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>
