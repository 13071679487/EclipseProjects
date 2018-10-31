<%@ page language="java" import="java.util.*,com.jspsmart.upload.*,java.io.*" 
pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>上传详情</title>
</head>
<body>
<% 
request.setCharacterEncoding("GBK"); 
long size = 5 * 1024 * 1024;//允许上传最大值为5MB 
String fileType = "jpg,gif,JPG";//允许上传文件类型 
String imgName = null;//图片名称 
byte[] data = null;//数据 
String filePath = "";//文件路径 

//得到服务器目录webroot下的ImageFiles目录的完整路径 
String path = super.getServletContext().getRealPath("/Image"); 

System.out.println(path);

SmartUpload su = new SmartUpload(); 
//初始化 
su.initialize(pageContext); 
su.setMaxFileSize(size); 
su.setAllowedFilesList(fileType); 
//上载文件 
su.upload(); 
System.out.println(su.getSize());
su.getRequest();
//循环取得所有上载的文件 
Files files = su.getFiles(); 
if (files != null) { 
//如果文件路径不存在则生成路径 
java.io.File fileDir = new java.io.File(path); 
System.out.println("存在");
if (!fileDir.exists()) { 
fileDir.mkdirs(); 
System.out.println("不存在");
} 

System.out.println(files.getCount());
//取出文件 
for (int i = 0; i < files.getCount(); i++)
 { 
 com.jspsmart.upload.File file = files.getFile(i);
 if (file.isMissing()) continue; 
 if ("selPicture".equals(file.getFieldName())) { 
 String type = file.getFilePathName(); 
 type = type.substring(type.lastIndexOf(".")); 
 imgName = UUID.randomUUID().toString();//生成uuid作为图片的名称 
 imgName += type; 
 filePath = path + "/" + imgName; 

 //保存到指定文件 
 file.saveAs(filePath); 

 //读取文件 
 data = readFile(filePath); 
 break; 
 } 
} 
} 

if (data == null) { 
out.print("没有图片"); 
} else { 
out.print("图片上传成功"); 
} 
%> 
<%!byte[] readFile(String filePath) { 
ByteArrayOutputStream bos = null; 
try { 
FileInputStream fs = new FileInputStream(filePath); 
bos = new ByteArrayOutputStream(5 * 1024 * 1024); 
byte[] b = new byte[1024]; 
int len; 
while ((len = fs.read(b)) != -1) { 
bos.write(b, 0, len); 
} 
fs.close(); 
} catch (FileNotFoundException e) { 
e.printStackTrace(); 
} catch (IOException e) { 
e.printStackTrace(); 
} 
if (bos == null) { 
return null; 
} else { 
return bos.toByteArray(); 
} 
} 
%> 
<%=request.getParameter("name") %>
</body>
</html>