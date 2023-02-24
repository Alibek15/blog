package org.me.blog.servlets;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.me.blog.db.DbManager;
import org.me.blog.db.Operations;
import org.me.blog.entity.Post;
import org.me.blog.entity.User;
import org.me.blog.model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Log
@WebServlet(value = "/show")
public class ShowBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Integer author = Integer.valueOf(request.getParameter("author"));
        Post p = new Post(title,content,author,null);


        String redirect = "/show?error=1"; //пустой пост


        User user = (User) request.getSession().getAttribute("USER_SESSION");
        if (user!= null) {

            if (DbManager.getAllBlog()!=null) {

                List<Post> post =DbManager.getAllBlog();

                if(post.contains(p)) {
                    log.info("TRUE");
                }
                request.setAttribute("POST",post);
                redirect = "/show?success";
            }

        }
            response.sendRedirect(redirect);
    }
}
