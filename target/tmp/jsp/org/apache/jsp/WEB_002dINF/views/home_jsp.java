package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>宁波市质量安全监管业务平台</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/css/zjj2011.css\"></link>\r\n");
      out.write("<style>\r\n");
      out.write(".layer_select_aqlb {\r\n");
      out.write("  background-color:rgba(255, 255, 255, 0.6);\r\n");
      out.write("  border: 1px solid #FFFFFF;\r\n");
      out.write("  border-radius: 3px 3px 3px 3px;\r\n");
      out.write("  line-height: 17px;\r\n");
      out.write("  padding: 6px 1px;\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  right: 54px;\r\n");
      out.write("  top: 457px;\r\n");
      out.write("  width: 100px;\r\n");
      out.write("  z-index: 9999;\r\n");
      out.write("}\r\n");
      out.write(".layer_select_aqlb ul{\r\n");
      out.write("\tmargin: 0 4px;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\tlist-style:none outside none;\r\n");
      out.write("}\r\n");
      out.write(".layer_select_aqlb li{\r\n");
      out.write("\tcolor: #595959;\r\n");
      out.write("    line-height: 14px;\r\n");
      out.write("    padding: 5px 4px;\r\n");
      out.write("    list-style: none outside none;\r\n");
      out.write("}\r\n");
      out.write(".layer_select_aqlb div{\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("}\r\n");
      out.write(".layer_select_aqlb label{\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write(".layer_select_aqlb input{\r\n");
      out.write("\tvertical-align:middle;\r\n");
      out.write("\tline-height:normal;\r\n");
      out.write("\tmargin-right:5px;\r\n");
      out.write("}\r\n");
      out.write(".layer_msgbox {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("  \tleft: 50%;\r\n");
      out.write("  \ttop: 407px;\r\n");
      out.write("  \tfont-size:18px;\r\n");
      out.write("  \tfont-weight:bold;\r\n");
      out.write(" \tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"loginbody\" style=\"background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/images/bgbody.jpg) center center repeat-x;\">\r\n");
      out.write("<div class=\"login_main dhmain\">\r\n");
      out.write("<div class=\"dhnav dhnavc\">\r\n");
      out.write("\t<a href=\"main.jsp?showtype=dqsw\" class=\"dhnav01\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=qyda\" class=\"dhnav04\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=xyjg\" class=\"dhnav052\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=qyjg\" class=\"dhnav05\"></a>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"dhnavb\">\r\n");
      out.write("\t<a href=\"main.jsp?showtype=yg\" class=\"dhnav06\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=yc\" class=\"dhnav08\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=yx\" class=\"dhnav07\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=yj\" class=\"dhnav09\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=yz\" class=\"dhnav10\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=xc\" class=\"dhnav11\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=cc\" class=\"dhnav12\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=zfjc\" class=\"dhnav13\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=sdhc\" class=\"dhnav14\"></a>\r\n");
      out.write("\t<a href=\"main.jsp?showtype=gzdc\" class=\"dhnav15\"></a>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"dhnavb2\">\r\n");
      out.write("\t<a href=\"main.jsp?showtype=xzxk\" class=\"dhnav02\">行政许可</a>\r\n");
      out.write("\t<a href=\"#\" class=\"dhnav03 aqlbclz\">食品监管</a>\r\n");
      out.write("\t<a href=\"#\" class=\"dhnav03 aqlbclz\">安全类产品</a>\r\n");
      out.write("\t<a href=\"#\" class=\"dhnav03 aqlbclz\">民生计量</a>\r\n");
      out.write("\t<a href=\"#\" class=\"dhnav03 aqlbclz\">特种设备</a>\r\n");
      out.write("\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/demo\" class=\"dhnav03\">测试</a>\r\n");
      out.write("\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/main?right_id=109\" class=\"dhnav03\">预告</a>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:relative\"></div>\r\n");
      out.write("<div style=\"display:none;\" class=\"layer_select_aqlb\">\r\n");
      out.write("\t<div id=\"\">选择查看类别</div>\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<!--tip start-->\r\n");
      out.write("\t\t<!--tip end-->\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"layer_msgbox\" style=\"display:none\">\r\n");
      out.write("\t<label id=\"msgcontent\"></label>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery/jquery-1.7.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var aqlb_all;\r\n");
      out.write("var curAqlb=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user_aqlb}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("var curAqlbmc=\"\";\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$.getJSON('getAqlbList.action',{},function(data){\r\n");
      out.write("\t\tif(data.res_code=='000'){\r\n");
      out.write("\t\t\t//var strs = \"\";\r\n");
      out.write("\t\t\tvar list = data.res_data;\r\n");
      out.write("\t\t\t//for(var i=0;i<list.length;i++){\r\n");
      out.write("\t\t\t///\tstrs += \"<li><label><input name='aqlb' type='radio' value='\"+list[i].id+\"' /><span class='lbname'>\"+list[i].name+\"</span></label></li>\";\r\n");
      out.write("\t\t\t//}\r\n");
      out.write("\t\t\t//$(\".layer_select_aqlb ul\").append(strs);\r\n");
      out.write("\t\t\t//var aqlbel = $(\"input[name='aqlb']\");\r\n");
      out.write("\t\t\t//aqlbel.filter('[value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user_aqlb}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("]').attr(\"checked\",true);\r\n");
      out.write("\t\t\taqlb_all = list[0].id;\r\n");
      out.write("\t\t\t$(\".dhnavb2 a.aqlbclz\").each(function(index,domEle){\r\n");
      out.write("\t\t\t\t$(this).attr(\"id\",\"aqlb_\"+list[index+1].id);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"a.aqlbclz\").filter('[id=aqlb_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user_aqlb}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("]').addClass(\"selected\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".aqlbclz\").click(function(e){\r\n");
      out.write("\t\te.preventDefault();\r\n");
      out.write("\t\tvar selectedAqlb = $(this).attr(\"id\").substring(5);\r\n");
      out.write("\t\tif(selectedAqlb!=curAqlb){\r\n");
      out.write("\t\t\tselectedContent = $(this).text();\r\n");
      out.write("\t\t\t$(this).addClass(\"selected\").siblings().removeClass(\"selected\");\r\n");
      out.write("\t\t\t$.post(\"setAqlb.action\",{lb:selectedAqlb},function(data){\r\n");
      out.write("\t\t\t\tcurAqlb = selectedAqlb;\r\n");
      out.write("\t\t\t\t$(\"#msgcontent\").text(\"您选择了\"+selectedContent);\r\n");
      out.write("\t\t\t\t$(\".layer_msgbox\").stop().fadeIn().delay(3000).fadeOut();\r\n");
      out.write("\t\t\t},'json');\r\n");
      out.write("\t\t}else if(selectedAqlb==curAqlb){\r\n");
      out.write("\t\t\t$(this).removeClass(\"selected\");\r\n");
      out.write("\t\t\t$.post(\"setAqlb.action\",{lb:aqlb_all},function(data){\r\n");
      out.write("\t\t\t\tcurAqlb = aqlb_all;\r\n");
      out.write("\t\t\t\t$(\"#msgcontent\").text(\"您恢复查看所有类别\");\r\n");
      out.write("\t\t\t\t$(\".layer_msgbox\").stop().fadeIn().delay(3000).fadeOut();\r\n");
      out.write("\t\t\t},'json');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//$(\".layer_select_aqlb\").delegate(\"input[name='aqlb']\",\"change\",function(){\r\n");
      out.write("\t//\tvar selectedAqlb = $(this).val();\r\n");
      out.write("\t//\tvar selectedContent = $(this).next(\"span\").text();\r\n");
      out.write("\t//\t$.post(\"setAqlb.action\",{lb:selectedAqlb},function(data){\r\n");
      out.write("\t//\t\t$(\"#msgcontent\").text(\"您选择了\"+selectedContent);\r\n");
      out.write("\t//\t\t$(\".layer_msgbox\").fadeIn().delay(3000).fadeOut();\r\n");
      out.write("\t//\t},'json');\r\n");
      out.write("\t//});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
