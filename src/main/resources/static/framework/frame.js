$(function(){
	
	init();
	$(window).resize(function(){
		init();
	});
	
	//菜单
	$(".menuFA").click(function(){
		menuFAClick($(this));
	});
	$(".menuFA").mouseenter(function(){
		menuFAMouseenter($(this));
	});
	$(".menuFA").mouseleave(function(){
		menuFAMouseleave($(this));
	});
	
})

function menuFAMouseenter(_this){
	_this.animate({
	    borderWidth:'7px'
	},200);
}

function menuFAMouseleave(_this){
	_this.animate({
	    borderWidth:'0px'
	},200);
}

function menuFAClick(_this){
	var dl = _this.siblings("dl");
	var bgColor = "#282a32";
	if(dl.length > 0){
		if(dl.css("display") == "none"){
			dl.show();
			_this.find(".right").attr("class","iconfont icon-arrow-down right");
			bgColor = "#282a32";
		}else{
			dl.hide();
			_this.find(".right").attr("class","iconfont icon-dajiantouyou right");
			bgColor = "transparent";
		}
	}
	_this.css("background-color",bgColor);
	_this.parent().siblings().find("dl").hide();
	_this.parent().siblings().find("a.menuFA").css("background-color","transparent");
}



//初始化页面
function init(){
	var win_h = $(window).height();
	var win_w = $(window).width();
	var frameMenuW = $(".frameMenu").width();
	var logoH = 110;
	var frameTopH = $(".frameTop").height();
	
	$(".frameMenu").height(win_h);
	$(".frameMenu .menu").height(win_h - logoH);
	$(".main").width(win_w - frameMenuW).height(win_h);
	$(".frameMain").height(win_h - frameTopH);
	$(".frameMain .con").height(win_h - frameTopH - 40);
	$(".frameMain .con iframe").height(win_h - frameTopH - 40);
	
	//自定义滚动条
	$(".menu").mCustomScrollbar();
}
