package com.wushengde.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class SimpleShowIp implements SimpleTag {
	private JspContext pc = null;

	// 最后调用doTag方法,在这个方法里我们可以书写处理标签事件的java代码
	// 当自定义标签执行完成后,简单标签对象就销毁掉了.
	public void doTag() throws JspException, IOException {
		PageContext pcx = (PageContext)pc;
		String ip = pcx.getRequest().getRemoteAddr();
		pcx.getOut().write(ip);
	}

	public JspTag getParent() {

		return null;
	}

	// 如果当前标签具有标签体,则会调用setJspBody将封装了标签体信息的JspFragment传入,如果没有标签体,这个方法不执行
	public void setJspBody(JspFragment jspBody) {

	}

	// 相当于传入了当前jsp页面的pageContext对象，因为JspContext是pageContext的直接父类。
	public void setJspContext(JspContext pc) {
		this.pc = pc;

	}

	// 如果当前标签有父标签则调用setParent方法将父标签传入,如果没有父标签则这个方法不会被调用.
	public void setParent(JspTag parent) {

	}

}
