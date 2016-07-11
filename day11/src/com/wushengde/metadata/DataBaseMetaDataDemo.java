package com.wushengde.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ��Ԫ���ݵ���ʾ����
 * @author john
 *
 */
public class DataBaseMetaDataDemo {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn=source.getConnection();
			//--��ȡ��ǰ���ݿ��Ԫ���ݣ�
			DatabaseMetaData metadata=  conn.getMetaData();
			//--��ȡ���ݿ�����ʱʹ�õ�URL
			String url=metadata.getURL();
			System.out.println(url);
			//--��ȡ���ݿ����ӵ��û���
			String username=metadata.getUserName();
			System.out.println(username);
			//--��ȡ���ݿ�ʹ�õ�����������
			String driver=metadata.getDriverName();
			System.out.println(driver);
			
			ps=conn.prepareStatement("select*from account");
			rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				System.out.println(name);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			/*if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs=null;
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					ps=null;
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn=null;
				}
			}*/
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}
