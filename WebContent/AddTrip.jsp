<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />
 	   
    <div class="login-clean">
 
 
        <form  method="post" action="AddTrip">
               <h2 class="text-center"><strong>Add</strong>Trips.</h2>
    
            <div >
                <div class="col-md-12">
                    <label>Source</label>
                    <input class="form-control" type="text"  name="Source" placeholder="Source">
                </div>
                <div class="col-md-12">
                    <label>Destination</label>
                    <input class="form-control" type="text"  name="Destination" placeholder="Destination">
                </div>
                <div class="col-md-12">
                    <label>Date</label>
                    <input class="form-control" type="date"  name="date" placeholder="date">
                </div>
                <div class="col-md-12">
                    <label>Description</label>
                    <input class="form-control" type="text" name="Description" placeholder="Description">
                </div>
            
            <div class="checkbox col-md-12">
                <label>
                    <input type="checkbox" name="Availability">Car Available</label>
            </div>
            <div class="col-md-12">
                <label>Vacant Seats</label>
                <input class="form-control" type="number" name="VacantSeat" >
            </div>
            <div class="col-md-12">
                <label>Estimated Cost ($)</label>
                <input class="form-control" type="number" name="estimatedcost">
            </div>
      </div>
      <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit">Save</button>
        </div>
        </form>
    </div>
    
    <c:import url="cfooter.jsp" />