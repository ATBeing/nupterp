<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
<head>

<title>外联宣传部主页</title>
<jsp:include page="../incB.jsp"></jsp:include>
<link href="../css/waixuanbu.css" rel="stylesheet">
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<div id="home">
					<a class="brand" href="waixuanbu.jsp">外联宣传部的家</a>
				</div>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="../index.jsp">Home(返回主页)</a></li>
						<li><a href="#">部门介绍</a></li>
						<li><a href="#">部门成员</a></li>
						<li><a href="#">活动</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">About Ours <b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="#">事件1</a></li>
								<li><a href="#">事件2</a></li>
								<li><a href="#">事件3</a></li>
								<li class="divider"></li>
								<li class="nav-header">导航</li>
								<li><a href="#">事件4</a></li>
								<li><a href="#">事件5</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>外联宣传部</h1>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;一 地位：
				外宣部是ERP协会对外展示的重要窗口，也是协会举办活动的经济支撑之一。在前几位部长的精心领导下，外宣部得以发展到现在。外宣部今后将继续秉承继往开来的精神，为协会的发展壮大作出努力。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二 组织形式：部长两位及所属部员</p>
			<p>
				<a href="#" class="btn btn-primary btn-large">更靠近我们 &raquo;</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>三 职能：</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;除接受与其他部门相同的技能培训外，通过人人网，微博等新媒体进行宣传，印发传单，组织招新；举办相关的各类比赛，与其他部门或社团联合举办活动等。</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>四 未来展望与特色活动：</h2>
				<p>1将恢复例会</p>
				<p>2加强时间观念</p>
				<p>3组织户外拓展特色活动</p>
				<p>4外宣部与其他部门在内部培训时，会针对一些今后在工作中可能要用到的软件进行培训，如spass</p>
				<p>5除了对金蝶，用友的培训之外，还可以针对大家比较感兴趣软件与其他部门一起进行培训，如PPT,Word,Excel之类的办公软件或者是Photoshop等一些制作方面的软件 。</p>
				<p>6定期进行部内和部门之间的比赛，以此考核大家对金蝶，用友的熟练程度。</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>五 部门宣言：</h2>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;胆大心细、文武兼得，在忙碌的工作中寻找真正的自我。</p>
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
