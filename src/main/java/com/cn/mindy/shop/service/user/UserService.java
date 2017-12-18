package com.cn.mindy.shop.service.user;

import java.util.List;

import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.service.IService;

/**
 * 用户操作的抽象类
 * @author Mindy
 *
 */
public abstract class UserService implements IService<User>{
	
	     
	
		 /**
		  * 分页-通用方法
		  */
		@Override
		public List<User> queryAllByPage(int pageSize, int begin, int end){
			   
			return null;
		}
		
		
		/**
		 * 查询总记录数
		 */
		@Override
		public int queryAllCount(int param)  {
		
			
		    return 0;
		}
		
		
		
		 /**
		   * 根据code查询用户
		   * @param code
		   * @return
		   */
		  public abstract User queryByCode(String code);
		  
		  
		  
		  /**
		   * 根据uid修改user数据
		   * @param uid
		   * @return
		   */
		  public abstract boolean updateByUid(String uid);
		  
		  
		  
		  /**
		   * 根据username查询用户
		   * @param username
		   * @return
		   */
		  public abstract User queryByName(String username);

}
