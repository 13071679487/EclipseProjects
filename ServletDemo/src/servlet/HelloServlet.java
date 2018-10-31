package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="HelloServlet",value={"/servlet/HelloServlet"})
public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����get����1");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.println("<h2>Hello Servlet</h2>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����post����1");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.println("<h2>Hello Servlet</h2>");
	}
}
