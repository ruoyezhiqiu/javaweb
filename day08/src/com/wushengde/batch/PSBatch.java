package com.wushengde.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.wushengde.util.JDBCUtils;

/*
 此处使用：preparedStatement 实现批处理
 目标：插一万条记录到数据库中！
 create table psbatch(
 id int primary key auto_increment,
 name varchar(30)
 );
 */
public class PSBatch {
	public static void main(String[] args) {
		//演示二：preparedStatement 执行批处理
		/*
		 优点：有编译机制，效率比较高，执行多条结果相同参数不同的sql时，不需要重复书写sql语句
		 缺点：只能执行主干相同参数不同的sql，没有办法在一个批中加入结构不同的sql
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
				// 每一千条记录执行一次：此处避免ps占用内存过高，导致内存崩溃
				if (i % 1000 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			//此处防止一些未被1000除尽的记录漏掉
			ps.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
