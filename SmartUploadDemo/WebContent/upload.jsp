<%@ page language="java" import="java.util.*,com.jspsmart.upload.*,java.io.*" 
pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�ϴ�����</title>
</head>
<body>
<% 
request.setCharacterEncoding("GBK"); 
long size = 5 * 1024 * 1024;//�����ϴ����ֵΪ5MB 
String fileType = "jpg,gif,JPG";//�����ϴ��ļ����� 
String imgName = null;//ͼƬ���� 
byte[] data = null;//���� 
String filePath = "";//�ļ�·�� 

//�õ�������Ŀ¼webroot�µ�ImageFilesĿ¼������·�� 
String path = super.getServletContext().getRealPath("/Image"); 

System.out.println(path);

SmartUpload su = new SmartUpload(); 
//��ʼ�� 
su.initialize(pageContext); 
su.setMaxFileSize(size); 
su.setAllowedFilesList(fileType); 
//�����ļ� 
su.upload(); 
System.out.println(su.getSize());
su.getRequest();
//ѭ��ȡ���������ص��ļ� 
Files files = su.getFiles(); 
if (files != null) { 
//����ļ�·��������������·�� 
java.io.File fileDir = new java.io.File(path); 
System.out.println("����");
if (!fileDir.exists()) { 
fileDir.mkdirs(); 
System.out.println("������");
} 

System.out.println(files.getCount());
//ȡ���ļ� 
for (int i = 0; i < files.getCount(); i++)
 { 
 com.jspsmart.upload.File file = files.getFile(i);
 if (file.isMissing()) continue; 
 if ("selPicture".equals(file.getFieldName())) { 
 String type = file.getFilePathName(); 
 type = type.substring(type.lastIndexOf(".")); 
 imgName = UUID.randomUUID().toString();//����uuid��ΪͼƬ������ 
 imgName += type; 
 filePath = path + "/" + imgName; 

 //���浽ָ���ļ� 
 file.saveAs(filePath); 

 //��ȡ�ļ� 
 data = readFile(filePath); 
 break; 
 } 
} 
} 

if (data == null) { 
out.print("û��ͼƬ"); 
} else { 
out.print("ͼƬ�ϴ��ɹ�"); 
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