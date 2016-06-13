package com.wushengde.tag;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class URLDEcoderTag extends SimpleTagSupport {
	private String content = null;
	private String encode = null;

	public void setContent(String content) {
		this.content = content;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	@Override
	public void doTag() throws JspException, IOException {
		String str = URLDecoder.decode(content, encode == null ? "utf-8"
				: encode);
		getJspContext().getOut().write(str);
	}

}
