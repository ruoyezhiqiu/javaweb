package com.wushengde.object;
/**
 * String 类的练习
 * 练习String类中的常用的方法：
 * charAt()、hashCode()、getBytes()
 * isEmpty()、length()、subString()
 * replace()、trim()、valueOf()
 * indexOf()
 * @author john
 *
 */

public class Demo1 {
	public static void main(String[] args) {
		byte[] by={'a','b','c'};
		String str=new String(by);
		System.out.println(str);
		System.out.println(str.charAt(1));
		System.out.println(str.hashCode());
		byte[] bb=str.getBytes();
		System.out.println(bb[0]);
		System.out.println(str.isEmpty());
		System.out.println(str.length());
		str=str.replace('a', 'z');
		System.out.println(str);
		String mm=str.substring(2);
		System.out.println(mm);
		String str2="  aa  bbb  cc dddedef dsf   ";
		System.out.println(str2);
		String str3=str2.trim();
		String i=String.valueOf(97);
		String j=String.valueOf('x');
		System.out.println(j);
		System.out.println(i);
		System.out.println(str3);
		int mz=str.indexOf("b");
		System.out.println(mz);
	}
}
