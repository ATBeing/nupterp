<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="zh-CN">
<head>
<title>欢迎使用ERP管理系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<jsp:include page="incB.jsp"></jsp:include>
<script type="text/javascript">
	var loginForm;
	$(function() {
		loginForm = $("#user_login_loginForm");
		window.setTimeout(function() {
			loginForm.find('input[name=name]').focus();
		}, 0);
		
		loginForm.bind('keyup', function(event) {/* 增加回车提交功能 */
			if (event.keyCode == '13') {
				_submit();
			}
		});
	});
	
	function isEmpty( inputStr ) { if ( null == inputStr || "" == inputStr ) { return true; } return false; }
	
	function _submit() {
		$.ajax({
			url : '${pageContext.request.contextPath}/userController/login',
			data : loginForm.serialize(),
			dataType : 'json',
			beforeSend : function(XMLHttpRequest) {
				if (isEmpty(loginForm.find('input[name=name]').val()) || isEmpty(loginForm.find('input[name=pwd]').val())) {
					$('#errorMessage').modal({
						show : true
					});
					return false;
				} 
			},
			success : function(json) {
				if (json.success) {
					window.location.href = "${pageContext.request.contextPath}/Index";
				} else {
					$('#errorMessages').modal({
						show : true
					});
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="login">
		<div class="box png">
			<form id="user_login_loginForm" method="post">
				<div class="header">
					<h2 class="logo png">
						<a href="#http://dolphin.com" target="_blank"></a>
					</h2>
					<span class="alt">管理员登录</span>
				</div>
				<ul>
					<li><label>用户名</label><input name="name" type="text" id="text" class="easyui-validatebox"
						data-options="required:'true',missingMessage:'登陆名称必填'" />
					</li>
					<li><label>密 码</label><input name="pwd" type="password" id="text" class="easyui-validatebox"
						data-options="required:'true',missingMessage:'密码必填'" />
					</li>
					<li class="submits"><input class="submit" type="button" value="登录" onclick="_submit();" />
					</li>
				</ul>
				<div class="copyright">&copy; 2012 - 2015</div>
			</form>
		</div>
		<div class="air-balloon ab-1 png"></div>
		<div class="air-balloon ab-2 png"></div>
		<div class="footer"></div>
	</div>

	<script type="text/javascript" src="jslib/fun.base.js"></script>
	<script type="text/javascript" src="jslib/login.js"></script>

	<!--[if lt IE 8]>
<script src="jslib/PIE.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
    if (window.PIE && ( $.browser.version >= 6 && $.browser.version < 10 )){
        $('input.text,input.submit').each(function(){
            PIE.attach(this);
        });
    }
});
</script>
<![endif]-->

	<!--[if IE 6]>
<script src="jslib/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->


	<div class="modal hide fade" id="errorMessage">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>警告</h3>
		</div>
		<div class="modal-body">
			<p>用户名与密码都不能为空</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" onclick="$('#errorMessage').modal('hide')">关闭</a>
		</div>
	</div>

	<div class="modal hide fade" id="errorMessages">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>警告</h3>
		</div>
		<div class="modal-body">
			<p>用户名或密码错误</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" onclick="$('#errorMessages').modal('hide')">关闭</a>
		</div>
	</div>
</body>
</html>