<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users of Group</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css"/>">
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Lista użytkowników grupy: ${groupName}</h2>
<hr>
<main>
    <table class="striped centered container">
        <thead>
        <tr>
            <th>Nazwa użytkownika</th>
            <th>Więcej</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userName}</td>
                <td><a href="<c:url value="/user?id=${user.id}"/>"><i class="material-icons">visibility</i></a></td>
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