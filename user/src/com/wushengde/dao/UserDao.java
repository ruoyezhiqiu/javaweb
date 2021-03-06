package com.wushengde.dao;

import java.util.ArrayList;
import java.util.List;

import com.wushengde.domain.Admin;
import com.wushengde.domain.Message;
import com.wushengde.domain.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户
	 * 
	 * @param uername 用户名
	 *            
	 * @return 根据用户名找到的用户信息bean，如果没有找到返回null。
	 */
	public User findUserName(String username);
	
	/**
	 * 添加用户的方法
	 * 
	 * @param user
	 *            要添加的用户信息bean
	 */
	public void addUser(User user);
	
	
	/**
	 * 普通用户登录查询
	 * 根据用户名密码查找对应的用户
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 找到的用户，如果找不到则返回null。
	 */
	
	public User findUserByUNandPSW(String username, String password);
	/**
	 * 管理员用户登录查询
	 */
	
	public Admin findAdminUP(String username,String password);
	
	/**
	 * 查找数据库中的文章信息
	 * @return
	 * 
	 */
	
	public List findMessage();
	
	/**
	 * 添加文章
	 * @param msg
	 */
	public void addMsg(Message msg);
	
	/**
	 * 根据Id查看文章内容
	 * @param msg
	 */
	public Message findMsg(int id);
	/**
	 * 更新文章数据库中的内容
	 * @param msg
	 */
	public void updateMsg(Message msg);
	/**
	 * 删除文章数据库中的内容
	 * @param msg
	 */
	public void deleteMsg(Message msg);
}
