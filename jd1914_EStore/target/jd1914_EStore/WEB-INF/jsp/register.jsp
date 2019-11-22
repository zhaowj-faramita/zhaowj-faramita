<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.sql.Connection,
    java.sql.Statement,
    java.sql.ResultSet,
    javax.servlet.http.HttpSession"%>
<%
	StringBuilder builder = new StringBuilder();
	builder.append(request.getScheme()).append("://")
		   .append(request.getServerName()).append(":")
		   .append(request.getServerPort())
		   .append(request.getContextPath()).append("/");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=builder.toString()%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-注册页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="container2">
    	<div class="header2">
        	<div>
            	<a href="index"><img class="logo" src="images/logon_register.png"></a>
            </div>
            <div>
            	<ul class="tabs">
                	<li class="phone current"><a href="#">用户注册，请将信息填写完整</a></li>
                </ul>
            </div>
            <div class="tlg">
            	已有账号 <a href="login">登陆</a>
            </div>
        </div>
        <div class="content2">
			<form action="RegisterFrom" method="post">
            <ul class="reg_box">
                <li>
                    <span><b>*</b>用户名：</span>
                    <input type="text" name="name"/>
                 <%
                    if(request.getAttribute("message_register_name")!=null) {
                 %>
                    <span><b>*${requestScope.message_register_name}</b></span>
                 <%
                    request.removeAttribute("message_register_name");
                    }
                 %>
                </li> 
               <li>
                    <span><b>*</b>密码：</span>
                    <input type="password" name="password"/>
                 <%
                    if(request.getAttribute("message_register_password")!=null) {
                 %>
                    <span><b>*${requestScope.message_register_password}</b></span>
                 <%
                    request.removeAttribute("message_register_password");
                    }
                 %>
                </li>
                <li>
                    <span><b>*</b>邮编：</span>
                    <input type="text" name="zipCode"/>
                 <%
                    if(request.getAttribute("message_register_zipCode")!=null) {
                 %>
                    <span><b>*${requestScope.message_register_zipCode}</b></span>
                 <%
                    request.removeAttribute("message_register_zipCode");
                    }
                 %>
                </li>
                <li>
                    <span><b>*</b>电话：</span>
                    <input type="text" name="telephone"/>
                 <%
                    if(request.getAttribute("message_register_telephone")!=null) {
                 %>
                    <span><b>*${requestScope.message_register_telephone}</b></span>
                 <%
                    request.removeAttribute("message_register_telephone");
                    }
                 %>
                </li>
                <li>
                    <span><b>*</b>电子邮箱：</span>
                    <input type="text" name="email"/>
                 <%
                    if(request.getAttribute("message_register_email")!=null) {
                 %>
                    <span><b>*${requestScope.message_register_email}</b></span>
                 <%
                    request.removeAttribute("message_register_email");
                    }
                 %>
                </li>
            </ul>
            <p>
                <input type="checkbox" checked/>
                 我已阅读并同意
                <a href="#">用户注册协议</a>
            </p>
            <input class="btn_submit" type="submit" value="立即注册"/>
           </form>
        </div>
   	</div>
</body>
</html>
