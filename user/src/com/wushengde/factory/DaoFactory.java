package com.wushengde.factory;

import java.io.FileReader;
import java.util.Properties;

import com.wushengde.dao.UserDao;

/**
 * 
 * @author john
 *������һ�������ࣺ������һ����õ���ģʽ��
 */
public class DaoFactory {
	private static DaoFactory factory = new DaoFactory();
	private static Properties prop =null;
	
	static {
		try{
			prop=new Properties();
			prop.load(new FileReader(DaoFactory.class.getClassLoader().getResource("config.properties").getPath()));
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private DaoFactory(){}
	
	public static DaoFactory getfactory(){
		return factory;
	}
	public UserDao  getDao(){
		String clazz= prop.getProperty("UserDao");
		try {
			return (UserDao) Class.forName(clazz).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
