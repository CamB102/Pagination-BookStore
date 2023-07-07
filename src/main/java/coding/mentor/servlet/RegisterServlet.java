package coding.mentor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.entity.Book;
import coding.mentor.entity.Category;
import coding.mentor.entity.User;
import coding.mentor.service.BookService;
import coding.mentor.service.CategoryService;
import coding.mentor.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//get attribute
			String userName = request.getParameter("userName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			// create object
			User user = new User(userName, email, password);			
			UserService userService = new UserService();			
			userService.addUser(user);
			
			response.sendRedirect("register_success.jsp");
			
			
			}catch(SQLException e){
				e.printStackTrace();
			}

		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
//		doGet(request, response);
	}

}
