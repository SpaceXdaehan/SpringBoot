/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.8
 * Generated at: 2023-05-19 03:09:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.post;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/workspaces/lab-web/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/spring2/WEB-INF/lib/jakarta.servlet.jsp.jstl-3.0.1.jar!/META-INF/c-1_2.tld", Long.valueOf(1664421078000L));
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-3.0.1.jar", Long.valueOf(1683187927401L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody;

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>Spring 2</title>\r\n");
      out.write("        <link\r\n");
      out.write("            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\"\r\n");
      out.write("            crossorigin=\"anonymous\">\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("        <header class=\"my-2 p-5 text-center\">\r\n");
      out.write("            <h1>포스트 작성</h1>\r\n");
      out.write("        </header>\r\n");
      out.write("        \r\n");
      out.write("        <nav>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li class=\"nav-item\"s>\r\n");
      out.write("                    ");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("<a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ mainPage }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">메인 페이지</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("<a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ postListPage }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">포스트 목록</a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("        \r\n");
      out.write("    	<main class=\"my-2\">\r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("                <form method=\"post\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <div class=\"my-2\">\r\n");
      out.write("                            <label class=\"form-label\" for=\"title\">제목</label> <!-- laber의 for-title는 id의 title를 찾아감 -->\r\n");
      out.write("                            <input class=\"form-control\" type=\"text\" id=\"title\" name=\"title\" required autofocus/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <label class=\"form-label\" for=\"content\">내용</label>\r\n");
      out.write("                            <textarea class=\"form-control\" id=\"content\" name=\"content\" required></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <label class=\"form-label\" for=\"author\">작성자 아이디</label>\r\n");
      out.write("                            <input class=\"form-control\" type=\"text\" id=\"author\" name=\"author\" required />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"card-footer my-2\">\r\n");
      out.write("                        <label for=\"author\"></label>\r\n");
      out.write("                        <input class=\"form-control btn btn-outline-primary\"\r\n");
      out.write("                         type=\"submit\" value=\"작성 완료\" required />\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </main>	\r\n");
      out.write("		<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("                    integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\"\r\n");
      out.write("                    crossorigin=\"anonymous\">\r\n");
      out.write("        </script>\r\n");
      out.write("    <div/>  \r\n");
      out.write("	</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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

  private boolean _jspx_meth_c_005furl_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/views/post/create.jsp(25,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setVar("mainPage");
      // /WEB-INF/views/post/create.jsp(25,20) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /WEB-INF/views/post/create.jsp(29,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setVar("postListPage");
      // /WEB-INF/views/post/create.jsp(29,20) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/post/list");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }
}
