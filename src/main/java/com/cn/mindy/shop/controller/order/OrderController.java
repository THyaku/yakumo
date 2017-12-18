package com.cn.mindy.shop.controller.order;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.mindy.shop.controller.validator.ValidationOrderGroup;
import com.cn.mindy.shop.pojo.Order;
import com.cn.mindy.shop.pojo.OrderItem;
import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.pojo.vo.Cart;
import com.cn.mindy.shop.pojo.vo.CartItem;
import com.cn.mindy.shop.service.order.OrderService;
import com.cn.mindy.shop.service.user.UserService;
import com.cn.mindy.shop.utils.Common;
import com.cn.mindy.shop.utils.PaymentUtil;
import com.cn.mindy.shop.utils.UUIDUtils;
import common.Logger;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	    private  Logger log = Logger.getLogger(OrderController.class);
	 
	    @Resource(name="order")
	    public Order order;
	    
	    
	    @Resource(name="userService")
	    public UserService userService;
	    
	    
	    @Resource(name="orderService")
	    public OrderService orderService;
	    
	    
	   
	    
	    
	    /**
	     * 提交订单操作
	     * @param request
	     * @return
	     */
	    @RequestMapping("/orderInit")
	    public String orderInit(HttpServletRequest request){
	    	    
	    	    /****************封装订单的数据*********/
	    	    order = new Order();
	 		    
		 		order.setOrdertime(new Date());
		 		
		 		order.setState(1); // 1 未付款   2 已经付款.  3.已经发货   4 已经收货.
		 		
		 		// 有些数据需要从购物车中获取:
		 		
		 		// 获得购物车:
		 		Cart cart = (Cart) request.getSession().getAttribute("cart");
		 		
		 		if(cart == null){
		 			
		 			request.setAttribute(Common.MESSAGE, "您还没有购物!请先去购物!");
		 			
		 			return "Message";
		 		}
		 		
		 		log.debug("..................cart................."+cart.toString()+"....+..."+cart.getCartItems().toString());
		 		order.setTotal(Double.valueOf(cart.getTotal()));
		 		
		 		// 订单所属的用户:
		 		String username = (String) request.getSession().getAttribute("username");
		 		
		 		log.debug("......................username....................."+username);
		 		User existUser = userService.queryByName(username);
		 		
		 		if(existUser == null){
		 			
                    request.setAttribute(Common.MESSAGE, "您还没有登录!请先去登录!");
		 			
                    return "Message";
		 		}
		 		
		 		//设置订单用户
		 		order.setUid(existUser.getUid());
		 		order.setUser(existUser);
		 		
		 		/********************封装订单项数据*************/
		 		// 订单项数据从 购物项的数据获得.
		 		Map<Integer, CartItem>  cartItems = cart.getCartItems();
		 		
		 		Set<Integer> sets = cartItems.keySet();
		 
		 		Iterator<Integer> its = sets.iterator();
		 		
		 		while(its.hasNext()){
		 			
		 			Integer key  =its.next();
		 			CartItem cartItem= cartItems.get(key);
		 			
		 			log.debug("............cartItem = "+cartItem.toString());
                    if(null != cartItem){
		 				
		 				OrderItem orderItem = new OrderItem();
			 			orderItem.setCount(cartItem.getNum()==0?0:cartItem.getNum());
			 			orderItem.setSubtotal(Double.valueOf(cartItem.getSubTotal()));
			 			orderItem.setProduct(cartItem.getProduct());
			 			orderItem.setOrder(order);
			 			
			 			order.getOrderItems().add(orderItem);
		 			}
		 		
				}
		 		
		 		// 清空购物车.
		 		cart.clearCart();
		 		
		 		//获取新生成的Order No
		 		order.setOrderNo(UUIDUtils.getUUID());
		 		
		 		log.debug("get a bew orderNo......."+order.getOrderNo());
		 			
		 	    // 保存订单:
		 		boolean result = orderService.add(order);
		 		
		 		//设置响应数据
		 		request.setAttribute("order", order);
		 		
			   return "order/Order";
	    	 
	     }
	     
	    
	    
	    /**
	     * 确认订单
	     */
	    @RequestMapping("/payOrder")
	    public String  payOrder(@Validated(value=(ValidationOrderGroup.class))Order order,String pd_FrpId){
	    	
	    	log.debug("...............payOrder()............order.getOrderNo() = "+order.getOrderNo()+"...pd_FrpId="+pd_FrpId);
	    	
//	    	private String pd_FrpId;
	    	
//	    	// 付款成功后的需要的参数:
//	    	private String r3_Amt;
//	    	private String r6_Order;
	    	
	    	//根据订单新输入的收货人信息修改Order
	    	Order currOrder = orderService.findByOrderNo(order.getOrderNo());
	    	
			currOrder.setAddr(order.getAddr());
			currOrder.setName(order.getName());
			currOrder.setPhone(order.getPhone());
			
			
			//修改订单操作
			orderService.modify(currOrder);
			
			// 付款:
			// 定义付款的参数:
			String p0_Cmd = "Buy";
			String p1_MerId = "10001126856";
			String p2_Order = currOrder.getOid().toString();
			String p3_Amt = "0.01";
			String p4_Cur = "CNY";
			String p5_Pid = "";
			String p6_Pcat = "";
			String p7_Pdesc = "";
			String p8_Url = "http://192.168.139.1:8080/Shop/order/callBack";
			String p9_SAF = "";
			String pa_MP = "";
			String pr_NeedResponse = "1";
			String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,pd_FrpId , pr_NeedResponse, keyValue);
			
			StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
			sb.append("p0_Cmd=").append(p0_Cmd).append("&");
			sb.append("p1_MerId=").append(p1_MerId).append("&");
			sb.append("p2_Order=").append(p2_Order).append("&");
			sb.append("p3_Amt=").append(p3_Amt).append("&");
			sb.append("p4_Cur=").append(p4_Cur).append("&");
			sb.append("p5_Pid=").append(p5_Pid).append("&");
			sb.append("p6_Pcat=").append(p6_Pcat).append("&");
			sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
			sb.append("p8_Url=").append(p8_Url).append("&");
			sb.append("p9_SAF=").append(p9_SAF).append("&");
			sb.append("pa_MP=").append(pa_MP).append("&");
			sb.append("pd_FrpId=").append(pd_FrpId).append("&");
			sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
			sb.append("hmac=").append(hmac);
			
			log.debug("pay money.......begin................");
			
	    	return "redirect:"+sb.toString();
	    
	    }
	    
	    
	    
	    
	    /**
		 * 付款成功后的回调方法
		 */
	    @RequestMapping("/callBack/{r6_Order}/{r3_Amt}")
		public String callBack(@PathVariable Integer r6_Order,@PathVariable Integer r3_Amt, HttpServletRequest request){
			
	    	log.debug("......callBack().......r6_Order = "+ r6_Order + "...r3_Amt=" + r3_Amt+"....");
	    	
			Order currOrder = orderService.findByOid(r6_Order);
			
			currOrder.setState(2);// 修改订单状态.
			orderService.update(currOrder);
			
			request.setAttribute(Common.MESSAGE,"订单付款成功!订单号:"+r6_Order+" 付款金额:"+r3_Amt);
			
			return "Message";
			
		}
		
		
		
//		
//		/**
//		 * 按用户id查询订单:
//		 */
//		public String findByUid(HttpServletRequest request){
//			// 获得用户对象:
//			String userName = request.getSession().getAttribute("userName");
//			
//			
//			List<Order> oList = orderService.findByUid(existUser);
//			
//			// 压栈
//			ActionContext.getContext().getValueStack().set("oList", oList);
//			return "findByUidSuccess";
//		}
//		
//		/**
//		 * 查询订单:
//		 */
//		public String findByOid(Integer oid){
//			order = orderService.findByOid(oid);
//			return "findByOidSuccess";
//		}
//		
		
	     
}
