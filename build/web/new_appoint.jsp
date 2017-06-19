<%-- 
    Document   : new_appoint
    Created on : Apr 28, 2017, 2:50:13 PM
    Author     : shrut
--%>

<%-- Include tag is used to import header page --%>
<%@ include file="header2.jsp" %>
<%
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
    %>
<!--<script type="text/javascript" src="js/newstudy.js">
</script>-->
<%-- Code to display Page Name --%>
<h3 id="page_name">New Appointment</h3>
 <%-- Code to go Back to the Main Page  --%>
<a href="userhome.jsp" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to create new appointment --%>
<section>
    <form class="form-horizontal" action="HMS_Controller?action=add" method="post">
    
    	<div class="form-group">
        <label class="col-sm-4 control-label">Patient Name *</label>
        <div class="col-sm-4">
        <input type="text" id="patient_name" class="form-control" name="patient_name" required />
         </div>
            </div>
        
        <div class="form-group">
        <label class="col-sm-4 control-label">Age *</label>
        <div class
             ="col-sm-4">
        <input type="text" class="form-control" id="age" name="age" required/>
         </div>
            </div>
        
        <div class="form-group">
        <label class="col-sm-4 control-label">Purpose of visit*</label>
        <div class
             ="col-sm-4">
        <input type="text" class="form-control" id="purpose" name="purpose" />
         </div>
            </div>
<!--        <button type="button" class="btn btn-primary">

 Browse</button>-->
        
        
<!--        <div class="form-group">
        <label class="col-sm-4 control-label"># Participants *</label>
        <div class="col-sm-4">
        <input type="text" class="form-control" name="participant_text" id="participant_text" required/>
         </div>
            </div>-->

<div class="form-group">
        <label class="col-sm-4 control-label">Date and Time *</label>
        <div class="col-sm-4">
        <input type="datetime-local" class="form-control" name="date_time" id="date_time" required/>
         </div>
            </div>
<!--         <div class="container">
    <div class="row">
        <label class="col-sm-4 control-label"># Date and time *</label>
        <div class='col-sm-4'>
            <div class="form-group">
                
                <div class='input-group date' id='datetimepicker1'>
                    <input type='datetime-local' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').data("DateTimePicker").FUNCTION()
            });
        </script>
    </div>
</div>-->
        
        <div class="form-group">
        <label class="col-sm-4 control-label"># Doctor *</label>
        <div class="col-sm-4">
        <select name="doctor" class="form-control" id="doctor">
            <option value="Dr Smith">Dr Smith</option>
            <option value="Dr Watson">Dr Watson</option>
            <option value="Dr Carol">Dr Carol</option>
        </select> <br>
         </div>
            </div>
        
        
<!--        <div id="TextBoxContainer">
    	 Textboxes will be added here 
		</div>
       
        
        <div class="form-group">
        <label class="col-sm-4 control-label">Description *</label>
        <div class="col-sm-4">
        <textarea name="desc" class="form-control" id="desc" required></textarea>
         </div>
            </div>-->
        
        <div class="form-group">
        <div class="col-sm-offset-5 col-sm-4">
        <button type="submit" class="btn btn-primary">Submit</button>
<!--       <input type="hidden" name="action" value="add">-->
<!--          <input type="hidden" name="studyCode" value="Study Code">-->
        <input type="hidden" name="status" id="status" value="Pending">
       

        <br/><br/><br/>
         </div>
            </div>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%--<%@ include file="footer.jsp" %>--%>
