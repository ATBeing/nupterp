<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<title>复试名单安排</title>
<jsp:include page="../incB.jsp"></jsp:include>
<script type="text/javascript">
	function downloadExcel() {
		window.setTimeout(function() {
			window.location.href = "${pageContext.request.contextPath}/download/fushi.xls";
		}, 0);
	}
</script>
</head>

<body>
	<div class="container">
		<h1 class="page-header">复试名单安排</h1>
		<div class="row">
			<div class="span3"></div>
			<input type="submit" class="btn btn-primary btn-large span6" value="复试名单Excel表，请猛戳这里" onclick="downloadExcel();" />
		</div>
		
		<div class="row">
			<div class="span3">·</div>
		</div>

		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>组别：</th>
					<th>姓名</th>
					<th>手机</th>
				</tr>
			</thead>
			<tr>
				<td>第一组</td>
				<td>沈启明</td>
				<td>18351925110</td>
				<td>李卓颖</td>
				<td>18351922152</td>
				<td>华建勋</td>
				<td>18351929122</td>
				<td>管楹</td>
				<td>18351928802</td>
				<td>安冰强</td>
				<td>18351926019</td>
				<td>戴骊润</td>
				<td>18351925802</td>
			</tr>
			<tr>
				<td>第二组</td>
				<td>王志豪</td>
				<td>18361456289</td>
				<td>甄帅</td>
				<td>18351929289</td>
				<td>崔建树</td>
				<td>18351927956</td>
				<td>戈书杰</td>
				<td>18351928680</td>
				<td>丽丽</td>
				<td>15951917686</td>
				<td>刘颖</td>
				<td>18351925583</td>
			</tr>
			<tr>
				<td>第三组</td>
				<td>方晓纯</td>
				<td>18351927231</td>
				<td>张蕾</td>
				<td>18351926607</td>
				<td>史俊鹏</td>
				<td>18351925989</td>
				<td>丁馨</td>
				<td>18351928505</td>
				<td>崔艺铭</td>
				<td>18351928075</td>
				<td>陆柏羽</td>
				<td>18351923171</td>
			</tr>
			<tr>
				<td>第四组</td>
				<td>孙国栋</td>
				<td>15951918003</td>
				<td>王菊</td>
				<td>18351922199</td>
				<td>黎国使</td>
				<td>18351927302</td>
				<td>杨尚书</td>
				<td>18351926102</td>
				<td>周巧婷</td>
				<td>18351921572</td>
				<td>韩欣卉</td>
				<td>18351927110</td>
			</tr>
			<tr>
				<td>第五组</td>
				<td>倪蔡飞</td>
				<td>18351925772</td>
				<td>于晨光</td>
				<td>15006313456</td>
				<td>焦露平</td>
				<td>15951908327</td>
				<td>陶靓</td>
				<td>18351928512</td>
				<td>杨曦文</td>
				<td>18351925972</td>
				<td>缪晓丹</td>
				<td>18351925699</td>
			</tr>
			<tr>
				<td>第六组</td>
				<td>茅心怡</td>
				<td>18351925781</td>
				<td>徐丹</td>
				<td>18351928952</td>
				<td>冷卓</td>
				<td>18585362493</td>
				<td>黄崎凯</td>
				<td>18351921677</td>
				<td>李月</td>
				<td>18351929255</td>
				<td>王志刚</td>
				<td>18351926703</td>
			</tr>
			<tr>
				<td>第七组</td>
				<td>顾岩</td>
				<td>18351927929</td>
				<td>彭韵琪</td>
				<td>18351926557</td>
				<td>苏景源</td>
				<td>15358549168</td>
				<td>陈昶君</td>
				<td>18351927255</td>
				<td>邱瑶</td>
				<td>18351925737</td>
				<td>王冰冰</td>
				<td>18351922356</td>
			</tr>
			<tr>
				<td>第八组</td>
				<td>夏颖</td>
				<td>18351929050</td>
				<td>纪超</td>
				<td>18120117911</td>
				<td>谢祎玮</td>
				<td>18351926179</td>
				<td>屈秋梅</td>
				<td>18351922251</td>
				<td>闵昌达</td>
				<td>18351926795</td>
				<td>吴义令</td>
				<td>18351922561</td>
			</tr>
			<tr>
				<td>第九组</td>
				<td>韩瑞东</td>
				<td>18351929266</td>
				<td>王娟</td>
				<td>18351928772</td>
				<td>黄杨东</td>
				<td>15951911606</td>
				<td>郝慧杰</td>
				<td>18351929282</td>
				<td>陈伊欣</td>
				<td>18351927233</td>
				<td>黄宏星</td>
				<td>18351921629</td>
			</tr>
			<tr>
				<td>第十组</td>
				<td>阚海波</td>
				<td>18351926509</td>
				<td>黄钰淇</td>
				<td>18351927285</td>
				<td>汪希祥</td>
				<td>18351926522</td>
				<td>李婧</td>
				<td>18351922787</td>
				<td>余尚强</td>
				<td>18664065839</td>
				<td>韩旭</td>
				<td>18351928862</td>
			</tr>
			<tr>
				<td>第十一组</td>
				<td>白智博</td>
				<td>15951917883</td>
				<td>张爱爱</td>
				<td>18351929332</td>
				<td>李媛慧</td>
				<td>18351929056</td>
				<td>尤志凌</td>
				<td>18932369333</td>
				<td>高嵩</td>
				<td>18351928729</td>
				<td>李诗雅</td>
				<td>15951907350</td>
			</tr>
			<tr>
				<td>第十二组</td>
				<td>张绮璇</td>
				<td>18351926802</td>
				<td>卢小涵</td>
				<td>18351927330</td>
				<td>刘畅</td>
				<td>18351926523</td>
				<td>张亚宁</td>
				<td>18351926283</td>
				<td>方胜</td>
				<td>18351926521</td>
				<td>佘倩倩</td>
				<td>18351925761</td>
			</tr>
			<tr>
				<td>第十三组</td>
				<td>庄珹</td>
				<td>18351922716</td>
				<td>陈滢</td>
				<td>18351925830</td>
				<td>黄蒙</td>
				<td>18351927965</td>
				<td>徐新杰</td>
				<td>18351928813</td>
				<td>王佳雯</td>
				<td>15365230019</td>
				<td>吴瑶</td>
				<td>18260045172</td>
			</tr>
			<tr>
				<td>第十四组</td>
				<td>王久春</td>
				<td>18351923290</td>
				<td>张莲文</td>
				<td>18351926880</td>
				<td>朱斌</td>
				<td>15951900785</td>
				<td>刘丽蓉</td>
				<td>15951907319</td>
				<td>胡政涛</td>
				<td>18351929167</td>
				<td>李琦</td>
				<td>18351928530</td>
			</tr>
			<tr>
				<td>第十五组</td>
				<td>胡申煜</td>
				<td>18351925306</td>
				<td>杜学明</td>
				<td>15951907287</td>
				<td>靳利成</td>
				<td>18351922069</td>
				<td>吴丹</td>
				<td>15951905619</td>
				<td>刘笑笑</td>
				<td>18351925831</td>
				<td>讦敏</td>
				<td>18351928829</td>
			</tr>
			<tr>
				<td>第十六组</td>
				<td>周莹莹</td>
				<td>18351928551</td>
				<td>李彩玲</td>
				<td>18351929365</td>
				<td>高罗娜</td>
				<td>18351928739</td>
				<td>杨雨清</td>
				<td>18351928209</td>
				<td>贾欢</td>
				<td>15951905991</td>
				<td>马军</td>
				<td>15951916305</td>
			</tr>
			<tr>
				<td>第十七组</td>
				<td>信迪</td>
				<td>18351926080</td>
				<td>孙怡忱</td>
				<td>15951907309</td>
				<td>钟欢</td>
				<td>15951915381</td>
				<td>刘博文</td>
				<td>18351926560</td>
				<td>何金宝</td>
				<td>18647294738</td>
				<td>孟凡迪</td>
				<td>18351928759</td>
			</tr>
			<tr>
				<td>第十八组</td>
				<td>姜德志</td>
				<td>18351927366</td>
				<td>陆蕾</td>
				<td>18351928565</td>
				<td>林少燕</td>
				<td>18351921621</td>
				<td>姜娅</td>
				<td>18351925866</td>
				<td>王绍铎</td>
				<td>18351925909</td>
				<td>徐子博</td>
				<td>15957875555</td>
			</tr>
			<tr>
				<td>第十九组</td>
				<td>李瑶康</td>
				<td>18351922209</td>
				<td>刘士伟</td>
				<td>18351925985</td>
				<td>李青青</td>
				<td>18351921809</td>
				<td>龙威</td>
				<td>18351926755</td>
				<td>刘瑞鹏</td>
				<td>18351925937</td>
				<td>李智</td>
				<td>18351921633</td>
				<td>鲁泽阳</td>
				<td>18351921851</td>
			</tr>
			<tr>
				<td>第二十组</td>
				<td>徐辉</td>
				<td>15951916807</td>
				<td>刘畅</td>
				<td>13934568660</td>
				<td>陈峰</td>
				<td>18351925006</td>
				<td>吉祥</td>
				<td>15951917537</td>
				<td>印宇静</td>
				<td>18351925331</td>
				<td>周圆</td>
				<td>18351926295</td>
				<td>徐阳</td>
				<td>13115018619</td>
			</tr>
			<tr>
				<td>第二十一组</td>
				<td>阮适仲</td>
				<td>18351927221</td>
				<td>杨博</td>
				<td>15951907290</td>
				<td>李刚</td>
				<td>18351927116</td>
				<td>王永芳</td>
				<td>18351929176</td>
				<td>李金泽</td>
				<td>18351926801</td>
				<td>赵唯唯</td>
				<td>15951910310</td>
				<td>蔡守杰</td>
				<td>18351926129</td>
			</tr>


		</table>

	</div>

</body>
</html>