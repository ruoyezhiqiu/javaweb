package com.wushengde.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.wushengde.util.JDBCUtils;

/*
 �˴�ʹ�ã�preparedStatement ʵ��������
 Ŀ�꣺��һ������¼�����ݿ��У�
 create table psbatch(
 id int primary key auto_increment,
 name varchar(30)
 );
 */
public class PSBatch {
	public static void main(String[] args) {
		//��ʾ����preparedStatement ִ��������
		/*
		 �ŵ㣺�б�����ƣ�Ч�ʱȽϸߣ�ִ�ж��������ͬ������ͬ��sqlʱ������Ҫ�ظ���дsql���
		 ȱ�㣺ֻ��ִ��������ͬ������ͬ��sql��û�а취��һ�����м���ṹ��ͬ��sql
		 */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into psbatch values(null,?)");
			for (int i = 1; i <= 10000; i++) {
				ps.setString(1, "zhangsan" + i);
				ps.addBatch();
				// ÿһǧ����¼ִ��һ�Σ��˴�����psռ���ڴ���ߣ������ڴ����
				if (i % 1000 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			//�˴���ֹһЩδ��1000�����ļ�¼©��
			ps.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}