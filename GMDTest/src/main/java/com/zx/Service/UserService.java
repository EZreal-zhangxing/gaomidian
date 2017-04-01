package com.zx.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zx.Dao.UserDaoImp;
import com.zx.Pojo.Message;
import com.zx.Pojo.Pageinfo;
import com.zx.Pojo.User;

public class UserService {
	private UserDaoImp userDaoimp;
	
	public UserDaoImp getUserDaoimp() {
		return userDaoimp;
	}

	public void setUserDaoimp(UserDaoImp userDaoimp) {
		this.userDaoimp = userDaoimp;
	}
	/**
	 * 登陆方法
	 * @param user
	 * @return
	 */
	public User getLogin(User user)
	{
		//用户登陆
		User u=userDaoimp.getLogin(user);
		//登陆签到+1P
		if(u!=null)
		{
			if(!(u.getLoginPointDate()!= null && u.getLoginPointDate().equals(user.getLoginPointDate())))
			{
				//今日未登陆加分
				addloginPoint(u.getId()+"",user.getLoginPointDate());
			}
		}
		return u;
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public User regist(User user)
	{
		User u=userDaoimp.regist(user);
		return u;
	}
	/**
	 * 找回密码
	 * @param user
	 * @return
	 */
	public Message findpassword(User user)
	{
		Message msg=userDaoimp.findpassword(user);
		return msg;
	}
	/**
	 * 用户是否注册
	 * @param user
	 * @return
	 */
	public Message checkusername(String username)
	{
		Integer result=userDaoimp.checkusername(username);
		if(result>0)
		{
			return new Message("fail", "用户名已注册！", new Date());
		}else
		{
			return new Message("success", "可以使用", new Date());
		}
	}
	
	public Message checkusernamehasregist(String username)
	{
		Integer result=userDaoimp.checkusernameisexist(username);
		if(result>0)
		{
			return new Message("success", "用户名已注册", new Date());
			
		}else
		{
			return new Message("fail", "用户名没有注册！", new Date());
		}
	}
	/**
	 * 用户签到
	 * @param user
	 * @return
	 */
	public Message singin(String userid)
	{
		User user=userDaoimp.getUserByid(userid);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=sdf.format(new Date());
		if(user.getLastPointDate()!= null && user.getLastPointDate().equals(dateStr))
		{
			//最后签到时间 是今天
			return new Message("exist", "已经签到！", new Date());
		}else
		{
			Map<String, String> map=new HashMap<String, String>();
			map.put("lastPointDate", dateStr);
			map.put("userid", userid);
			Integer result=userDaoimp.singin(map);
			if(result>0)
			{
				return new Message("success", "签到成功！", new Date());
			}else
			{
				return new Message("fail", "签到失败！", new Date());
			}
		}
	}
	/**
	 * 登陆方法
	 * @param user
	 * @return
	 */
	public Integer getadminLogin(User user)
	{
		Integer u=userDaoimp.getadminLogin(user);
		return u;
	}
	
	/**
	 * 登陆方法
	 * @param user
	 * @return
	 */
	public Integer getPoint(User user)
	{
		Integer result=userDaoimp.getPoint(user);
		return result;
	}
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean changeUserinfo(User user)
	{
		Integer result=userDaoimp.changeUserinfo(user);
		if(result>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	/**
	 * 判断用户验证码是否正确
	 * @return
	 */
	public boolean checkCode(String username,String checkcode)
	{
		Integer result=userDaoimp.checkCode(username, checkcode);
		if(result>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	/**
	 * 注册时候创建一条只有电话的记录
	 * @return
	 */
	public User createUserrecord(User user)
	{
		User resultuser= userDaoimp.createrecordUser(user);
		return resultuser;
	}
	
	public boolean hasexist(User user)
	{
		int resultuser= userDaoimp.hasexist(user);
		if(resultuser>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public User updateUserrecord(User user)
	{
		User resultuser= userDaoimp.updateUserrecord(user);
		return resultuser;
	}
	
	public Integer getNumofUserbyPi(User conduser)
	{
		return userDaoimp.getnumofUser(conduser);
	}
	//获取用户信息 分页 和条件
	public List<User> getListofUserbyPiandCond(Pageinfo pi)
	{
		return userDaoimp.getlistofUser(pi);
	}
	
	public Message updatePoint(String userid,String point)
	{
		Map<String, String> map=new HashMap<String, String>();
		map.put("userid", userid);
		map.put("point", point);
		Integer result=userDaoimp.updatePoint(map);
		if(result>0)
		{
			return new Message("success", "修改成功！", new Date());
		}else
		{
			return new Message("fail", "修改失败！", new Date());
		}
	}
	
	public void addloginPoint(String userid,String loginPointDate)
	{
		Map<String, String> map=new HashMap<String, String>();
		map.put("userid", userid);
		map.put("loginPointDate", loginPointDate);
		Integer result=userDaoimp.addloginPoint(map);
	}
	
	public void loginaddPoint(User user)
	{
		User u=userDaoimp.getUserByid(user.getId()+"");
		if(!(u.getLoginPointDate()!= null && u.getLoginPointDate().equals(user.getLoginPointDate())))
		{
			//今日未登陆加分
			addloginPoint(u.getId()+"",user.getLoginPointDate());
		}
	}
}
