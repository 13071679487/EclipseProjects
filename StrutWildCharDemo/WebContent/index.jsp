<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用通配符</title>
</head>
<body>
<a href="student_list" target="_blank">查询学生列表</a>
<a href="student_add"target="_blank">添加学生</a>
<a href="student_update"target="_blank">修改学生</a>
<a href="student_delete"target="_blank">删除学生</a>
</br></br>
<a href="grade_list"target="_blank">查询班级列表</a>
<a href="grade_add"target="_blank">添加班级</a>
<a href="grade_update"target="_blank">修改班级</a>
<a href="grade_delete"target="_blank">删除班级</a>

<h1>动态方法调用</h1>
<a href="student!list" target="_blank">学生信息查询</a>&nbsp;
<a href="student!add" target="_blank">学生信息添加</a>&nbsp;
<a href="student!update" target="_blank">学生信息修改</a>&nbsp;
<a href="student!delete" target="_blank">学生信息删除</a>&nbsp;
<br/><br/>
<a href="grade!list" target="_blank">班级信息查询</a>&nbsp;
<a href="grade!add" target="_blank">班级信息添加</a>&nbsp;
<a href="grade!update" target="_blank">班级信息修改</a>&nbsp;
<a href="grade!delete" target="_blank">班级信息删除</a>&nbsp;<br/>
</body>
</html>