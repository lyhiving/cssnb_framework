var setting = {
	callback: {
		onExpand: resizeIframe,
		onCollapse: resizeIframe
	},
	data: {
		key:{
			url: 'URL',
			name: 'NAME'
		},
		simpleData:{
			enable: true,
			idKey: 'NODE',
			pIdKey: 'PID',
			rootPId: '000'
		}
	}
};
var zTreeAPI, target_serverPath;
function jsonpcallback(data){
	if(data){
		for(var i = 0; i < data.length; i++){
			if(data[i].URL == "#"){
				data[i].isParent = true;
				delete data[i].URL;
			}else{
				data[i].target = "_self";
				data[i].URL = target_serverPath + data[i].URL;
				data[i].target = 'mainFrame';
			}
		}
		// 初始化树
		treeAPI = $.fn.zTree.init($("#ztree"), setting, data);
		// 如果树的高度大于窗口高度
		if($("#ztree").height() > $(window).height()){
			resizeIframe();
		}
	}
}
/**
 * 底部高度
 */
function getBottomHeight(){
	return $(window).height() - $("#top").height() - $("#top").css("marginTop").replace("px", "") - $("#top").css("marginBottom").replace("px", "") - 1;
}
/**
 * 滑动门控制
 * @作者: 卜繁晟
 * @创时: 2013-3-1 下午3:36:41
 */
function setSwitchBarLeft(){
	$(".switch_bar").css({
		left: $("#left").is(":visible") ? ($("#left").width() - $(".switch_bar").width() - 2) : 0,
		borderRight: $("#left").is(":visible") ? "1px solid #cccccc" : "none"
	});
};
/**
 * demo树数据
 */
var tree_data = [
 	{NODE: 1, PID: 0, NAME: 'ztree'},
 	{NODE: 2, PID: 1, NAME: '一次性加载', URL: baseURL + '/ztree/index', target: 'mainFrame'},
 	{NODE: 2, PID: 1, NAME: '异步加载', URL: baseURL + '/ztree/index_lazy', target: 'mainFrame'},
 	{NODE: 3, PID: 0, NAME: 'ajaxUpload', URL: baseURL + '/ajaxUpload/index', target: 'mainFrame'},
 	{NODE: 4, PID: 0, NAME: '表格'},
 	{NODE: 5, PID: 4, NAME: '表格', URL: baseURL + '/demo/table/index', target: 'mainFrame'},
 	{NODE: 6, PID: 4, NAME: '表格', URL: baseURL + '/demo/table/ajax', target: 'mainFrame'}
 ];
//重设页面高度
function resizeIframe(height){
	setSwitchBarLeft();
	if($("#bottom").height() < getBottomHeight()){
		$("#left, #mainFrame").css("minHeight", getBottomHeight());
	}else if($("#ztree").height() < document.body.scrollHeight){
		$("#left, #mainFrame").css("minHeight", document.body.scrollHeight - $("#top").height() - $("#top").css("marginTop").replace("px", "") - $("#top").css("marginBottom").replace("px", "") - 1);
	}
	if(height){$("#left, #mainFrame").css("minHeight", height);}
	$("html, body").css("scrollTop", document.body.scrollHeight);
};
$(function(){
	// 重设iframe高度
	//resizeIframe();
	$(window).resize(function(){resizeIframe();});
	// 左侧菜单收起展开
	$(".switch_arrow").css("top", (window.screen.height - $(".switch_arrow").height()) / 2 ).click(function(){
		var $this = $(this);
		if($("#left").is(":visible")){
			$this.attr("title", "展开").addClass("arrow_hidden");
			$(".switch_bar").toggle();
			var rightWidth = $("#right").width();
			$("#left").stop(false, true).animate({"marginLeft": -1 * $("#left").width()}, {
				duration: 100,
				step: function(now, fx){
					$("#right").width(rightWidth + Math.floor(Math.abs(now)));
				},
				complete: function(){
					$("#right").width("100%");
					$(this).hide();
					setSwitchBarLeft();
					$(".switch_bar").toggle();
				}
			});
		}else{
			$this.attr("title", "展开").removeClass("arrow_hidden");
			$(".switch_bar").toggle();
			var rightWidth = $("#right").width();
			$("#left").stop(false, true).animate({"marginLeft": 0}, {
				duration: 100,
				step: function(now, fx){
					$("#right").width(rightWidth - ($("#left").width() - Math.floor(Math.abs(now))));
				},
				complete: function(){
					$(this).show();
					$("#right").removeAttr("style");
					setSwitchBarLeft();
					$(".switch_bar").toggle();
				}
			});
		}
	});
	// 项目点击（跨域），读取树
	$(".btn-group button").click(function(e){
		$("#ztree").html("");
		if(e.target.id == 'p2'){
			$.fn.zTree.init($("#ztree"), setting, tree_data);
			return;
		}
		if($("#ztree").data("p") != e.target.id){
			$("#ztree").data("p", e.target.id);
			target_serverPath = $(this).attr("serverPath");
			$.ajax({
				type: "get",		//使用get方法访问后台
				dataType: "jsonp",	//返回json格式的数据
				jsonp: "jsonpcallback",
				url: "http://localhost:8012/p1/ztree/getQxList_jsonp?callback=jsonpcallback",	//要访问的后台地址
				data: {},
				async: true,
				success: function(e){
					alert("success");
				},
				complete: function(e){
					alert("complete");
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					alert("error");
					if(XMLHttpRequest.status == 404){
						alert("页面不存在，访问出错！");
					}
				}
			});
		}
	});
});