<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#car_availability").change(function(){
		if($("#car_availability").prop("checked")){
			$("td.car_available").each(function(index){
				if($(this).text()=="0"){
					$("tr").eq(index+1).hide();
				}
			});
		}
		else{
			$("tr").show();
		}
	})
});
</script>

<div class="login-clean">

<c:if test="${requestScope.mytrips_flag=='notrips'}">
	<div class="container">
		<div class="col-md-offset-4 col-md-5 well well-lg">
			<div style="font-size:30px" class="col-md-offset-3">
				You added no trips
			</div>
		</div>
	</div>
</c:if>

<c:if test="${requestScope.mytrips_flag!='notrips'}">
	<div class="container">     
	<label><input id="car_availability" type="checkbox" value=""> Car availability</label>
	       
  <table class="table table-hover table-striped">
    <thead>
      <tr>
        <th>Source</th>
        <th>Destination</th>
        <th>Start Date</th>
        <th>Car Available</th>
        <th>Vacant Seats</th>
        <th>Estimated Cost</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>
      	<c:forEach var="trip" items="${mytrips_flag}">
     		<tr>
     			<td>${trip.src}</td>
     			<td>${trip.dest}</td>
     			<td>${trip.date}</td>
		        <td class="car_available">${trip.cars_available}</td>
		        <td>${trip.vacant_seats}</td>
		        <td>${trip.cost}</td>
		        <td>${trip.desc}</td>
	      	</tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</c:if>
	
</div>

<c:import url="cfooter.jsp" />   