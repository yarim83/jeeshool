<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Groups</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css"/>">
</head>
<body>
<jsp:include page="header.jsp"/>

<h2>Lista grup</h2>
<hr>
<main>
    <table class="striped centered container">
        <thead>
        <tr>
            <th>Nazwa grupy</th>
            <th>Użytkownicy</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td>${group.name}</td>
                <td><a href="<c:url value="/usersOfGroup?groupId=${group.id}"/>"><i
                        class="material-icons">visibility</i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<hr>
<jsp:include page="footer.jsp"/>

<script type="text/javascript" src="<c:url value="js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/functions.js"/>"></script>
</body>
</html>