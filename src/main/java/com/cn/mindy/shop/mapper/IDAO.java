package com.cn.mindy.shop.mapper;

import java.util.List;

import com.cn.mindy.shop.pojo.User;


/**
 * 定义所有dao层
 * 所有需要实现的操作
 * 方法命名规则
 * <tx:advice id="txAdvice" transaction-manager="transactionManager">
	
		<tx:attributes>
			<!-- 传播行为 -->
			<tx:method name="save*"   propagation="REQUIRED"/>  
            <tx:method name="add*"     propagation="REQUIRED"/>
			<tx:method name="delete*"  propagation="REQUIRED"/>
			<tx:method name="insert*"  propagation="REQUIRED"/>
			<tx:method name="update*"  propagation="REQUIRED"/>
			<tx:method name="modify*"  propagation="REQUIRED"/>
			<tx:method name="find*"  propagation="SUPPORTS" read-only="true"/>
			<tx:method name="get*"  propagation="SUPPORTS" read-only="true"/>
			<tx:method name="select*" propagation="SUPPORTS" read-only="true"/>
			<tx:method name="query*" propagation="SUPPORTS" read-only="true"/>
		</tx:attributes>
	</tx:advice>
 * @author Mindy
 *
 */
public interface IDAO<T>{
	
	 //新增pojo
	 public boolean add(T t);
	
	 
	 //删除pojo
	 public boolean delete(T t);
	 
	 
	 //修改pojo
	 public boolean modify(T t);
	 
	
	 //查询指定pojo
	 public T query(T t);
	 
	 
	 //查询指定pojo
	 public List<T> query(Integer intParam);
	 
	 
	 //查询所有pojo
	 public List<T> queryAll();
	 
	 
	 //分页查询所有pojo
	 public List<T> queryAllByPage(int[] objs);
		 
	 
	 //查询总记录数
     public int queryAllCount();
	
     

}
