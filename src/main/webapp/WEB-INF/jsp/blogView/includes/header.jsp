<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="/${blog.slug}">${blog.name}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/${blog.slug}">Inici</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/${blog.slug}/articles">Llistat de posts</a>
                </li>
                <%--<li class="nav-item">
                    <a class="nav-link" href="/${blog.slug}/categoryList">Categories</a>
                </li>--%>
                <c:choose>
                    <c:when test="${user != null}">
                        <li>
                            <a href="/" class="nav-link">Tornar al panell d'administraci√≥</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a href="/sharedBlogs" class="nav-link">Llistat de blogs oberts</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <ul class="navbar-nav form-inline my-2 my-lg-0">
                <c:choose>
                    <c:when test="${user != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Sortir al panell principal</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/doLogout" id="logout">Tancar sessi√≥</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="/">Iniciar sessi√≥</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
</nav>

<div class="modal" tabindex="-1" id="loadingModal">
    <div class="modal-dialog">
        <div class="modal-content align-content-center">
            <div class="spinner-border align-self-center mt-2 mb-2" style="width: 12rem; height: 12rem;" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>
            <p class="text-center">Carregant, espera per-favor</p>
        </div>
    </div>
</div>


<script>
    $('#logout').on('click', function (e) {
        e.preventDefault();
        $('#loadingModal').modal("toggle");

        setTimeout(function () {
            window.location.href = "/doLogout";
        }, 1000);

    })
</script>
