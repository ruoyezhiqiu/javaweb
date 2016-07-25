package com.wushengde.mybatis.test6;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wushengde.mybatis.beans.Classes;
import com.wushengde.mybatis.util.MybatisUtil;

public class Test6 {
	public static void main(String[] args) {
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		String statement="com.wushengde.mybatis.test6.classMapper.getClass2";
		Classes classes=session.selectOne(statement, 1);
		session.close();
		System.out.println(classes);
	}
}
