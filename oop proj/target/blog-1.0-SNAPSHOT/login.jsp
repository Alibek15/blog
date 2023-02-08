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
                <strong>ERROR!</strong> User with this email doesn't exist.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%} else if(request.getParameter("error")!=null &&
                    request.getParameter("error").equals("2")){



            %>
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>ERROR!</strong> Invalid password for email.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }%>
            <form method="post" action="/login">
                <div class="form-group">
                    <label class="form-label"> EMAIL:</label>
                    <input type="email" name="email" class="form-control" required value="<%=request.getParameter("email")!=null ? request.getParameter("email") :""%>">
                </div>
                <div class="form-group">
                    <label class="form-label"> PASSWORD:</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
                <div class="form-group mt-2">
                    <button class="btn btn-info">SIGN IN</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>