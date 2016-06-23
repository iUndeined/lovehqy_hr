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
            return ajaxHtml(ctxPathFixed + '/judgement');
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
	// 关闭 confirm事件
	.on('click', '.btn-cancel', function(){
		$(this).parents('.wrap-cancel').hide();
	})
	
	// 排班 添加雇员
	.on('click', '.employee-sch-add', function(){
		var template = $('#employee-sch-item-template').html();
		if (template) {
			var self = $(this)
			,	str = self.attr('data-str')
			,	date = self.attr('data-date')
			,	$html = $(template).attr({'data-str': str, 'data-date': date});
			
			// 触发 雇员选择窗口
			eventSchDialogDisplay.call($html);
			// 插入 往前
			self.before($html);
		}
	})
	
	// 排班 触发雇员选择窗口
	.on('click', '.employee-sch-select', eventSchDialogDisplay)
	
	// 排班 雇员选择赋值事件
	.on('click', '#confirm-sch-employee', eventSchChooceEmployee)
	
	// 排班 保存事件
	.on('click', '#btn-sch-shoot', eventSchFinalShoot)
	
	// 解雇雇员事件
	.on('click', '.employee_item', eventFireEmployee);
}

var currentSchSel = null;

function eventSchDialogDisplay(){
	var self = currentSchSel = $(this)
	,	str = self.attr('data-str')
	,	dialogStr = $('#dialog-work-str')
	,	dialog = $('#dialog-employee-select');
	
	dialogStr.text(str);
	dialog.find('.sch-chooce-radio').prop('checked', false);
	dialog.show();
}

function eventSchChooceEmployee(){
	// 获取 选中的
	var $sel = $('.sch-chooce-radio:checked');
	if ($sel.length == 0) {
		alert('一定要选择一位雇员');
		return;
	}
	
	var id = $sel.val()
	,	name = $sel.attr('data-name');
	
	// 设置 隐藏值
	currentSchSel.attr({
		'data-id': id
	,	'data-name': name
	}).find('.sch-name').text(name);
	
	// 关闭选择窗口
	$('#dialog-employee-select').hide();
}

/**
 * 排班 保存事件
 */
function eventSchFinalShoot(){
	// 开始 加载
	var loading = new UiLoading()
	// 开始转换保存值
	,	items = $('.employee-sch-select[data-id]');
	
	if (items.length == 0) {
		loading.hide();
		alert('您还没有进行排班');
		return;
	}
	
	var datas = [];
	
	// 循环一波
	items.each(function(index, element) {
		var self = $(this)
		// 只有已经保存过的才会有这个属性
		,	uid = self.attr('data-uid')
		
		// 获取 正常所需的值们
		,	id = self.attr('data-id')
		,	name = self.attr('data-name')
		,	date = self.attr('data-date')
		
		// 声明 数据对象
		,	data = {
			'employeeId': id
		,	'employeeName': name
		,	'date': date
		};
		
		// 如需修改
		if (uid) {
			data.schId = uid;
		}
		
        datas.push(data);
    });
	
	// 设置 保存数据
	$('#employee-sch-datas').val(JSON.stringify(datas));
	// 提交 表单
	$('#employee-sch-form').submit();
}

/**
 * 解雇雇员事件处理方法
 */
function eventFireEmployee(){
	var $this = $(this)
	,	$confirm = $('#dialog-employye-fire')
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