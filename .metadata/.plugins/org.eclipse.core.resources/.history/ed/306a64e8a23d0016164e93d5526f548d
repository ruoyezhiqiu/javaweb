package com.wushengde.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wushengde.domain.User;
import com.wushengde.exception.MsgException;
import com.wushengde.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理POST请求提交中的乱码问题：
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 1.检验验证码
		try {
			UserService service = new UserService();
			String valistr = request.getParameter("valistr");
			String valistr2 = (String) request.getSession().getAttribute(
					"valistr");
			if (valistr == null || valistr2 == null
					|| !valistr.equals(valistr2)) {
				request.setAttribute("msg", "验证码不正确，请重新输入！");
				request.getRequestDispatcher("/regist.jsp").forward(request,
						response);
				return;
			}
			// 2.封装数据校验数据
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			user.checkValue();
			// 3.调用Service中的添加用户
			service.registUser(user);
			// 4. 登录用户
			request.getSession().setAttribute("user", user);
			// 5.提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功！3秒后回到主页......");
			response.setHeader("Refresh", "3;url="+request.getContextPath()+"/index.jsp");
		}catch(MsgException e){
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
