<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>

<title>南邮ERP专属网站</title>
<jsp:include page="incB.jsp"></jsp:include>
<style>
h2 a:LINK {
	color: black;
	text-decoration: none;
}

h2 a {
	color: black;
	text-decoration: none;
}
</style>

<script type="text/javascript">
	function register() {
		window.setTimeout(function() {
			window.location.href = "${pageContext.request.contextPath}/jsp/register.jsp";
		}, 0);
	}
	
	function fushimigndan(){
		window.setTimeout(function() {
			window.location.href = "${pageContext.request.contextPath}/jsp/fushimingdan.jsp";
		}, 0);
	}
</script>
</head>

<body>

	<div class="container">
		<div style="height:50px"></div>
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="#">ERP</a>
					<ul class="nav">
						<li class="active"><a href="#">首页</a>
						</li>
						<li><a href="#">ERP简介</a>
						</li>
						<li><a href="#">获得奖项</a>
						</li>
						<li><a href="#">有趣活动</a>
						</li>
					</ul>

					<ul class="nav pull-right">
						<li><a href="#login" data-toggle="modal">登陆</a>
						</li>
						<li class="divider-vertical"></li>
						<li><a href="#sign" data-toggle="modal">注册</a>
						</li>
					</ul>
				</div>

			</div>
		</div>

		<div class="modal hide fade" id="login">
			<div class="modal-header">
				<a href="#" class="close" data-dismiss="modal">×</a>
				<h4>嘿嘿，man</h4>
			</div>
			<div class="modal-body">
				<div>
					这个<span style="color:red">登陆</span>功能还没有开发哦，等一会儿吧~
				</div>
			</div>
		</div>

		<div class="modal hide fade" id="sign">
			<div class="modal-header">
				<a href="#" class="close" data-dismiss="modal">×</a>
				<h4>嘿嘿，man</h4>
			</div>
			<div class="modal-body">
				<div>
					这个<span style="color:red">注册</span>功能还没有开发哦，等一会儿吧~
				</div>
			</div>
		</div>

		<h1 class="page-header">
			ERP协会首页&nbsp;&nbsp;&nbsp;<small>校科协直属社团</small>
		</h1>

		<div class="row">
			<div class="span3"></div>
			<input type="submit" class="btn btn-primary btn-large span6" value="新生通道：我要报名" onclick="register();" />
		</div>
		<div class="row">
			<div class="span3">·</div>
		</div>
		<div class="row">
			<div class="span3"></div>
			<input type="submit" class="btn btn-primary btn-large span6" value="复试名单，请猛戳这里" onclick="fushimigndan();" />
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="span3">
				<h2 class="page-header">
					<a href="jsp/fenjibu.jsp">分析技术部</a>
				</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;借助数据的力量进行决策，我们不再靠经验判断！分技部通过对excel，spss等的培训帮助培养会员建立对数据的敏感性，形成理性判断的习惯。有时，事情没你想像的那么难！</p>
			</div>
			<div class="span3">
				<h2 class="page-header">
					<a href="jsp/shangyanbu.jsp">商业案例研究部</a>
				</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;部门宣言：众多的商业案例，科学的分析研究，让我们一起领航时代的潮流。 如果你也想成为明日大家眼中的大神，那还在等什么？？？</p>
			</div>
			<div class="span3">
				<h2 class="page-header">
					<a href="jsp/waixuanbu.jsp">外联宣传部</a>
				</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;地位：
					外宣部是ERP协会对外展示的重要窗口，也是协会举办活动的经济支撑之一。在前几位部长的精心领导下，外宣部得以发展到现在。外宣部今后将继续秉承继往开来的精神，为协会的发展壮大作出努力。</p>
			</div>
			<div class="span3">
				<h2 class="page-header">
					<a href="jsp/bangongshi.jsp">办公室</a>
				</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;每一支强队，都需要一批细心的人做着琐碎繁杂的工作。我们磨练意志，我们踏实肯干，我们德才兼备。我们愿做那最坚强的支撑，祝南邮ERP勇往直前！</p>
			</div>
		</div>
		<div style="height:50px"></div>
		<blockquote class="pull-right">
			<p>作为ERP协会的主席，希望大家能像一家人一样在这个协会中学习生活。加入我们，我们需要你！</p>
			<small>陈雨豪<cite>2013年会长</cite> </small>
			<p>读好书，交高人，天道酬勤！ERP是一个家庭，也是一个平台，为我们更加好的未来提供一种可能。</p>
			<small>赵一荣<cite>2012年会长</cite> </small>
		</blockquote>
	</div>

	<div class="container">
		<div class="row">
			<div class="span3">
				<h4 class="page-header">ERP协会合作伙伴</h4>
				——南邮人自己的校园App：
			</div>
		</div>
		<div class="row">
			<div class="span3"></div>
			<div class="span3">
				<h2 class="page-header">
					<a href="http://www.cpsdna.com/clients/iNUPT.apk"><img src="images/inupt.png" />iNUPT-安卓版</a>
				</h2>
			</div>
			<div class="span3">
				<h2 class="page-header">
					<a href="http://www.cpsdna.com/clients/iNUPT.ipa"><img src="images/inupt.png" />iNUPT-iOS版</a>
				</h2>
			</div>
			<div class="span3"></div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
