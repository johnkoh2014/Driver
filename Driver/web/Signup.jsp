<%-- 
    Document   : login
    Created on : May 4, 2016, 5:43:20 PM
    Author     : joanne.ong.2014
--%>

<%@page import="java.util.ArrayList"%>
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
                            String email = (String) request.getAttribute("email");
                            if (email == null || email.equals("null")) {
                                email = "";
                            }
                            String name = (String) request.getAttribute("fullname");
                            if (name == null || name.equals("null")) {
                                name = "";
                            }
                            String handphone = (String) request.getAttribute("handphone");
                            if (handphone == null || handphone.equals("null")) {
                                handphone = "";
                            }
                            
                            String nric = (String) request.getAttribute("nric");
                            if (nric == null || nric.equals("null")) {
                                nric = "";
                            }
                            ArrayList<String> errMsg = (ArrayList<String>) request.getAttribute("err");
                            if (errMsg != null && errMsg.size() > 0) {
                        %>
                        <div class="alert alert-danger">
                            <ul>
                                <%
                                    for (String error : errMsg) {
                                %>
                                <li><%=error%></li>
                                    <%
                                        }
                                    %>
                            </ul>
                        </div>
                        <%
                            }
                        %>

                        <form id="form-signin" class="form-signin" action = "SignupServlet" method= "post">
                            <section>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="fullname" value="<%=name%>" placeholder="Fullname">
                                    <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                </div>
                                <div class="input-group">
                                    <input type="email" class="form-control" name="email" value="<%=email%>" placeholder="Email">
                                    <div class="input-group-addon"><i class="fa fa-pencil"></i></div>
                                </div>
                                <div class="input-group">
                                    <input type="tel" class="form-control" name="handphone" value="<%=handphone%>" placeholder="Handphone Number">
                                    <div class="input-group-addon"><i class="fa fa-pencil"></i></div>
                                </div> 
                                <div class="input-group">
                                    <input type="text" class="form-control" name="nric" placeholder="NRIC" id="nric" data-toggle="tooltip" data-placement="top" title="" data-original-title="Last 5 characters e.g. 4567D">
                                    <div class="input-group-addon"><i class="fa fa-key"></i></div>
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
                                <button class="btn btn-greensea">Sign Up</button>
                            </section>
                        </form>
                    </div>
                </div>
                <!-- /Page content -->  
            </div>
        </div>
        <!-- Wrap all page content end -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            $('#nric').tooltip();
        </script>
    </body>
</html>
