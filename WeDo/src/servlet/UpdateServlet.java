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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String appkey = "21397d7801997";

	private final static int CHECK_EXIST = 0;
	private final static int UPDATE_HEADICON = 1;
	private final static int UPDATE_PWD = 2;
	private final static int UPDATE_USERNAME = 3;
	private final static int UPDATE_SEX = 4;
	private final static int UPDATE_ADDRESS = 5;
	private final static int UPDATE_DYNAMIC = 6;
	private final static int RESET_PWD = 7;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter = resp.getWriter();
		int method = Integer.parseInt(req.getParameter("method"));
		String phone = req.getParameter("phone");
		String value = req.getParameter("value");
		UserDao ud = new UserDao();
		int resultcode = ResultCodeUtil.UPDATE_FAIL;
		switch (method) {
		case CHECK_EXIST:
			boolean result = ud.isExist(phone);
			if (!result) {
				resultcode = ResultCodeUtil.FAIL;
			} else
				resultcode = ResultCodeUtil.SUCCESS;
			printWriter.write(resultcode + "");
			System.out.println(resultcode + "");
			break;
		case UPDATE_HEADICON:
			resultcode = ud.updateIcon(phone, value);
			printWriter.write(resultcode + "");
			System.out.println(resultcode + "");
			break;
		case UPDATE_PWD:
			resultcode = ud.updatePwd(phone, value);
			printWriter.write(resultcode + "");
			System.out.println(resultcode + "");
			break;
		case UPDATE_USERNAME:
			resultcode = ud.updateName(phone, value);
			printWriter.write(resultcode + "");
			System.out.println(resultcode + "");
			break;
		case UPDATE_SEX:
			resultcode = ud.updateSex(phone, Integer.parseInt(value));
			printWriter.write(resultcode + "");
			System.out.println(resultcode + "");
			break;
		case UPDATE_ADDRESS:
			resultcode = ud.updateAddress(phone, value);
			printWriter.write(resultcode + "");
			System.out.println(resultcode);
			break;
		case UPDATE_DYNAMIC:
			resultcode = ud.updateDynamic(phone, value);
			printWriter.write(resultcode + "");
			System.out.println(resultcode + "");
			break;
		case RESET_PWD:
			String code = req.getParameter("code");
			String result1;
			try {
				result1 = checkcode(phone, "86", code);
				JSONObject json=JSON.parseObject(result1);
				System.out.println(json.toString());
				if(json.getString("status").equals("200")){
					resultcode =ud.updatePwd(phone, value);
				}else{
					resultcode =ResultCodeUtil.VERIFY_FAIL;
				}
				printWriter.write(resultcode + "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			break;
		}
		printWriter.flush();
	}

	public String checkcode(String phone, String zone, String code) throws Exception {

		String address = "https://webapi.sms.mob.com/sms/verify";
		MobClient client = null;
		try {
			client = new MobClient(address);
			client.addParam("appkey", appkey).addParam("phone", phone).addParam("zone", zone).addParam("code", code);
			client.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}

}
