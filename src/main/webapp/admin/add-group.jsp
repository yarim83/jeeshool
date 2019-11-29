<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Group</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/style.css"/>">
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>Dodaj grupę</h2>
<hr>
<main>
    <form action="/adminPanel/addGroup" method="post" class="container">
        <div class="input-field col s12">
            <input id="groupName" type="text" class="validate" name="groupName" required>
            <label for="groupName">Nazwa grupy</label>
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