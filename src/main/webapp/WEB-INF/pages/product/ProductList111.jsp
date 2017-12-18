<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

    $(function(){
    	
    	    //全选反选
	        $("#checkAll").click(function() {
	
		          $('input[name="pids"]').attr("checked",this.checked); 
	        });
	
	        var $subBox = $("input[name='pids']");
	      
	        $subBox.click(function(){
				
				$("#checkAll").attr("checked",$subBox.length
			       == $("input[name='user_ids']:checked").length ? true : false);
	        });

    	    
    	    //新增操作跳转
    	    $("#btnadd").click(function(){
    	    	
    	    	 $("#form02").attr("action","${pageContext.request.contextPath}/pro/addProductInit.action");   
    	    	 $("#form02").submit();
    	    });
    	    
    	    
    	   //批量删除操作跳转
    	    $("#btndel").click(function(){
    	    	
    	    	 $("#form02").attr("action","${pageContext.request.contextPath}/pro/delProduct.action");   
    	    	 
    	    	 $("#form02").submit();
    	    });
    	    
    	    
    	
    })

</script>
</head>
<body>
   <div class="container">
          <div class="querys" style="width: 80%;height: 5%; border: 1px black solid; margin: 0px auto;">
              <c:if test="${allErrors != null}">
	                <c:forEach items="${allErrors}" var="error">
	                    ${error.defaultMessage}
	                </c:forEach>
              </c:if>
          </div>
           <div class="querys" style="width: 80%;height: 10%; border: 1px black solid; margin: 0px auto;">
        
            <form action="" method="post" id="form01">
            
                <table class="table" width="100%" height="30" 
                      border="1" cellpadding="0" cellspacing="0" align="center">
	                 <tr>
	                    <td>商品名称</td>
	                    <td><input type="text"  id="pname" name="pname" value=""/></td>
	                    <td>是否是热门商品</td>
	                    <td><input type="text"  id="is_hot" name="is_hot" value=""/></td>
	                 </tr>
	                 <tr><td colspan="4"><input type="text"  id="query" name="query" value="查询"/></td></tr>
	                 
               </table>
            </form>
            </div>
            
             <form action="" method="post" id="form02">
            
                <table class="table" width="80%" height="30" 
                      border="1" cellpadding="0" cellspacing="0" align="center">                 
	                 <tr>
	                   <td><input type="button"  id="btnadd" name="btnadd" value="新增商品"/></td>
	                   <td><input type="button"  id="btndel" name="btndel" value="批量删除"/></td>
	                   </tr>
                  </table>
                  <table class="table" width="80%" height="30" 
                       border="1" cellpadding="0" cellspacing="0" align="center">
        
	                <tr>
	                   <td><input type="checkbox" name="checkAll" id="checkAll" value=""/>全选</td>
	                   <td>商品编号:</td>
		               <td>商品名称:</td> <td>商品市场价:</td>
		               <td>商品电商价:</td><td>发布日期:</td>
		               <td>商品描述:</td>	<td>操作</td>             
		            </tr>
		           <c:forEach items="${products}" var="product"> 
			          <c:if test="${product != null}">
			             <tr>	
			               <td><input type="checkbox" name="pids" id="pids" value="${product.pid}"/></td>        
			               <td>${product.pid}</td>
			               <td>${product.pname}</td>	            
			               <td>${product.market_price}</td>	             
			               <td>${product.shop_price}</td>	                        
			               <td><f:formatDate value="${product.pdate}" pattern="yyyy-MM-dd:mm:ss"/></td>
			               <td>${product.pdesc}</td>
			               <td><a href="<%=request.getContextPath()%>/pro/queryProductByPid.action?productId=${product.pid}">详细...</a></td>
			               
			               <td><a href="<%=request.getContextPath()%>/pro/modifyProductInit2/${product.pid}/${product.pname}.action">修改</a></td>
			             </tr>
		             </c:if>
		           </c:forEach>       
               </table>
               
            </form>
            
            
        
       
   
   </div>
    
</body>
</html>