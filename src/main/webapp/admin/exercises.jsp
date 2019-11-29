<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Exercises</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/style.css"/>">
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>Zarządzanie zadaniami</h2>
<hr>
<main>
    <div class="add-button">
        <a href="<c:url value="/adminPanel/addExercise"/>"
           class="btn-floating btn-large waves-effect waves-light red"><i
                class="material-icons">add</i></a>
    </div>
    <table class="striped centered container">
        <thead>
        <tr>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Edytuj</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="exercise" items="${exercises}">
            <tr>
                <td>${exercise.title}</td>
                <td>${exercise.description}</td>
                <td><a href="<c:url value="/adminPanel/editExercise?id=${exercise.id}"/>"><i
                        class="material-icons">edit</i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<hr>
<jsp:include page="../footer.jsp"/>

<script type="text/javascript" src="<c:url value="../js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../js/functions.js"/>"></script>
</body>
</html>