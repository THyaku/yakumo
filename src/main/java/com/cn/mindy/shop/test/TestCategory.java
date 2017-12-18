package com.cn.mindy.shop.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.mindy.shop.mapper.CategoryMapper;
import com.cn.mindy.shop.pojo.Category;
import com.cn.mindy.shop.pojo.CategorySecond;
import com.cn.mindy.shop.service.category.CategoryService;

public class TestCategory {
	
	private SqlSessionFactory factory = null;
	 ApplicationContext  context;
	@Before
	public void init(){
		
		     context 
		     = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext_dao.xml");
	    
		   factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
	}
	
	@Test
	public void test_queryAll1() throws Exception{
		
		  SqlSession session = factory.openSession();
		  
		  CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		  
		  List<Category> categories =mapper.queryAll();
		  
		  for (Category category : categories) {
			  
			 System.out.println(category.toString());
			 Set<CategorySecond> set =  category.getCategorySecond();
			 Iterator<CategorySecond> its = set.iterator();
			 
			while(its.hasNext()){
				
				   CategorySecond second = its.next();
				   System.out.println(".............."+second.toString());
				   
			}
			 
		  }
		
	}
	
	
	@Test
	public void test_queryAll2() throws Exception{
		
		  CategoryService  categoryService 
		     =  (CategoryService) context.getBean("categoryServiceImpl");
		  List<Category> categories =categoryService.queryAll();
		  
		  for (Category category : categories) {
			  
			 System.out.println(category.toString());
			 Set<CategorySecond> set =  category.getCategorySecond();
			 Iterator<CategorySecond> its = set.iterator();
			 
			while(its.hasNext()){
				
				   CategorySecond second = its.next();
				   System.out.println(".............."+second.toString());
				   
			}
			 
		  }
		
	}
	

}
