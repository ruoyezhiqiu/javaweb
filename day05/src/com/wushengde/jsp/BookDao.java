package com.wushengde.jsp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.wushengde.domain.Book;
/*
 * 相当于一个数据库：即模仿一个数据库。
 */
public class BookDao {
	private static Map<String,Book> bookMap = new LinkedHashMap<String, Book>();
	private BookDao(){
	}
	static{
		bookMap.put("1",new Book("1","三国演义","99","罗贯中","黑马出版社","一群男人纠结不清的故事......"));
		bookMap.put("2",new Book("2","水浒传","108","施耐庵","人民出版社","105个男人跟3个女人的故事......"));
		bookMap.put("3",new Book("3","西游记","10","吴承恩","人民邮电出版社","一个和尚一只猴，一个秃头一头猪加上一匹马去西天的故事......"));
		bookMap.put("4",new Book("4","金瓶梅","38","哈利波特","科技工业出版社","混乱不堪的故事......"));
	}
	public static Map<String,Book> getBooks(){
		return bookMap;
	}
	public static Book getBook(String id){
		return bookMap.get(id);
	}
	
}
