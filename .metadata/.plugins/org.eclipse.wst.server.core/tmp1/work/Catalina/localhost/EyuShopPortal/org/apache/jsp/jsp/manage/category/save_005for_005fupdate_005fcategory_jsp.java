/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2018-09-29 12:34:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.manage.category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class save_005for_005fupdate_005fcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\t#category_form .layui-select-title i{\r\n");
      out.write("\t right:120px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"btn_returnToCategory\" class=\"layui-btn layui-btn-sm\" style=\"width:35px;height:35px;border-radius:50%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"layui-icon layui-icon-return\" style=\"\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"font-size:15px;color:#444;\">返回标签列表</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-row\" style=\"margin-top:25px;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-col-md8 layui-col-md-offset2\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<form id=\"category_form\" class=\"layui-form\" action=\"\" style=\"margin-top:25px;\">\r\n");
      out.write("\t\t\t    \t\t\t<div class=\"layui-form-item\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t      <input  type=\"text\" id=\"categoryId\" name=\"categoryId\" >\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" ><i class=\"layui-icon layui-icon-senior\" style=\"font-size: 20px; color: #009688;\"></i></label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       <input  type=\"text\" id=\"categoryName\" name=\"categoryName\" required  lay-verify=\"required\" placeholder=\"标签名字\" autocomplete=\"off\" class=\"layui-input input-radius-20px\">\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" ><i class=\"layui-icon layui-icon-note\" style=\"font-size: 20px; color: #009688;\"></i></label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t      <select id=\"parentId\" name=\"parentId\" style=\"width:200px;\">\r\n");
      out.write("\t\t\t\t\t\t\t      \t<option value=\"1\">东西呢</option>\r\n");
      out.write("\t\t\t\t\t\t\t      </select>\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" ><i class=\"layui-icon layui-icon-log\" style=\"font-size: 20px; color: #009688;\"></i></label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       \t<input type=\"radio\" name=\"categoryStatus\" value=\"1\" title=\"可用\"/>\r\n");
      out.write("      \t\t\t\t\t\t\t\t<input type=\"radio\" name=\"categoryStatus\" value=\"0\" title=\"不可用\"/>\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t    \t\r\n");
      out.write("\t\t\t    \t<div class=\"layui-form-item\" style=\"margin-top:50px;\">\r\n");
      out.write("\t\t\t\t    \t<div class=\"layui-input-block\" style=\"margin:0;text-align: center;\">\r\n");
      out.write("\t\t\t\t\t      <button lay-submit lay-filter=\"category_form\" class=\"layui-btn input-radius-20px\" style=\"width:200px;\">保存</button>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t    </form>\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t</div>\r\n");
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