<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />
 <div class="login-clean">
      
    
    
    <div class="form-container">
     <form method="post" action="search">
                <h2 class="text-center"><strong>Search</strong>Trips.</h2>
                <div class="form-group">
                    <input class="form-control" type="text" name="Source" placeholder="Source">
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="Destination" placeholder="Destination">
                </div>
                <div class="form-group">
                    <input class="form-control" type="date" name="date">
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit">Search</button>
                </div></form>
    </div>
    </div>
    
    <c:import url="cfooter.jsp" />
   