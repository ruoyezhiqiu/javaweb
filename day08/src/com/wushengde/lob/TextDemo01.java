package com.wushengde.lob;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.wushengde.util.JDBCUtils;


/*
 *���ı��Ĵ�����ȡ�����磺���С˵�� 
 *ע��һ�㲻����������Ч�ʵ��£�һ�����ݿ���ֻ�Ǵ洢���ڷ������еĴ���·����
 */


/*
 create table textdemo(
 id int primary key auto_increment,
 name varchar(100),
 content MEDIUMTEXT
 );
 */


/*�������ĸ����쳣��
java.lang.AbstractMethodError: com.mysql.jdbc.PreparedStatement.setCharacterStream(ILjava/io/Reader;J)V
java.lang.OutOfMemoryError: Java heap space
com.mysql.jdbc.PacketTooBigException: Packet for query is too large (10886473 > 1048576). You can change this value on the server by setting the max_allowed_packet' variable.

�ѵ㣺���Լ�鱾���ϵ�mysql��װĿ¼�е�my.ini��[mysqld]��������ݲο�
*/

public class TextDemo01 {
	
	/**
	 * �鿴���ݿ��д���ı��ļ�
	 */
	@Test
	public void findText(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("select * from textdemo where id=?");
			ps.setInt(1, 1);
			rs =ps.executeQuery();
			while(rs.next()){
				 String filename = rs.getString("name");
				 Reader reader =rs.getCharacterStream("content");
				 Writer writer=new FileWriter(filename);
				 
				 char[] cs= new char[1024];
				 int i = 0;
				 while((i=reader.read(cs))!=-1){
					 writer.write(cs,0,i);
				 }
				 reader.close();
				 writer.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	/**
	 * �����ݿ��д������ı��ļ�
	 */
	@Test
	public void addText(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into textdemo values (null,?,?)");
			ps.setString(1, "�������������ɵ�.txt");
			File file = new File("a.txt");
			ps.setCharacterStream(2, new FileReader(file), (int)file.length());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
}