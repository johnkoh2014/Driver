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
        <link rel="stylesheet" href="css/custom.css">
        <title>Log In</title>
    </head>
    <body class="bg-3">
        <!-- Wrap all page content here -->
        <div id="wrap">
            <!-- Make page fluid -->
            <div class="row">
                <!-- Page content -->
                <div id="content" class="col-md-12 full-page login">


                    <div class="inside-block">
                        <img src="images/Logo.png" alt class="logo">
                        <h4><strong>VALUE QUOTES FROM TRUSTED WORKSHOPS</strong></h4>
                        <%
                            String errMsg = (String) request.getAttribute("errMsg");
                            if (errMsg != null) {%>
                        <div class="alert alert-danger"><%=errMsg%></div>
                        <%}

                            String successResetPasswordMsg = (String) request.getAttribute("successResetPasswordMsg");
                                if (successResetPasswordMsg != null) {%>
                        <div class="alert alert-success"><%=successResetPasswordMsg%></div>
                        <%}
                        %>
                        <form id="form-signin" class="form-signin" action = "Authenticate" method= "post">
                            <section>
                                <div class="input-group">
                                    <input type="email" class="form-control" name="email" placeholder="abc@email.com">
                                    <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                </div>
                                <div class="input-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password">
                                    <div class="input-group-addon"><i class="fa fa-key"></i></div>
                                </div>
                            </section>
                            <section class="controls">
                                <div class="checkbox check-transparent">
                                    <!--                                    <input type="checkbox" value="1" id="remember" checked>
                                                                        <label for="remember">Remember me</label>-->
                                </div>
                                <a href = "ForgotPassword.jsp">Forgot Password</a>
                            </section>
                            <section class="log-in">
                                <div class="col-xs-6">
                                    <a href="Signup.jsp" class="btn btn-blue">Sign Up</a>
                                </div>
                                <div class="col-xs-6">
                                    <button class="btn btn-greensea">Log In</button>
                                </div>
                            </section>
                        </form>
                    </div>
                </div>
                <!-- /Page content -->  
            </div>
        </div>
        <!-- Wrap all page content end -->
    </body>
</html>
