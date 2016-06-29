package com.wushengde.service;

import com.wushengde.dao.XmlUserDao;
import com.wushengde.domain.User;
import com.wushengde.exception.MsgException;

public class UserService {
	private XmlUserDao dao = new XmlUserDao();
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void registUser(User user) throws MsgException{
		//1.检查用户名是否存在如果已经存在则提示出去
		if(dao.findUserName(user.getUsername())!=null){
			throw new MsgException("用户名已经存在");
		}
		//2.如果用户名不存在，则调用dao中的方法添加用户
		dao.addUser(user);
	}
	
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password){
		return dao.findUserByUNandPSW(username, password);
	}
}
