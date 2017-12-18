package com.cn.mindy.shop.mapper;

import java.util.List;

import com.cn.mindy.shop.pojo.Category;
import com.cn.mindy.shop.pojo.CategorySecond;


public interface CategorySecondMapper extends IDAO<CategorySecond>{

	 
	  @Override
	  public boolean add(CategorySecond categorySecond);
	  
	  
	  public Category queryCategory(CategorySecond categorySecond);
	  
	  //查询所有pojo
//	  @Override
//      public List<CategorySecond> queryAll()throws Exception;
		 
	  
	  
	  
}
