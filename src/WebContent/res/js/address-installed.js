;(function(w){
	
	var regx = /#\//g
	,	pathname = w.location.pathname
	,	url = w.location.href.split('?')[0]
	,	ctxPath = url.replace(regx, '').replace(pathname, '');
	
	// 项目 根路径
	w.ctxPath = ctxPath + '/' + pathname.split('/')[1];
	
})(window);