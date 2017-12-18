package com.cn.mindy.shop.service.category;

import java.util.List;

import com.cn.mindy.shop.pojo.Category;
import com.cn.mindy.shop.service.IService;

/**
 * 用户操作的抽象类
 * @author Mindy
 *
 */
public abstract class CategoryService implements IService<Category>{
	
	     
		 /**
		  * 分页-通用方法
		  */
		@Override
		public List<Category> queryAllByPage(int pageSize, int begin, int end) {
			   
			
			
			return null;
		}
		
		
		/**
		 * 查询总记录数
		 */
		@Override
		public int queryAllCount(int param) {
		
			
		    return 0;
		}
		
		
		
		
		

}
