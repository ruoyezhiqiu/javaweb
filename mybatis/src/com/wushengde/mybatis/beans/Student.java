package com.wushengde.mybatis.beans;

public class Student {
	private int id;
	private String name;
	public Student() {
		super();
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return id+":"+name;
	}
	
}
