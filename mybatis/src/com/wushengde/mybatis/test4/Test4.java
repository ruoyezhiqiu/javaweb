package com.wushengde.mybatis.test4;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wushengde.mybatis.beans.Order;
import com.wushengde.mybatis.util.MybatisUtil;

public class Test4 {
	public static void main(String[] args) {
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		String statement="com.wushengde.mybatis.test4.orderMapper.getOrder2";
		Order order=session.selectOne(statement, 2);
		session.close();
		System.out.println(order);
	}
}
