package com.wushengde.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ShowIpTag implements Tag {
	private PageContext pc = null;
	public int doEndTag() throws JspException {
	
		//����ֵ:EVAL_PAGE  ����������ǩ֮���ʣ��ҳ����Ҫִ��
		//����ֵ��SKIP_PAGE ����������ǩ֮���ʣ��ҳ�治��Ҫִ��
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
		
		//����ֵ��EVAL_BODY_INCLUDE ������ʼ��ǩ֮��ı�ǩ����Ҫִ��
		//����ֵ��SKIP_BODY  ������ʼ��ǩ֮��ı�ǩ�岻��Ҫִ��
		return 0;
	}

	public Tag getParent() {
		
		return null;
	}

	public void release() {
		

	}
	//��һ��Ҫ���õķ�����setPageContext()
	//��ǰ̨ҳ����ʹ����<showip/>��ǩ��ʱ�򣬳����������һ��Ҫִ�еķ�����setPageContext()
	//�÷�����pageCongtext�����뵽��������У�����pageContext������ܻ�ȡҳ���е�9����ʽ������4��������
	public void setPageContext(PageContext pc) {
		this.pc = pc;

	}
	//�ڶ���Ҫ���õķ�����setParent()
	public void setParent(Tag t) {
		

	}

}
