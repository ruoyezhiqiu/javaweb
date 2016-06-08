package com.wushengde;

import org.junit.Test;

public class PersonTest {
	@Test
	public void testEat(){
		Person p = new Person();
		p.eat("zhangsan");
	}
	@Test
	public void testRun(){
		Person p = new Person();
		p.run("lisi");
	}

}
