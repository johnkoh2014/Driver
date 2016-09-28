<%-- 
    Document   : login
    Created on : May 4, 2016, 5:43:20 PM
    Author     : joanne.ong.2014
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/ico" href="images/Logo.ico" />
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap-checkbox.css">
        <link rel="stylesheet" href="css/bootstrap-dropdown-multilevel.css">

        <link href="css/minimal.css" rel="stylesheet">
        <title>Sign Up</title>
    </head>
    <body class="bg-3">
        <!-- Wrap all page content here -->
        <div id="wrap">
            <!-- Make page fluid -->
            <div class="row">
                <!-- Page content -->
                <div id="content" class="col-md-12 full-page login">


                    <div class="inside-block">
                        <h2><strong>Sign Up</strong></h2>
                        <%
                        
                        %>

                        <form id="form-signin" class="form-signin" action = "SignupServlet" method= "post">
                            <section>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="fullname" placeholder="Fullname">
                                    <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                </div>
                                <div class="input-group">
                                    <input type="email" class="form-control" name="email" placeholder="Email">
                                    <div class="input-group-addon"><i class="fa fa-pencil"></i></div>
                                </div>
                                <div class="input-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password">
                                    <div class="input-group-addon"><i class="fa fa-key"></i></div>
                                </div>
                                <div class="input-group">
                                    <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password">
                                    <div class="input-group-addon"><i class="fa fa-key"></i></div>
                                </div>

                            </section>
                            <section class="log-in">
                                <a href="Login.jsp" class="btn btn-blue">Back</a>
                                <button class="btn btn-greensea">Submit</button>
                            </section>
                        </form>
                        <%
                            String errMsg = (String) request.getAttribute("errMsg");
                            if (errMsg != null) {
                                out.println(errMsg + "<br/><br/>");
                            }

                            String successResetPasswordMsg = (String) request.getAttribute("successResetPasswordMsg");
                            if (successResetPasswordMsg != null) {
                                out.println(successResetPasswordMsg + "<br/><br/>");
                            }
                        %>
                    </div>
                </div>
                <!-- /Page content -->  
            </div>
        </div>
        <!-- Wrap all page content end -->
    </body>
</html>
