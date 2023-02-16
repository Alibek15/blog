package org.me.blog.filter;

import lombok.extern.java.Log;
import org.me.blog.db.DbManager;
import org.me.blog.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log
@WebFilter(value = "/*")
public class BlogFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        boolean online = false;
        User currentUser = null;

        User sessionUser = (User) session.getAttribute("USER_SESSION");


        if(sessionUser != null){
            User onlineUser = DbManager.getUserByEmail(sessionUser.getEmail());
            if(onlineUser!=null && onlineUser.getPassword().equals(sessionUser.getPassword())){
                online = true;
                currentUser = onlineUser;

            }
            else {
                session.removeAttribute("USER_SESSION");
            }
        }
        request.setAttribute("online",online);
        request.setAttribute("USER", currentUser);
        log.info("FILTERING");
        chain.doFilter(request, response);
    }
}

