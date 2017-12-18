package com.cn.mindy.shop.mapper;

import java.util.List;

import com.cn.mindy.shop.pojo.Category;


public interface CategoryMapper extends IDAO<Category>{

	 
	  @Override
	  public boolean add(Category category);
	  
	  
	  public Category queryCategory(Category category);
	  
	  //查询所有pojo
	  @Override
      public List<Category> queryAll();
		 
	  
}
