
<%@ page import="org.me.blog.entity.Post" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>IT BLOG</title>
  <%@include file="bootstrap/bootstrap.jsp" %>
  <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>


</head>
<body>
<div class="container-fluid">
  <%@include file="bootstrap/navbar.jsp" %>
</div>
<div class="container mt-3">
  <div class="row">
    <div class="col-sm-6 offset-3">
      <%
        if (request.getParameter("error") != null && request.getParameter("error").equals("1")) {
      %>
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>User with email <%=request.getParameter("email")%> already exist.</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%
        }
      %>
      <%
        if (request.getParameter("error") != null && request.getParameter("error").equals("2")) {
      %>
      <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong>Passwords does not match</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%
        }
      %>
      <form method="post" action="/show">
        <div class="form-group">
          <label class="form-label mt-2"> Title:</label>
          <input type="text" name="title" class="form-control" readonly required value="<%=post.getTitle()  %>">

          <label class="form-label mb-3"> Author: </label>
          <input type="text" name="author" class="form-control" readonly required value="<%=user.getFullName()%>">
        </div>
        <div class="form-group">
          <label class="form-label">
            CONTENT :
          </label>
          <textarea name="content" id="mytextarea" class="form-control" required rows="10" readonly required value="<%=post%>">
                    </textarea>
        </div>
        <div class="form-group mt-2">
          <button class="btn btn-info">SHOW POST</button>
        </div>

      </form>
    </div>
  </div>
</div>
</body>
</html>
