package com.wushengde.batch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wushengde.util.JDBCUtils;

/*
 ����������������䣬�������һ��ִ����ɵĹ��̽���������(�磺�����sql���)��
 	���磺
 	create database day08batch;
 	use day08batch;
 	create table batchDemo(
 	id int primary key auto_increment,
 	name varchar(20)
 	);
 	insert into batchDemo values(null,'aaaa');
 	insert into batchDemo values(null,'bbb');
 	insert into batchDemo values(null,'cc');
 	insert into batchDemo values(null,'d'); 	
 */

/*
 	ע��statement ��PreparedStatement ����ִ��������
 */
public class StatementBatch {
	public static void main(String[] args) {
		//��ʾһ��statement ִ��������
		/*
		 Statement ִ����������
		 �ŵ㣺����ִ�ж�����ͬ�ṹ��sql��䣻
		 ȱ�㣺1.û��ʹ��Ԥ������ƣ�Ч�ʵ��£�2.���Ҫִ�ж����ṹ��ͬ��������ͬ��sqlʱ����Ȼ��Ҫд���sql�������ɡ�
		 */
		Connection conn=null;
		Statement stat = null;
		ResultSet rs =null;
		try{
			conn=JDBCUtils.getConn();
			stat=conn.createStatement();
			stat.addBatch("create database day08batch");
			stat.addBatch("use day08batch");
			stat.addBatch("create table batchDemo("+
					"id int primary key auto_increment,"+
					"name varchar(20)"+
					")");
			stat.addBatch("insert into batchDemo values(null,'aaaa')");
			stat.addBatch("insert into batchDemo values(null,'bbb')");
			stat.addBatch("insert into batchDemo values(null,'cc')");
			stat.addBatch("insert into batchDemo values(null,'d')");
			stat.executeBatch();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}
}