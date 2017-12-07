<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="cheader.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="assets/js/Chart.min.js"></script>

<script>
$(document).ready(function(){
	$("button.trip-class").click(function(){
		$("#uemail").val($(this).prop("id"));
	})
})  
</script>

<div class="login-clean">

<c:if test="${requestScope.cont_flag=='NoMessages'}">
	<div class="container">

		<div class="col-md-offset-4 col-md-5 well well-lg">
			<div style="font-size:30px" class="col-md-offset-3">
				You have no contact messages
			</div>
		</div>
	</div>
</c:if>

<c:if test="${requestScope.cont_flag!='NoMessages'}">
	<div class="container">  
	<h1>Contact Us Messages</h1>   
	</br></br></br></br>
	       
  <table class="table table-hover table-striped">
    <thead>
      <tr>
       <th>Id</th>
        <th>UserName</th>
        <th>Email</th>
        <th>Message</th>
      </tr>
    </thead>
    <tbody>
      	<c:forEach var="cont" items="${cont_flag}">
     		<tr>
     		    <td>${cont.id} </td>
     			<td>${cont.name}</td>
     			<td>${cont.email}</td>
     			<td>${cont.message}</td>
     			  <td><button id="${cont.email}" data-toggle="modal" data-target="#mySendMessage"  class='trip-class btn btn-info'>Send Message</button></td>
		        	</tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</c:if>
	
</div>


<div class="container">

  <!-- Modal -->
  <div class="modal fade" id="mySendMessage" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Send Message</h4>
        </div>
        <div class="modal-body">
          <div class="form-container">
            <div class="image-holder"></div>
            <form method="post" action="TripMapper">
                
                <div class="form-group">
                <label>User Email</label>
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