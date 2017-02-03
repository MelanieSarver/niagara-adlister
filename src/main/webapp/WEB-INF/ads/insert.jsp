<%--
  Created by IntelliJ IDEA.
  User: mel
  Date: 2/2/17
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create New Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create A New Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label>Title</label>
                <input type="text" name="title">
            </div>
            <div class="form-group">
                <label>Description</label>
                <input type="text" name="description">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Submit">
        </form>
    </div>
</body>
</html>
