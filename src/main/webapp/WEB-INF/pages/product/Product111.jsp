<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <div class="container">
     
          <c:choose>
          
	            <c:when test="${null != product}">
	            
	                <form action="<%=request.getContextPath()%>/pro/modifyProduct.action" method="post">
	       
	                  <input type="hidden" id="pid" name="pid" value="${product.pid}" />
	                  
			          <table class="table" width="50%" height="30" 
			               border="1" cellpadding="0" cellspacing="0" align="center">
			                 
				                <tr>
					               <td>商品名称:</td>  
					               <td><input type="text" id="pname" name="pname" value="${product.pname}" /></td>         
					            </tr>
					             <tr>
					               <td>商品市场价:</td>  
					               <td><input type="text" id="market_price" name="market_price" value="${product.market_price}" /></td>		              
					            </tr>
					             <tr>
					                 <td>商品电商价:</td>
					                 <td><input type="text" id="shop_price" name="shop_price" value="${product.shop_price}" /></td>		               
					            </tr>
					            <tr>
					                 <td>商品发布时间:</td>
					                 <td>
					                     <input type="date" name="pdate" id="pdate"
					                         value="<f:formatDate value='${product.pdate}' type='date' pattern="yyyy-MM-dd"/>"/>
					                 </td>		               
					            </tr>
					            <tr>	             
					               <td>商品描述:</td>
					               <td><input type="text" id="pdesc" name="pdesc" value="${product.pdesc}" /></td>		              		                          
					            </tr>
					            
					            <tr>	             					               
					               <td colspan="2" align="center">
					                   <input type="submit" id="btnModify" name="btnModify" value="修改"/>
					               </td>		              		                          
					            </tr>
				            
				         </table>
		             </form>
	            </c:when>
	            
	            <c:otherwise>
	                  <form action="<%=request.getContextPath()%>/pro/addProduct3.action" method="post">
				          <table class="table" width="50%" height="30" 
				               border="1" cellpadding="0" cellspacing="0" align="center">
				                 
					                <tr>
						               <td>商品名称:</td>  
						               <td><input type="text" id="pname" name="pname"  /></td>         
						            </tr>
						             <tr>
						               <td>商品市场价:</td>  
						               <td><input type="text" id="market_price" name="market_price" /></td>		              
						            </tr>
						             <tr>
						                 <td>商品电商价:</td>
						                 <td><input type="text" id="shop_price" name="shop_price"" /></td>		               
						            </tr>
						            
						             <tr>
					                 <td>商品发布时间:</td>
					                 <td>
					                     <input type="date" name="pdate" id="pdate" value=""/>
					                 </td>		               
					            </tr>
						             <tr>	             
						               <td>商品描述:</td>
						               <td><input type="text" id="pdesc" name="pdesc"  /></td>		              		                          
						            </tr>
						            
						            <tr>	             
						               
						               <td colspan="2" align="center">
						                   <input type="submit" id="btn" name="btn" value="新增"/>
						               </td>		              		                          
						            </tr>
					         </table>
				        </form>
	                
	            </c:otherwise>
          </c:choose>
           
          
          
     </div>
</body>
</html>