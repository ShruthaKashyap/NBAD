<%-- 
    Document   : admin
    Created on : Apr 30, 2017, 10:23:08 AM
    Author     : shrut
--%>

<%@include file="header2.jsp" %>
<%--<%
response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
try{
    if(session.getAttribute("theUser")==null )
    {
       // request.setAttribute("msg", "Session has ended.  Please login.");
       RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
       
     }
    else if(session.getAttribute("theAdmin")==null)
    {
      //  request.setAttribute("msg", "Session has ended.  Please login.");
       RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
    }
    else
    {
        System.out.println("user logged in is::"+session.getAttribute("theUser").toString());
    }
}
    catch(NullPointerException e)
            {
            
            
            }
    %>--%>

<!-- TODO: Change the menu as per the admin page -->
<br>
<br>
<h2>Review Appointments</h2><br>
<div class="archive-comtainer">
            <div class="thumb">
                <div class="thumb-image">
                    <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="HMS_Controller?action=adminAppointments&user=theAdmin" title="Review Appointments">
                        <img src="images/admin-review.jpg" height="270" width="270"/>
                    </a>
<!--                    <a href=view_appoint.jsp title="View Appointments">
                        <img src="images/view_appt.jpg" height="310" width="310"/>
                    </a>-->
                </div>
            </div>
        </div>
