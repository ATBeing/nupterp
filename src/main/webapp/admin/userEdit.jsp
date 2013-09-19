<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var role;
	$(function() {
		role = $('#role').combobox({
			panelHeight : 100,
			valueField : 'role',
			textField : 'roleName',
			data : [ {
				role : 'admin',
				roleName : '管理员'
			}, {
				role : 'guest',
				roleName : '游客'
			}, {
				role : 'HR',
				roleName : 'HR'
			} ]
		});
	});
</script>
<div>
	<form id="admin_userEdit_form" method="post">
		<input name="id" readonly="readonly" hidden="true" style="display:none" />
		<table>
			<tr>
				<th>用户名称</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:'true'" /></td>
			</tr>
			<tr>
				<th>学号</th>
				<td><input name="sid" class="easyui-validatebox" data-options="required:'true'" />
				</td>
			</tr>
			<tr>
				<th>角色</th>
				<td><input id="role" name="role"></td>
			</tr>
		</table>
	</form>
</div>
