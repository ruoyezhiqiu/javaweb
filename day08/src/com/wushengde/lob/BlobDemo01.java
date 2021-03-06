package com.wushengde.lob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.wushengde.util.JDBCUtils;

/*
 *大二进制的存入与取出（如：音频mp3、视频mp4等存入数据库与从中取出）
 *注：一般不用这样做，效率低下，一般数据库中只是存储其在服务器中的磁盘路径。 
 */

/*
	create table blobdemo(
	id int primary key auto_increment,
	name varchar(100),
	content MEDIUMBLOB
	);
*/
public class BlobDemo01 {
	
	
	@Test
	public void findBlob(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("select * from blobdemo");
			rs =ps.executeQuery();
			while(rs.next()){
				 String filename = rs.getString("name");
				 InputStream in =rs.getBinaryStream("content");
				 OutputStream out = new FileOutputStream(filename);
				 
				 byte[] bs= new byte[1024];
				 int i = 0;
				 while((i=in.read(bs))!=-1){
					 out.write(bs,0,i);
				 }
				 in.close();
				 out.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
		
	}
	//向数据库中存入大的二进制文件（此处存的是mp3，也可以存大的视频等，但是注意数据中内容字段的类型的设置，单个视频最大只能存4G）
	@Test
	public void addBlob(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into blobdemo values (null,?,?)");
			ps.setString(1, "洛天依.mp3");
			File file = new File("b.mp3");
			ps.setBinaryStream(2, new FileInputStream(file),(int)file.length());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
