package com.wushengde.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.wushengde.util.JDBCUtils;

public class JDBCTransDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Savepoint sp=null;
		try {
			conn = JDBCUtils.getConn();
			// �������ݿ���������Զ��ύ(Ĭ��������Զ��ύ)
			// ע����conn����Ϊfalseʱ �����е�conn�Ĳ���������ͬһ�������У�
			// ע��һ��������ָ�߼��ϵ�һ�����,�������Ҫôͬʱ���Ҫôͬʱ�����
			
			//�˴��൱�ڿ�����һ������
			conn.setAutoCommit(false);
			
			//��ʾ����ת�˵Ĺ��̣�
			//��һ��ת�ˣ�a-->b  100Ԫ
			ps = conn.prepareStatement("update account set money=money-100 where name=?");
			ps.setString(1, "a");
			ps.executeUpdate();

			// �˾��ǲ���һ���쳣
			//int i = 1 / 0;
			
			ps = conn.prepareStatement("update account set money=money+100 where name=?");
			ps.setString(1, "b");
			ps.executeUpdate();

			//���ûع���
			sp=conn.setSavepoint();
			
			//�ڶ���ת�ˣ�b-->a  100Ԫ
			
			ps = conn.prepareStatement("update account set money=money-100 where name=?");
			ps.setString(1, "b");
			ps.executeUpdate();
			
			
			//�˾����һ����ָ���쳣
/*			String str=null;
			str.toUpperCase();*/
			
			ps = conn.prepareStatement("update account set money=money+100 where name=?");
			ps.setString(1, "a");
			ps.executeUpdate();
			
			// �����������sql��䶼ִ�гɹ��ˣ����ڴ˴�ִ���ύ����
			
			 conn.commit();

		} catch (Exception e) {
			// �����������sql���ִ��ʱ�������쳣�����ڴ˴�ִ�лع�
			try {
				
				if(sp==null){//���ع���û�б����ã�֤��֮ǰ�Ĵ���Ҳ���������⣬��ص�����Ŀ�ʼ					
					conn.rollback();
				}else{//���������˻ع��㣬֤���ع���֮ǰ�Ĵ�������ȷ���еģ���ֱ�������ع��㣬Ȼ��ִ���ύ
					//�����ع���
					conn.rollback(sp);
					//�����ع��㴦���ύ
					conn.commit();
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
