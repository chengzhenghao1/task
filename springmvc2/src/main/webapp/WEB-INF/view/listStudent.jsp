<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
<!-- 导入核心标签库 -->

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>


<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("#formdelete").attr("action", href).submit();
            return false;
        })
    })
</script>
<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>type</td>
            <td>gradSchool</td>
            <td>onlineId</td>
            <td>channel</td>
            <td>createAt</td>
            <td>updateAt</td>
            <td>编辑</td>
            <td>删除</td>
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
                <td><a href="student/${student.id}">编辑</a></td>
                <td><a class="delete" href="/student/${student.id}">删除</a></td>
            </tr>
        </c:forEach>


    </table>
    <!-- 分页功能 -->
    <div style="text-align:center">
        <a href="?start=0">首 页</a>
        <c:if test="${page.start-page.count>=0}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>
        <c:if test="${page.start+page.count<=page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <a href="?start=${page.last}">末 页</a>
        <a href="/increaseStudent">增加</a>
        <%--        <a href="/student/name/">模糊查询</a>--%>
    </div>
    <form action="/student/name/">
        <input type="text" name="name" placeholder="请输入姓名">
        <input type="submit" value="根据姓名查询">
    </form>

</div>
<form id="formdelete" action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>


<json:array name="cs" var="student" items="${cs}">
    <json:object>
        <json:property name="id" value="${student.id}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="type" value="${student.type}"/>
        <json:property name="gradschool" value="${student.gradSchool}"/>
        <json:property name="online_id" value="${student.onlineId}"/>
        <json:property name="channel" value="${student.channel}"/>
        <json:property name="create_at" value="${student.createAt}"/>
        <json:property name="update_at" value="${student.updateAt}"/>
    </json:object>
</json:array>