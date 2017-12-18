package com.cn.mindy.shop.service.order;

import com.cn.mindy.shop.pojo.Order;
import com.cn.mindy.shop.service.IService;

public interface OrderService extends IService<Order>{

	Order findByOid(Integer oid);

	void update(Order currOrder);

	Order findByOrderNo(String orderNo);
	
	
	
	

}
