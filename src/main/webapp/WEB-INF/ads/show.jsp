<%--
  Created by IntelliJ IDEA.
  User: mel
  Date: 2/2/17
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="This is your new ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<h1>${ad.title}</h1>
<p>${ad.description}</p>
</body>
</html>
