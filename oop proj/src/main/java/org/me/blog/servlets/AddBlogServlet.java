package org.me.blog.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( value = "/addblog")
public class AddBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("USER_SESSION");

        if(user != null){
            request.getRequestDispatcher("addblog.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("/login");
        }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        User user = (User) request.getSession().getAttribute("USER_SESSION");

        String redirect = "/addblog?error";
        if(user != null){

            Post post = new Post(title,content,user.getId().intValue(), Timestamp.valueOf(LocalDateTime.now()));
            if (DbManager.addOrUpdate(Operations.CREATE, post)) {
                redirect = "/addblog?success";
            }
        }
        response.sendRedirect(redirect);
    }

    }
