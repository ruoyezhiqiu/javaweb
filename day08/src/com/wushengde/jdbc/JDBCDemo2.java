package com.wushengde.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.wushengde.util.JDBCUtils;

public class JDBCDemo2 {
	/*
	 *����һ��ʵ�����ݿ�ɾ�� 
	 */
	@Test
	public void delete(){
		Connection conn=null;
		Statement stat = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			int count = stat.executeUpdate("delete from user where name='gouwa'");
			if(count>0){
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
	}
	
	/*
	 * ���ܶ���ʵ�����ݿ��ѯ
	 * 
	 */
	@Test
	public void find() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("select *from user where name='zs'");
			while(rs.next()){
				String name =rs.getString("name");
				String password =rs.getString("password");
				String birthday = rs.getString("birthday");
				System.out.println("������"+name);
				System.out.println("���룺"+password);
				System.out.println("���գ�"+birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, stat, conn);
		}
	}

	/*
	 * ��������ʵ�ָ������ݵ��е�����
	 */
	@Test
	public void update() {
		Connection conn = null;
		Statement statement = null;
		try {
			// 1.ע�����ݿ�����
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.��ȡ���ݿ�����
			// conn =
			// DriverManager.getConnection("jdbc:mysql:///day08?user=root&password=123456");

			// ֱ�ӵ��ù����ࣺJDBCUtils
			conn = JDBCUtils.getConn();
			// 3.��������������
			statement = conn.createStatement();
			// 4.ִ��sql���
			int count = statement
					.executeUpdate("update user set birthday='2000-1-1' where name='zs'");
			// 5.����ִ�н��
			if (count > 0) {
				System.out.println("ִ�гɹ���Ӱ�쵽������Ϊ:" + count + "��");
			} else {
				System.out.println("ִ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.�ر���Դ
			/*
			 * if(rs!=null){ try { rs.close(); } catch (SQLException e) {
			 * e.printStackTrace(); }finally{ rs=null; } } if(statement!=null){
			 * try { statement.close(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }finally{
			 * statement=null; } } if(conn!=null){ try { conn.close(); } catch
			 * (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }finally{ conn=null; } }
			 */

			// ֱ�ӵ��ù�����ر���Դ:��û�ж���ResultSetʱ��ֱ�Ӵ���һ��null
			JDBCUtils.close(null, statement, conn);
		}

	}

	/*
	 * �����ģ�ʵ�������ݿ�����һ�����ݣ���ʵ��ע��ķ���
	 */
	@Test
	public void add() {
		Connection conn = null;
		Statement statement = null;
		try {
			// 1.ע�����ݿ�����
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.��ȡ���ݿ�����
			// conn =
			// DriverManager.getConnection("jdbc:mysql:///day08?user=root&password=123456");

			// ֱ�ӵ��ù����ࣺJDBCUtils
			conn = JDBCUtils.getConn();

			// 3.��������������
			statement = conn.createStatement();
			// 4.���ô���������sql���(����ִ��sql���)
			int count = statement.executeUpdate("insert into user values(null,'gouwa','123321','gouwa@sina.com','1999-9-9')");
			// 5.��Ϊû�з��ؽ������ֱ�Ӵ������
			if (count > 0) {
				System.out.println("ִ�гɹ���Ӱ�쵽������Ϊ:" + count + "��");
			} else {
				System.out.println("ִ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.�ر���Դ
			/*
			 * if(rs!=null){ try { rs.close(); } catch (SQLException e) {
			 * e.printStackTrace(); }finally{ rs=null; } } if(statement!=null){
			 * try { statement.close(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }finally{
			 * statement=null; } } if(conn!=null){ try { conn.close(); } catch
			 * (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }finally{ conn=null; } }
			 */

			// ֱ�ӵ��ù�����ر���Դ:��û�ж���ResultSetʱ��ֱ�Ӵ���һ��null
			JDBCUtils.close(null, statement, conn);
		}

	}

}