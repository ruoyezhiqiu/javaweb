package com.wushengde.domain;

import java.io.Serializable;

public class Message implements Serializable {
	private int id;
	private String title;
	private String context;
	private String time;
	
	public Message() {
		super();
	}
	public Message(int id, String title, String context, String time) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
