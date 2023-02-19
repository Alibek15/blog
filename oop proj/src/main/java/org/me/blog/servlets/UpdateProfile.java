package org.me.blog.servlets;

import org.me.blog.db.DbManager;
import org.me.blog.db.Operations;
import org.me.blog.entity.User;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( value = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String fullName = request.getParameter("full_name");

        String redirect = "/profile?error=1";

        User user = DbManager.getUserByEmail(email);
        if(user!=null){
            user.setFullName(fullName);
            DbManager.addOrUpdate(Operations.UPDATE, user);
            request.getSession().setAttribute("USER_SESSION", user);
            redirect="profile?success";
        }
        response.sendRedirect(redirect);

    }
}
