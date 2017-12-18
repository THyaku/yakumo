package com.cn.mindy.shop.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cn.mindy.shop.mapper.UserMapper;
import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.service.user.UserService;

/**
 * User操作的实现类
 * @author Mindy
 *
 */
@Service("userService")
@Scope("prototype")
public class UserServiceImpl extends UserService {

	//根据数据类型自动注入(接口)
	@Autowired
	public UserMapper userMapper;
	
	/**
	 * 注册用户
	 */
	@Override
	public boolean add(User user)  {
		
		return userMapper.add(user);
	}

	
	/**
	 * 注销用户
	 */
	@Override
	public boolean delete(User t)  {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * 修改用户
	 */
	@Override
	public boolean modify(User t)  {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 登录操作—根据参数查询用户
	 */
	@Override
	public User query(User user)  {
		
		
		    return userMapper.queryUserByName(user.getUsername());
		
		
	}

	
	/**
	 * 查询所有用户
	 */
	@Override
	public List<User> queryAll()  {
	
		return null;
	}


	@Override
	public List<User> query(Integer intParam)  {
		
		return null;
	}


	/**
	 * 根据code查询用户
	 */
	@Override
	public User queryByCode(String code) {
		
		
		return userMapper.queryByCode(code);
	}


	/**
	 * 根据uid修改user数据
	 */
	@Override
	public boolean updateByUid(String uid) {
		
		return userMapper.updateByUid(uid);
	}


	/**
	 * 根据username查询用户
	 */
	@Override
	public User queryByName(String username) {
		
		return userMapper.queryUserByName(username);
	}
	
	
	
	
	

}
