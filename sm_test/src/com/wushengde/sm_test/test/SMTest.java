package com.wushengde.sm_test.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wushengde.sm_test.domain.User;
import com.wushengde.sm_test.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)//使用Spring的测试框架
@ContextConfiguration("/beans.xml") //加载Spring的配置问价beans.xml文件
public class SMTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testAdd(){
		User user=new User(-1,"boss",new Date(),999999);
		userMapper.save(user);
	}
	@Test
	public void testDelete(){
		userMapper.delete(1);
	}
	@Test
	public void testUpdate(){
		User user=new User(1,"tom",new Date(),123456);
		userMapper.update(user);
	}
	@Test
	public void testFindById(){
		User user=userMapper.findById(2);
		System.out.println(user);
	}
}
