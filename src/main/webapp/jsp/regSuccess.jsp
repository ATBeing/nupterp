<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../incB.jsp"></jsp:include>
<script>
	window.onload = function() {
		jump(5);
	};
	function jump(count) {
		window.setTimeout(function() {
			count--;
			if (count > 0) {
				document.getElementById("num").innerHTML = count;
				jump(count);
			} else {
				window.location.href = "${pageContext.request.contextPath}/index.jsp";
			}
		}, 1000);
	}
</script>
<div class="container">
	<h1 class="page-header">报名成功</h1>
	<h3><span class="label label-success">报名成功</span></h3>
	<h3 class="span6">
		在 5秒后自动跳转。当前还剩<span id="num" class="" style="font-size:100px;color:red;">5</span>秒。
	</h3>
</div>