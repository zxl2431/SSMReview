<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/7/8
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3>查询所有的数据</h3>
<c:forEach items="${ users }" var="user">
    ${ user.username }
    ${ user.password }
    <br/>
</c:forEach>
</body>
</html>