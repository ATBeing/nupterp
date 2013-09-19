<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>分析技术部主页</title>
<jsp:include page="../incB.jsp"></jsp:include>
<link href="../css/fenjibu.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3 class="muted">分析技术部的家</h3>
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<li class="active"><a href="../index.jsp">Home(返回主页)</a></li>
							<li><a href="#">部门简介</a></li>
							<li><a href="#">部门成员</a></li>
							<li><a href="#">活动</a></li>
							<li><a href="#">过往事迹</a></li>
							<li><a href="#">About Ours</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /.navbar -->
		</div>

		<!-- Jumbotron -->
		<div class="jumbotron">
			<h1>分技部</h1>
			<p class="lead">借助数据的力量进行决策，我们不再靠经验判断！分技部通过对excel，spss等的培训帮助培养会员建立对数据的敏感性，形成理性判断的习惯。有时，事情没你想像的那么难！</p>
			<p>现有部长林棋栋&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;副部长邓嘉琪</p>
			<a class="btn btn-large btn-success" href="#">Go</a>
		</div>

		<hr>

		<!-- Example row of columns -->
		<div class="row-fluid">
			<div class="span4">
				<h2>Spssp培训</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;通过对软件的培训，部员可以进行简单的问卷调查进行统计，整理。</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>第五届尖峰时刻模拟经营大赛</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;前任主席与，前任分技部部长、副部长参加了有华北电力大学与中国石油大学主办的第五届尖峰时刻比赛，获得丰富的比赛经验并与其它院校进行了相关交流，并取得全国二等奖的成绩。</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>梅花谷之行</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;三月初，协会一同前去梅花谷观光游览。与部员一起游玩，品赏梅花之资，自有“任他桃李争欢赏，不为繁华易素心。”的情怀于心。</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
		</div>

		<hr>


	</div>
	<!-- /container -->

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
