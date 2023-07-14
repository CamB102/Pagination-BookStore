package coding.mentor.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.entity.Book;
import coding.mentor.entity.Order;
import coding.mentor.entity.OrderDetails;
import coding.mentor.service.BookService;
import coding.mentor.service.OrderDetailsService;
import coding.mentor.service.OrderService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookService();

        try {
            String command = request.getParameter("command");
            int bookId = 0;

            if (command != null && command.equals("ADD_TO_CART")) {
                bookId = Integer.parseInt(request.getParameter("bookId"));
                Book book = bookService.getBookDetails(bookId);
                HttpSession session = request.getSession();
                Map<Integer, Book> cart = (Map<Integer, Book>) session.getAttribute("cart");

                if (cart == null) {
                    cart = new HashMap<>();
                    session.setAttribute("cart", cart);
                }

                cart.put(book.getId(), book);
                
                // Redirect to the home page
                response.sendRedirect("home");
            } else if (command != null && command.equals("VIEW_CART")) {
            	HttpSession session = request.getSession();
                Map<Integer, Book> cart = (Map<Integer, Book>) session.getAttribute("cart");
                double totalPrice = 0;

                if (cart != null) {
                    for (Book book : cart.values()) {
                        totalPrice += book.getPrice();
                    }
                }  
                RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
                request.setAttribute("totalPrice", totalPrice);
        		rd.forward(request, response);
        		
            } else if (command != null && command.equals("REMOVE")) {
                bookId = Integer.parseInt(request.getParameter("bookId"));
                Book book = bookService.getBookDetails(bookId);
            	HttpSession session = request.getSession();
                Map<Integer, Book> cart = (Map<Integer, Book>) session.getAttribute("cart");
                cart.remove(bookId);
                response.sendRedirect("cart.jsp");	
                
            } else if (command != null && command.equals("SUBMIT_CART")) {
            	HttpSession session = request.getSession();
                Map<Integer, Book> cart = (Map<Integer, Book>) session.getAttribute("cart");
                OrderService orderService = new OrderService();
                
                //create order- return order ID
                System.out.println("user id: " + session.getAttribute("userId"));
                int userId = (int) session.getAttribute("userId");

                Order order = new Order(userId, false);
                int orderId = orderService.addOrder(order);
                
                
                
                // create orderDetail list for each order
                List<OrderDetails> orderDetails = new ArrayList<>();
                for (int bookIdKey : cart.keySet()) {
                	OrderDetails orderDetailsForEachBook = new OrderDetails(orderId, bookIdKey);
                	OrderDetailsService orderDetailsService = new OrderDetailsService();
                	
                	orderDetailsService.addOrderDetails(orderDetailsForEachBook);
                	orderDetails.add(orderDetailsForEachBook);
                	
                }
                
                List<Book> booksOrdered = new ArrayList<>();
                double totalPrice = 0;
                
                for(OrderDetails orderDetail : orderDetails) {
                	int bookIdInOrder = orderDetail.getBookId();
                	Book bookInOrderDetail = bookService.getBookDetails(bookIdInOrder);
                	booksOrdered.add(bookInOrderDetail);
                	totalPrice += bookInOrderDetail.getPrice();
                }
              
                session.removeAttribute("cart");
                request.setAttribute("booksOrdered", booksOrdered);
                request.setAttribute("orderDetails", orderDetails);
                request.setAttribute("totalPrice", totalPrice);
                

			    RequestDispatcher rd = request.getRequestDispatcher("check_out.jsp");
			    rd.forward(request, response);
			    
                
                
        
            }
        } catch (Exception e) {
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
