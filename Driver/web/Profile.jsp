<%@page import="dao.VehicleDAO"%>
<%@page import="entity.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <jsp:include page="include/head.jsp"/>
    </head>
    <body class="solid-bg-3">

        <!-- Preloader -->
        <div class="mask"><div id="loader"></div></div>
        <!--/Preloader -->

        <!-- Wrap all page content here -->
        <div id="wrap">
            <!-- Make page fluid -->
            <div class="row">
                <%@include file="include/topbar.jsp"%>
                <!-- Page content -->
                <div id="content" class="col-md-12">
                    <!-- page header -->
                    <div class="pageheader">

                        <!--<h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i>Get Quotes</h2>-->
                        <div class="margin-top-15 text-center">
                            <h2>My Profile</h2>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        VehicleDAO vDAO = new VehicleDAO();
                        ArrayList<Vehicle> vList = vDAO.getAllVehicles(id, token);
//                        ArrayList<Vehicle> vList = driver.getVehicles();

                    %>
                    <%                        String success = (String) session.getAttribute("success");

                        if (success != null && !(success.equals("null")) && success.length() > 0) {
                    %>
                    <div class="alert alert-success"><%=success%></div>
                    <%
                            session.setAttribute("success", "");
                        }
                    %>
                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>

                                <section class="tile color transparent-black">
                                    <div class="tile-header text-center">
                                        <h3>Account Information</h3>
                                    </div>
                                    <!--end tile header-->

                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <form class="form-horizontal" role="form" action="" method="POST">

                                            <div class="form-group">
                                                <label for="input01" class="col-sm-2 control-label">Email</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="input01" name="email" value="<%=email%>" style="color:white" readonly>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="input02" class="col-sm-2 control-label">Name</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="input02" name="name" value="<%=name%>" style="color:white" readonly>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="input03" class="col-sm-2 control-label">Mobile Number</label>
                                                <div class="col-sm-10">
                                                    <input type="tel" class="form-control" id="input03" name="hpNo" value="<%=handphone%>" style="color:white" readonly>
                                                </div>
                                            </div>
                                                
                                            <div class="form-group">
                                                <label for="input04" class="col-sm-2 control-label">NRIC (Last 5 characters e.g. 4567D)</label>
                                                <div class="col-sm-10">
                                                    <input type="tel" class="form-control" id="input04" name="nric" value="<%=nric%>" style="color:white" readonly>
                                                </div>
                                            </div>

                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <a href="ChangePassword.jsp" class="btn btn-blue">Change Password</a>
                                                <a href="EditProfile.jsp" class="btn btn-default">Edit Profile</a>

                                            </div>
                                            <!--end form footer-->
                                        </form>

                                    </div>
                                    <!--end tile body-->


                                </section>


                                <section class="tile color transparent-black">
                                    <div class="tile-header text-center">
                                        <h3>Vehicles</h3>
                                    </div>
                                    <!--end tile header-->

                                    <!-- /tile body -->
                                    <div class="tile-body">
                                        <%
                                            for (Vehicle vehicle : vList) {
                                                int vid = vehicle.getId();
                                                String make = vehicle.getMake();
                                                String model = vehicle.getModel();
                                                String noPlate = vehicle.getPlateNumber();
                                        %>
                                        <div class="carItem">
                                            <div class="col-xs-7 car1">
                                                <%=make + " " + model%><br/>
                                                <%=noPlate%>
                                            </div>

                                            <div class="col-xs-2 car">
                                                <a href="EditVehicle.jsp?id=<%=vid%>" class="btn btn-blue btn-sm">Edit</a>
                                            </div>
                                            <div class="col-xs-3 car">
                                                <form role="form" action="DeleteVehicle" method="POST">
                                                    <button type="submit" name="vid" value="<%=vid%>" class="btn btn-danger btn-sm">Delete</button>
                                                </form>
                                            </div>
                                            <div class="margin-bottom-20"></div>
                                        </div>
                                        <!--<div class="line-across-dark"></div>-->
                                        <%
                                            }
                                        %>
                                    </div>
                                    <!--end tile body-->


                                </section>



                            </div>
                            <!-- /col 12 -->
                        </div>
                        <!-- /row -->
                    </div>
                    <!-- /content container -->
                </div>
                <!-- Page content end -->
            </div>
            <!-- Make page fluid-->
        </div>
        <!-- Wrap all page content end -->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-dropdown-multilevel.js"></script>
        <script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js?lang=css&amp;skin=sons-of-obsidian"></script>
        <script type="text/javascript" src="js/jquery.mmenu.min.js"></script>
        <script type="text/javascript" src="js/jquery.sparkline.min.js"></script>
        <script type="text/javascript" src="js/jquery.nicescroll.min.js"></script>
        <script type="text/javascript" src="js/jquery.animateNumbers.js"></script>
        <script type="text/javascript" src="s/jquery.videobackground.js"></script>
        <script type="text/javascript" src="js/jquery.blockUI.js"></script>
        <script type="text/javascript" src="js/intercom.js"></script>
        <script src="js/minimal.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            intercom("<%=name%>", "<%=email%>",<%=id%>, "<%=handphone%>");
        </script>
    </body>
</html>
