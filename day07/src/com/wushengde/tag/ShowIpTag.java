package com.wushengde.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ShowIpTag implements Tag {
	private PageContext pc = null;
	public int doEndTag() throws JspException {
	
		//返回值:EVAL_PAGE  表明结束标签之后的剩余页面需要执行
		//返回值：SKIP_PAGE 表明结束标签之后的剩余页面不需要执行
		return 0;
	}

	public int doStartTag() throws JspException {
		String ip = pc.getRequest().getRemoteAddr();
		try {
			pc.getOut().write(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回值：EVAL_BODY_INCLUDE 表明开始标签之后的标签体需要执行
		//返回值：SKIP_BODY  表明开始标签之后的标签体不需要执行
		return 0;
	}

	public Tag getParent() {
		
		return null;
	}

	public void release() {
		

	}
	//第一个要调用的方法：setPageContext()
	//当前台页面中使用了<showip/>标签的时候，程序进入该类第一个要执行的方法：setPageContext()
	//该方法将pageCongtext对象传入到这个方法中，有了pageContext对象就能获取页面中的9大隐式对象与4大作用域！
	public void setPageContext(PageContext pc) {
		this.pc = pc;

	}
	//第二个要调用的方法：setParent()
	public void setParent(Tag t) {
		

	}

}
