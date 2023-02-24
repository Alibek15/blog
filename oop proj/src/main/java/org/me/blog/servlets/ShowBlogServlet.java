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
}
