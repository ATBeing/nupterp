<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var admin_reg_datagrid;

	$(function() {
		admin_reg_datagrid = $('#admin_reg_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/registerController/dataGrid',
			fit : true,
			fitColumns : true,//使得列之间相互充满，当列比较多的时候不要使用
			cache : false,
			nowrap : false,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'sid',
			sortOrder : 'asc',
			checkOnSelect : true,//选为false时，点击行不会选中复选框
			selectOnCheck : false,//为false时，点击复选框，不让选中行
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 10,
				checkbox : true
			}, {
				field : 'name',
				title : '登录名称',
				width : 80,
				sortable : true,
			} ] ],
			columns : [ [ {
				field : 'sid',
				title : '学号',
				width : 80
			}, {
				field : 'sex',
				title : '性别',
				width : 100
			},{
				field : 'major',
				title : '专业',
				width : 100
			},{
				field : 'phone',
				title : '手机号',
				width : 100
			}, {
				title : 'qq',
				field : 'qq',
				width : 100
			} , {
				title : '部门意向',
				field : 'departments',
				width : 100
			}, {
				title : '特长',
				field : 'speciality',
				width : 100
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					appendReg();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					removeReg();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					editReg();
				}
			}, '-' ],
			loadFilter : function(data) {
				if (data !=null ) {
					return data;
				}else{
					$.messager.alert('提示', '查询数据不存在，请确认查询条件后再查询', 'error');
					data={"rows":[],"total":0};
					return data;
				}
			},
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});

	function editReg() {//动态加载节点，最后要销毁节点
		var rows = admin_reg_datagrid.datagrid('getChecked');//记录选中的行的信息
		if (rows.length == 1) {
			var p = parent.sy.dialog({
				width : 600,
				height : 500,
				href : '${pageContext.request.contextPath}/registerController/editPage',
				modal : true,
				title : '编辑用户',
				buttons : [ {
					text : '编辑',
					handler : function() {
						var f = p.find('form');
						f.form('submit', {
							url : '${pageContext.request.contextPath}/registerController/edit',
							success : function(d) {
								var json = $.parseJSON(d);
								if (json.success) {
									admin_reg_datagrid.datagrid('reload');
									p.dialog('close');
								}
								$.messager.show({
									title : '提示',
									msg : json.msg
								});
							}
						});
					}
				} ],
				onLoad : function() {//用动态加载时，用onLoad事件做数据填充
					var f = p.find('form');
					f.form('load', rows[0]);
				}
			});
		} else if (rows.length > 1) {
			$.messager.alert('提示', '请选择一条记录进行编辑！', 'error');
		} else {
			$.messager.alert('提示', '请选择要编辑的记录！', 'error');
		}
	}

	function searchFun() {
		//序列化查询参数
		admin_reg_datagrid.datagrid('load', serializeObject($('#admin_reg_searchForm')));
	}
	function clearFun() {
		$('#admin_reg_layout').find('input[name=name]').val('');
		admin_reg_datagrid.datagrid('load', {});
	}
	function appendReg() {
		var p = parent.sy.dialog({
			title : '添加用户',
			href : '${pageContext.request.contextPath}/registerController/addPage',
			width : 600,
			height : 500,
			buttons : [ {
				text : '添加',
				handler : function() {
					var f = p.find('form');
					f.form('submit', {
						url : '${pageContext.request.contextPath}/registerController/add',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								admin_reg_datagrid.datagrid('reload');
								p.dialog('close');
							}
							parent.sy.messagerShow({
								msg : json.msg,
								title : '提示'
							});
						}
					});
				}
			} ]
		});
	}

	function removeReg() {
		var rows = admin_reg_datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/registerController/delete',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(r) {
							admin_reg_datagrid.datagrid('load');
							admin_reg_datagrid.datagrid('unselectAll');
							$.messager.show({
								title : '提示',
								msg : r.msg
							});
						}
					});
				}
			});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要删除的记录！'
			});
		}
	}
</script>
<div id="admin_reg_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 80px;">
		<form id="admin_reg_searchForm">
			检索用户名称(可模糊查询)：<input name="name" /> <a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a> <a
				href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true"
				onclick="clearFun();">清空</a>
		</form>
	</div>

	<div data-options="region:'center',border:false">
		<table id="admin_reg_datagrid"></table>
	</div>
	
	<div id="menu" class="easyui-menu" style="width:120px;display: none;">
		<div onclick="appendReg();" data-options="iconCls:'icon-add'">增加</div>
		<div onclick="removeReg();" data-options="iconCls:'icon-remove'">删除</div>
		<div onclick="editReg();" data-options="iconCls:'icon-edit'">编辑</div>
	</div>
</div>