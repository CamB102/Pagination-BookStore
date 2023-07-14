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
import coding.mentor.service.BookService;
import coding.mentor.service.CategoryService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		CategoryService categoryService = new CategoryService();
		List<Category> categoryList = categoryService.getAllCategories();
		
		BookService bookService = new BookService();
		
		//bookList by categoryId
		String categoryId = request.getParameter("categoryId");
		List<Book> bookList = new ArrayList<Book>();
		
		if(categoryId == null ) {
			bookList = bookService.getAllBooks();
		} else {
			bookList = bookService.getBooksByCategoryId(Integer.parseInt(categoryId));
		}
		request.setAttribute("categoryList", categoryList);
		
		//bookList by search
		String searchKey = request.getParameter("searchBookInput");
		
		List<Book> bookListBySearch = new ArrayList<Book>();
	
		
		if (searchKey != null) {
            bookListBySearch = bookService.getBooksBySearch(searchKey);
            request.setAttribute("searchKey", searchKey);
            request.setAttribute("hideBookList", true);
        }

		request.setAttribute("bookListBySearch", bookListBySearch);
		
		
		//RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		request.setAttribute("bookList", bookList);
		
	
		
		rd.forward(request, response);

		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
