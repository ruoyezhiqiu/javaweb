package com.wushengde.test;

import org.junit.Test;

import com.wushengde.dao.XmlUserDao;
import com.wushengde.domain.User;

public class XmlUserDaoTest {
	//测试XmlUserDao类，根据用户名查找用户的方法
	@Test
	public void testFindUserByUserName(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserName("admin");
		System.out.println(user);
	}
	//测试XmlUserDao类，根据用户名密码查找用户的方法
	@Test
	public void testFindUserByNMandPSW(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUNandPSW("张三", "123456");
		System.out.println(user);
	}
	//测试XmlUserDao类，添加用户名的方法
	@Test
	public void testAddUser(){
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUsername("李四");
		user.setPassword("123456");
		user.setNickname("test");
		user.setEmail("test@qq.com");
		dao.addUser(user);
	}
}
