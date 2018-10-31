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
		System.out.println("返回的结果码为："+resultcode);
		printWriter.write(resultcode+"");
		if(resultcode==ResultCodeUtil.NO_REGISTER){
			System.out.println((phone+"账号未注册"));
		}else if(resultcode==ResultCodeUtil.LOGIN_SUCCESS){
			System.out.println((phone+"账号验证成功"));
		}else if(resultcode==ResultCodeUtil.LOGIN_FAIL){
			System.out.println((phone+"账号验证失败"));
		}
		printWriter.flush();
	}
}
