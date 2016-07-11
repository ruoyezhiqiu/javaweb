package com.wushengde.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.wushengde.pool.MyPool;

/**
 * ���ÿ�Դ���ݿ����ӳ� �������ݿ�
 * @author john
 *
 */
public class DBCPDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//MyPool pool = new MyPool();
		
		//��������Դ��ʽһ��
		
/*		//1.��������Դ��
		BasicDataSource source= new BasicDataSource();
		//2.��������Դ����
		source.setDriverClassName("com.mysql.jdbc.Driver");
		//3.�������ݿ���������
		source.setUrl("jdbc:mysql:///day09");
		//4.�������ݿ����ӵ��û���
		source.setUsername("root");
		//5.�������ݿ����ӵ�����
		source.setPassword("123456");*/
		
		//�������ݿ�����Դ��ʽ����ʹ�������ļ������еĲ�������װ����
		try {
			
		Properties prop = new Properties();
		prop.load(new FileReader("dbcp.properties"));
		BasicDataSourceFactory factory= new BasicDataSourceFactory();
		DataSource source= factory.createDataSource(prop);
		
			
			//1.����JDBCUtils������ -->��ȡ���ݿ�����:conn
			// conn=JDBCUtils.getConn();
			
			//2.�����Զ����ַ�� -->��ȡ���ݿ�����:conn
			//conn=pool.getConnection();
			
			//3.���ÿ�Դ���ݿ����ӳ� -->��ȡ���ݿ�����:conn
			conn=source.getConnection();
			
			ps = conn.prepareStatement("select * from account");
			rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch (Exception e) {

		} finally {
			//���е�close()������̨�Ѿ�������ˣ��Զ�������ַ����ȥ������ֻ��Ҫ���ճ���д���������
			if(rs!=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					rs=null;
				}
			}
			if(ps!=null){
				try{
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					ps=null;
				}
			}
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					conn=null;
				}
			}
		}
	}
}
