package com.cn.mindy.shop.pojo;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * 订单项的实体
 *
 */
@Repository("orderItem")
@Scope("prototype")
public class OrderItem implements Serializable{
	
	
	private static final long serialVersionUID = -9071048806649214252L;
	
	private Integer itemid;  //商品编号
	
	private Integer count;    //商品数量
	
	private Double subtotal;  //小计
	
	private Integer pid ;
	
	private Product product;  // 商品外键:对象
	
	private Order order;   // 订单外键:对象
	
	
	
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", product=" + product
				+ ", order=" + order + "]";
	}
	
	
	
}
