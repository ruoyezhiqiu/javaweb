package com.wushengde.batch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wushengde.util.JDBCUtils;

/*
 批处理：大量的语句，打包起来一次执行完成的过程叫做批处理(如：最常见的sql语句)。
 	例如：
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
 	注：statement 与PreparedStatement 都能执行批处理
 */
public class StatementBatch {
	public static void main(String[] args) {
		//演示一：statement 执行批处理
		/*
		 Statement 执行批处理：
		 优点：可以执行多条不同结构的sql语句；
		 缺点：1.没有使用预编译机制，效率低下；2.如果要执行多条结构相同但参数不同的sql时，仍然需要写多次sql语句的主干。
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
