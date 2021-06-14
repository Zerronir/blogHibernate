<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <c:choose>
        <c:when test="${user != null}">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                <span class="fs-4">Panell d'administració</span>
            </a>

            <div class="collapse navbar-collapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a href="/" class="nav-link active" aria-current="page">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
                            Inici
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/blogList" class="nav-link" aria-current="page">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
                            Llistat de blogs
                        </a>
                    </li>
                    <li>
                        <a href="/sharedBlogs" class="nav-link text-white">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
                            Blogs compartits amb jo
                        </a>
                    </li>
                </ul>
                <hr>
                <div class="dropdown">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <strong>Perfil</strong>
                    </a>
                    <a href="/doLogout" id="logout" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle">
                        <strong>Tancar sessió</strong>
                    </a>
                </div>
            </div>
        </c:when>

        <c:otherwise>
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                <span class="fs-4">Panell d'invitats</span>
            </a>

            <div class="collapse navbar-collapse">
                <ul class="navbar-nav mr-auto">
                    <li>
                        <a href="/sharedBlogs" class="nav-link text-white">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
                            Blogs oberts
                        </a>
                    </li>
                </ul>
                <hr>
                <div class="dropdown">
                    <a href="/" id="logout" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle">
                        <strong>Sortir</strong>
                    </a>
                </div>
            </div>

        </c:otherwise>

    </c:choose>
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
