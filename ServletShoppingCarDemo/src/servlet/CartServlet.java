package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cart;
import bean.Item;
import dao.ItemDao;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(name="CartServlet",value={"/servlet/CartServlet"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String action; // 判断发生的动作，是添加到购物车还是显示购物车
	private ItemDao idao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		idao = new ItemDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		action = request.getParameter("action");
		if (action.equals("add")) {
			if (addToCart(request, response)) {
				// TODO 添加成功
				request.getRequestDispatcher("../addSuccess.jsp").forward(request, response);
			} else {
				// TODO 失败
				request.getRequestDispatcher("../addfailure.jsp").forward(request, response);
			}
		} else if (action.equals("show")) {
			showCart(request, response);
		}
	}

	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("number"));
		Item i = idao.getItemById(id);
		// 判断是否第一次加入购物车
		if (request.getSession().getAttribute("cart") == null) {
			Cart c = new Cart();
			if (c.addItemToCart(i, num)) {
				request.getSession().setAttribute("cart", c);
				return true;
			}
		}else{
			Cart c = (Cart) request.getSession().getAttribute("cart");
			if(c.addItemToCart(i, num)){
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	private boolean showCart(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("../cart_list.jsp").forward(request, response);
		return true;
	}

}
