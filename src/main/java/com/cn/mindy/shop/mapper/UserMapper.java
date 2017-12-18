package com.cn.mindy.shop.mapper;

import com.cn.mindy.shop.pojo.User;

public interface UserMapper extends IDAO<User>{

	
	 /**
	  * 根据用户名查询用户信息
	  */
	  public User queryUserByName(String uname);
	  
	  
	  
	  @Override
	  public boolean add(User user);
	  
	  
	  public User queryUser(User user);
	  
	  
	  /**
	   * 根据code查询用户
	   * @param code
	   * @return
	   */
	  public User queryByCode(String code);
	  
	  
	  /**
	   * 根据uid修改user数据
	   * @param uid
	   * @return
	   */
	  public boolean updateByUid(String uid);
	  
	  
	  
}
