<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>

</head>
<body>

    
   <div class="container" style="width: 60%; margin: 0px auto;">
      
      <form action="${pageContext.request.contextPath}/userContro/regist.action" method="post">
      
           <table class="table table-striped table-bordered table-hover table-condensed" width="100%" height="50%" border="1" cellpadding="0" cellspacing="0">
           
           
              <tr>
               <td>爱&nbsp;&nbsp;好</td>
               <td>
                
                  <input type="checkbox" id="hobbies"  name="hobbies" 
                         value="sport"/>&nbsp;${hobbies[0]}
                    &nbsp;&nbsp;
                  <input type="checkbox" id="hobbies"  name="hobbies" 
                         value="it"/>&nbsp;${hobbies[1]}
                    &nbsp;&nbsp;
                  <input type="checkbox" id="hobbies"  name="hobbies" 
                         value="trip"/>&nbsp;${hobbies[2]}
                    &nbsp;&nbsp;
                  <input type="checkbox" id="hobbies"  name="hobbies" 
                         value="read"/>&nbsp;${hobbies[3]}
                    &nbsp;&nbsp;
               </td>
               <td></td>
             </tr>
             <tr>
              
                <td colspan="3">
                  <input type="submit" value="注册"/>
                </td>
             </tr>
           </table>
      
      </form>
   
   </div>
</body>
</html>