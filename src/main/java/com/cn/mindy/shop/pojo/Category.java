package com.cn.mindy.shop.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Category 一级分类实体类
 * @author Mindy
 *
 */
@Repository("category")
@Scope("prototype")
public class Category implements Serializable {
	

	private static final long serialVersionUID = 3109589538326022996L;

	private Integer cid;    //id
	
	private String cname;  //一级分类名称
	
	
	//所属二级分类的集合
	private Set<CategorySecond> categorySecond = new HashSet<CategorySecond>();
	
	
	
	public Category() {
		
		
	}
	
	public Category(String cname) {
		
		this.cname = cname;
	}



	public Category(Integer cid, String cname) {
		
		this.cid = cid;
		this.cname = cname;
	}



	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	
	
	
	public Set<CategorySecond> getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(Set<CategorySecond> categorySecond) {
		this.categorySecond = categorySecond;
	}
	
	

	@Override
	public String toString() {
		
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		return true;
	}

	
	
	
	
	
	
	

}
