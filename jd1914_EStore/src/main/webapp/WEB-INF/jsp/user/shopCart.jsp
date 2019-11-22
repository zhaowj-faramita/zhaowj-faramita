<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.sql.Connection,
    java.sql.Statement,
    java.sql.ResultSet"%>
<%
	StringBuilder builder = new StringBuilder();
	builder.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
			.append(request.getServerPort()).append(request.getContextPath()).append("/");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%=builder.toString()%>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>购物车页面</title>
<link rel="stylesheet" href="css/fullCar.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/shopCar.css">
<script type="text/javascript">
	function submitUpdate(){
		document.getElementById("updateShopCar").submit();
	}
</script>
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">
			<c:if test="${not empty sessionScope.customer}">
				<ul class="top_bars">
					<li><a href="Offline">退出</a>|</li>
					<li><a href="#">${customer.name}</a>|</li>
					<li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
					<li><a href="#">网站导航<span class="jt_down"></span></a></li>
				</ul>
			</c:if>
			<c:if test="${empty sessionScope.customer}">
				<ul class="top_bars">
					<li><a href="login">登录</a>|</li>
					<li><a href="register">注册</a>|</li>
				</ul>
			</c:if>
		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<a href="#"><img src="images/logo.png" class="oneImg"></a>


		<div class="h3_right">
			<img src="images/play_03.png" alt="">
		</div>

	</div>
	<!--中间部分div-->
	<div class="empty">
		<div class="peisong">
			<pre>全部商品 </pre>
		</div>
		<div class="mainCenter">
			<div class="allCheck">
				<input type="checkbox">
				<p>全选</p>
				<p class="leftM">商品</p>
				<p class="rightM">单价(元)</p>
				<p class="rightM">数量</p>
				<p class="rightM">小计(元)</p>
				<p class="rightM">操作</p>
			</div>
			<div class="mainPro">
				<div class="aa">
					<input type="checkbox"><span id="but">自营</span>
				</div>
				<%int maxNum = 0,maxPrice = 0; %>
				<c:forEach var="orderLines" items="${sessionScope.ShopCar}" begin="0" end="3" varStatus="n">
					<form action="UpdateShopCar?id=${n.index+1}" id="updateShopCar" method="post">
						<table>
							<tbody>
								<tr>
									<td class="index">&nbsp;&nbsp;&nbsp;${n.index+1}</td>
									<td><img src="images/1.png"> <span>
											${orderLines.book.name}<br>
									</span></td>
									<td><span> ${orderLines.book.price} </span></td>
									<td class="index2"><input type="text" value="${orderLines.num}" name="newNum" class="index2_input"/>
										<br> <span>有货</span></td>
									<td ><span >${orderLines.cost}</span></td>
									<td>
										<button type="button" onclick="submitUpdate()">更新</button>
										<button type="button"><a href="RemoveShopCar?id=${n.index+1}">取消</a></button>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
					<%maxNum++;%>
				</c:forEach>


			</div>
			<div class="allButtom">
				<!-- <p class="caozuo">去结算</p> -->
				<!-- <input value="去提交" class="caozuo" type="submit"> -->
				<a href="user/confirm" class="caozuo">去提交</a> <span>已选择<font><%=maxNum%></font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：<font>¥
				${0+sessionScope.maxPrice}
				元</font></span>
			</div>

		</div>

	</div>
	</div>


	<!--脚部-->
	<div class="footer3">
		<div class="f3_top">
			<div class="f3_center">
				<div class="ts1">品目繁多 愉悦购物</div>
				<div class="ts2">正品保障 天天低价</div>
				<div class="ts3">极速物流 特色定制</div>
				<div class="ts4">优质服务 以客为尊</div>
			</div>
		</div>
		<div class="f3_middle">
			<ul class="f3_center">
				<li class="f3_mi_li01">
					<h1>购物指南</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>配送方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>支付方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>售后服务</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>服务保障</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li06">
					<h1>客服中心</h1> <img src="images/qrcode_jprj.jpg" width="80px"
					height="80px">
					<p>抢红包、疑问咨询、优惠活动</p>
				</li>
			</ul>
		</div>
		<div class="f3_bottom">
			<p class="f3_links">
				<a href="#">关于我们</a>| <a href="#">联系我们</a>| <a href="#">友情链接</a>| <a
					href="#">供货商入驻</a>
			</p>
			<p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司</p>
			<img src="images/police.png">
		</div>
	</div>
</body>
</html>