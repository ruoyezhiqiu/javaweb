package com.wushengde.metadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * ��ȡ�����Ԫ����
 */
public class RSMetaDataDemo {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ComboPooledDataSource source=new ComboPooledDataSource();
		try{
			conn=source.getConnection();
			ps=conn.prepareStatement("select * from account");
			rs=ps.executeQuery();
			//--��ȡ������е�Ԫ����
			ResultSetMetaData metaData=rs.getMetaData();
			//--��ȡ������е�����
			//int cc=metaData.getColumnCount();
			//System.out.println(cc);
			//--��ȡ�������ָ���е�����
			//String cn=metaData.getColumnName(1);
			//System.out.println(cn);
			//--��ȡ�������ָ���е����͵�����
			//String ct=metaData.getColumnTypeName(3);
			//System.out.println(ct);
			
			//--���´���ʵ�ֽ����ݿ��еı������ݴ�ӡ������̨
			System.out.println("=======================================================");
			int cc=metaData.getColumnCount();
			for(int i=1;i<=cc;i++){
				String cn=metaData.getColumnName(i);
				String ct=metaData.getColumnTypeName(i);
				System.out.print(cn+"("+ct+")"+"\t\t");
			}
			System.out.println();
			System.out.println("=======================================================");
			while(rs.next()){
				for(int i=1;i<=cc;i++){
					Object obj=rs.getObject(i);
					System.out.print(obj+"\t\t");
				}
				System.out.println();
			}
			System.out.println("=======================================================");
			
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
			//ʹ��DbUtils�ر�����:������
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}