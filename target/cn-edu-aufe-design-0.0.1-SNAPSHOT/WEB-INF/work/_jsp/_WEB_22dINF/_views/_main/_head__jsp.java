/*
 * JSP generated by Resin Professional 4.0.39 (built Tue, 01 Apr 2014 09:46:53 PDT)
 */

package _jsp._WEB_22dINF._views._main;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _head__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  private boolean _caucho_isNotModified;
  private com.caucho.jsp.PageManager _jsp_pageManager;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, session, _jsp_state);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_pageManager.freePageContext(pageContext);
    }
  }
  
  private void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response,
              com.caucho.jsp.PageContextImpl pageContext,
              javax.servlet.ServletContext application,
              javax.servlet.http.HttpSession session,
              TagState _jsp_state)
    throws Throwable
  {
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.jsp.tagext.JspTag _jsp_parent_tag = null;
    com.caucho.jsp.PageContextImpl _jsp_parentContext = pageContext;
    response.setContentType("text/html;charset=UTF-8");

    out.write('\n');
    String ctx = request.getContextPath();
    out.write(_jsp_string0, 0, _jsp_string0.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string1, 0, _jsp_string1.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string2, 0, _jsp_string2.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string3, 0, _jsp_string3.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string4, 0, _jsp_string4.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string5, 0, _jsp_string5.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string6, 0, _jsp_string6.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string7, 0, _jsp_string7.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string8, 0, _jsp_string8.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string9, 0, _jsp_string9.length);
  }

  private com.caucho.make.DependencyContainer _caucho_depends
    = new com.caucho.make.DependencyContainer();

  public java.util.ArrayList<com.caucho.vfs.Dependency> _caucho_getDependList()
  {
    return _caucho_depends.getDependencies();
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    _caucho_depends.add(depend);
  }

  protected void _caucho_setNeverModified(boolean isNotModified)
  {
    _caucho_isNotModified = true;
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;

    if (_caucho_isNotModified)
      return false;

    if (com.caucho.server.util.CauchoSystem.getVersionId() != 6205146603351083403L)
      return true;

    return _caucho_depends.isModified();
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
    TagState tagState;
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/views/main/head.jsp"), -2841304452781943403L, false);
    _caucho_depends.add(depend);
  }

  final static class TagState {

    void release()
    {
    }
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void caucho_init(ServletConfig config)
  {
    try {
      com.caucho.server.webapp.WebApp webApp
        = (com.caucho.server.webapp.WebApp) config.getServletContext();
      init(config);
      if (com.caucho.jsp.JspManager.getCheckInterval() >= 0)
        _caucho_depends.setCheckInterval(com.caucho.jsp.JspManager.getCheckInterval());
      _jsp_pageManager = webApp.getJspApplicationContext().getPageManager();
      com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
      com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.InitPageContextImpl(webApp, this);
      _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${ctx}");
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;

  private final static char []_jsp_string8;
  private final static char []_jsp_string6;
  private final static char []_jsp_string1;
  private final static char []_jsp_string2;
  private final static char []_jsp_string7;
  private final static char []_jsp_string3;
  private final static char []_jsp_string0;
  private final static char []_jsp_string5;
  private final static char []_jsp_string9;
  private final static char []_jsp_string4;
  static {
    _jsp_string8 = "/img/favicon.png\" type=\"image/x-icon\">\n  <link rel=\"icon\" href=\"".toCharArray();
    _jsp_string6 = "/css/mystyle.css\">\n  <!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->\n  <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"".toCharArray();
    _jsp_string1 = "/css/bootstrap.min.css\">\n  <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"".toCharArray();
    _jsp_string2 = "/css/font-awesome.min.css\">\n  <!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->\n  <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"".toCharArray();
    _jsp_string7 = "/css/demo.min.css\">\n\n  <!-- FAVICONS -->\n  <link rel=\"shortcut icon\" href=\"".toCharArray();
    _jsp_string3 = "/css/smartadmin-production.min.css\">\n  <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"".toCharArray();
    _jsp_string0 = "\n<head>\n  <meta charset=\"utf-8\">\n  <title> \u6bd5\u4e1a\u8bba\u6587\u9009\u9898\u7cfb\u7edf </title>\n  <meta name=\"description\" content=\"\">\n  <meta name=\"author\" content=\"\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n  <!-- #CSS Links -->\n  <!-- Basic Styles -->\n  <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"".toCharArray();
    _jsp_string5 = "/css/smartadmin-rtl.min.css\">\n  <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"".toCharArray();
    _jsp_string9 = "/img/favicon.png\" type=\"image/x-icon\">\n</head>".toCharArray();
    _jsp_string4 = "/css/smartadmin-skins.min.css\">\n  <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"".toCharArray();
  }
}