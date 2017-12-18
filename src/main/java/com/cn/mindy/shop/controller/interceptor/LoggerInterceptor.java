package com.cn.mindy.shop.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器演示
 * 第一个拦截器--配置日志拦截--必须放行
 * @author Mindy
 *
 */
public class LoggerInterceptor implements HandlerInterceptor {
	
	   private final Logger log = Logger.getLogger(LoggerInterceptor.class);

		/**
		 * 进入 Handler方法之前执行
		 * 用于身份认证、身份授权
		 * 比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
		 * handler,是指controller的@Controller注解下的整个方法名
		 */
		@Override
		public boolean preHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler) throws Exception {
			
			
			//获取请求的URL
			String url = request.getRequestURI();
			
			//判断
			String handlerValue = handler.toString();
//	        String[] methodStringArray = StringUtils.split(handlerValue);
//	        String methodName = methodStringArray[methodStringArray.length - 1];
	        
			log.info("HandlerInterceptor1.....preHandle()........");
			log.info("Logger......preLog....prepare execute method : " + handlerValue);
			
			//return false表示拦截，不向下执行
			//return true表示放行
					
			
			return true;
		}
	
		
		/**
		 * 进入Handler方法之后，返回modelAndView之前执行
		 * 应用场景从modelAndView出发：
	     * 将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
		 */
		@Override
		public void postHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			
			
			log.info("Logger....postHandle().finish...prepare execute method : " + handler.toString());
			
		}
		
		
	   /**
	    * 执行Handler完成执行此方法
	    * 应用场景：统一异常处理，统一日志处理
	    */
		@Override
		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
		
			
			log.info("Logger....afterCompletion.....finish...prepare execute method : " + handler.toString());
			
		}
	
	

}
