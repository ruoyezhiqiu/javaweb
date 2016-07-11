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
			// 设置数据库中事务的自动提交(默认情况是自动提交)
			// 注：当conn设置为false时 则所有的conn的操作都处在同一个事务当中！
			// 注：一次事务是指逻辑上的一组操作,这组操作要么同时完成要么同时不完成
			
			//此处相当于开启了一次事务
			conn.setAutoCommit(false);
			
			//演示两次转账的过程：
			//第一次转账：a-->b  100元
			ps = conn.prepareStatement("update account set money=money-100 where name=?");
			ps.setString(1, "a");
			ps.executeUpdate();

			// 此句是产生一个异常
			//int i = 1 / 0;
			
			ps = conn.prepareStatement("update account set money=money+100 where name=?");
			ps.setString(1, "b");
			ps.executeUpdate();

			//设置回滚点
			sp=conn.setSavepoint();
			
			//第二次转账：b-->a  100元
			
			ps = conn.prepareStatement("update account set money=money-100 where name=?");
			ps.setString(1, "b");
			ps.executeUpdate();
			
			
			//此句产生一个空指针异常
/*			String str=null;
			str.toUpperCase();*/
			
			ps = conn.prepareStatement("update account set money=money+100 where name=?");
			ps.setString(1, "a");
			ps.executeUpdate();
			
			// 如果以上四条sql语句都执行成功了，则在此处执行提交事务
			
			 conn.commit();

		} catch (Exception e) {
			// 如果以上两条sql语句执行时出现了异常，则在此处执行回滚
			try {
				
				if(sp==null){//即回滚点没有被设置，证明之前的代码也出现了问题，则回到事务的开始					
					conn.rollback();
				}else{//即：设置了回滚点，证明回滚点之前的代码是正确运行的，则直接跳到回滚点，然后执行提交
					//跳到回滚点
					conn.rollback(sp);
					//跳到回滚点处作提交
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
