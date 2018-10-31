<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:updownselect 
    list="#{0:'游泳', 1:'唱歌', 2:'跳舞'}"
    name="hobby" 
    headerKey="-1"
    headerValue="请选择" 
    emptyOption="true"
    allowMoveUp="true" 
    allowMoveDown="true" 
    allowSelectAll="true"
    moveUpLabel="向上" 
    moveDownLabel="向下"
    selectAllLabel="全选" /> 
</body>
</html>