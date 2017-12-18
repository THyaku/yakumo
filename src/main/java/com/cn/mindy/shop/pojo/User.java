package com.cn.mindy.shop.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cn.mindy.shop.controller.validator.ValidationRegistGroup;

@Repository("user")
@Scope("prototype")
public class User implements Serializable{
	

	private static final long serialVersionUID = 5544282910861954161L;
	
	private String uid;       //主键
	
	@Size(min=5,max=12,message="{user.username.length.error}",groups={ValidationRegistGroup.class})
	private String username;  //用户名
	
	private String password;  //密码
	private String name;      //真实姓名
	private String gender;   //male 男 female 女 
	private String email;    //邮件
	private String phone;    //手机号
	private String addr;     //地址
	private Date birthday;   //出生日期
	private Integer state;   //用户状态 0:未激活  1:已激活
	private String code;     //激活码
	private transient String repassword; //重新输入密码
	
	
	
	
	
	public User() {
		
	}


		

	public User(String username, String password, String name, String gender, String email, String phone,
			String addr, Date birthday, Integer state, String code) {
	
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.birthday = birthday;
		this.state = state;
		this.code = code;
		
	}
	
	public User(String uid, String username, String password, String phone, Date birthday) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
	}


	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", gender="
				+ gender + ", email=" + email + ", phone=" + phone + ", addr=" + addr + ", birthday=" + birthday
				+ ", state=" + state + ", code=" + code + ", repassword=" + repassword + "]";
	}
	
	
	

}
