<%@ page import="org.me.blog.entity.User" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <%
    User user =(User) request.getAttribute("USER");
  %>
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <%
          if(user!=null){


        %>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/profile">Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/addblog">Add Blog</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/logout">Logout</a>
        </li>
        <%
          } else{
        %>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/login">Log in</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/register">Register</a>
        </li>
        <%
          }
        %>


      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>