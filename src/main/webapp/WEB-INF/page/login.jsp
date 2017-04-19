<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- <!DOCTYPE html> 这个标签不能删, 不然页面样式就变了 -->
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/taglibs.jsp" %>
    <%@ include file="/common/head.jsp" %>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='<c:url value='/login_file/css/t1.css'/>' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value='/login_file/css/t2.css'/>">
    <link rel="stylesheet" href="<c:url value='/login_file/css/style.css'/>">
</head>

<body>
<div class="form">
    <ul class="tab-group">
        <li class="tab"><a href="#signup">Sign Up</a></li>
        <li class="tab active"><a href="#login">Log In</a></li>
    </ul>
    <div class="tab-content">
        <div id="signup" style="display: none">
            <h1>Sign Up for Free</h1>
            <form action="/" method="post">
                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            First Name<span class="req">*</span>
                        </label>
                        <input type="text" required autocomplete="off"/>
                    </div>

                    <div class="field-wrap">
                        <label>
                            Last Name<span class="req">*</span>
                        </label>
                        <input type="text" required autocomplete="off"/>
                    </div>
                </div>

                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input type="email" required autocomplete="off"/>
                </div>

                <div class="field-wrap">
                    <label>
                        Set A Password<span class="req">*</span>
                    </label>
                    <input type="password" required autocomplete="off"/>
                </div>
                <button type="submit" class="button button-block"/>
                Get Started</button>
            </form>
        </div>
        <div id="login" style="display: block">
            <h1>Welcome Back!</h1>
            <form action="<c:url value="/login/check"/>" method="post">
                <div class="field-wrap">
                    <label>
                        User Address<span class="req">*</span>
                    </label>
                    <input type="text" required autocomplete="off" name="userName" id="userName"/>
                </div>
                <div class="field-wrap">
                    <label>
                        Password<span class="req">*</span>
                    </label>
                    <input type="password" required autocomplete="off" name="password" id="password"/>
                </div>
                <c:if test="${!empty errorMsg}">
                    <h3>${errorMsg}</h3>
                </c:if>
                <p class="forgot"><a href="#">Forgot Password?</a></p>
                <button class="button button-block"/>
                Log In</button>
            </form>
        </div>
    </div>
    <!-- tab-content -->

</div>
<!-- /form -->
<script src="<c:url value='/login_file/js/index.js'/>"></script>
</body>
</html>
