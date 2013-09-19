<%@ page language="java" pageEncoding="UTF-8"%>
<div>
	<form id="admin_regAdd_form" method="post">
		<input name="id" readonly="readonly" hidden="true" style="display:none" />
		<table>
			<tr>
				<th>用户名称</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:'true'" />
				</td>
			</tr>
			<tr>
				<th>学号</th>
				<td><input name="sid" type="text" class="easyui-validatebox"
					data-options="required:'true'" />
				</td>
			</tr>
			<tr>
				<th>手机</th>
				<td><input name="phone" class="easyui-validatebox easyui-numberbox"
					data-options="required:'true'"/>
				</td>
			</tr>
			<tr>
				<th>性别</th>
				<td><input id="sex" name="sex"></td>
			</tr>
			<tr>
				<th>专业</th>
				<td><input id="major" name="major"></td>
			</tr>
			<tr>
				<th>qq</th>
				<td><input id="qq" name="qq" class="easyui-numberbox"></td>
			</tr>
			<tr>
				<th>部门意向</th>
				<td><input id="departments" name="departments"></td>
			</tr>
			<tr>
				<th>特长</th>
				<td><textarea id="speciality" name="speciality" cols="50" rows="5"></textarea></td>
			</tr>
		</table>
	</form>
</div>
