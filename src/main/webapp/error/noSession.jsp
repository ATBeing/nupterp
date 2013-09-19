<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
				window.location.href = "http://nyerp.sinaapp.com/login.jsp";
			}
		}, 1000);
	}
</script>
<div id="f">
	<h1>
		登录超时：<br> 5秒后自动跳转。当前还剩<span id="num">5</span>秒。
	</h1>
</div>