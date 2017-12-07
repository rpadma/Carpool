<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	setTimeout(function(){ 
		$("#trip_msg").remove();
		}, 3000);
	
	if($("#trips_container").length!=0){
		$("#trip_form").remove();
	}
	
	$("a.trips").click(function(event){
		event.preventDefault();
		var url = window.location.hostname;
		
		url = "TripMapper?id=".concat($(this).prop("id"))
		location.href = url;
	});
	
	$("button.trip-class").click(function(){
		$("#uemail").val($(this).prop("id"));
	})
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


<c:if test="${requestScope.mapflag=='1'}">
	<div style="margin-top:10px"" id="trip_msg" class="col-md-offset-4 col-md-4 alert success">
	  <div class="col-md-offset-4">
	  	<strong>Trip joined successfully</strong>.
	  </div>
	</div>
</c:if>

<c:if test="${requestScope.mapflag=='0'}">
	<div style="margin-top:10px"" id="trip_msg" class="col-md-offset-4 col-md-4 alert danger">
	  <div class="col-md-offset-4">
	  	<strong>Trip Already joined</strong>.
	  </div>
	</div>
</c:if>

 <div class="login-clean">
    <div id="trip_form" class="form-container">
     <form method="post" action="searchtrip">
                <h2 class="text-center"><strong>Search</strong>Trips.</h2>
                <div class="form-group">
                    <input class="form-control" type="text" name="Source" placeholder="Source" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="Destination" placeholder="Destination" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="date" name="date" required>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit">Search</button>
                </div>
                <div class="form-group">
                    <a class="btn btn-primary btn-block" href="AddTrip.jsp">Add Trip</a>
                </div>
                </form>
                
    </div>
    
    
    <c:if test="${requestScope.search_flag!='notrips' && requestScope.search_flag!=null}">
	
	<div class="container">
	<h1>Search Results</h1></br></br></br></br>
	<table id="trips_container" class="table table-hover table-striped" style="height:200px">
    <thead>
      <tr>
        <th>User id</th>
        <th>Car Available</th>
        <th>Vacant Seats</th>
        <th>Estimated Cost</th>
        <th>Description</th>
        <th>Email</th>
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
		        <td>${trip.user_email} </td>
		        <td><a id='${Long.toString(trip.trip_id)}' class='btn btn-info trips'>Join trip</a></td>
		        <td><button id='${trip.user_email}' data-toggle="modal" data-target="#myModal"  class='trip-class btn btn-info'>Contact trip owner</button></td>
	      	</tr>
      </c:forEach>
    </tbody>
  </table>
  
  </div>
</c:if>
    </div>
    
<div class="container">

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Contact Trip owner</h4>
        </div>
        <div class="modal-body">
          <div class="form-container">
            <div class="image-holder"></div>
            <form method="post" action="TripMapper">
             <div class="form-group">
                <label>Trip Owner Email</label>
                    <input  type="text" class="form-control"  id="uemail" name="uemail" readonly></input>
                </div>
               
                <div class="form-group">
                <label>Message</label>
                    <textarea class="form-control" rows="5" id="message" name="message"></textarea>
                </div>
                
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit">Send message</button>
                </div></form>
        </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
    

    
    <c:import url="cfooter.jsp" />
   