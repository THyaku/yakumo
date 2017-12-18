package com.cn.mindy.shop.service.product.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.service.product.ProductService;
import com.cn.mindy.shop.utils.Common;
import com.cn.mindy.shop.utils.PageBean;


@Service("productService")
@Scope("prototype")
public class ProductServiceImpl extends ProductService{

		
		@Override
		public boolean add(Product t)  {
			// TODO Auto-generated method stub
			return false;
		}
	
		@Override
		public boolean delete(Product t)  {
			// TODO Auto-generated method stub
			return false;
		}
	
		@Override
		public boolean modify(Product t)  {
			// TODO Auto-generated method stub
			return false;
		}
	
		@Override
		public Product query(Product t)  {
			// TODO Auto-generated method stub
			return null;
		}
		
	
		@Override
		public List<Product> queryAll()  {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		/**
		 * 查询前10个热门商品
		 */
		@Override
		public List<Product> query(Integer is_hot)  {
			
			return productMapsper.query(is_hot);
		}
	
		
		/**
		 * 查询前十个最新商品
		 */
		@Override
		public List<Product> queryNews()  {
			
			return productMapsper.queryNews();
		}
	
		
		/**
		 * 根据pid查看商品详情
		 */
		@Override
		public Product queryPorductByPid(Integer pid) {
		
			
			return productMapsper.queryPorductByPid(pid);
			
		}
	
		
		/**
		 * 根据cid获取所有二级分类的所有商品并分页
		 */
		@Override
		public PageBean<Product> getPageByCid(int cid, int page) {
			
			
			/**
			 * 1 获取各种PageBean属性
			 */
			
			PageBean<Product> pageBean = new PageBean<Product>();
			
			int limit = Common.LIMIT;//每页记录数
			
			int totalCount = queryAllCount(cid);//总记录数
			
			//总页数
			int totalPage =totalCount % Common.LIMIT >0 ? totalCount /Common.LIMIT + 1:totalCount /Common.LIMIT;
			
			//当前记录数索引位
			int begin = (page-1) * Common.LIMIT;
			
			//当前页的商品集合
			List<Product> list = queryAllByPage(cid,begin,limit);
			
			
			/**
			 * 2 组装PageBean
			 */
			pageBean.setPage(page);
			pageBean.setLimit(limit);
			pageBean.setList(list);
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(totalPage);
			
			return pageBean;
			
		}
		
		
		/**
		 * 根据cid获取所有二级分类的所有商品并分页
		 */
		@Override
		public PageBean<Product> getPageByCsid(int csid, int page) {
			
			
			/**
			 * 1 获取各种PageBean属性
			 */
			
			PageBean<Product> pageBean = new PageBean<Product>();
			
			int limit = Common.LIMIT;//每页记录数
			
			int totalCount = queryAllCount(csid);//总记录数
			
			//总页数
			int totalPage =totalCount % Common.LIMIT >0 ? totalCount /Common.LIMIT + 1:totalCount /Common.LIMIT;
			
			//当前记录数索引位
			int begin = (page-1) * Common.LIMIT;
			
			//当前页的商品集合
			List<Product> list = queryScByPage(csid,begin,limit);
			
			
			/**
			 * 2 组装PageBean
			 */
			pageBean.setPage(page);
			pageBean.setLimit(limit);
			pageBean.setList(list);
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(totalPage);
			
			return pageBean;
			
		}
		
	
	
	

}
