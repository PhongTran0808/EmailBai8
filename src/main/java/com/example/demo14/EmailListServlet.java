package com.example.demo14;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy tham số từ form
        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String email     = request.getParameter("email");

        // Tạo đối tượng User
        User user = new User(firstName, lastName, email);

        // Lưu user vào session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // Kiểm tra dữ liệu
        String message = "";
        if (firstName == null || firstName.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty() ||
                email == null || email.trim().isEmpty()) {
            message = "Hãy điền đầy đủ dữ liệu!!!";
            request.setAttribute("message", message);

            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return;
        }

        // Lưu ngày hiện tại (request scope)
        Date currentDate = new Date();
        request.setAttribute("currentDate", currentDate);

        // cũng cần năm hiện tại cho index.jsp
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);

        // Lấy danh sách User từ session (nếu chưa có thì tạo mới)
        List<User> users = (List<User>) session.getAttribute("users");
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
        session.setAttribute("users", users);

        // Chuyển sang thanks.jsp
        getServletContext()
                .getRequestDispatcher("/thanks.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            session.setAttribute("user", user);
        }

        request.setAttribute("user", user);

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
