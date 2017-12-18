package com.cn.mindy.shop.mapper;

import java.util.List;

import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.vo.PageVo;
import com.cn.mindy.shop.utils.PageBean;


public interface ProductMapper extends IDAO<Product>{

	
	  public Product queryUserByName(String uname);
	  
	  @Override
	  public boolean add(Product product);
	  
	  
	  public Product queryUser(Product product);
	  
	  
	  
	  /**
	   * 查询是否是热门商品
	   */
	  @Override
	  public List<Product> query(Integer intParam);
	  
	  
	  /**
	   * 查询是否是最新商品
	   * @return
	   * @throws Exception
	   */
	  public List<Product> queryNews() ;
	  
	  
	  /**
	   * 根据pid查看商品详情
	   * @param pid
	   * @return
	   */
	  public Product queryPorductByPid(Integer pid);
	  
	  
	  
	  /**
	   * 根据cid获取所有二级分类的所有商品并分页
	   */
	  public List<Product> queryAllByPage(PageVo pageVo);
	  
	  
	  /**
	   * 根据cid获取所有指定分类的所有商品并分页
	   */
	  public List<Product> queryScByPage(PageVo pageVo);
	  
	  
	  /**
	   * 查询指定cid的商品总共记录数
	   */
	  public int queryAllCount(int param);
	  
	  
}
