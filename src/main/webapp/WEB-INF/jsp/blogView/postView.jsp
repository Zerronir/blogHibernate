<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ofn" uri="/WEB-INF/utils/funcs.tld" %>

<html>
<head>
    <title>Hello World!</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<%!
    /*private java.time.LocalDate date;*/
%>
<jsp:include page="includes/header.jsp" />
<div class="d-flex flex-column align-items-center container">
    <div class="w-100">
        <h3>${post.name}</h3>
        <p>${ofn:renderPost(post.content)}</p>
    </div>
    <div class="w-100 d-flex flex-column">
        <c:choose>
            <c:when test="${comments != null}">
                <div>
                    <form action="/postComment" method="post">
                        <input type="hidden" name="postId" value="${post.id}">
                        <div class="form-group">
                            <label>Comentari</label>
                            <textarea class="form-control" name="commentContent"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>

                <c:forEach items="${comments}" var="comment">
                    <div>
                        <p>
                            <c:choose>

                                <c:when test="${comment.user_id != null}">
                                    ${comment.user_id.nickname} el <strong>${ofn:formatDate(comment.posted_at)}</strong>
                                </c:when>

                                <c:otherwise>
                                    <c:if test="${comment.user_id == null && comment.approved == 1}">
                                        Anònim el <strong>${ofn:formatDate(comment.posted_at)}</strong>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </p>

                        <p>
                            <c:choose>

                                <c:when test="${comment.user_id != null || comment.approved == 1}">
                                    ${ofn:renderPost(comment.text)}
                                </c:when>

                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${comment.approved == 0}">
                                            <c:if test="${blog.userSet.id eq user.id}">
                                                ${ofn:renderPost(comment.text)}
                                                <a href="/approveComment/${comment.id}" class="btn btn-primary">Aprovar comentari</a>
                                                <a href="/deleteComment/${comment.id}" class="btn btn-danger">Eliminar comentari</a>
                                            </c:if>
                                        </c:when>

                                        <c:otherwise>

                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </p>

                    </div>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <form action="/postComment" method="post" class="form d-flex flex-column">
                    <input type="hidden" name="postId" value="${post.id}">
                    <div class="form-group">
                        <label>Comentari</label>
                        <textarea class="form-control" name="commentContent"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>
