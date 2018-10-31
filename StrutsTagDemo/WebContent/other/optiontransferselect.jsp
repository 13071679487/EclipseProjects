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
<s:optiontransferselect label="选择你喜欢图书"  
              name="cnbook" leftTitle="中文图书"  list="{'struts2权威指南','轻量级javaeye 企业应用空实战','ajax讲义'}"
              doubleName="enBook"  rightTitle="外文图书" doubleList="{'JavaScrip:The definitive Guide','export one-to-one'}"  multiple="true" 
              addToLeftLabel="向左移动" addToRightLabel="向右移动" addAllToRightLabel="全部右移" addAllToLeftLabel="全部左移"
               allowSelectAll="true" headerKey="cnKey" headerValue="选择图书" emptyOption="true"   doubleHeaderKey="enKey" 
               doubleHeaderValue="选择外文图书" doubleMultiple="true" doubleEmptyOption="true"  leftDownLabel="向下移动" 
       rightDownLabel="向下移动" 
       leftUpLabel="向上移动" 
       rightUpLabel="向上移动" >
   </s:optiontransferselect>
</body>
</html>