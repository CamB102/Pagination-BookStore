//package coding.mentor.servlet;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import coding.mentor.entity.Book;
//import coding.mentor.service.BookService;
//
//
///**
// * Servlet implementation class SearchBookServlet
// */
//@WebServlet("/search")
//public class SearchBookServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SearchBookServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try {
//			
//			String searchKey = request.getParameter("searchBookInput");
//			
//			BookService bookService = new BookService();
//			
//			List<Book> bookListBySearch = new ArrayList<Book>();
//			System.out.println("searchBookInput: " + request.getParameter("searchBookInput"));
//			
//			System.out.println("searchKey: " + searchKey);
//			
//			if (searchKey == null) {
//				bookListBySearch = bookService.getAllBooks();
//			}else {
//				bookListBySearch = bookService.getBooksBySearch(searchKey);
//			}
//			
//			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//			request.setAttribute("bookListBySearch", bookListBySearch);
//
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
