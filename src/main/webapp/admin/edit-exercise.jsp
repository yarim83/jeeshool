<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Exercises</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/style.css"/>">
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>Edytuj zadanie</h2>
<hr>
<main>
    <form action="/adminPanel/editExercise?id=${exercise.id}" method="post" class="container">
        <div class="input-field col s12">
            <input id="title" type="text" class="validate" name="title" value="${exercise.title}" required>
            <label for="title">Nazwa</label>
        </div>
        <div class="input-field col s12">
            <input id="desc" type="text" class="validate" name="description" value="${exercise.description}" required>
            <label for="desc">Opis</label>
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