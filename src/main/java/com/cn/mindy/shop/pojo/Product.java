package com.cn.mindy.shop.pojo;

import java.io.Serializable;
import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository("product")
@Scope("prototype")
public class Product implements Serializable {
	

	private static final long serialVersionUID = -5336829272613973857L;
	private Integer pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String pdesc;
	private Integer is_hot;
	private Date pdate;
	private Integer csid;
	private CategorySecond categorySecond;
	
	
		//private Integer csid;
		public Integer getPid() {
			return pid;
		}
		public void setPid(Integer pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public Double getMarket_price() {
			return market_price;
		}
		public void setMarket_price(Double market_price) {
			this.market_price = market_price;
		}
		public Double getShop_price() {
			return shop_price;
		}
		public void setShop_price(Double shop_price) {
			this.shop_price = shop_price;
		}
		public String getImage() {
			return image;
		}
		
		public void setImage(String image) {
			this.image = image;
		}
		public String getPdesc() {
			return pdesc;
		}
		public void setPdesc(String pdesc) {
			this.pdesc = pdesc;
		}
		
		public Integer getIs_hot() {
			return is_hot;
		}
		public void setIs_hot(Integer is_hot) {
			this.is_hot = is_hot;
		}
		public Date getPdate() {
			return pdate;
		}
		public void setPdate(Date pdate) {
			this.pdate = pdate;
		}
		
		
		public Integer getCsid() {
			return csid;
		}
		public void setCsid(Integer csid) {
			this.csid = csid;
		}
		public CategorySecond getCategorySecond() {
			return categorySecond;
		}
		public void setCategorySecond(CategorySecond categorySecond) {
			this.categorySecond = categorySecond;
		}
		
		public Product(Integer pid, String pname, Double market_price, Double shop_price, String image, String pdesc,
				Integer is_hot, Date pdate, CategorySecond categorySecond) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.market_price = market_price;
			this.shop_price = shop_price;
			this.image = image;
			this.pdesc = pdesc;
			this.is_hot = is_hot;
			this.pdate = pdate;
			this.categorySecond = categorySecond;
		}
		public Product() {
			super();
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			
			result = prime * result + ((image == null) ? 0 : image.hashCode());
			result = prime * result + ((market_price == null) ? 0 : market_price.hashCode());
			result = prime * result + ((pdesc == null) ? 0 : pdesc.hashCode());
			result = prime * result + ((pid == null) ? 0 : pid.hashCode());
			result = prime * result + ((pname == null) ? 0 : pname.hashCode());
			result = prime * result + ((shop_price == null) ? 0 : shop_price.hashCode());
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
			Product other = (Product) obj;
			
			if (image == null) {
				if (other.image != null)
					return false;
			} else if (!image.equals(other.image))
				return false;
			if (market_price == null) {
				if (other.market_price != null)
					return false;
			} else if (!market_price.equals(other.market_price))
				return false;
			if (pdesc == null) {
				if (other.pdesc != null)
					return false;
			} else if (!pdesc.equals(other.pdesc))
				return false;
			if (pid == null) {
				if (other.pid != null)
					return false;
			} else if (!pid.equals(other.pid))
				return false;
			if (pname == null) {
				if (other.pname != null)
					return false;
			} else if (!pname.equals(other.pname))
				return false;
			if (shop_price == null) {
				if (other.shop_price != null)
					return false;
			} else if (!shop_price.equals(other.shop_price))
				return false;
			return true;
		}
		
		
		@Override
		public String toString() {
			return "Product [pid=" + pid + ", pname=" + pname
					+ ", market_price=" + market_price + ", shop_price="
					+ shop_price + ", image=" + image + ", pdesc=" + pdesc
					+ ", is_hot=" + is_hot + ", pdate=" + pdate + ", csid="
					+ csid + ", categorySecond=" + categorySecond + "]";
		}
		
		
		
	


}

