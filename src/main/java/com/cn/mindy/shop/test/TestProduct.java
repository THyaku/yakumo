package com.cn.mindy.shop.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.mindy.shop.controller.user.UserController;
import com.cn.mindy.shop.mapper.ProductMapper;
import com.cn.mindy.shop.mapper.UserMapper;
import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.service.user.impl.UserServiceImpl;


/**
 * Spring整合MyBatis实现道层开发
 * @author Mindy
 *
 */
public class TestProduct {
	 
	  private final Logger log  = Logger.getLogger(TestProduct.class);
	
	  private  ApplicationContext context ;
	  private  SqlSessionFactory factory;
      
	  @Before
	  public void init(){
		  
		    context 
		      = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext_dao.xml");
		    
		    factory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
		    
	  }
	  
	  
	  @Test
	  public void test01(){
		  
			try {
				
				
				log.error("开始测试Spring整合MyBatis......");;
			    SqlSession session = factory.openSession();
				
			    ProductMapper mapper = session.getMapper(ProductMapper.class);
				
				List<Product> products = mapper.query(1);
				
				for (Product product : products) {
					
					System.out.println(product.toString());
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
	  }
	  
	  
	  /**
	   * 新增测试
	   */
	  @Test
	  public void test02(){
		  
			  log.error("开始测试Spring整合MyBatis..................");
		      SqlSession session = factory.openSession();
		      try {
					    
				  UserMapper userMapper = session.getMapper(UserMapper.class);
				
				  User user = new User("isabelle","11111111","belle","女","isabelle@qq.com","13910168888","北京市朝阳区", new java.util.Date(),1,"123456");
				
				  Boolean result =  userMapper.add(user);
				   
				  session.commit();
				  
				  System.out.println(result);
			
		    } catch (Exception e) {
			  
				session.rollback();
			  
				e.printStackTrace();
			}
			
	  }
	  
	  
	  
	  /**
	   * 登录测试测试
	   */
	  @Test
	  public void testLogin(){
		  
			  log.error("开始测试Spring整合MyBatis..................");
		      SqlSession session = factory.openSession();
		      
		      try {
				    
				  UserMapper userMapper = session.getMapper(UserMapper.class);
				
				  User user = new User();
				  user.setUsername("isabelle");
				  user.setPassword("11111111");
				  
				  User _user =  userMapper.queryUser(user);
				   
				  System.out.println(_user);
			
		    } catch (Exception e) {
			  
				e.printStackTrace();
			}
			
	  }
	  
	  
	  
	  /**
	   * 登录测试测试
	   */
	  @Test
	  public void testLogin2(){
		  
			  log.error("开始测试Spring整合MyBatis..................");
		      SqlSession session = factory.openSession();
		      
		      try {
				    
				  UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
				  User user = new User();
				  user.setUsername("isabelle");
				  user.setPassword("11111111");
				  
				  User _user = userService.query(user);
				  
				  System.out.println(_user);
				  
			
		    } catch (Exception e) {
			  
				e.printStackTrace();
			}
			
	  }
	  
	  
	
	  
	  
	  
	  
}
