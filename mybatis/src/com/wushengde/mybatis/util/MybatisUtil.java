package com.wushengde.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisUtil {
	public static SqlSessionFactory getFactory(){
		String resource = "conf.xml"; 
		//加载mybatis的配置文件,此处使用类加载器加载文件（它也加载关联的映射文件）
		 InputStream inputStream= Test.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
		return factory;
	}
}
