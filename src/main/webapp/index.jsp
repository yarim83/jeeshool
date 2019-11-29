<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Main Page</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <!--
    <link type="text/css" rel="stylesheet" href="<c:url value="css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css"/>">
    -->
</head>
<body>
<%@include file="header.jsp" %>
<h2>Strona główna</h2>
<hr>
<main>
    <table class="striped centered container">
        <thead>
        <tr>
            <th>Tytuł zadania</th>
            <th>Autor rozwiązania</th>
            <th>Data rozwiązania</th>
            <th>Więcej</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="solution" items="${recent}">
            <tr>
                <td>${solution[0].title}</td>
                <td>${solution[1].userName}</td>
                <td>${solution[2].created}</td>
                <td><a href="<c:url value="/solution?id=${solution[2].id}"/>"><i
                        class="material-icons">visibility</i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<hr>
<%@include file="footer.jsp" %>
<!--
<script type="text/javascript" src="<c:url value="js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/functions.js"/>"></script>
-->
</body>
</html>