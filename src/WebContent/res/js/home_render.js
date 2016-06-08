$(function () {

    var router = new Router({
        container: '#container',
        enterTimeout: 250,
        leaveTimeout: 250
    });

    // grid
    var home = {
        url: '/',
        className: 'home',
        render: function () {
            return $('#tpl_home').html();
        }
    }
	
	,	judgement = {
        url: '/judgement',
        className: 'judgement',
        render: function () {
            return $('#tpl_judgement').html();
        }
    }
	
    , scheduling = {
		url: '/scheduling',
        className: 'scheduling',
        render: function () {
            return ajaxHtml(ctxPathFixed + '/scheduling/builder');
        }
    }
    
	,	employee = {
		url: '/employee',
        className: 'employee',
        render: function () {
            return $('#tpl_employee').html();
        }
	}
    
    ,	employeeAdd = {
		url: '/employee_add',
        className: 'employee_add',
        render: function () {
            return $('#tpl_employee_add').html();
        }
	}
    
    ,	employeeList = {
		url: '/employee_list',
        className: 'employee_list',
        render: function () {
            return ajaxHtml(ctxPathFixed + '/employee/list');
        }
	};
	
	router.push(home)
		.push(judgement)
		.push(scheduling)
		.push(employee)
		.push(employeeAdd)
		.push(employeeList)
        .setDefault('/')
        .init();


    // .container 设置了 overflow 属性, 导致 Android 手机下输入框获取焦点时, 输入法挡住输入框的 bug
    // 相关 issue: https://github.com/weui/weui/issues/15
    // 解决方法:
    // 0. .container 去掉 overflow 属性, 但此 demo 下会引发别的问题
    // 1. 参考 http://stackoverflow.com/questions/23757345/android-does-not-correctly-scroll-on-input-focus-if-not-body-element
    //    Android 手机下, input 或 textarea 元素聚焦时, 主动滚一把
    if (/Android/gi.test(navigator.userAgent)) {
        window.addEventListener('resize', function () {
            if (document.activeElement.tagName == 'INPUT' || document.activeElement.tagName == 'TEXTAREA') {
                window.setTimeout(function () {
                    document.activeElement.scrollIntoViewIfNeeded();
                }, 0);
            }
        })
    }
	
    // 加载 事件
    initEvent();
});

function ajaxHtml(url, data){
	var result = null;
	
	$.ajax({
		'url': url
	,	'data': data
		// 同步请求
	,	'async': false
	,	'dataType': 'html'
	,	'success': function(response){
			result = response;
		}
	});
	
    return result;
}

function initEvent(){
	$(document)
	// 打开 Dialog事件
	.on('click', '#btn-qrcode-dialog', function(){
		$('#dialog-qrcode').show();
	})
	// 关闭 dialog事件
	.on('click', '.weui_btn_dialog', function(){
		$(this).parents('.weui_dialog_alert').hide();
	})
	// 关闭 confirm事件
	.on('click', '.confirm-cancel', function(){
		$(this).parents('.weui_dialog_confirm').hide();
	})
	// 打开雇员选择
	.on('click', '.employee-select', function(){
		$('#dialog-employee-select').show();
	})
	// 解雇雇员事件
	.on('click', '.employee_item', function(){
		var $this = $(this)
		,	$confirm = $('#dialog-employye-fire')
//		,	$loadding = $('#loading-toast')
		,	id = $this.attr('data-id')
		,	name = $this.attr('data-name');
		
		// 先显示确认窗口先
		$confirm.show();
		
		$('#confirm-fire-employee').one('click', function(){
			$confirm.hide();
			// 加载窗口 五秒后消失
			var loading = new UiLoading();
			
			$.get(ctxPathFixed + '/employee/fire', {'id': id}, function(result){
				loading.hide();
				if (!result.success) {
					alert('解雇失败系统不受');
				} else {
					window.location.reload(true);
				}
			}, 'json');
		});
	});
}

function UiLoading(delay){
	var self = 
	// 获取 加载窗口
	this.$loading = $('#loading-toast');
	// 显示 加载窗口
	this.$loading.show();
	
	if (delay && !isNaN(delay)) {
		window.setTimeout(function(){
			self.hide();
		}, delay);
	}
}

UiLoading.prototype = {
	'hide': function(){
		this.$loading.hide();
	}
};