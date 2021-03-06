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
 *大文本的存入与取出（如：大的小说） 
 *注：一般不用这样做，效率低下，一般数据库中只是存储其在服务器中的磁盘路径。
 */


/*
 create table textdemo(
 id int primary key auto_increment,
 name varchar(100),
 content MEDIUMTEXT
 );
 */


/*将遇到的各种异常：
java.lang.AbstractMethodError: com.mysql.jdbc.PreparedStatement.setCharacterStream(ILjava/io/Reader;J)V
java.lang.OutOfMemoryError: Java heap space
com.mysql.jdbc.PacketTooBigException: Packet for query is too large (10886473 > 1048576). You can change this value on the server by setting the max_allowed_packet' variable.

难点：可以检查本机上的mysql安装目录中的my.ini中[mysqld]下面的内容参考
*/

public class TextDemo01 {
	
	/**
	 * 查看数据库中大的文本文件
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
	 * 向数据库中存入大的文本文件
	 */
	@Test
	public void addText(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into textdemo values (null,?,?)");
			ps.setString(1, "钢铁是怎样练成的.txt");
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
