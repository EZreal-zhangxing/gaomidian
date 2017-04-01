package com.zx.Dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zx.Pojo.Message;
import com.zx.Pojo.Model;
import com.zx.Pojo.Pageinfo;
import com.zx.Pojo.User;

public class UserDaoImp extends SqlSessionDaoSupport{
	public User getLogin(User user)
	{
		SqlSession session=this.getSqlSession();
		List<User> list=session.selectList("selectUser",user);
		return list.size()>0?list.get(0):null;
	}
	public User regist(User user)
	{
		SqlSession session=this.getSqlSession();
		int result=session.update("UpdateUserByid",user);
		if(result>0)
		{
			List<User> list=session.selectList("selectUser",user);
			return list.size()>0?list.get(0):null;
		}else
		{
			return null;
		}
	}
	
	public Message findpassword(User user)
	{
		SqlSession session=this.getSqlSession();
		List checkuser=session.selectList("checkUser",user);
		Integer result=(checkuser.size())>0?(Integer)checkuser.get(0):0;
		if(result>0)
		{
			int upin=session.update("updateUser",user);
			if(upin>0)
			{
				return new Message("success", "更新密码成功", new Date());
			}else
			{
				return new Message("fail", "更新密码失败", new Date());
			}
		}else
		{
			return new Message("notexist", "用户不存在", new Date());
		}
	}
	
	public Integer checkusername(String username)
	{
		SqlSession session=this.getSqlSession();
		List list=session.selectList("checkusername",username);
		return list.size()>0?(Integer)list.get(0):0;
	}
	public Integer checkusernameisexist(String username)
	{
		SqlSession session=this.getSqlSession();
		List list=session.selectList("checkusernameisexist",username);
		return list.size()>0?(Integer)list.get(0):0;
	}
	
	public Integer singin(Map<String, String> map)
	{
		SqlSession session=this.getSqlSession();
		int result=session.update("singinUser",map);
		return result;
	}
	
	public User getUserByid(String userid)
	{
		SqlSession session=this.getSqlSession();
		List<User> list=session.selectList("selectUserbyid",userid);
		return list.size()>0?list.get(0):null;
	}
	
	
	public Integer getadminLogin(User user)
	{
		SqlSession session=this.getSqlSession();
		List list=session.selectList("selectadminUser",user);
		return list.size()>0?(Integer)list.get(0):0;
	}
	
	public Integer getPoint(User user)
	{
		SqlSession session=this.getSqlSession();
		List list=session.selectList("selectPointbyid",user);
		return list.size()>0?(Integer)list.get(0):0;
	}
	
	public Integer changeUserinfo(User user)
	{
		SqlSession session=this.getSqlSession();
		return session.update("changeuserinfo",user);
	}
	
	public Integer checkCode(String username,String checkcode)
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", username);
		map.put("checkcode", checkcode);
		SqlSession session=this.getSqlSession();
		List list=session.selectList("checkUserCode",map);
		return list.size()>0?(Integer)list.get(0):0;
	}
	
	public User createrecordUser(User user)
	{
		SqlSession session=this.getSqlSession();
		int result=session.insert("insertrecordUser",user);
		if(result>0)
		{
			List<User> list=session.selectList("selectUser",user);
			return list.size()>0?list.get(0):null;
		}else
		{
			return null;
		}
	}
	
	public Integer hasexist(User user)
	{
		SqlSession session=this.getSqlSession();
		List list=session.selectList("hasexistUser",user);
		return list.size()>0?(Integer)list.get(0):0;
	}
	
	public User updateUserrecord(User user)
	{
		SqlSession session=this.getSqlSession();
		int result=session.update("updaterecordUser",user);
		if(result>0)
		{
			List<User> list=session.selectList("selectUser",user);
			return list.size()>0?list.get(0):null;
		}else
		{
			return null;
		}
	}
	
	public Integer getnumofUser(User user)
	{
		SqlSession session=this.getSqlSession();
		List list=session.selectList("selectNumofUser",user);
		return list.size()>0?(Integer)list.get(0):0;
	}
	
	public List<User> getlistofUser(Pageinfo pi)
	{
		SqlSession session=this.getSqlSession();
		List<User> list=session.selectList("selectListofUser",pi);
		return list;
	}
	
	public Integer updatePoint(Map<String, String> map)
	{
		SqlSession session=this.getSqlSession();
		Integer result=session.update("updatePoint",map);
		return result;
	}
	
	public Integer addloginPoint(Map<String, String> map)
	{
		SqlSession session=this.getSqlSession();
		Integer result=session.update("addloginPoint",map);
		return result;
	}
}
