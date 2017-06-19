<%-- 
    Document   : signup
    Created on : Apr 28, 2017, 8:53:27 PM
    Author     : shrut
--%>
<%@include file="header.jsp" %>
<section>
<br/><br/><br/>
<!--<h5 id="msg"> ${msg}</h5>-->
        <form class="form-horizontal" action="UserController?action=create" method="post">
        
            <input type="hidden" name="action" value="create">
            <div class="form-group">
            <label class="col-sm-4 control-label">Name *</label>
            <div class="col-sm-4">
            <input type="text" class="form-control" id="name" name="name" required/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-4 control-label">Email *</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="email" name="email" required/><br>
                <input type="checkbox" name="admincheck"/>&nbsp;Admin Account
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-4 control-label">Password *</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password" name="password" required/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-4 control-label">Confirm Password *</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="cpassword" name="cpassword" required />
            </div>
            </div>
            	
			<div class="form-group">
    <div class="col-sm-offset-5">
            <input type="submit" value="Create Account" class="btn btn-primary">
            </div>
            </div>
            <br><br/><br/>
        </form>
        </section>
