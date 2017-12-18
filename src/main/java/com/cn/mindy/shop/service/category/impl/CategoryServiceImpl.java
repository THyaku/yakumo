package com.cn.mindy.shop.service.category.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cn.mindy.shop.mapper.CategoryMapper;
import com.cn.mindy.shop.pojo.Category;
import com.cn.mindy.shop.service.category.CategoryService;


@Service("categoryService")
@Scope("prototype")
public class CategoryServiceImpl extends CategoryService{
	
	@Resource(name="categoryMapper")
	public CategoryMapper categoryMapper;

	@Override
	public boolean add(Category category)  {
		
		return false;
	}

	@Override
	public boolean delete(Category t)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Category t)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category query(Category t)  {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 查询所有的一级导航和二级导航
	 */
	@Override
	public List<Category> queryAll()  {
		
		return categoryMapper.queryAll();
	}

	@Override
	public List<Category> query(Integer intParam)  {
		// TODO Auto-generated method stub
		return null;
	}

}
