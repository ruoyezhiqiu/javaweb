package com.wushengde.dbutils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

/**
 * 自定义MyQueryRunner类实现与DbUtils框架中的QueryRunner相同的功能
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
		//获取参数元数据
		ParameterMetaData metaData= ps.getParameterMetaData();
		//获取参数的个数
		int count=metaData.getParameterCount();
		for(int i=1;i<=count;i++){
			ps.setObject(i, params[i-1]);
		}
		//执行update操作
		int num=ps.executeUpdate();
		//使用DbUtils关闭连接
		DbUtils.closeQuietly(conn, ps, null);
		return num;
	}
}
