package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import dao.UserDao;
import util.MobClient;
import util.ResultCodeUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String appkey="21397d7801997";

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter printWriter=response.getWriter();
		System.out.println("Ω” ’µΩ«Î«Û");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pwd");
		String code=request.getParameter("code");
		try {
			String result=checkcode(phone, "86", code);
			JSONObject json=JSON.parseObject(result);
			System.out.println(json.toString());
			if(json.getString("status").equals("200")){
				UserDao ud=new UserDao();
				int resultcode=ud.register(phone, pwd);
				System.out.println(resultcode+"");
				printWriter.write(resultcode+"");
				if(resultcode==ResultCodeUtil.REGISTER_ALREADY){
					System.out.println(phone+"’À∫≈“—◊¢≤·");
				}else if(resultcode==ResultCodeUtil.REGISTER_SUCCESS){
					System.out.println(phone+"’À∫≈◊¢≤·≥…π¶");
				}else if(resultcode==ResultCodeUtil.REGISTER_FAIL){
					System.out.println(phone+"’À∫≈◊¢≤· ß∞‹");
				}
			}else{
				printWriter.write(ResultCodeUtil.REGISTER_FAIL+"");
			}
		} catch (Exception e) {
		}
		printWriter.flush();
	}

public  String checkcode(String phone,String zone,String code) throws Exception{
		
		String address = "https://webapi.sms.mob.com/sms/verify";
		MobClient client = null;
		try {
			client = new MobClient(address);
			client.addParam("appkey", appkey).addParam("phone", phone)
					.addParam("zone", zone).addParam("code", code);
			client.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}
}
