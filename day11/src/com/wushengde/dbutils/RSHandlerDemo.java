package com.wushengde.dbutils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wushengde.domain.Account;

/**
 * 使用DBUtils框架实现查询时，对结果集的不同处理方式的举例：
 * 框架设计者已经为我们写好了不同处理方式时用到的不同的类，我们只需要使用就可以。
 * 注：两行代码实现查询
 * @author john
 *
 */
public class RSHandlerDemo {
	
	//处理方式一：
	// ArrayHandler 把结果集中的第一行数据转成对象数组
	//返回的是一个Object类型的数组
	@Test
	public void find1() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		Object objs[]=runner.query("select * from account where money>?",new ArrayHandler(),300);
		System.out.println(objs);
	}
	
	//处理方式二：
	//ArrayListHandler：把结果集中的每一行数据都转成一个对象数组，再存放到List中
	//返回一个list
	@Test
	public void find2() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		List<Object[]> list=runner.query("select * from account where money>?",new ArrayListHandler(),300);
		System.out.println(list);
	}
	
	//处理方式三：常用
	//BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
	@Test
	public void find3() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		Account account=runner.query("select * from account where money>?",new BeanHandler<Account>(Account.class) ,300);
		System.out.println(account);
	}
	
	//处理方式四：常用
	//BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
	@Test
	public void find4() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		List<Account> list=runner.query("select * from account where money>?",new BeanListHandler<Account>(Account.class),300);
		System.out.println(list);
	}

	
	
}
