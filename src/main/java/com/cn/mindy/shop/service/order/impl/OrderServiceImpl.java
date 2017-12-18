package com.cn.mindy.shop.service.order.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mindy.shop.mapper.OrderMapper;
import com.cn.mindy.shop.pojo.Order;
import com.cn.mindy.shop.service.order.OrderService;


/**
 * 订单操作类
 * @author Mindy
 *
 */@Service("orderService")
public class OrderServiceImpl implements OrderService{
	 
	 @Autowired
	 OrderMapper orderMapper;

	 
	/**
	 * 生成新订单
	 */
	@Override
	public boolean add(Order order) {
		
		return orderMapper.add(order);
	}

	
	/**
	 * 删除订单
	 */
	@Override
	public boolean delete(Order order) {
		
		return false;
	}

	
	
	/**
	 * 修改订单操作
	 */
	@Override
	public boolean modify(Order order) {
		
		return orderMapper.modify(order);
	}
	

	@Override
	public Order query(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> query(Integer intParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryAllByPage(int id, int begin, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryAllCount(int param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/**
	 * 根据OrderNo查询指定订单
	 * @param orderNo
	 * @return
	 */
	@Override
	public Order findByOrderNo(String orderNo) {
		
		return orderMapper.findByOrderNo(orderNo);
		
	}
	

	@Override
	public void update(Order currOrder) {
		// TODO Auto-generated method stub
		
	}

}
