<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container header">
		<%@ include file="../Head.jsp"%>
	</div>
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">

				<c:forEach items="${categories}" var="category">
					<dl>
						<dt>
							<!-- 一级分类 -->
							<a href="${pageContext.request.contextPath}">
								${category.cname} </a>
						</dt>
						<!-- 二级分类 -->
						<c:forEach items="${category.categorySecond}" var="categorysecond">

							<dd>
								<a
									href="${pageContext.request.contextPath}/product/getPageByCsid/${categorysecond.csid}/1">${categorysecond.csname}</a>
							</dd>
						</c:forEach>
					</dl>
				</c:forEach>
			</div>
		</div>
		<div class="span18 last">

			<form id="productForm"
				action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm"
				method="get">
				<input type="hidden" id="brandId" name="brandId" value=""> <input
					type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">

				<div id="result" class="result table clearfix">
					<ul>
						<c:forEach items="${pageBean.list}" var="product">
							<li><a
								href="${pageContext.request.contextPath}/product/getroductDetail/${product.pid}">
									<img
									src="${pageContext.request.contextPath}/image/${product.image}"
									width="170" height="170" style="display: inline-block;">

									<span style='color: green'> ${product.pname} </span> <span
									class="price"> 商城价： ￥${product.shop_price}/份 </span>
							</a></li>

						</c:forEach>

					</ul>
				</div>




				<!-- 分页控件 -->
				<div class="pagination">


					<!-- 首页 
				        <span class="firstPage">&nbsp;</span>
				      -->
					<c:choose>
						<c:when test="${pageBean.page >1}">
							<a class="firstPage"
								href="${pageContext.request.contextPath}/product/getPageByCid/${cid}/1">
								&nbsp; </a>
						</c:when>
						<c:otherwise>
							<span class="firstPage">&nbsp;</span>
						</c:otherwise>
					</c:choose>


					<!-- 上一页
				      <span class="previousPage">&nbsp;</span>
				      -->

					<c:choose>
						<c:when test="${pageBean.page >1}">
							<a class="previousPage"
								href="${pageContext.request.contextPath}/product/getPageByCid/${cid}/${pageBean.page-1}">
								&nbsp; </a>
						</c:when>
						<c:otherwise>
							<span class="previousPage">&nbsp;</span>
						</c:otherwise>
					</c:choose>


					<!-- 当前页
				 	    <span class="currentPage">1</span>
				 	  -->

					<a class="currentPage"
						href="${pageContext.request.contextPath}/product/getPageByCid/${cid}/${pageBean.page}">
						${pageBean.page} </a>


					<!-- 当前页+1
				 	    <span class="currentPage">1</span>
				 	  -->
					<c:if test="${pageBean.totalPage > pageBean.page}">
						<a class="currentPage"
							href="${pageContext.request.contextPath}/product/getPageByCid/${cid}/${pageBean.page+1}">
							${pageBean.page+1} </a>
					</c:if>
					<!-- 下一页 -->
					<c:choose>
						<c:when test="${pageBean.page+1 <=pageBean.totalPage}">
							<a class="nextPage"
								href="${pageContext.request.contextPath}/product/getPageByCid/${cid}/${pageBean.page+1}">&nbsp;</a>

						</c:when>
						<c:otherwise>
							<span class="nextPage">&nbsp;</span>
						</c:otherwise>
					</c:choose>

					<!-- 尾页 -->
					<c:choose>
						<c:when test="${pageBean.page !=pageBean.totalPage}">
							<a class="lastPage"
								href="${pageContext.request.contextPath}/product/getPageByCsid/${cid_scid}/${pageBean.totalPage}">&nbsp;</a>
						</c:when>
						<c:otherwise>
							<span class="lastPage">&nbsp;</span>
						</c:otherwise>
					</c:choose>


				</div>
			</form>
		</div>
	</div>
	<div class="container footer">
		<%@include file="../Footer.jsp"%>
	</div>
</body>
</html>