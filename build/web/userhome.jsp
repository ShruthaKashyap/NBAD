<%-- 
    Document   : userhome
    Created on : Apr 27, 2017, 1:01:33 PM
    Author     : shrut
--%>

<%@ include file="header2.jsp" %>
<%--<%
response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
try{
    if(session.getAttribute("theUser")==null )
    {
      //  request.setAttribute("msg", "Session has ended.  Please login.");
       RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
       
     }
    else if(session.getAttribute("theAdmin")==null)
    {
       // request.setAttribute("msg", "Session has ended.  Please login.");
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
<%-- Code to display items in List --%>
<form class="form-horizontal" action="HMS_COntroller?action=view" method="post">
<c:if test="${param.user == 'theUser'}">
    <br><br>
    <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;What do you wanna do today?</h2><br>
    <br><br>
    <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Make Appointment&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;View Appointments</h2>
        <div class="archive-comtainer">
            <div class="thumb">
                <div class="thumb-image">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href=new_appoint.jsp title="Make Appointment">
                        <img src="images/make_appt.png" height="270" width="270"/>
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="HMS_Controller?action=view&user=theUser" title="View Appointments">
                        <img src="images/view_appt.jpg" height="310" width="310"/>
                    </a>
                </div>
            </div>
        </div>
    </c:if>
</form>

<!-- <c:if test="${param.user == 'theAdmin'}">
 <nav id="menu">
 <ul>
	    <li><a href="admin.jsp">Home</a></li>
        <li><a href="reportques.jsp?user=theAdmin">Reported Questions</a></li>
  </ul>
 </nav>
</c:if>-->
