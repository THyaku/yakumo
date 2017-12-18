<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员登录</title>


<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
	
<script type="text/javascript">
	
		  $(function(){
			  
				    
			    //输入用户名校验
			    $("#username").blur(function(){
			    	
			    	var result = checkUserName1();
			    	//alert(result);
			    	
			    	if(result == true){
			    		
			    		checkUserName2();
			    	}
			    	
			    });
			    
			    $("#loginBtn").click(function(){
			    	
			    	/*
			    	if((checkUserName1() == true) && (checkUserName2() == true)){
		    		
			    		     $("#loginForm").submit();
			    	}else{
			    		
			    		alert("登录失败");
			    	}
			    	*/
			    	
			    	 $("#loginForm").submit();
			    	   
			    });
			    
			    
			    //用户名的长度和非空校验
			    function checkUserName1 (){
			    	
			    	  var result = true;
			    	  var username = $("#username").val();
			    	  
			    	  if(username == "" || username == null){
			    		  $("#usernamemsg").html("<font color='red'>不能为空</font>");
			    		  result = false;
			    		  
			    	  }else if(username.length < 5 ||username.length > 12){
			    		  
			    		  $("#usernamemsg").html("<font color='red'>长度5-12之间</font>");
			    		  result = false;
			    		  
			    	  }else{
			    		  
			    		  $("#usernamemsg").html(" ");
			    		  result = true;
			    	  }
			    	
			    	  return result;
			    	  
			    }// end of chekUnserName1
			    
			    
			    //用户名是否存在校验
			    function checkUserName2(){
				 	   
				  	   var username = $("#username").val();
				  	   //alert("username = " + username);
				  	   var result=false;
				  	     
				  	   $.ajax(
				  			   {
				  					url:"${pageContext.request.contextPath}/user/checkUsername",   //url
				  					type:"post",                                 //type 默认 get
				  				    data:JSON.stringify({"username":username}),  //data
				  					contentType:"application/json;charset=utf-8",
				  					
				  					success:function(data){
				  						
				  						//alert(data.username);
				  						if(data.username == null){
				  							
				  							$("#usernamemsg").html("<font color='red'>用户名不存在</font>");
				  							result= false;
				  							
				  						}else{
				  							
				  							$("#usernamemsg").html("<font color='green'>用户名可用</font>");
				  							result= true;
				  						}
				  					},//success	
				  				    error:function(data){
				  				    	
				  					   //返回的json存储的是Student对象
				  				    	$("#usernamemsg").html("<font color='red'>系统异常</font>");
				  				    	result= false;
				  					}//error
				  				} 
				  		 );
				  	 
				  	  return result;
				  	  
				 }// end of chekUsername2

		  })
	</script>


</head>
<body>


	<div class="container header">
		<%@ include file="../Head.jsp"%>

	</div>
	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="${pageContext.request.contextPath}/image/login.jpg"
					width="500" height="330" alt="会员登录" title="会员登录">
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN
					</div>
					<form id="loginForm" method="post" novalidate="novalidate" action="${pageContext.request.contextPath}/user/login">
						<table>
							<tbody>
								<tr>
									<th>用户名:</th>
									<td><input type="text" id="username" name="username"
										class="text" maxlength="20"></td>
									<td id="usernamemsg">aaa</td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="password" name="password"
										class="text" maxlength="20" autocomplete="off"></td>
									<td id="userpwd">aaaa</td>
								</tr>
								<tr>
									<th>验证码:</th>
									<td><span class="fieldSet"> <input type="text"
											id="captcha" name="captcha" class="text captcha"
											maxlength="4" autocomplete="off"> <img
											id="captchaImage" class="captchaImage"
											src="${pageContext.request.contextPath}/user/getImg"
											title="点击更换验证码">
									</span></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><label> <input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true">记住用户名
									</label> <label> &nbsp;&nbsp;<a>找回密码</a>
									</label></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><input type="button" class="submit" value="登 录" id="loginBtn">
									</td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt>还没有注册账号？</dt>
											<dd>
												立即注册即可体验在线购物！ <a
													href="${pageContext.request.contextPath}/会员注册.htm">立即注册</a>
											</dd>
										</dl>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">
		<%@ include file="../Footer.jsp"%>
	</div>
</body>
</html>