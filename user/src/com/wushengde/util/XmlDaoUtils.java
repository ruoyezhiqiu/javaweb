package com.wushengde.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlDaoUtils {
	private static Document dom = null;
	private static String path =XmlDaoUtils.class.getClassLoader().getResource("users.xml").getPath();
	private XmlDaoUtils() {
	}

	static {
		SAXReader reader = new SAXReader();
		try {
			dom = reader.read(path);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Document getDom() {
		return dom;
	}
	//封装了写回xml文件的方法
	public static void refXml(){
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(path),OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
