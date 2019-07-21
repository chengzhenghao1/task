<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/7/14
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>修真类型</td>
        <td>毕业院校</td>
        <td>线上学号</td>
        <td>获取渠道</td>
        <td>创建时间</td>
        <td>更新时间</td>
    </tr>
    <c:forEach items="${cs}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.type}</td>
            <td>${student.gradSchool}</td>
            <td>${student.onlineId}</td>
            <td>${student.channel}</td>
            <td>${student.createAt}</td>
            <td>${student.updateAt}</td>
        </tr>
    </c:forEach>
</table>
<div style="text-align: center">
    <a href="/listStudent">返回</a>
</div>
</body>
</html>
