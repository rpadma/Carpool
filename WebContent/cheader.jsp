<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Button1.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/Footer-Clean.css">
</head>

<body>
    <div>
        <nav class="navbar navbar-default navigation-clean-button">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">Carpool</a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                    <c:if test="${sessionScope.user==null}">
                        <li role="presentation"><a href="home.jsp" onclick="return false;">Home </a></li>
                        </c:if>
                        <c:if test="${sessionScope.user!=null}">
                        <li role="presentation"><a href="home.jsp">Home </a></li>
                        </c:if>
                        
                        <li role="presentation"><a href="contactus.jsp">Contact us</a></li>
                        <li role="presentation"><a href="aboutus.jsp">About us</a></li>
                    </ul>
                    
                    <c:if test="${sessionScope.user==null}">
                    	 <p class="navbar-text navbar-right actions"><a class="navbar-link login" href="index.jsp">Log In</a>
                         <a class="btn btn-default action-button" role="button" href="register.jsp">Sign Up</a></p>
                  
                    </c:if>
                    
                    <c:if test="${sessionScope.user!=null}">
                    	 <p class="navbar-text navbar-right actions"><a class="navbar-link login" href="index?action=logout">Log Out</a>
                    </c:if>
                   
                    
                   
                </div>
            </div>
        </nav>
    </div>