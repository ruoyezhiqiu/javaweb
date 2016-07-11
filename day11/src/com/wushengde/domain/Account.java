package com.wushengde.domain;

import java.io.Serializable;
/**
 * 此处添加一个javabean用来定义账户的类：Account
 * @author john
 *
 */
public class Account implements Serializable{
	private int id;
	private String name;
	private double money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
