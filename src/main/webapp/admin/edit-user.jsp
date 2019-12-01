<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit User</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/style.css"/>">
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>Edytuj użytkownika</h2>
<hr>
<main>
    <form action="/adminPanel/editUser" method="post" class="container">
        <div class="input-field col s12">
            <input id="name" type="text" class="validate" name="username" value="${user.userName}" required>
            <label for="name">Imię i nazwisko:</label>
        </div>
        <div class="input-field col s12">
            <input id="email" type="email" class="validate" name="email" value="${user.email}" required>
            <label for="email">Email:</label>
            <span class="helper-text" data-error="wrong" data-success="right"></span>
        </div>
        <div class="input-field col s12">
            <select name="groupId">
                <c:forEach var="group" items="${groups}">
                    <option selected value="${group.id}">${group.name}</option>
                </c:forEach>
            </select>
            <label>Grupa</label>
        </div>
        <input type="hidden" name="id" value="${user.id}">
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