package com.cn.mindy.shop.mapper;

import com.cn.mindy.shop.pojo.Order;

public interface OrderMapper extends IDAO<Order> {
	
	@Override
	public boolean add(Order order);
	
	
	@Override
	public boolean modify(Order order);


	/**
	 * 根据订单号查询指定订单
	 * @param orderNo
	 * @return
	 */
	public Order findByOrderNo(String orderNo);
	

}
