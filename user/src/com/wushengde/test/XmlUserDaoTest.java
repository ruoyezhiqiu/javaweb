package com.wushengde.test;

import org.junit.Test;

import com.wushengde.dao.XmlUserDao;
import com.wushengde.domain.User;

public class XmlUserDaoTest {
	//����XmlUserDao�࣬�����û��������û��ķ���
	@Test
	public void testFindUserByUserName(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserName("admin");
		System.out.println(user);
	}
	//����XmlUserDao�࣬�����û�����������û��ķ���
	@Test
	public void testFindUserByNMandPSW(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUNandPSW("����", "123456");
		System.out.println(user);
	}
	//����XmlUserDao�࣬�����û����ķ���
	@Test
	public void testAddUser(){
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUsername("����");
		user.setPassword("123456");
		user.setNickname("test");
		user.setEmail("test@qq.com");
		dao.addUser(user);
	}
}