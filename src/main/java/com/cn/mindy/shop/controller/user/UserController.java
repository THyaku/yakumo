package com.cn.mindy.shop.controller.user;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.mindy.shop.controller.validator.ValidationLoginGroup;
import com.cn.mindy.shop.controller.validator.ValidationRegistGroup;
import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.service.user.UserService;
import com.cn.mindy.shop.utils.CheckImgUtils;
import com.cn.mindy.shop.utils.Common;
import com.cn.mindy.shop.utils.MD5Util;
import com.cn.mindy.shop.utils.MailUtils;
import com.cn.mindy.shop.utils.UUIDUtils;


@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger log = Logger.getLogger(UserController.class);

	@Resource(name="userService")
	public UserService userService;


	/**
	 * 登录页面初始化
	 * @return
	 */
	@RequestMapping("/loginInit")
	public ModelAndView loginInit(){

		log.debug("UserController........loginInit().......");


		ModelAndView mv =new ModelAndView();

		mv.setViewName("users/Login");

		return mv;
	}





	/**
	 * 登录操作
	 * @param model
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/login")
	public String login( HttpSession session,Model model,@Validated(value=(ValidationLoginGroup.class)) User user,BindingResult bindingResult){

		log.debug("bindingResult.hasErrors()....." + bindingResult.hasErrors());

		try {
			/**
			 * 1 校验
			 */
			if(bindingResult.hasErrors()){

				// 输出错误信息
				List<ObjectError> allErrors = bindingResult.getAllErrors();

				for (ObjectError objectError : allErrors) {
					// 输出错误信息
					log.error(objectError.getDefaultMessage());
				}

				// 将错误信息传到页面
				model.addAttribute("allErrors", allErrors);

				// 出错重新到
				return "forward:loginInit.action";

			}else{

				/**
				 * 2 连接数据库判断是否登录成功
				 */

				User _user = userService.query(user);

				if(null != _user){

					//判断激活状态
					if(Common.STATE_NO == _user.getState()){

						model.addAttribute(Common.MESSAGE,"账号未激活,登录失败");
						return "Message";
					}

					//给密码解密
					boolean result = MD5Util.judgeMD5(user.getPassword(),_user.getPassword() );

					if(result){

						//登录成功
						//将登录信息放入session
						session.setAttribute("username",user.getUsername());

						model.addAttribute(Common.MESSAGE,"登录成功");

						return "Message";

					}else{
						//登录失败
						model.addAttribute(Common.MESSAGE,"密码,登录失败");
						return "Message";
					}
				}else{
					//登录失败
					model.addAttribute("message","没有该账号,登录失败");
					return "Message";
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

			//登录失败
			model.addAttribute("message","系统异常,稍后登录.....");
			return "Message";
		}


	}

	//	  @RequestMapping("/tuichu")
	//	  public String tuiChu(HttpSession session){
	//		  session.setAttribute("username",null);
	//		  return "forward:loginInit.action";
	//	  }

	/**
	 * 查询用户名是否存在
	 * @param user
	 * @return
	 */
	@RequestMapping("/login_username")
	public @ResponseBody String login_username(@RequestBody User user){

		log.debug("UserController........login_username().......user = " + user);


		String data = "true";//用户名可用
		return data;

	}







	/**
	 * 注册页面初始化
	 * @return
	 */
	@RequestMapping(value = "/registInit",method=RequestMethod.GET)
	public ModelAndView registInit(){

		log.debug("UserController........registInit()......");

		ModelAndView mv = new ModelAndView();

		mv.setViewName("users/Regist");

		return mv;
	}




	/**
	 * 注册操作
	 * @param model
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/regist")
	public String regist(HttpServletRequest request,Model model,@Validated(value=ValidationRegistGroup.class)User user,BindingResult bindingResult){

		log.debug("UserController........regist().......user =" + user.toString());  


		//数据校验
		log.debug("bindingResult.hasErrors() = " + bindingResult.hasErrors()+"......................");

		if(bindingResult.hasErrors()){

			// 输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			for (ObjectError objectError : allErrors) {

				// 输出错误信息
				log.error(objectError.getDefaultMessage());

			}

			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);

			// 出错重新到
			return "forward:registInit.action";

		}else{

			/**
			 * 注册操作
			 */
			String message = null;

			try { 

				//1 上传头像
				if(!upLoadImage(request)){

					message="上传头像失败";
					return "Message";
				}

				//2 密码加密
				String md5pwd =MD5Util.addMD5(user.getPassword());
				user.setPassword(md5pwd);

				//3 生成激活码和激活状态
				user.setCode(UUIDUtils.getUUID());
				user.setState(Common.STATE_NO);

				//4 发送激活邮件
				MailUtils.sendMail(user.getEmail(), user.getCode());

				//5 注册信息持久化到数据库
				boolean result = userService.add(user);

				log.debug(".........regist result:" + result+"...................");

			} catch (NoSuchAlgorithmException e) {

				e.printStackTrace();
				message="系统异常";
				return "Message";

			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
				message="系统异常";
				return "Message";
			}

			return "Message";

		}

	}


	/**
	 * 上传图片操作
	 */
	private  boolean upLoadImage(HttpServletRequest request){

		boolean result = true;
		ServletFileUpload upload =null;

		try {
			request.setCharacterEncoding("utf-8");
			String uploadFileName = ""; //上传的文件名
			String fieldName = "";      //表单字段元素的name属性值

			//请求信息中的内容是否是multipart类型
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			//上传文件的存储路径（服务器文件系统上的绝对文件路径）
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/" );

			//创建临时文件目录路径
			File tempPatchFile=new File("d:\\temp\\buffer\\");

			if(!tempPatchFile.exists())  //判断文件或目录是否存在

				tempPatchFile.mkdirs();   //创建指定的目录，包括所有必需但不存在的父目录

			if (isMultipart) {

				DiskFileItemFactory factory=new DiskFileItemFactory();

				//设置缓冲区大小4kb
				factory.setSizeThreshold(4096);   

				//设置上传文件用到临时文件存放路径
				factory.setRepository(tempPatchFile);   

				upload = new ServletFileUpload(factory);

				//设置单个文件的最大限制
				upload.setSizeMax(1024 * 30);   

				//解析form表单中所有文件
				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> iter = items.iterator();

				//依次处理每个文件
				while (iter.hasNext()) {   

					FileItem item = (FileItem) iter.next();

					//文件表单字段
					String fileName = null;
					if (!item.isFormField()){  

						fileName = item.getName();

						//通过Arrays类的asList()方法创建固定长度的集合
						List<String> filType=Arrays.asList("gif","bmp","jpg");

						String ext=fileName.substring(fileName.lastIndexOf(".")+1);

						//判断文件类型是否在允许范围内
						if(!filType.contains(ext)) {

							request.setAttribute(Common.MESSAGE, "上传失败，文件类型只能是gif、bmp、jpg");
							result = false;

						}else if (fileName != null && !fileName.equals("")) {

							File fullFile = new File(item.getName());

							File saveFile = new File(uploadFilePath, fullFile.getName());

							item.write(saveFile);

							uploadFileName = fullFile.getName();

							request.setAttribute(Common.MESSAGE, "上传成功后的文件名是："+uploadFileName+"，文件大小是："+item.getSize()+"bytes!");

							result = false;
						}		
					}// end of isFormField

				}// end of whiles
			}
		}catch(FileUploadBase.SizeLimitExceededException ex){

			request.setAttribute(Common.MESSAGE, "上传失败，文件太大，单个文件的最大限制是："+upload.getSizeMax()+"bytes!");

			result = false;

		}catch (Exception e) {

			e.printStackTrace();
		}

		return result;

	}

	/**
	 * 获取注册码操作
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getImg")
	private void getImg(HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("................getImg()........................");
			CheckImgUtils.checkImg(request, response);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}



	/**
	 * @RequestBody 请求:json数据--->pojo
	 * @ResponseBody  响应: pojo----->json数据
	 */
	@RequestMapping(value="/checkUsername")

	public @ResponseBody User checkUsername(@RequestBody User user){

		System.out.println("coming into checkUsername().............json......user.username"+user.getUsername());
		String uname = user.getUsername();
		user = new User();
		user.setUsername(uname);


		return user; 
	}



	/**
	 * 退出操作
	 * @return
	 */
	@RequestMapping("/logout")
	public  String logout(HttpServletRequest rquest){
		//设置当前session失效
		rquest.getSession().invalidate();
		System.out.println("rquest.getContextPath():-------"+rquest.getContextPath());
//		return "forward:"+rquest.getContextPath()+"/main/mainInit";
		return "forward:loginInit";
	}

//		  @RequestMapping("/tuichu")
//		  public String tuiChu(HttpSession session){
//			  session.setAttribute("username",null);
//			  return "forward:loginInit.action";
//		  }



	/**
	 * 注册激活操作
	 */
	@RequestMapping(value="/activeCode/{code}")
	public String activeCode(@PathVariable String code,HttpServletRequest request){

		String path = null;
		String message = null;
		log.debug(".......activeCode....code = " + code);

		User user = userService.queryByCode(code);
		if(null != user){
			//存在该注册用户.进行激活操作 state = 1
			user.setState(Common.STATE_YES);
			//更新用户信息
			if(userService.updateByUid(user.getUid())){
				message = "注册激活成功!";
			} 
		}else{

			//不存在该注册用户
			message = "注册激活失败!";

		}
		request.setAttribute(Common.MESSAGE, message);
		return "Message";
	}






	/**
	 * 注解形式的属性编辑器
	 * 将之前的initBinder方法copy过来即可
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}


}
