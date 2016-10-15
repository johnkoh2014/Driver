<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valet Payment</title>
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
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>Valet Payment</h1>

                        </div>
                    </div>
                    <!-- /page header -->

                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>
                                <div class="alert alert-success" role="alert">
                                    <h3 class="alert-heading"><center>Success!</center></h3>
                                    <p><center>Your Valet has been booked!</center></p>
                                    <p class="m-b-0"><center>You'll be notified via a notification once your valet has reached.</center></p>
                                </div>

                                <section class="tile color transparent-black">
                                    <div class="tile-header">

                                        <center><strong>CONFIRMED BOOKING</strong></center>

                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
                                    <!-- /tile body -->
                                    <div class="tile-body">




                                        <div class="notification">
                                            <div class="row">
                                                <strong><center>AH HUAT WORKSHOP</center></strong>
                                            </div>
                                            <div class="row">
                                                <center>
                                                    Tuesday, 12 July 2016
                                                    1:00pm
                                                </center>
                                            </div>
                                            <p> </p>
                                            <div class="row">
                                                <strong><center>VALET DETAILS</center></strong>
                                            </div>
                                            <div class="row">
                                                <center>
                                                    Tuesday, 12 July 2016
                                                    12:15pm
                                                </center>
                                            </div>

                                        </div>
                                        
                                        <div class="notification">
                                            <a href="#" class="btn btn-block btn-orange margin-bottom-20" role="button"><font color="black">View Valet Details</font></a>
                                            <a href="#" class="btn btn-block btn-orange margin-bottom-20" role="button"><font color="black">View All Appointments</font></a>
                                            
                                        </div>
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

        <script src="js/minimal.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            $(function () {



            })

        </script>
    </body>
</html>
