<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	setTimeout(function(){ 
		$("#trip_msg").remove();
		}, 3000);
});
</script>

<c:if test="${requestScope.trip_msg!=null }">
	<div style="margin-top:10px"" id="trip_msg" class="col-md-offset-4 col-md-4 alert alert-success">
	  <div class="col-md-offset-4">
	  	<strong>Trip added successfully</strong>.
	  </div>
	</div>
</c:if>

<c:if test="${requestScope.search_flag=='notrips'}">
	<div style="margin-top:10px"" id="trip_msg" class="col-md-offset-4 col-md-4 alert alert-danger">
	  <div class="col-md-offset-4">
	  	<strong>No trips found</strong>.
	  </div>
	</div>
</c:if>

 <div class="login-clean">
    <div class="form-container">
     <form method="post" action="searchtrip">
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
                </div>
                <div class="form-group">
                    <a class="btn btn-primary btn-block" href="AddTrip.jsp">Add Trip</a>
                </div>
                </form>
                
    </div>
    </div>
    
<c:if test="${requestScope.search_flag!='notrips' && requestScope.search_flag!=null}">
	 <div class="container">            
  <table class="table table-hover table-striped">
    <thead>
      <tr>
        <th>Email</th>
        <th>Car Available</th>
        <th>Vacant Seats</th>
        <th>Estimated Cost</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>
      	<c:forEach var="trip" items="${search_flag}">
     		<tr>
		        <td>${trip.user_id}</td>
		        <td>${trip.cars_available}</td>
		        <td>${trip.vacant_seats}</td>
		        <td>${trip.cost}</td>
		        <td>${trip.desc}</td>
	      	</tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</c:if>
    
    <c:import url="cfooter.jsp" />
   