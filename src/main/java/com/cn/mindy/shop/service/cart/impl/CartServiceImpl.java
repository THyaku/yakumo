package com.cn.mindy.shop.service.cart.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cn.mindy.shop.pojo.vo.Cart;
import com.cn.mindy.shop.service.cart.CartService;


@Service("cartService")
@Scope("prototype")
public class CartServiceImpl implements CartService{

		@Override
		public Cart getCart(Cart cart) {
			
			if(null == cart){
				
				cart = new Cart();
			}
			
			return cart;
		}

}
