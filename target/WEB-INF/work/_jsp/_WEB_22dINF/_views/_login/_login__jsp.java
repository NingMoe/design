/*
 * JSP generated by Resin Professional 4.0.36 (built Fri, 26 Apr 2013 03:33:09 PDT)
 */

package _jsp._WEB_22dINF._views._login;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _login__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, null, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, _jsp_state);
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

    out.write(_jsp_string0, 0, _jsp_string0.length);
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

    if (com.caucho.server.util.CauchoSystem.getVersionId() != -7791540776389363938L)
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/views/login/login.jsp"), 8022898678526892883L, false);
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
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "\n<html lang=\"en-us\" id=\"extr-page\">\n\n<head>\n    <meta charset=\"utf-8\">\n    <title>\u767b\u5f55\u8bba\u6587\u9009\u9898\u7cfb\u7edf</title>\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n\n    <!-- #CSS Links -->\n    <!-- Basic Styles -->\n    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/bootstrap.min.css\">\n    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/font-awesome.min.css\">\n    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/mystyle.css\">\n\n    <!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->\n    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/smartadmin-production.min.css\">\n    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/smartadmin-skins.min.css\">\n\n    <!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->\n    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/demo.min.css\">\n\n    <!-- #FAVICONS -->\n    <link rel=\"shortcut icon\" href=\"img/favicon.png\" type=\"image/x-icon\">\n    <link rel=\"icon\" href=\"img/favicon.png\" type=\"image/x-icon\">\n\n</head>\n\n<body class=\"animated fadeInDown\">\n\n<div id=\"main\" role=\"main\" class=\"login_main\">\n    <!-- MAIN CONTENT -->\n    <div id=\"content\" class=\"container\">\n\n        <div class=\"row\">\n            <div class=\"col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm\">\n                <h1 class=\"txt-color-red login-header-big\">\u5b89\u5fbd\u8d22\u7ecf\u5927\u5b66\u8bba\u6587\u9009\u9898\u7cfb\u7edf</h1>\n\n                <div class=\"hero\">\n\n                    <div class=\"pull-left login-desc-box-l\">\n                        <h4 class=\"paragraph-header\">\u8bf7\u540c\u5b66\u4eec\u767b\u5f55\u540e\u9009\u9898\uff0c\u5fc5\u987b\u5728\u89c4\u5b9a\u65f6\u95f4\u5185\u9009\u597d\u9898\u76ee\uff0c\u5e76\u63d0\u4ea4\u5f00\u9898\u62a5\u544a\u3002</h4>\n                    </div>\n\n                    <img src=\"img/bigaufe.png\" class=\"pull-right display-image\" style=\"width:350px\">\n\n                </div>\n\n                <div class=\"row\">\n                    <div class=\"col-xs-12 col-sm-12 col-md-6 col-lg-6\">\n                        <h5 class=\"about-heading\">\u5173\u4e8e\u672c\u7cfb\u7edf</h5>\n\n                        <p>\u672c\u7cfb\u7edf\u6700\u7ec8\u89e3\u91ca\u6743\u5f52\u5c5e\u5b89\u5fbd\u8d22\u7ecf\u5927\u5b66</p>\n                    </div>\n                    <div class=\"col-xs-12 col-sm-12 col-md-6 col-lg-6\">\n                        <h5 class=\"about-heading\">\u8bb8\u53ef\u8bc1</h5>\n\n                        <p>\n                            www.aufe.edu.cn \u5b89\u5fbd\u8d22\u7ecf\u5927\u5b66 Copyright \u00a9 2015-2016\n                        </p>\n                    </div>\n                </div>\n\n            </div>\n            <div class=\"col-xs-12 col-sm-12 col-md-5 col-lg-4\">\n                <div class=\"well no-padding\">\n                    <form method=\"post\" id=\"login-form\" class=\"smart-form client-form\">\n                        <header>\n                            \u767b\u5f55\n                        </header>\n\n                        <fieldset>\n                            <section>\n                                <label class=\"label\">\u5b66\u53f7</label>\n                                <label class=\"input state-success\"> <i class=\"icon-append fa fa-user\"></i>\n                                    <input type=\"text\" name=\"account\" id=\"account\">\n                                    <b class=\"tooltip tooltip-top-right\"><i class=\"fa fa-user txt-color-teal\"></i>\u8bf7\u8f93\u5165\u5b66\u53f7</b></label>\n                            </section>\n\n                            <section>\n                                <label class=\"label\">\u5bc6\u7801</label>\n                                <label class=\"input state-success\"> <i class=\"icon-append fa fa-lock\"></i>\n                                    <input type=\"password\" name=\"password\" id=\"password\" >\n                                    <b class=\"tooltip tooltip-top-right\"><i class=\"fa fa-lock txt-color-teal\"></i>\u8bf7\u8f93\u5165\u5bc6\u7801</b>\n                                </label>\n\n                                <div class=\"note\">\n                                    <b>*\u8bf7\u52a1\u5fc5\u8f93\u5165\u6b63\u786e\u7684\u5b66\u53f7\u5bc6\u7801</b>\n                                </div>\n                            </section>\n\n                            <section>\n                                <label class=\"checkbox \">\n                                    <input type=\"checkbox\" name=\"remember\" checked=\"\">\n                                    <i></i>\u8bb0\u4f4f\u5bc6\u7801</label>\n                            </section>\n                        </fieldset>\n                        <footer>\n                            <button type=\"button\" class=\"btn btn-success\" onclick=\"loginCheck();\">\n                                \u767b\u5f55\n                            </button>\n                        </footer>\n                    </form>\n\n                </div>\n\n                <ul class=\"list-inline text-center\">\n                    <li>\n                        <a href=\"http://weibo.com/\" class=\"btn btn-primary btn-circle\"><i class=\"fa fa-weibo\"></i></a>\n                    </li>\n                    <li>\n                        <a href=\"https://wx.qq.com/\" class=\"btn btn-info btn-circle\"><i class=\"fa fa-weixin\"></i></a>\n                    </li>\n                    <li>\n                        <a href=\"https://www.baidu.com/\" class=\"btn btn-warning btn-circle\"><i class=\"fa fa-paw\"></i></a>\n                    </li>\n                    <li>\n                        <a href=\"http://www.qq.com/\" class=\"btn btn-danger btn-circle\"><i class=\"fa fa-qq\"></i></a>\n                    </li>\n                </ul>\n\n            </div>\n        </div>\n    </div>\n</div>\n\n<!--================================================== -->\n\n<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->\n<script src=\"js/plugin/pace/pace.min.js\"></script>\n\n<script> if (!window.jQuery) {\n    document.write('<script src=\"js/libs/jquery-2.0.2.min.js\"><\\/script>');\n} </script>\n\n<script> if (!window.jQuery.ui) {\n    document.write('<script src=\"js/libs/jquery-ui-1.10.3.min.js\"><\\/script>');\n} </script>\n<!-- BOOTSTRAP JS -->\n<script src=\"js/bootstrap/bootstrap.min.js\"></script>\n<!-- JQUERY VALIDATE -->\n<script src=\"js/plugin/jquery-validate/jquery.validate.min.js\"></script>\n<!-- JQUERY MASKED INPUT -->\n<script src=\"js/plugin/masked-input/jquery.maskedinput.min.js\"></script>\n<!-- MAIN APP JS FILE -->\n<script src=\"js/app.min.js\"></script>\n\n<script src=\"js/login.js\"></script>\n\n<form name=\"loginForm\" action=\"/design/index\" method=\"post\">\n    <input type=\"hidden\" value=\"\" name=\"account\" id=\"loginAccount\">\n    <input type=\"hidden\" value=\"\" name=\"password\" id=\"loginPassword\">\n</form>\n\n</body>\n</html>\n".toCharArray();
  }
}