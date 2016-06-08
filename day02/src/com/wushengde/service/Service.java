package com.wushengde.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Service {
	public void method() {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(Service.class.getClassLoader()
					.getResource("com/wushengde/config02.properties").getPath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("sex"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("major"));
	}

}
