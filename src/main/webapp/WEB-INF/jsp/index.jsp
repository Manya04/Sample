<%-- 
    Document   : index
    Created on : 5 Jul, 2018, 7:25:57 PM
    Author     : AKASH
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}/resources" scope="request" />
<%@page import="co.admis.config.ServerConfig " %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${ServerConfig.PROJECT_NAME} | LIS</title>
  <meta name="adlis" content="Adeep Lab Information System. One system to take care all your lab activities.">
  <meta name="keywords" content="lab information system, lis, adlis, information system, hospital information system">

  <!-- Favicon icon -->
  <link rel="icon" type="image/png" sizes="16x16" href="${cp}/img/icon.png">
  
  <link rel="stylesheet" type="text/css" href="${cp}/home/css/bootstrap-theme.css">
  <link rel="stylesheet" type="text/css" href="${cp}/home/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="${cp}/home/css/style.css">
  <link rel="shortcut icon" href="${cp}/images/icon.png">
</head>

<body>

  <!-- Fixed navbar -->
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index">${ServerConfig.RES_PATH} | ${cp}</a>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="Template/adminLoginPage">Admin Sign in</a></li>
          <li><a href="Template/userLoginPage">User Sign in</a></li>
        </ul>
      </div>
      <!--/.nav-collapse -->
    </div>
  </div>

  <div id="header">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <h1><img src="${cp}/img/logo.png"></h1>
          <h2 class="subtitle">Adeep My IT Solution pvt. ltd.</h2>
          <form class="form-inline signup" role="form">
            <div class="form-group">
              <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter your email address">
            </div>
            <button type="submit" class="btn btn-theme">Get it now</button>
          </form>
        </div>
        <div class="col-lg-4 col-lg-offset-2">
          <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
              <li data-target="#carousel-example-generic" data-slide-to="1"></li>
              <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <!-- slides -->
            <div class="carousel-inner">
              <div class="item active">
                <img src="${cp}/home/img/slide1.png" alt="">
              </div>
              <div class="item">
                <img src="${cp}/home/img/slide2.png" alt="">
              </div>
              <div class="item">
                <img src="${cp}/home/img/slide3.png" alt="">
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
  <div id="footer">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <p class="copyright">&copy; Adeep My IT Solution Private Limited 2018</p>
        </div>
        <div class="col-md-6">
          
        </div>
      </div>
    </div>
  </div>

  <script src="${cp}/home/js/jquery.min.js"></script>
  <script src="${cp}/home/js/bootstrap.min.js"></script>

</body>

</html>
