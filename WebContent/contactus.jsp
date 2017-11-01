
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />

    <div class="contact-clean">
        <form method="post">
            <h2 class="text-center">Contact us</h2>
            <div class="form-group has-success has-feedback">
                <input class="form-control" type="text" name="name" placeholder="Name"><i class="form-control-feedback glyphicon glyphicon-ok" aria-hidden="true"></i></div>
            <div class="form-group has-error has-feedback">
                <input class="form-control" type="email" name="email" placeholder="Email"><i class="form-control-feedback glyphicon glyphicon-remove" aria-hidden="true"></i>
                <p class="help-block">Please enter a correct email address.</p>
            </div>
            <div class="form-group">
                <textarea class="form-control" rows="14" name="message" placeholder="Message"></textarea>
            </div>
            <div class="form-group">
                <button class="btn btn-primary" type="submit">send </button>
            </div>
        </form>
    </div>
    
<c:import url="cfooter.jsp" />