package com.cn.mindy.shop.pojo;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * CategorySecond 二级分类实体类
 * DROP TABLE IF EXISTS `categorysecond`;
	CREATE TABLE `categorysecond` (
	  `csid` int(11) NOT NULL AUTO_INCREMENT,
	  `csname` varchar(255) DEFAULT NULL,
	  `cid` int(11) DEFAULT NULL,
	  PRIMARY KEY (`csid`),
	  KEY `FK936FCAF21DB1FD15` (`cid`),
	  CONSTRAINT `FK936FCAF21DB1FD15` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
	) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
 * 
 * @author Mindy
 *
 */
@Repository("categorySecond")
@Scope("prototype")
public class CategorySecond implements Serializable{

	/**
	 * 属性
	 */
	private static final long serialVersionUID = 209312843137771375L;

	private Integer csid;      //csid主键
	
	private String csname;      //csname二级分类商品名称
	
	private Integer cid;        //cid外键  一级分类cid
	
	private Category  category; //所对应的一级分类
	

	

	public CategorySecond() {
	
	}
	
	
    public CategorySecond( String csname) {
	
		this.csname = csname;
	}



	public CategorySecond(Integer csid, String csname) {
		
		this.csid = csid;
		this.csname = csname;
	}
	
	
	public CategorySecond( String csname, Category category) {
		
		this.csname = csname;
		this.category = category;
	}
	
	

	public CategorySecond(Integer csid, String csname, Category category) {
	
		this.csid = csid;
		this.csname = csname;
		this.category = category;
	}



	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}


	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	
	

	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((csid == null) ? 0 : csid.hashCode());
		result = prime * result + ((csname == null) ? 0 : csname.hashCode());
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
		CategorySecond other = (CategorySecond) obj;
		if (csid == null) {
			if (other.csid != null)
				return false;
		} else if (!csid.equals(other.csid))
			return false;
		if (csname == null) {
			if (other.csname != null)
				return false;
		} else if (!csname.equals(other.csname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", cid="
				+ cid + ", category=" + category + "]";
	}


	

}
