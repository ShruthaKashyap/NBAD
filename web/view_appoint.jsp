<%-- 
    Document   : view_appoint
    Created on : Apr 28, 2017, 5:58:46 PM
    Author     : shrut
--%>

<%@ include file="header2.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--<h3 id="add_new_study"><a href="newstudy.jsp?user=theUser" >Add a new study</a></h3>-->
 <%-- Code to go Back to the Main Page  --%>
<a href="userhome.jsp" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to display studies details --%> 
<%-- Clicking on Start, Stop to Participate in that study and  Edit button to display edit page and edit study details in it--%>
<section >
<!--    <form class="form-horizontal" action="HMS_COntroller?action=view" method="post">-->
<div class="table-responsive">
     
    <table class="table table-bordered" >
        
                    <tr class="table_appointment">
                    <th><b> Patient Name</b></th>
                    <th><b> Age</b></th>   
                    <th><b> Purpose of visit</b></th>  
                    <th><b> Date and Time </b></th>
                    <th><b> Doctor</b></th> 
                    <th><b> Status</b><th>
            </tr>
            
            <c:forEach var="appointment" items="${newAppointment}">
                <tr>
                    <td>${appointment.patientName}</td>
                <td>${appointment.age}</td>
                <td>${appointment.purpose}</td>
                <td>${appointment.getDateString()}</td>
                <td>${appointment.doctor}</td>
                <td>${appointment.status}</td>
                </tr>
            </c:forEach>
                         
    </table>
                 <input type="hidden" id="code" name="appointmentCode">
    
</div>
<!--    </form>-->
</section>
