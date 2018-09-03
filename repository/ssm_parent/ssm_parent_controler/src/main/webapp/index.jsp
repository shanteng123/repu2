<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29 0029
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/test/findAll.do">查询所有</a><br>

<jsp:forward page="/pages/main.jsp"></jsp:forward>
<%--<a href="${pageContext.request.contextPath}/test/save.do">添加线路</a>--%>
</body>
</html>
