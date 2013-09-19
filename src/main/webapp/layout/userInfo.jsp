<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	var pwd;
	var pwdd;
	$(function() {
		pwd = $('#pwd').validatebox({
			required : true,
			delay : 10,
			deltaX : 10
		});

	});
</script>
<div id="userInfo">
	<form method="post">
		<input name="id" type="hidden" value="${sessionInfo.id}" />
		<table class="tableForm">
			<tr>
				<th style="width: 130px;">登录名</th>
				<td><input readonly="readonly" value="${sessionInfo.name}" />
				</td>
			</tr>
			<tr>
				<th>修改密码<br>
				<span style="color:red">(不想修改可以不填)</span>
				</th>
				<td><input id="pwd" name="pwd" type="password" />
				</td>
			</tr>
			<tr>
				<th><span style="color:red">再输入一次修改的密码</span>
				</th>
				<td><input type="password" class="easyui-validatebox"
					data-options="required:'true',missingMessage:'请再次填写密码',validType:'eqPwd[\'#userInfo input[name=pwd]\']'" />
				</td>
			</tr>
		</table>
	</form>
</div>