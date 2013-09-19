<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>ERP协会招新表</title>
<jsp:include page="../incB.jsp"></jsp:include>
<script type="text/javascript">
	var registerForm;
	$(function() {
		registerForm = $('#registerForm');
		window.setTimeout(function() {
			registerForm.find('input[name=sid]').focus();
		}, 0);
	});
	
	function isEmpty( inputStr ) { if ( null == inputStr || "" == inputStr ) { return true; } return false; }
	
	function _submit() {
		$.ajax({
			url : '${pageContext.request.contextPath}/registerController/noSession_add',
			data : registerForm.serialize(),
			dataType : 'json',
			beforeSend : function(XMLHttpRequest) {
				if (isEmpty(registerForm.find('input[name=name]').val()) || isEmpty(registerForm.find('input[name=sid]').val() ) || isEmpty(registerForm.find('input[name=phone]').val())) {
					$('#errorMessage').modal({
						show : true
					});
					return false;
				}
			},
			success : function(json) {
				if (json.success) {
					window.location.href = "${pageContext.request.contextPath}/jsp/regSuccess.jsp";
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
	<div class="container" style="overflow: hidden;">
		<h1 class="page-header">ERP协会招新表</h1>
		<form class="form-horizontal" id="registerForm" method="post">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="sid">学号：</label> <input type="text" id="sid" name="sid" placeholder="请输入您的学号"
						class="span3" />
				</div>
				<div class="control-group">
					<label class="control-label" for="sid">姓名：</label> <input type="text" id="name" name="name" placeholder="请输入您的姓名"
						class="span3" />
				</div>
				<div class="control-group">
					<label class="control-label" for="sid">性别：</label> <input type="radio" name="sex" value="女" />女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="男" />男
				</div>
				<div class="control-group">
					<label class="control-label" for="major">专业：</label> <input type="text" id="major" name="major"
						placeholder="请输入您的专业" class="span3" />
				</div>
				<div class="control-group">
					<label class="control-label" for="phone">手机：</label> <input type="text" id="phone" name="phone"
						placeholder="请输入您的手机号" class="span3" />
				</div>
				<div class="control-group">
					<label class="control-label" for="qq">qq：</label> <input type="text" id="qq" name="qq" placeholder="请输入您的qq"
						class="span3 easyui-numberbox" />
				</div>
				<div class="control-group">
					<label class="control-label" for="departments">部门意向：</label> <input type="text" id="departments" name="departments"
						placeholder="请输入您希望加入的部门" class="span3" />
				</div>
				<div class="control-group">
					<label class="control-label" for="speciality">特长：</label>
					<textarea id="speciality" name="speciality" placeholder="请输入您的特长，比如：计算机，文字功底，演讲等" class="span6"></textarea>
				</div>
			</fieldset>

			<div class="form-actions">
				<input type="button" class="btn btn-primary" onclick="_submit();" value="提交" />
			</div>
		</form>
	</div>


	<div class="modal hide fade" id="errorMessage">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>警告</h3>
		</div>
		<div class="modal-body">
			<p>学号，姓名，手机号都不能为空</p>
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
			<p>已经有您填写的学号学生注册了，如果不是您本人，请直接到ERP招新人员处报名</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" onclick="$('#errorMessages').modal('hide')">关闭</a>
		</div>
	</div>
</body>
</html>
