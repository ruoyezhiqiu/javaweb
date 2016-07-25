package com.wushengde.mybatis.test1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.mybatis.beans.User;

public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		//����mybatis�������ļ�,�˴�ʹ��������������ļ�����Ҳ���ع�����ӳ���ļ���
		 InputStream inputStream= Test.class.getClassLoader().getResourceAsStream(resource);
		//����sqlSession�Ĺ���
		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
		//������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session=factory.openSession();
		//ӳ��sql�ı�ʶ�ַ���
		//���´������˼Ӻ��ַ���ƴ�ӣ�Ŀ����Ϊ��˵������ӳ���ļ�������Ӧ��sql����ǩ
		String statement="com.wushengde.mybatis.test1.userMapper.getUser";
		//ִ�в�ѯ����һ��Ψһuser�����sql
		User user=session.selectOne(statement, 11);
		System.out.println(user);
	}
}