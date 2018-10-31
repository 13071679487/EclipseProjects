package com.rifu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/testImageServlet")
public class TestImageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String code=req.getParameter("code");
		HttpSession session=req.getSession();
		String codeValue=(String) session.getAttribute("CHECK_CODE_KEY");
		System.out.println(code);
		System.out.println(codeValue);
		if(code.equals(codeValue.toLowerCase())){
			session.removeAttribute("CHECK_CODE_KEY");
			session.removeAttribute("errorMsg");
			session.setAttribute("name", name);
			resp.sendRedirect(req.getContextPath()+"/success.jsp");
		}else{
			session.setAttribute("errorMsg", "÷ÿ∏¥Ã·Ωª");
			resp.sendRedirect(req.getContextPath()+"/validator/index.jsp");
		}
	}

}
