package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

import dao.UserDao;

@WebServlet("/icon")
public class UploadIconServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter pw = resp.getWriter();
		String phone = req.getParameter("phone");
		System.out.println(phone);
		int code = 202;
		try {
			SmartUpload upload = new SmartUpload();
			upload.initialize(config, req, resp);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String absPath = req.getSession().getServletContext().getRealPath("/") + "/icons/";
			System.out.println(absPath);
			absPath = absPath.replace("\\", "/");
			System.out.println(absPath);
			String Ext = phone + "_" + sdf.format(new Date()) + ".jpg";
			String filename = absPath + Ext;
			String imagePath = "http://39.108.177.230:8080/WeDo/icons/" + Ext;
			System.out.println(filename);
			upload.upload();
			File file = upload.getFiles().getFile(0);
			System.out.println("1");
			if (!file.isMissing()) {
				System.out.println("2");
				file.saveAs(filename, upload.SAVE_PHYSICAL);
				if (phone != null && phone.length() > 0) {
					System.out.println("3");
					code = new UserDao().updateIcon(phone, imagePath);
					if (code == 201) {
						pw.write(imagePath);
					} else {
						pw.write(code + "");
					}
				} else {
					System.out.println("4");
					code = 202;
					pw.write(code + "");
				}
			} else {
				System.out.println("5");
				code = 202;
				pw.write(code + "");
			}
		} catch (Exception e) {
			System.out.println("6");
			code = 202;
			pw.write(code + "");
		}
		pw.flush();
	}
}
