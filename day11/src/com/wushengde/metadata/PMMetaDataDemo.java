package com.wushengde.metadata;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库的参数元数据的演示过程
 * @author john
 *
 */
public class PMMetaDataDemo {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		
		ComboPooledDataSource source= new ComboPooledDataSource();
		try{
			conn=source.getConnection();
			ps=conn.prepareStatement("select * from account where name=? and money=?");
			//--获取参数元数据
			ParameterMetaData metaData =ps.getParameterMetaData();
			//--获取参数的个数
			int count=metaData.getParameterCount();
			System.out.println(count);
			//--获取指定参数的sql类型
			String type=metaData.getParameterTypeName(1);
			System.out.println(type);
			 
			String type2=metaData.getParameterTypeName(2);
			System.out.println(type2);
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
			}
*/
		DbUtils.closeQuietly(conn, ps, rs);
			}
	}
}
