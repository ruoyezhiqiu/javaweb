package com.wushengde.service;

import java.util.List;

import com.wushengde.dao.MysqlUserDao;
import com.wushengde.dao.UserDao;
import com.wushengde.dao.XmlUserDao;
import com.wushengde.domain.Admin;
import com.wushengde.domain.Message;
import com.wushengde.domain.User;
import com.wushengde.exception.MsgException;
import com.wushengde.factory.DaoFactory;

public class UserService {
	// private XmlUserDao dao = new XmlUserDao();
	// private MysqlUserDao dao = new MysqlUserDao();
	private UserDao dao= DaoFactory.getfactory().getDao();
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void registUser(User user) throws MsgException {
		// 1.检查用户名是否存在如果已经存在则提示出去
		if (dao.findUserName(user.getUsername()) != null) {
			throw new MsgException("用户名已经存在");
		}
		// 2.如果用户名不存在，则调用dao中的方法添加用户
		dao.addUser(user);
	}

	/**
	 * 检查用户名密码是否正确
	 * 
	 * @param username
	 * @param password
	 */
	public User isUser(String username, String password) {
		return dao.findUserByUNandPSW(username, password);
	}
	/**
	 * 检查管理员用户名密码是否正确
	 * 
	 */
	public Admin isAdmin(String username,String password){
		return dao.findAdminUP(username, password);
	}
	
	/**
	 * 向数据库添加文章
	 * @param msg
	 */
	public void addMessages(Message msg){
		dao.addMsg(msg);
	}
	
	public List findMessage(){
		return dao.findMessage();
	}
	public Message findMsg(int id){
		return dao.findMsg(id);
	}
	public void updateMsg(Message msg){
		dao.updateMsg(msg);
	}
	
	public void deleteMsg(Message msg){
		dao.deleteMsg(msg);
	}
}
