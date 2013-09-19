<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新生数据导入导出</title>
<jsp:include page="../inc.jsp"></jsp:include>

<script type="text/javascript" charset="UTF-8">
	$(function() {
		$('#regIO_fileform_reg').form({
			url : '${pageContext.request.contextPath}/importController/importRegisterExcel',
			success : function(r) {
				var json = jQuery.parseJSON(r);
				$.messager.show({
					title : '提示',
					msg : json.msg
				});
			}
		});
		$('#regIO_fileform_user').form({
			url : '${pageContext.request.contextPath}/importController/importUserExcel',
			success : function(r) {
				var json = jQuery.parseJSON(r);
				$.messager.show({
					title : '提示',
					msg : json.msg
				});
			}
		});
		
		window.setTimeout(function(){
			parent.$.messager.progress('close');
		}, 0);

	});
</script>
<link rel="stylesheet" href="../css/regIO.css">
</head>
<body>
	<div>
		<div id="export_excel_reg">
			<p class="excel">导出所有新生数据</p>
			<a id="btn" href="${pageContext.request.contextPath}/exportController/exportRegisterToExcel"
				class="easyui-linkbutton" data-options="iconCls:'icon-redo'">导出</a> &nbsp;&nbsp;&nbsp;&nbsp; <a id="btn1"
				href="${pageContext.request.contextPath}/exportController/exportRegisterModel" class="easyui-linkbutton"
				data-options="iconCls:'icon-redo'">导出新生填写资料的Excel模版</a>
		</div>
	<!--  	<div id="import_excel_reg">
			<form id="regIO_fileform_reg" method="post" enctype="multipart/form-data">
				<label for="regIO_file" class="excel">选择要导入的Excel文件:</label> <br> <br> <input type="file" name="file"
					id="regIO_file" size="8" /> <br> <br> <input type="button" value="导入数据"
					onclick="$('#regIO_fileform').submit(); " />
			</form>
		</div>-->
		<div id="clear"></div>
	</div>
<!--<div>
		<div id="export_excel_user">
			<p class="excel">导出用户数据</p>
			<a id="btn_user" href="${pageContext.request.contextPath}/exportController/exportUserToExcela"
				class="easyui-linkbutton" data-options="iconCls:'icon-redo'">导出</a> &nbsp;&nbsp;&nbsp;&nbsp; <a id="btn1_user"
				href="${pageContext.request.contextPath}/exportController/exportUserModela" class="easyui-linkbutton"
				data-options="iconCls:'icon-redo'">导出用户模版</a>
		</div>
		<div id="import_excel_user">
			<form id="regIO_fileform_user" method="post" enctype="multipart/form-data">
				<label for="regIO_file_user" class="excel">选择要导入的Excel文件:</label> <br> <br> <input type="file" name="file"
					id="regIO_file_user" size="8" /> <br> <br> <input type="button" value="导入用户数据"
					onclick="$('#regIO_fileform_user').submit(); " />
			</form>
		</div>
		
		<div id="clear"></div>
	</div>-->
</body>
</html>