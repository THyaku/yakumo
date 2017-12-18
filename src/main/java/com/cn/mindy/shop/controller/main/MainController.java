package com.cn.mindy.shop.controller.main;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.mindy.shop.pojo.Category;
import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.service.category.CategoryService;
import com.cn.mindy.shop.service.product.ProductService;

@Controller
@RequestMapping("/main")
public class MainController {


	@Resource(name="categoryService")
	public CategoryService categoryService;

	@Resource(name="productService")
	public ProductService  productService;



	@RequestMapping("/mainInit")
	public ModelAndView mainInit(HttpServletRequest request){

		try {

			/**
			 * 1 业务逻辑处理
			 */

			//1.1 从数据库获取1级导航和2级导航的数据

			List<Category> categories  = categoryService.queryAll();

			//1.2 将数据放入session中
			request.getSession().setAttribute("categories",categories);

			//1.3 获取前10个热门商品并放入session中
			List<Product> products = productService.query(1);
			request.getSession().setAttribute("hots",products);

			//1.4 获取前10个最新商品并方法session中
			List<Product> products_new = productService.queryNews();
			System.out.println("products_new = "+ products_new.toString());

			request.getSession().setAttribute("news",products_new);

			/**
			 * 2 控制分发处理
			 */
			ModelAndView mv = new ModelAndView();

			mv.setViewName("main/Main");

			return mv;

		} catch (Exception e) {

			e.printStackTrace();
			return null;	
		}


	}

}
