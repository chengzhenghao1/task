<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/7/14
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="post" action="/increaseStudent">
            姓名： <input name="name" value="${student.name}" type="text"> <br><br>
            修真类型：<input name="type" value="${student.type}" type="text"> <br><br>
            毕业院校：<input name="gradSchool" value="${student.gradSchool}" type="text"> <br><br>
            线上学号：<input name="onlineId" value="${student.onlineId}" type="text"> <br><br>
            师兄：<input name="channel" value="${student.channel}" type="text"> <br><br>
            创建时间：<input name="createAt" value="${student.createAt}" type="text"> <br><br>
            更新时间：<input name="updateAt" value="${student.updateAt}" type="text"> <br><br>
            <input type="submit" value="增加学员">
        </form>

    </div>
</div>