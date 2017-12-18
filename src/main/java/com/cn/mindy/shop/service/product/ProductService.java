package com.cn.mindy.shop.service.product;

import java.util.List;

import javax.annotation.Resource;

import com.cn.mindy.shop.mapper.ProductMapper;
import com.cn.mindy.shop.pojo.Product;
import com.cn.mindy.shop.pojo.vo.PageVo;
import com.cn.mindy.shop.service.IService;
import com.cn.mindy.shop.utils.PageBean;

/**
 * 用户操作的抽象类
 * @author Mindy
 *
 */
public abstract class ProductService implements IService<Product>{

	@Resource(name="productMapper")
	public ProductMapper  productMapsper;

	/**
	 * 分页-通用方法
	 */
	@Override
	public List<Product> queryAllByPage(int cid, int begin, int limit) {

		PageVo pageVo = new PageVo();
		pageVo.setCid(cid);
		pageVo.setBegin(begin);
		pageVo.setLimit(limit);

		return productMapsper.queryAllByPage(pageVo);
	}
	
	
	/**
	 * 分页-通用方法
	 */
	public List<Product> queryScByPage(int csid, int begin, int limit) {

		PageVo pageVo = new PageVo();
		pageVo.setCsid(csid);
		pageVo.setBegin(begin);
		pageVo.setLimit(limit);

		return productMapsper.queryScByPage(pageVo);
	}



	/**
	 * 查询总记录数
	 */
	@Override
	public int queryAllCount(int cid) {

		return productMapsper.queryAllCount(cid);
	}


	/**
	 * 查询最新商品
	 * @return
	 */
	public abstract List<Product> queryNews();



	/**
	 * 根据pid查看商品详情
	 * @param pid
	 * @return
	 */
	public abstract Product queryPorductByPid(Integer pid);

	/**r
	 * 获取指定一级分类的所有二级分类的所有商品cid
	 * @param cid
	 * @param page
	 * @return
	 */
	public abstract PageBean<Product> getPageByCid(int cid, int page);



	/**r
	 * 获取指定二级分类的所有商品csid
	 * @param csid
	 * @param page
	 * @return
	 */
	public abstract PageBean<Product> getPageByCsid(int csid, int page);



}
