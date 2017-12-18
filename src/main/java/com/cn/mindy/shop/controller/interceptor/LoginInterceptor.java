package com.cn.mindy.shop.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录校验拦截器
 * @author Mindy
 *
 */
public class LoginInterceptor implements HandlerInterceptor {


	private final Logger log = Logger.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {


		//获取请求的url
		String url = request.getRequestURI();

		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址

		log.error("Logger..._**_**.._**_**_**_**.url...." + url);

		//判断session
		HttpSession session  = request.getSession();

		//从session中取出用户身份信息
		String username = (String) session.getAttribute("username");

		if(username == null){

			if(url.contains("cart") ||url.contains("order") ){

				log.error("Logger....*_**_**_*..interceptor....login..firstly....*_**_**_*......");

				request.getRequestDispatcher("/WEB-INF/pages/main/Main.jsp").forward(request, response);						

			}

			return true;
		}


		//				//执行这里表示用户身份需要认证，跳转登陆页面
		//				request.getRequestDispatcher("/WEB-INF/pages/users/Login.jsp").forward(request, response);
		//				
		//				//return false表示拦截，不向下执行
		//				//return true表示放行
		//				log.error("Logger.....LoginInterceptor..*_**_**_*...Login Firstly..*_**_**_*..ops....!>_<...!>_<..!>_<");
		//			
		log.debug("intercepter.....already...released.........................");
		return true;

	}



	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.error("Logger.....LoginInterceptor.......postHandle()......");

	}



	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {

		log.error("Logger.....LoginInterceptor.......afterCompletion()......");

	}

}
