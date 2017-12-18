<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/slider.css"  rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"  rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css" 	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<div class="container header">
	    <%@ include  file="../Head.jsp"%>
	</div>

	<div class="container index">


		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title">
					<strong>热门商品</strong>
					
					<!-- <a  target="_blank"></a> -->
				</div>
				<ul class="tab">
					<li class="current"><a
						href="${pageContext.request.contextPath}/product/getroductDetail/${hot.pid}"
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<!-- 					<div class="hotProductAd">
					<img src="${pageContext.request.contextPath}/image/a.jpg" width="260" height="343" alt="热门商品" title="热门商品">
		         -->
		      
				<ul class="tabContent" style="display: block;">
				
					  <c:forEach items="${hots}" var="hot">
					  
					      <li><a href="${pageContext.request.contextPath}/product/getroductDetail/${hot.pid}" target="_blank"><img
							src="${pageContext.request.contextPath}/image/${hot.image}"
							data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg"
							style="display: block;"></a></li>
					  </c:forEach>
				
				</ul>
				
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新商品</strong> <a target="_blank"></a>
				</div>
				<ul class="tab">
					<li class="current"><a
						href="${pageContext.request.contextPath}/product/getroductDetail/${newpoduct.pid}"
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<!-- 	<div class="newProductAd">
									<img src="${pageContext.request.contextPath}/image/q.jpg" width="260" height="343" alt="最新商品" title="最新商品">
				 -->
				<ul class="tabContent" style="display: block;">
				
				   <c:forEach items="${news}" var="newpoduct">
				            <li><a href="${pageContext.request.contextPath}/product/getroductDetail/${newpoduct.pid}" target="_blank">
				            <img
							src="${pageContext.request.contextPath}/image/${newpoduct.image}"
							data-original="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg"
							style="display: block;"></a></li>
				   </c:forEach>
					
				</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>新手指南</dt>
					<dd>
						<a target="_blank">支付方式</a> |
					</dd>
					<dd>
						<a target="_blank">配送方式</a> |
					</dd>
					<dd>
						<a target="_blank">售后服务</a> |
					</dd>
					<dd>
						<a target="_blank">购物帮助</a> |
					</dd>
					<dd>
						<a target="_blank">蔬菜卡</a> |
					</dd>
					<dd>
						<a target="_blank">礼品卡</a> |
					</dd>
					<dd>
						<a target="_blank">银联卡</a> |
					</dd>
					<dd>
						<a target="_blank">亿家卡</a> |
					</dd>

					<dd class="more">
						<a>更多</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="container footer">
		 <%@include file="../Footer.jsp" %>
	</div>
</body>
</html>