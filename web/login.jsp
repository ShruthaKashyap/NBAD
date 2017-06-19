<%-- 
    Document   : login
    Created on : Apr 20, 2017, 7:09:00 PM
    Author     : shrut
--%>

<%-- Include tag is used to import header page --%>
<%@include file="header.jsp" %>
            <%-- Code to create login form--%>
            <div class="content">
			<div class="container">
				<div class="main">
    <form class="form-horizontal" id="userhome" action="UserController?action=login" method="post">
    
        <input type="hidden" name="action" value="login">
        	<div class="form-group">
                    <br><br><label class="control-label col-sm-2" for="email">Email Address *</label>
        	<div class="col-sm-5">
                    <input type="email"  class="form-control" id="email" name="email" required/>
        	</div>
       		</div>
       	<div class="form-group">
        	<label class="control-label col-sm-2" for="pwd">Password *</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" id="password" name="password" required/><br>
        </div>
        </div>
         <div class="form-group">
    	<div class="col-sm-offset-2 col-sm-10">
        <input type="submit" class="btn btn-primary" value="Log in" id="login_button">
        <!--<input type="submit" formaction="UserController?action=login" class="btn btn-primary" value="Admin">-->
		</div>
		</div>
    
    
    <%-- Code to go to Sign up for a new account  --%>
     <div class="form-group">
    	<div class="col-sm-offset-2 col-sm-10">
<!--    <a href="signup.jsp" id="sign_up_link">Sign up for a new account</a>-->
    </div>
		</div>
    
    </form>
    </div>
                        </div>
    
          </div>
<br/>
<br/>
<br/>
                                
    </body>
</html>

