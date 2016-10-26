<%@page import="entity.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valet Confirmed</title>
        <jsp:include page="include/head.jsp"/>
    </head>
    <body class="bg-3">

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
                            <h2>VALET PAYMENT</h2>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%--
                    <%
                        
                        String currentEmail = driver.getEmail();
                        String newEmail = (String) request.getAttribute("newEmail");
                        if (newEmail == null) {
                            newEmail = "";
                        }
                        String hpNo = driver.getHandphone();
                    %>
                    --%>


                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>

                                <section class="tile color transparent-black">
                                    <div class="tile-header text-center">
                                        <h3>Details</h3>
                                    </div>

                                    <div class="line-across"></div>
                                    <!--end tile header-->

                                    <!-- /tile body -->
                                    <div class="tile-body text-center">

                                        <b>Congratulations</b><br> 
                                        your valet has been confirmed.<br>


                                        Estimated Pick Up Time<br>
                                        <b>3:00PM</b>
                                    </div>
                                    <!--end tile body-->


                                </section>


                                <section class="tile color transparent-black">
                                    <div class="tile-header text-center">
                                        <b>VALET DRIVER</b>
                                        <div class="controls">
                                            <a href="#" class="minimize"><i class="fa fa-chevron-down"></i></a>
                                        </div>
                                    </div>
                                    <div class="tile-body">
                                        <div class="row">
                                            <center><img src="images/joshua.jpg" class="img-thumbnail-small" alt="Valet Profile Pic" width="304" height="236"></center>
                                        </div>
                                        <p> </p>
                                        <div class="row">
                                            <strong><center>Name</center></strong>
                                        </div>
                                        <div class="row">
                                            <center>
                                                Ah Siao
                                            </center>
                                        </div>

                                        <div class="row">
                                            <strong><center>Age</center></strong>
                                        </div>
                                        <div class="row">
                                            <center>
                                                24
                                            </center>
                                        </div>

                                        <div class="row">
                                            <strong><center>Contact</center></strong>
                                        </div>
                                        <div class="row">
                                            <center>
                                                91112222
                                            </center>    
                                        </div>
                                    </div>
                                    
                                    <div class="tile-footer">
                                        <div class="text-center">
                                            <a href="ValetBookingPayment.jsp" class="btn btn-primary" role="button">Proceed to Payment</a>
                                        </div>
                                    </div>

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
<script type="text/javascript" src="js/custom.js"></script>
        <script src="js/minimal.min.js"></script>

        <script>
            $(function () {



            })

        </script>
    </body>
</html>
