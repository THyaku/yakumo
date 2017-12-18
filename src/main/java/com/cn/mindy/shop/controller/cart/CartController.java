package com.cn.mindy.shop.controller.cart;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.vo.Cart;
import com.cn.mindy.shop.pojo.vo.CartItem;
import com.cn.mindy.shop.service.cart.CartService;
import com.cn.mindy.shop.service.product.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {


	@Resource(name="productService")
	public ProductService productService;

	@Resource(name="cartService")
	public CartService cartService;

	@RequestMapping("/cartInit")
	public String cartInit(HttpServletRequest request){
		String num = request.getParameter("quantity");
		
		String pids =request.getParameter("pid");
		

		System.out.println("........cartInit.....quantity = " + num +",pid = " + pids);
		if(null != num || null !=pids){
			
			Integer quantity = Integer.valueOf(num);
			Integer pid = Integer.valueOf(pids);
			CartItem cartItem = new CartItem();

			//根据pid查询Product对象
			//productService = new ProductServiceImpl();
			Product product = productService.queryPorductByPid(pid);
			cartItem.setProduct(product);
			cartItem.setNum(Integer.valueOf(quantity));
			cartItem.setSubTotal((float) (Integer.valueOf(quantity) * product.getShop_price()));

			//从Session中获取cart属性
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			cart = cartService.getCart(cart);

			//添加到购物车方法
			cart.addProductToCart(cartItem);

			//添加到session中
			request.getSession().setAttribute("cart", cart);
		}
		return "cart/CartList";

	}

	@RequestMapping("/delCart/{pid}")
	public String delCart(@PathVariable Integer pid,HttpServletRequest request){

		//从Session中获取cart属性
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		cart = cartService.getCart(cart);

		cart.delCartItemByPid(pid);

		request.getSession().setAttribute("cart", cart);

		return "cart/CartList";

	}


	@RequestMapping("/clearCart")
	public String clearCart(HttpServletRequest request){

		//从Session中获取cart属性
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		cart = cartService.getCart(cart);

		cart.clearCart();

		request.getSession().setAttribute("cart", null);

		return "cart/CartList";

	}


}
