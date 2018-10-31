package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import util.ResultCodeUtil;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		String phone=req.getParameter("phone");
		String pwd=req.getParameter("pwd");
		String token=req.getParameter("token");
		PrintWriter printWriter=resp.getWriter();
		UserDao ud=new UserDao();
		int resultcode=ud.login(phone, pwd,token);
		System.out.println("���صĽ����Ϊ��"+resultcode);
		printWriter.write(resultcode+"");
		if(resultcode==ResultCodeUtil.NO_REGISTER){
			System.out.println((phone+"�˺�δע��"));
		}else if(resultcode==ResultCodeUtil.LOGIN_SUCCESS){
			System.out.println((phone+"�˺���֤�ɹ�"));
		}else if(resultcode==ResultCodeUtil.LOGIN_FAIL){
			System.out.println((phone+"�˺���֤ʧ��"));
		}
		printWriter.flush();
	}
}
