<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/7/10
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户列名</title>
</head>
<body>
    <h3>查询到的数据</h3>
    <c:forEach items="${accounts}" var="account">
        ${account.id}
        ${account.name}
        ${account.balance} <br/>
    </c:forEach>
</body>
</html>
