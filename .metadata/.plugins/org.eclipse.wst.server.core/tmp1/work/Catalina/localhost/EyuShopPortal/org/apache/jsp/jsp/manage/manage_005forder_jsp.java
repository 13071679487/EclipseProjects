/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2018-09-25 06:37:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manage_005forder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jsp/common/base.jsp", Long.valueOf(1536556877308L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");

	String path=request.getContextPath();
	pageContext.setAttribute("path", path);
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	pageContext.setAttribute("basepath", basePath);

      out.write("\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("<link rel=\"icon\" href=\"https://getbootstrap.com/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<!-- 引入js文件 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/layui/layui.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/common.js\"></script>\r\n");
      out.write("<!-- 引入样式 -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/layui/css/layui.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/common.css\" rel=\"stylesheet\">\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#category_table tbody ul li{\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("\tmargin-left:2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\t\t\t<div class=\"layui-row\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-col-md2\" style=\"border-left:3px solid #009688;padding:10px;\">\r\n");
      out.write("\t\t\t\t\t<h4 style=\"color:rgba(80,80, 80, .7);\">订单管理</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"layui-row \" style=\"margin-top:25px;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-col-md3\" style=\"height:36px;background-color:#fff;border-radius:36px;border:1px solid #009688;\">\r\n");
      out.write("\t\t\t\t\t\t <i class=\"layui-icon layui-icon-search\" style=\"font-size:18px;color:#009688;\"></i> \r\n");
      out.write("\t\t\t\t\t\t<input id=\"orderNo\"  type=\"text\" placeholder=\"请输入订单号\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"layui-input\" style=\"height:100%;border: none;display:inline;\" />\r\n");
      out.write("\t\t\t\t\t\t<button id=\"btn_searchOrder\" class=\"layui-btn  layui-btn-xs\" style=\"height:100%;float:right;border:2px solid #fff;border-radius:0 36px 36px 0;display:inline;position:relative;\">搜索</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"layui-row\" style=\"margin-top:5px;\">\r\n");
      out.write("\t\t\t\t<table id=\"category_table\" lay-filter=\"category_table\" style=\"width:96%;\" class='layui-table'>\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t      <th lay-data=\"{field:'categoryId', width:80, sort: true}\">订单编号</th>\r\n");
      out.write("\t\t\t\t\t\t      <th lay-data=\"{field:'categoryName', width:80}\">收件人</th>\r\n");
      out.write("\t\t\t\t\t\t      <th lay-data=\"{field:'categoryName', width:80}\">联系电话</th>\r\n");
      out.write("\t\t\t\t\t\t      <th lay-data=\"{field:'parentId', width:80, sort: true}\">订单金额</th>\r\n");
      out.write("\t\t\t\t\t\t      <th lay-data=\"{field:'categoryStatus'}\" style='width:98px; '>\r\n");
      out.write("\t\t\t\t\t\t      \t<select id='orderStatus_select'>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <option value =\"-1\">全部订单</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <option value =\"10\">未支付</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"20\">已付款</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"40\">已发货</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"0\">已取消</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"60\">已关闭</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t      </th>\r\n");
      out.write("\t\t\t\t\t\t      <th lay-data=\"{field:'createTime'，sort: true}\">创建时间</th>\r\n");
      out.write("\t\t\t\t\t\t      <th lay-data=\"{field:'op'}\">操作</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"layui-row\" style=\"margin-top:50px;\">\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/widget/page_nav.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\tvar currentPage;\r\n");
      out.write("\t\t\t$(function(){\r\n");
      out.write("\t\t\t\tmanage_orderCallback();\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t\t/**\r\n");
      out.write("\t\t\t * 初始化函数\r\n");
      out.write("\t\t\t */\r\n");
      out.write("\t\t\tfunction manage_orderCallback(){\r\n");
      out.write("\t\t\t\tgetOrderList(1,10,null,null);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}