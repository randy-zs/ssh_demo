<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <%@ include file="/common/head.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>添加用户</h1>
<form action="" name="userForm">
    姓名：<input type="text" name="userName">
    年龄：<input type="text" name="age">
    <input type="button" value="添加" onclick="addUser()">
</form>
</body>
</html>
<script type="text/javascript">
    function addUser() {
        var form = document.forms[0];
        form.action = "/nanshen/user/addUser";
        form.method = "post";
        form.submit();
    }
</script>