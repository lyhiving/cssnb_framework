package org.apache.jsp.WEB_002dINF.views.yfive;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class yglist2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>jqgrid测试</title>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<title>宁波市质量安全监管平台新版本</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-store\" />\r\n");
      out.write("\t<meta http-equiv=\"Pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Expires\" content=\"0\" />\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge, chrome=1\">\r\n");
      out.write("\t<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("\t<meta name=\"description\" content=\"\" />\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-validation/1.9.0/validate.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/css/base.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/css/icon.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/superfish/css/superfish.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("\t<!--[if lt IE 9]>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/js/html5.js\"></script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("\t<!--[if lt IE 7]>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/js/iepngfix_tilebg.js\"></script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/js/jquery.hoverIntent.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/css/template2.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-ui/css/cssnb/jquery-ui-1.8.21.custom.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jqgrid/css/ui.jqgrid.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/global/css/jqgrid-ext.css\"/>\r\n");
      out.write("\t<script type='text/javascript' src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-ui/js/jquery-ui-1.8.21.custom.min.js\"/></script>\r\n");
      out.write("\t<script type='text/javascript' src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jqgrid/js/grid.locale-cn.js\"></script>\r\n");
      out.write("\t<script type='text/javascript' src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jqgrid/js/jquery.jqGrid.min.js\"></script>\r\n");
      out.write("\t<script type='text/javascript' src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\t<title>预告信息列表</title>\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1 id='banner'></h1>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t<form id=\"queryForm\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/yfive/yg/list2\">\r\n");
      out.write("  <table>  \r\n");
      out.write("  <tbody><tr>\r\n");
      out.write("    <td align=\"right\" width=\"50\">标题：</td>  \r\n");
      out.write("    <td align=\"left\" width=\"80\"><input name=\"title\" value=\"\" size=\"15\" type=\"text\"></td>  \r\n");
      out.write("    <td align=\"right\" width=\"60\">类型：</td>  \r\n");
      out.write("    <td align=\"left\" width=\"80\"><select name=\"type\">\r\n");
      out.write("  \t\t<option value=\"\" selected=\"selected\">请选择预告类型</option>\r\n");
      out.write("  \t\t<option value=\"食品\">食品</option>\r\n");
      out.write("  \t\t<option value=\"安全类\">安全类</option>\r\n");
      out.write("  \t\t<option value=\"计量\">计量</option>\r\n");
      out.write("  \t\t<option value=\"特种设备\">特种设备</option>\r\n");
      out.write("  \t\t<option value=\"综合\">综合</option>\r\n");
      out.write("\t\t</select></td>  \r\n");
      out.write("    <td align=\"right\" width=\"70\">发布单位：</td>  \r\n");
      out.write("    <td align=\"left\" width=\"80\"><input name=\"fbdw\" value=\"\" type=\"text\"></td>  \r\n");
      out.write("    <td align=\"right\" width=\"100\">日期区间：</td>  \r\n");
      out.write("    <td align=\"left\" width=\"80\"><input name=\"kssj\" value=\"\" style=\"width:100%\" onclick=\"WdatePicker()\" readonly=\"readonly\" type=\"text\"></td>  \r\n");
      out.write("    <td align=\"center\" width=\"10\">至</td>  \r\n");
      out.write("    <td align=\"left\" width=\"80\"><input name=\"jzsj\" value=\"\" style=\"width:100%\" onclick=\"WdatePicker()\" readonly=\"readonly\" type=\"text\"></td>  \r\n");
      out.write("    <td align=\"left\"><input name=\"Submit\" value=\" 查询 \" onclick=\"queryInfo()\" type=\"button\"></td>  \r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id='gridcontainer' style=\"width:80%;padding:20px;margin:0 auto;\">\r\n");
      out.write("\t\t<div class=\"grid-title\">\r\n");
      out.write("\t\t\t<strong>质量安全预告信息</strong>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<table id='grid'></table>\r\n");
      out.write("\t\t<div id='pager'></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id='msgbox' title='' style='display:none'></div>\r\n");
      out.write("\t<script type='text/javascript'>\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#grid\").jqGrid({\r\n");
      out.write("\t\t   \turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/yfive/yg/list2',\r\n");
      out.write("\t\t\tdatatype: 'json',\r\n");
      out.write("\t\t\tmtype: 'post',\r\n");
      out.write("\t\t   \tcolNames:['预告id','文件', '标题', '类型', '发布单位', '发布日期'],\r\n");
      out.write("\t\t   \tcolModel:[\r\n");
      out.write("\t\t   \t\t{name:'yginfoId',index:'yginfoId', width:55,hidden:true},\r\n");
      out.write("\t\t   \t\t{name:'yginfoFs',index:'yginfoFs', width:55,hidden:true},\r\n");
      out.write("\t\t   \t\t{name:'yginfoTitle',index:'yginfoTitle',formatter:function(cellvalue, options, rowObject){return \"<a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/public/download/\"+rowObject.yginfoFs+\"' title='\"+cellvalue+\"'>\" + cellvalue + \"</a>\";}},\r\n");
      out.write("\t\t   \t\t{name:'yginfoType',index:'yginfoType',width:'15%',align:'center'},\r\n");
      out.write("\t\t   \t\t{name:'yginfoDw',index:'yginfoDw', width:'15%',align:'center'},\r\n");
      out.write("\t\t   \t\t{name:'yginfoKssj',index:'yginfoKssj',width:'15%',align:'center'}\r\n");
      out.write("\t\t   \t],\r\n");
      out.write("\t\t   \t//postData: $(\"#queryForm\").serialize(),\r\n");
      out.write("\t\t\trowNum:10,\r\n");
      out.write("\t\t   \trowList:[10,20,50,100],\r\n");
      out.write("\t\t   \theight: \"auto\",\r\n");
      out.write("\t\t   \tautowidth: true,\r\n");
      out.write("\t\t\trownumbers: true,\r\n");
      out.write("\t\t   \tpager: '#pager',\r\n");
      out.write("\t\t   \tsortname: 'yginfo_kssj',\r\n");
      out.write("\t\t    viewrecords: true,\r\n");
      out.write("\t\t    sortorder: \"desc\",\r\n");
      out.write("\t\t    //caption:\"重要预告信息\",\r\n");
      out.write("\t\t    emptyrecords: \"无记录\",\r\n");
      out.write("\t\t    loadonce: false,\r\n");
      out.write("\t\t    loadComplete: function() {\r\n");
      out.write("\t\t    \t//加载完毕后\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    jsonReader : {\r\n");
      out.write("\t\t        root: \"rows\",\r\n");
      out.write("\t\t        page: \"page\",\r\n");
      out.write("\t\t        total: \"total\",\r\n");
      out.write("\t\t        records: \"records\",\r\n");
      out.write("\t\t        repeatitems: false,\r\n");
      out.write("\t\t        cell: \"cell\",\r\n");
      out.write("\t\t        id: \"id\"\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#grid\").jqGrid('navGrid','#pager',\r\n");
      out.write("\t\t\t\t{edit:false, add:false, del:false, search:true},\r\n");
      out.write("\t\t\t\t{}, {}, {}, \r\n");
      out.write("\t\t\t\t{ \t// search\r\n");
      out.write("\t\t\t\t\tsopt:['cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew'],\r\n");
      out.write("\t\t\t\t\tcloseOnEscape: true, \r\n");
      out.write("\t\t\t\t\t//multipleSearch: true, \r\n");
      out.write("\t\t\t\t\tcloseAfterSearch: true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.fn.serializeObject = function() {\r\n");
      out.write("\t\t    var o = {};\r\n");
      out.write("\t\t    var a = this.serializeArray();\r\n");
      out.write("\t\t    $.each(a, function() {\r\n");
      out.write("\t\t        if (o[this.name]) {\r\n");
      out.write("\t\t            if (!o[this.name].push) {\r\n");
      out.write("\t\t                o[this.name] = [ o[this.name] ];\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t            o[this.name].push(this.value || '');\r\n");
      out.write("\t\t        } else {\r\n");
      out.write("\t\t            o[this.name] = this.value || '';\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t\t    return o;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// Toolbar Search\r\n");
      out.write("\t\t//$(\"#grid\").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:\"cn\"});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(window).bind('resize', function() {\r\n");
      out.write("\r\n");
      out.write("\t    // Get width of parent container\r\n");
      out.write("\t    var width = $(\"#gridcontainer\").prop('clientWidth');\r\n");
      out.write("\t    if (width == null || width < 1){\r\n");
      out.write("\t        // For IE, revert to offsetWidth if necessary\r\n");
      out.write("\t        width = $(\"#gridcontainer\").prop('offsetWidth');\r\n");
      out.write("\t    }\r\n");
      out.write("\t    width = width - 2; // Fudge factor to prevent horizontal scrollbars\r\n");
      out.write("\t    if (width > 0 &&\r\n");
      out.write("\t        // Only resize if new width exceeds a minimal threshold\r\n");
      out.write("\t        // Fixes IE issue with in-place resizing when mousing-over frame bars\r\n");
      out.write("\t        Math.abs(width - $(\"#grid\").width()) > 5)\r\n");
      out.write("\t    {\r\n");
      out.write("\t        $(\"#grid\").setGridWidth(width);\r\n");
      out.write("\t    }\r\n");
      out.write("\r\n");
      out.write("\t}).trigger('resize');\r\n");
      out.write("\t\r\n");
      out.write("\tfunction queryInfo() {\r\n");
      out.write("\t\tvar postData = $(\"#grid\").jqGrid('getGridParam','postData');\r\n");
      out.write("\t\tvar formarray = $(\"form\").serializeArray();\r\n");
      out.write("\t\tvar o = {};\r\n");
      out.write("\t\t$.each(formarray,function(i,n){\r\n");
      out.write("\t\t\to[this.name] = this.value || '';\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\to['records'] = $(\"#grid\").jqGrid('getGridParam','records');\r\n");
      out.write("\t\t$.extend(postData,o);\r\n");
      out.write("\t\t$(\"#grid\").setGridParam({search: true,page:1,postData:postData}).trigger('reloadGrid',[{page:1}]);\r\n");
      out.write("\t\t//postData = $(\"#grid\").jqGrid('getGridParam','postData');\r\n");
      out.write("\t}\r\n");
      out.write("\tconsole.log(\"in frame:\"+$(window).height());\r\n");
      out.write("\tparent.$(\"iframe\").height($(\"body\").height());\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
