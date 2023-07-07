package coding.mentor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.entity.User;
import coding.mentor.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.getUserByUsernameAndPassword(username, password);
            if (user == null) {
                String errorMessage = "Incorrect username and password, please re-enter.";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
                HttpSession session = request.getSession(false);
                session.setAttribute("name", user.getName());
                response.sendRedirect("home");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

