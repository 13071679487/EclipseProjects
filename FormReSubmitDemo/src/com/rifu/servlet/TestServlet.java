package com.rifu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rifu.util.TokenProcessor;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String name=req.getParameter("name");
		System.out.println(name);
		
		String token=req.getParameter("COM.RIFU.TOKEN_KEY");
		System.out.println("token:"+token );
		HttpSession session=req.getSession();
		boolean valid=TokenProcessor.getInstance().isTokenValid(req);
		if(valid){
			TokenProcessor.getInstance().resetToken(req);
			if(name!=null)
				session.setAttribute("name", name);
			resp.sendRedirect(req.getContextPath()+"/success.jsp");
			session.removeAttribute("errorMsg");
		}else{
			session.setAttribute("errorMsg", "÷ÿ∏¥Ã·Ωª");
			if(session.getAttribute("repeatTime")!=null){
				session.setAttribute("repeatTime", (int)session.getAttribute("repeatTime")+1);
			}else{
				session.setAttribute("repeatTime", 1);
			}
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
	}
}
