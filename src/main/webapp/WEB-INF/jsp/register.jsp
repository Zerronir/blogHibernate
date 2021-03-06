<%--
  Created by IntelliJ IDEA.
  User: RaulM
  Date: 07/05/2021
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" th:href="@{/css/styles.css}">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<main class="container">
    <div class="d-flex flex-column justify-content-center mt-5 mb-5">
        <h1 class="display-1 text-center text-uppercase">Registra't</h1>
    </div>

    <div class="d-flex flex-column">
        <form id="registerForm" action="/doRegister" method="post" >
            <div class="mb-3">
                <label for="name" class="form-label">Nom</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="mb-3">
                <label for="lastname" class="form-label">Llinatges</label>
                <input type="text" class="form-control" id="lastname" name="lastname">
            </div>
            <div class="mb-3">
                <label for="nickname" class="form-label">Nickname</label>
                <input type="text" class="form-control" id="nickname" name="nickname">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Adreça electrònica</label>
                <input type="email" onkeyup="checkIsValidEmail(this)" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text text-danger d-none">Per favor, introdueix un email vàlid, exemple: jhon@doe.com</div>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Contrasenya</label>
                <input type="password" onkeyup="checkSecondPassEquals(this.value)" class="form-control" id="password" name="password">
                <div id="passwordHelp" class="form-text text-danger d-none">Les dues contrasenyes han de coincidir</div>
            </div>
            <div class="mb-3">
                <label for="password1" class="form-label">Repeteix la contrasenya</label>
                <input type="password" onkeyup="checkPassEquals(this.value)" class="form-control" id="password1" name="password1">
                <div id="passwordHelp1" class="form-text text-danger d-none">Les dues contrasenyes han de coincidir</div>
            </div>
            <button type="submit" id="submitBtn" onclick="submitForm()" class="btn btn-primary">Registra't</button>
            <a href="/sharedBlogs" class="btn btn-secondary">Entrar com a convidat</a>
            <a href="/" class="btn btn-danger">Tornar enrera</a>
        </form>
    </div>
</main>

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
    const checkIsValidEmail = (txt) => {
        let email = txt.value;
        const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if(re.test(String(email).toLowerCase())) {
            document.getElementById('email').classList.remove("is-invalid");
            document.getElementById('emailHelp').classList.add("d-none");
            $('#submitBtn').attr("disabled", false);
        } else {
            document.getElementById('email').classList.add("is-invalid");
            document.getElementById('emailHelp').classList.remove("d-none");
            $('#submitBtn').attr("disabled", true);
        }

        if(email === null || email === '' || email === undefined) {
            document.getElementById('email').classList.remove("is-invalid");
            document.getElementById('emailHelp').classList.add("d-none");
            $('#submitBtn').attr("disabled", false);
        }

    }

    const checkPassEquals = (txt) => {
        let otherPass = $('#password').val();

        if(txt === otherPass) {
            $('#password').removeClass('is-invalid');
            $('#password1').removeClass('is-invalid');
            $('#passwordHelp').addClass('d-none');
            $('#passwordHelp1').addClass('d-none');
            $('#submitBtn').attr("disabled", false);
        } else {
            $('#password').addClass('is-invalid');
            $('#password1').addClass('is-invalid');
            $('#passwordHelp').removeClass('d-none');
            $('#passwordHelp1').removeClass('d-none');
            $('#submitBtn').attr("disabled", true);
        }

    }

    const checkSecondPassEquals = (txt) => {
        let otherPass = $('#password1').val();

        if(txt === otherPass) {
            $('#password').removeClass('is-invalid');
            $('#password1').removeClass('is-invalid');
            $('#passwordHelp').addClass('d-none');
            $('#passwordHelp1').addClass('d-none');
            $('#submitBtn').attr("disabled", false);
        } else {
            $('#password').addClass('is-invalid');
            $('#password1').addClass('is-invalid');
            $('#passwordHelp').removeClass('d-none');
            $('#passwordHelp1').removeClass('d-none');
            $('#submitBtn').attr("disabled", true);
        }

    }

    document.getElementById('loginForm').addEventListener('submit', function (e) {
        e.preventDefault();



    });

    $(document).on('#loginForm', 'submit', function (e) {
        e.preventDefault();
        submitForm();
    });

    const submitForm = () => {

        $('#loadingModal').modal("toggle");

        setTimeout(function () {
            $('#registerForm').trigger('submit');
        }, 1000);
    }

</script>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
