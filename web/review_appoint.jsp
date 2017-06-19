<%-- 
    Document   : review_appoint
    Created on : Apr 30, 2017, 1:00:28 PM
    Author     : shrut
--%>
<%@ include file="header2.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br>
<h3><span id="studies">Reported Questions</span></h3><br/>
<a href="admin.jsp?user=theAdmin" id="back_to_page">&laquo;Back to the Main Page</a><br/>
<br/><br/><br/>


<!-- TODO: Add more code to get the table here.
  -->
  <div class="table-responsive">
  <table class="table table-bordered" >
        <%--Column Names --%>
        <tr>
            <th>User name</th>
            <th>Date and Time</th>
            <th> Doctor</th>
            <th> Decision </th>
        </tr>
        
        <c:forEach var="apt" items="${newAppointment}">
        <tr>
            <%-- First study details --%>
            <td>${apt.username}</td>
            <td>${apt.getDateString()}</td>
            <td>${apt.doctor}</td>
            <td>
             <form action="HMS_Controller" method="post">
            <input type="submit" class="btn btn-primary" formaction="HMS_Controller?user=theUser&amp;appointmentCode=${apt.appointmentCode }&amp;action=approve"  value="Approve">
            <input type="submit" class="btn btn-primary" formaction="HMS_Controller?user=theUser&amp;appointmentCode=${apt.appointmentCode }&amp;action=decline"  value="Dispprove">
             </form>
           </td>

        </tr>
        </c:forEach>
  </table>
        
  </div>
