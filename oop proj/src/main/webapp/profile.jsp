<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>IT BLOG</title>
  <%@include file="bootstrap/bootstrap.jsp"%>
</head>
<body>
<div class="container-fluid">
  <%@include file="bootstrap/navbar.jsp"%>

</div>
<div class="container mt-3">
  <div class="row">
    <div class="col-sm-6 offset-3">
      <%

        if(request.getParameter("error")!=null &&
                request.getParameter("error").equals("1")){


      %>
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>ERROR!</strong> User with email <%=request.getParameter("email")%> already exist.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%} else if(request.getParameter("error")!=null &&
              request.getParameter("error").equals("2")){



      %>
      <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong>ERROR!</strong> Passwords does not match.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%
        } else if( request.getParameter("success") == ""){

        %>
      <div class="alert alert-success alert-dismissible fade show" role="alert">
        Nickname was changed
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%}%>
      <form method="post" action="/updateProfile">
        <div class="form-group">
          <label class="form-label"> EMAIL:</label>
          <input type="email" name="email" class="form-control" readonly required value="<%=user.getEmail()%>">
        </div>
        <div class="form-group">
          <label class="form-label"> FULL NAME:</label>
          <input type="text" name="full_name" class="form-control" required  value="<%=user.getFullName()%>">
        </div>

        <div class="form-group mt-2">
          <button class="btn btn-info">UPDATE PROFILE</button>
        </div>
      </form>
      <%if( request.getParameter("success") == ""){

      %>
      <div class="alert alert-success alert-dismissible fade show" role="alert">
        Password was changed successfully
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%}%>
      <form method="post" action="/updatePassword">
        <div class="form-group">
          <label class="form-label"> OLD PASSWORD:</label>
          <input type="password" name="old_password" class="form-control" required>
        </div>
        <div class="form-group">
          <label class="form-label"> NEW PASSWORD:</label>
          <input type="password" name="new_password" class="form-control" required>
        </div>
        <div class="form-group">
          <label class="form-label"> CONFIRM PASSWORD:</label>
          <input type="password" name="confirm_password" class="form-control" required>
        </div>
        <div class="form-group mt-2">
          <button class="btn btn-info">UPDATE PASSWORD</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
