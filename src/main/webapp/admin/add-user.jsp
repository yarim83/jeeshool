<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add User</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/style.css"/>">
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>Dodaj użytkownika</h2>
<hr>
<main>
    <c:if test="${invalidPass}">
        <h4 style="color: red">Wprowadzone hasła są różne</h4>
    </c:if>
    <form action="/adminPanel/addUser" method="post" class="container">
        <div class="input-field col s12">
            <input id="name" type="text" class="validate" name="username" required>
            <label for="name">Imię i nazwisko:</label>
        </div>
        <div class="input-field col s12">
            <input id="email" type="email" class="validate" name="email" required>
            <label for="email">Email:</label>
            <span class="helper-text" data-error="wrong" data-success="right"></span>
        </div>
        <div class="input-field col s12">
            <input id="pass" type="password" class="validate" name="pass" required>
            <label for="pass">Hasło:</label>
        </div>
        <div class="input-field col s12">
            <input id="pass2" type="password" class="validate" name="pass2" required>
            <label for="pass2">Powtórz hasło:</label>
        </div>
        <div class="input-field col s12">
            <select name="groupId">
                <c:forEach var="group" items="${groups}">
                    <option value="${group.id}">${group.name}</option>
                </c:forEach>
            </select>
            <label>Grupa</label>
        </div>
        <button class="btn waves-effect waves-light" type="submit">
            Zapisz <i class="material-icons right">send</i>
        </button>
    </form>
</main>
<hr>
<jsp:include page="../footer.jsp"/>

<script type="text/javascript" src="<c:url value="../js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../js/functions.js"/>"></script>
</body>
</html>