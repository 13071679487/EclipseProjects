package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet(name="RegServlet",value={"/servlet/RegServlet"})
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Users u=new Users();
		String username;
		String password;
		String sex;
		String[] hobbies;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try{
			username=request.getParameter("username");
			password=request.getParameter("password");
			sex=request.getParameter("sex");
			birthday=sdf.parse(request.getParameter("birthday"));
			hobbies=request.getParameterValues("hobby");
			u.setUsername(username);
			u.setPassword(password);
			u.setSex(sex);
			u.setBirthday(birthday);
			u.setHobbies(hobbies);
			request.getSession().setAttribute("regUser", u);
		}catch( Exception ex){
			ex.printStackTrace();
		}
		request.getRequestDispatcher("../detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
