package com.zx.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.Pojo.Articel;
import com.zx.Pojo.Message;
import com.zx.Pojo.Pageinfo;
import com.zx.Pojo.User;
import com.zx.Service.EncoderHandler;
import com.zx.Service.ShortMessageUnit;
import com.zx.Service.UserService;

@RestController
public class UserController {
	private ShortMessageUnit shortMessageUnit;
	private UserService userService;
	//登陆后 保存用户信息 至cookie 在预约的时候一并提交
	@RequestMapping("/login")
	public User login(@RequestParam(value="username") String username,@RequestParam(value="password") String password)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=sdf.format(new Date());
		EncoderHandler eh=new EncoderHandler();
		String md5Password=eh.encodeByMD5(password);
		User user=new User();
		user.setUserName(username);
		user.setPassword(md5Password);
		user.setLoginPointDate(dateStr);
		User u=userService.getLogin(user);
		if(u!=null)
		{
			u.setCode("success");
		}
		return u;
	}
	/**
	 * 注册的时候需要校验码核对 （阿里大鱼）
	 * @param username
	 * @param password
	 * @param niceName
	 * @param trueName
	 * @return
	 */
	@RequestMapping("/regist")
	public Message regist(@RequestParam(value="userid") Integer userid,@RequestParam(value="username") String username,@RequestParam(value="password") String password,@RequestParam(value="niceName") String niceName,@RequestParam(value="trueName") String trueName,@RequestParam(value="checkcode") String checkcode)
	{
		boolean result=userService.checkCode(username, checkcode);
		if(result)
		{
			EncoderHandler eh=new EncoderHandler();
			String md5Password=eh.encodeByMD5(password);
			User user=new User();
			user.setId(userid);
			user.setUserName(username);
			user.setPassword(md5Password);
			user.setNiceName(niceName);
			user.setTrueName(trueName);
			User u=userService.regist(user);
			return new Message("success", "注册成功！",new Date());
		}else
		{
			return new Message("fail", "验证码错误！",new Date());
		}
	}
	/**
	 * 找回密码需要校验码核对 （阿里大鱼）
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/findpassword")
	public Message findpassword(@RequestParam(value="username") String username,@RequestParam(value="checkcode") String checkcode,@RequestParam(value="password") String password)
	{
		boolean result=userService.checkCode(username, checkcode);
		if(result)
		{
			EncoderHandler eh=new EncoderHandler();
			String md5Password=eh.encodeByMD5(password);
			User user=new User();
			user.setUserName(username);
			user.setPassword(md5Password);
			Message msg=userService.findpassword(user);
			return msg;
		}else
		{
			return new Message("codefail", "验证码错误！",new Date());
		}
	}
	/**
	 * 判断用户名是否重复
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkusername")
	public Message checkusername(@RequestParam(value="username") String username)
	{
		Message msg=userService.checkusername(username);
		return msg;
	}
	
	/**
	 * 判断用户是否注册
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkusernamehasregist")
	public Message checkusernamehasregist(@RequestParam(value="username") String username)
	{
		Message msg=userService.checkusernamehasregist(username);
		return msg;
	}
	
	@RequestMapping("/singin")
	public Message singin(@RequestParam(value="userid") String userid)
	{
		Message msg=userService.singin(userid);
		return msg;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/adminlogin/{username}/{password}")
	public Message adminlogin(@PathVariable(value="username") String username,@PathVariable(value="password") String password,HttpServletRequest request)
	{
		EncoderHandler eh=new EncoderHandler();
		String md5Password=eh.encodeByMD5(password);
		User user=new User();
		user.setUserName(username);
		user.setPassword(md5Password);
		Integer u=userService.getadminLogin(user);
		if(u >0)
		{
			HttpSession session=request.getSession();
			session.setAttribute("login", "success");
			return new Message("success", "登陆成功!", new Date());
		}else
		{
			return new Message("fail", "登陆失败!", new Date());
		}
	}
	/**
	 * 修改用户信息
	 * @param userid
	 * @param nicename
	 * @param truename
	 * @param sex
	 * @param birthday
	 * @param community
	 * @param detailAddress
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/changeuserinfo")
	public Message changeuserinfo(@RequestParam(value="userid") Integer userid,@RequestParam(value="nicename") String nicename,@RequestParam(value="truename") String truename,@RequestParam(value="sex") Integer sex,@RequestParam(value="birthday") String birthday,@RequestParam(value="community") String community,@RequestParam(value="detailAddress") String detailAddress) throws ParseException
	{
		User user=new User();
		user.setId(userid);
		user.setNiceName(nicename);
		user.setTrueName(truename);
		user.setSex(sex);
		System.out.println(birthday);
		user.setBirthday(birthday);
		user.setCommunity(community);
		user.setDetailAddress(detailAddress);
		boolean result=userService.changeUserinfo(user);
		if(result)
		{
			return new Message("success", "修改成功！",new Date());
		}else
		{
			return new Message("fail", "修改失败！",new Date());
		}
	}
	
	@RequestMapping("/getPoint/{userid}")
	public Integer getPoint(@PathVariable(value="userid") Integer userid)
	{
		User user=new User();
		user.setId(userid);
		return userService.getPoint(user);
	}
	
	@RequestMapping("/updatePoint")
	public Message updatePoint(@RequestParam(value="userid") String userid,@RequestParam(value="point") String point)
	{
		return userService.updatePoint(userid, point);
	}
	/**
	 * 获取短信验证码
	 * @param userid
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/sendCode/{username}/{type}")
	public User createCode(@PathVariable(value="username") String username,@PathVariable(value="type") Integer type) throws Exception
	{
		//type=1的时候 标识注册 type=2的时候 表示找回密码
		String code=(int) (Math.random()*10000%10000)+"";
		if(type==1)
		{
			User user=new User();
			user.setUserName(username);
			user.setPassword("123456");
			user.setCheckcode(code);
			user.setStatue(2); //账号置为注册状态
			boolean result=userService.hasexist(user);
			shortMessageUnit.sendShortMessage(username,code);
			if(result)
			{
				//存在短信验证码信息 更新验证码
				return userService.updateUserrecord(user);
			}else
			{
				//不存在 创建新纪录
				return userService.createUserrecord(user);
			}
		}else
		{
			User user=new User();
			user.setUserName(username);
			user.setCheckcode(code);
			user.setStatue(3);//账号置为找回密码状态
			shortMessageUnit.sendShortMessage(username,code);
			return userService.updateUserrecord(user);
		}
	}
	
	@RequestMapping("/getUserByPage")
	public Pageinfo getUserByPage(@RequestParam(value="username",required=false) String username,@RequestParam(value="truename",required=false) String truename,@RequestParam(value="page",defaultValue="1") String page)
	{
		User conduser=new User();
		conduser.setUserName(username);
		conduser.setTrueName(truename);
		Integer numofuser=userService.getNumofUserbyPi(conduser);
		Pageinfo pi=initpage(numofuser, page);
		if(Integer.parseInt(page) >pi.getLastpage())
		{
			pi.setPagenum(pi.getLastpage());
		}
		pi.setConduser(conduser);
		pi.setBegin((pi.getPagenum()-1)*pi.getShownum());
		pi.setEnd(pi.getBegin()+pi.getShownum());
		List<User> resultlist=userService.getListofUserbyPiandCond(pi);
		pi.setUserlist(resultlist);
		return pi;
	}
	
	//页面初始化
	public Pageinfo initpage(Integer datanum,String page)
	{
		Pageinfo pageif=new Pageinfo();
		int pageshownum=10;//每页展示数
		pageif.setShownum(pageshownum);
		pageif.setFirstpage(1);
		Integer allpage=(datanum>0)?(((datanum)%pageshownum==0)?(datanum/pageshownum):(datanum/pageshownum)+1):1;
		pageif.setAllpage(allpage);
		pageif.setLastpage(allpage);
		Integer pagenum=0;
		
		if(page==null)
		{
			pageif.setPagenum(1);
		}else
		{
			pagenum=Integer.parseInt(page);
			pageif.setPagenum(pagenum);
		}
		pageif.setPrev((pageif.getPagenum()-1)>0?pageif.getPagenum()-1:1);
		pageif.setNext((pageif.getPagenum()+1)<allpage?pageif.getPagenum()+1:allpage);
		String pageStr="";
		if(pagenum-3<=1||allpage<=7)
		{
			for (int i = 1; i <= ((allpage>7)?7:allpage); i++) {
				if(i==((allpage>7)?7:allpage))
				{
					pageStr+=i;
				}else
				{
					pageStr+=i+",";
				}
			}
			if(allpage>7)
			{
				pageStr+=",...";
			}
		}else
		{
			pageStr+="...,";
			int num=((((pagenum+3>allpage)?allpage:pagenum)>3)?3:((pagenum+3>allpage)?allpage:pagenum));
			int cnum=(num+pagenum)>allpage?(allpage-pagenum):num;
			for (int i = cnum-7; i <=cnum; i++) {
				if(i==cnum)
				{
					if(cnum+pagenum==allpage)
					{
						pageStr+=(pagenum+i);
					}else
					{
						pageStr+=(pagenum+i)+",...";
					}
				}else
				{
					pageStr+=(pagenum+i)+",";
				}
			}
		}
		pageif.setPageStr(pageStr.split(","));
		return pageif;
	}
	
	public ShortMessageUnit getShortMessageUnit() {
		return shortMessageUnit;
	}
	public void setShortMessageUnit(ShortMessageUnit shortMessageUnit) {
		this.shortMessageUnit = shortMessageUnit;
	}
	
	@RequestMapping("/loginaddpoint/{userid}")
	public void loginaddpoint(@PathVariable(value="userid") Integer userid)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=sdf.format(new Date());
		User user=new User();
		user.setId(userid);
		user.setLoginPointDate(dateStr);
		userService.loginaddPoint(user);
	}
}
