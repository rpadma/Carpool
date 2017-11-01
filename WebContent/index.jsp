<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />
 <div class="login-clean">
 		<c:if test="${requestScope.user!=null}">
	  		<p class="help-block">${requestScope.user.message}</p>
  		</c:if>
        <form method="post" action="index">
            <h2 class="sr-only">Login Form</h2>
            <input type="hidden" name="action" value="login">
            <div class="illustration"><i class="icon ion-ios-navigate"></i></div>
            <div class="form-group">
                <input class="form-control" type="email" name="email" placeholder="Email">
            </div>
            <div class="form-group">
                <input class="form-control" type="password" name="password" placeholder="Password">
            </div>
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">Log In</button>
            </div><a href="#" class="forgot">Forgot your email or password?</a></form>
    </div>
    
    <c:import url="cfooter.jsp" />
   