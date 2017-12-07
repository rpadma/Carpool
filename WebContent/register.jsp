<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />
<script>
	$(document).ready(function(){
		$("#register-form").submit(function(event){
			if($("#password").val()!=$("#password-repeat").val()){
				event.preventDefault();
				alert("Passwords not matched");
			}
		})
	})
</script>

<div class="register-photo">
<c:if test="${requestScope.valmsg=='exist' }">
	<div style="margin-top:10px" class="col-md-offset-4 col-md-4 alert alert-danger">
	  <div class="col-md-offset-4">
	  	<strong>Email already exists.</strong>.
	  </div>
	</div>
</c:if>
        <div class="form-container">
            <div class="image-holder"></div>
            <form id="register-form" method="post" action="register">
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="Email" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" id="password-repeat" name="password-repeat" placeholder="Password (repeat)" required>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label class="control-label">
                            <input type="checkbox">I agree to the license terms.</label>
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit">Sign Up</button>
                </div><a href="index.jsp" class="already">You already have an account? Login here.</a></form>
        </div>
    </div>
    
    <c:import url="cfooter.jsp" />