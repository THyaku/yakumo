package com.cn.mindy.shop.controller.product;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.service.product.ProductService;
import com.cn.mindy.shop.utils.PageBean;
import common.Logger;




@Controller
@RequestMapping("/product")
public class ProductController {
	
		private Logger log = Logger.getLogger(ProductController.class);
		
		
		@Resource(name="productService")
		public ProductService  productService;
		
		
		
		
		
		@RequestMapping("/pro_hot")
		public ModelAndView queryHotProduct(){
			
			   List<Product> products = productService.query(1);
			
			   ModelAndView mv = new ModelAndView();
			  
			   mv.setViewName("main/Main");
			   
			   return mv;
			  
		}
		
		
		/**
		 * 根据cid获取所有二级分类的所有商品并分页
		 * @param request
		 */
		@RequestMapping("/getPageByCid/{cid}/{page}")
		public String getPageByCid(@PathVariable Integer cid,@PathVariable Integer page,HttpServletRequest request) {
				//1 获取页面参数
				log.debug("....cid = " + cid +".......");
				System.out.println("....page = " + page +".......");
			   
				//2 获取指定一级分类的所有二级分类的所有商品cid
				PageBean<Product> pageBean = productService.getPageByCid(cid,page);
				
				//3 将PageBean存入request的Attriute中
				request.setAttribute("pageBean", pageBean);
				for (Product p: pageBean.getList()) {
					
					System.out.println(p.toString());
				}
				
				request.setAttribute("cid_scid", cid);
				
				//4 跳转页面
				return "/product/ProductList";
			
			
		}
		
		
		
		/**
		 * 根据csid获取指定二级分类的所有商品并分页
		 * @param request
		 */
		@RequestMapping("/getPageByCsid/{csid}/{page}")
		public String getPageByCsid(@PathVariable Integer csid,@PathVariable Integer page,HttpServletRequest request) {
				//1 获取页面参数
				log.debug("....cid = " + csid +".......");
				System.out.println("....page = " + page +".......");
			   
				//2 获取指定一级分类的所有二级分类的所有商品cid
				PageBean<Product> pageBean = productService.getPageByCsid(csid,page);
				System.out.println(pageBean.getList());
				//3 将PageBean存入request的Attriute中
				request.setAttribute("pageBean", pageBean);
				for (Product p: pageBean.getList()) {
					System.out.println(p.toString());
				}
				request.setAttribute("cid_scid", csid);
				
				//4 跳转页面
				return "/product/ProductList";
			
			
		}
	
		
		
		
	    /**
	     * 查看商品详情
	     * @param pid
	     * @param request
	     * @return
	     */
		@RequestMapping("/getroductDetail/{pid}")
		public String getroductDetail(@PathVariable Integer pid,HttpServletRequest request) {
			
			System.out.println(".........getroductDetail..............pid = " + pid);
			
			Product product = productService.queryPorductByPid(pid);
			System.out.println(".........."+product.toString());
			request.setAttribute("product", product);
			return "product/Product";
		
		}
	

}
