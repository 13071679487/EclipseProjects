/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2018-09-18 06:43:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class save_005for_005fupdate_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String path=request.getContextPath();
	pageContext.setAttribute("path", path);

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>商品信息</title>\r\n");
      out.write("<link rel=\"icon\" href=\"https://getbootstrap.com/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/layui/layui.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/common.js\"></script>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/layui/css/layui.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/common.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/richtext/jquery-3.2.1.js\"></script> \r\n");
      out.write("<!-- include summernote css/js-->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/richtext/summernote-lite.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/richtext/summernote-lite.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/richtext/lang/summernote-zh-CN.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\t#category_form .layui-select-title i{\r\n");
      out.write("\t right:120px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#product_form .layui-form-item label{\r\n");
      out.write("\t\tcolor:rgba(80,80,80,.7);\r\n");
      out.write("\t}\r\n");
      out.write("\t#product_subimages{\r\n");
      out.write("\t\tlist-style:none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#product_subimages li{\r\n");
      out.write("\t\tfloat:left;\r\n");
      out.write("\t\tmargin-left:10px;\r\n");
      out.write("\t\tmargin-top:5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.product-image-item{\r\n");
      out.write("\t\tposition:relative;\r\n");
      out.write("\t\tborder:2px dotted rgba(200,200,200,.8);\r\n");
      out.write("\t\tpadding:2px;\r\n");
      out.write("\t\twidth:90px;\r\n");
      out.write("\t\theight:120px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.product-image{\r\n");
      out.write("\t\twidth:90px;\r\n");
      out.write("\t\theight:120px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.product-image-del{\r\n");
      out.write("\t\tposition:absolute;\r\n");
      out.write("\t\ttop:0;\r\n");
      out.write("\t\tright:0;\r\n");
      out.write("\t\tborder-radius:50%;\r\n");
      out.write("\t\twidth:20px;\r\n");
      out.write("\t\theight:20px;\r\n");
      out.write("\t\tbackground-color:rgba(200,200,200,.8);\r\n");
      out.write("\t\tcolor:#f00;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\t.product-image-del i{\r\n");
      out.write("\t\tfont-size:18px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.product-image-add{\r\n");
      out.write("\t\tposition:absolute;\r\n");
      out.write("\t\ttop:40%;\r\n");
      out.write("\t\tleft:36%;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tcolor:#009688;\r\n");
      out.write("\t}\r\n");
      out.write("\t.product-image-add i{\r\n");
      out.write("\t\tfont-size:30px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class='layui-container'>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-row\" style=\"margin-top:15px;margin-left:20px;\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\" layui-col-md4\">\r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"btn_return\" class=\"layui-btn layui-btn-sm\" style=\"width:35px;height:35px;border-radius:50%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"layui-icon layui-icon-return\" style=\"\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"font-size:15px;color:#444;\">返回上一层</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\" layui-col-md2 layui-col-md-offset6\">\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"layui-btn\">预览</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-row\" style=\"margin-top:25px;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-col-md12\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<form id=\"product_form\" class=\"layui-form\" style=\"margin-top:25px;\">\r\n");
      out.write("\t\t\t    \t\t\t<div class=\"layui-form-item\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t      <input  type=\"text\" id=\"productId\" name=\"productId\" >\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" >商品名字：</label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       <input  type=\"text\" id=\"productName\" name=\"productName\" required  lay-verify=\"required\" placeholder=\"请输入商品名字\" autocomplete=\"off\" class=\"layui-input input-radius-20px\">\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" >子标题：</label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       <input  type=\"text\" id=\"subtitle\" name=\"subtitle\" required  lay-verify=\"required\" placeholder=\"请输入商品子标题\" autocomplete=\"off\" class=\"layui-input input-radius-20px\">\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" >商品单价：</label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       <input  type=\"text\" id=\"price\" name=\"price\" required  lay-verify=\"required\" placeholder=\"请输入商品单价(单位元)\" autocomplete=\"off\" class=\"layui-input input-radius-20px\"  style=\"width:128px;\">\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" >商品库存：</label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       <input  type=\"text\" id=\"stock\"  name=\"stock\" required  lay-verify=\"required\" placeholder=\"请输入商品库存\" autocomplete=\"off\" class=\"layui-input input-radius-20px\" style=\"width:128px;\">\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" >商品分类：</label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       <select id=\"categoryId\" name=\"categoryId\">\r\n");
      out.write("\t\t\t\t\t\t\t       \t\t\r\n");
      out.write("\t\t\t\t\t\t\t       </select>\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" >商品状态：</label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t       <input type=\"radio\" name=\"productStatus\" value=\"1\" title=\"在售\" checked>\r\n");
      out.write("      \t\t\t\t\t\t\t\t<input type=\"radio\" name=\"productStatus\" value=\"0\" title=\"下架\" >\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    \t<label class=\"layui-form-label\" >商品图片：</label>\r\n");
      out.write("\t\t\t\t\t    \t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t    \t\t\t<ul id=\"product_subimages\">\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t<li id=\"product-add\">\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t\t<div class=\"product-image-item\">\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t\t\t<a class=\"product-image-add\">\r\n");
      out.write("\t\t\t\t\t\t    \t\t\t\t\t\t<i class=\"layui-icon layui-icon-add-circle\"></i>\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t    \t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t       <input id=\"product_image_file\" accept=\"image/gif, image/jpeg, image/png\"  type=\"file\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t    \t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t     <input  type=\"text\" id=\"subimages\" name=\"subimages\" >\r\n");
      out.write("\t\t\t\t\t\t\t     <input  type=\"text\" id=\"productDetail\" name=\"detail\"  style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t    \t\t<div id=\"summernote\" class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \t</div>\r\n");
      out.write("\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t    \t<div class=\"layui-form-item\" style=\"margin-top:50px;\">\r\n");
      out.write("\t\t\t\t    \t<div class=\"layui-input-block\" style=\"margin:0;text-align: center;\">\r\n");
      out.write("\t\t\t\t\t      <button id=\"btn_submitProduct\" lay-submit lay-filter=\"product_form\" class=\"layui-btn input-radius-20px\" style=\"width:200px;\">保存</button>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t    </form>\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\" src=\"/EyuShopPortal/js/manage/save_or_update_product.js\"></script>\r\n");
      out.write("</body>\t\t\t\r\n");
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