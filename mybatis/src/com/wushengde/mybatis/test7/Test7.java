package com.wushengde.mybatis.test7;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.wushengde.mybatis.beans.ConditionUser;
import com.wushengde.mybatis.beans.User;
import com.wushengde.mybatis.util.MybatisUtil;

public class Test7 {
	public static void main(String[] args) {
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		String statement="com.wushengde.mybatis.test7.userMapper.getUser";
		String name="o";
		name=null;
		ConditionUser conditionUser=new ConditionUser("%"+name+"%",13,19);
		List<User> list =session.selectList(statement, conditionUser);
		session.close();
		System.out.println(list);
	}
}
