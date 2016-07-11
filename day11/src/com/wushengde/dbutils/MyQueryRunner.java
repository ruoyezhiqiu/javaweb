package com.wushengde.dbutils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

/**
 * �Զ���MyQueryRunner��ʵ����DbUtils����е�QueryRunner��ͬ�Ĺ���
 * @author john
 *
 */
public class MyQueryRunner {
	private DataSource source = null;
	public MyQueryRunner() {
	}

	public MyQueryRunner(DataSource source) {
		this.source = source;
	}
	public int update(String sql, Object... params) throws SQLException {
		Connection conn=source.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		//��ȡ����Ԫ����
		ParameterMetaData metaData= ps.getParameterMetaData();
		//��ȡ�����ĸ���
		int count=metaData.getParameterCount();
		for(int i=1;i<=count;i++){
			ps.setObject(i, params[i-1]);
		}
		//ִ��update����
		int num=ps.executeUpdate();
		//ʹ��DbUtils�ر�����
		DbUtils.closeQuietly(conn, ps, null);
		return num;
	}
}
