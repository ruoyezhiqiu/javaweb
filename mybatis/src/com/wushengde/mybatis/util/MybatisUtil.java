package com.wushengde.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisUtil {
	public static SqlSessionFactory getFactory(){
		String resource = "conf.xml"; 
		//����mybatis�������ļ�,�˴�ʹ��������������ļ�����Ҳ���ع�����ӳ���ļ���
		 InputStream inputStream= Test.class.getClassLoader().getResourceAsStream(resource);
		//����sqlSession�Ĺ���
		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
		return factory;
	}
}
