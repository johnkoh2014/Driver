<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Workshop Start Servicing</title>
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
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>MY APPOINTMENTS</h1>
                        </div>
                    </div>
                    <!-- /page header -->

                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>
                                <%                                    int valetRequestStatus = (int) session.getAttribute("valetRequestStatus");
                                    int offerStatus = (int) session.getAttribute("offerStatus");
                                    String status = "SERVICE NOT STARTED";
                                    if (offerStatus == 6) {
                                        status = "SERVICING IN PROGRESS";
                                    }
                                %>
                                <div class="alert alert-success" role="alert">
                                    <h5 class="alert-heading"><center><strong>STATUS: </strong>AT WORKSHOP<br/>(<%=status%>)</center></h5>
                                </div>
                                <section class="tile color transparent-black">
                                    <div class="tile-header">
                                        <div class="tile-widget">
                                            <div class="row">
                                                <div class="col-sm-12 col-xs-12 text-right">
                                                    <div class="btn-group btn-group-justified table-options desktopOnly">
                                                        <ul class="nav nav-pills tabpager text-center">
                                                            <li class="w45 active arrange-center"><a href="#offerDetails" data-toggle="pill">OFFER DETAILS</a></li>
                                                            <li class="w45 arrange-center"><a href="#workshopProfile" data-toggle="pill">WORKSHOP PROFILE</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--end tile header-->

                                    <!-- /tile body -->

                                    <div class="tile-body">
                                        <div class="tab-content">

                                            <div class="tab-pane fade active in" id="offerDetails" >

                                                <section class="tile color transparent-black minimized">



                                                    <!-- tile header -->
                                                    <div class="tile-header">
                                                        <center><h1><strong>VALET</strong> DETAILS</h1></center>
                                                        <div class="controls">
                                                            <a href="#" class="minimize"><i class="fa fa-chevron-down"></i></a>
                                                        </div>
                                                    </div>
                                                    <!-- /tile header -->

                                                    <!-- tile body -->
                                                    <div class="tile-body ">

                                                        <div class="notification">

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
                                                    </div>
                                                    <!-- /tile body -->




                                                </section>

                                                <section class="tile color transparent-black">
                                                    <div class="tile-header">

                                                        <center><h1><strong>FINAL</strong> ACCEPTED QUOTATION</h1></center>
                                                        <div class="controls">
                                                            <a href="#" class="minimize"><i class="fa fa-chevron-down"></i></a>
                                                        </div>
                                                    </div>
                                                    <!--end tile header-->
                                                    <!-- /tile body -->
                                                    <div class="tile-body">




                                                        <div class="notification">
                                                            <div class="row">
                                                                <center><h1><strong>$120</strong></h1></center>
                                                            </div>
                                                            <div class="row">
                                                                <center>
                                                                    <strong>ESTIMATED TIME AND DATE OF COMPLETION</strong>

                                                                </center>
                                                            </div>
                                                            <p> </p>

                                                            <div class="row">
                                                                <center>
                                                                    11 JULY 2016, 1400HRS
                                                                </center>
                                                            </div>
                                                            <p></p>
                                                            <div class="row">                                               
                                                                <center>
                                                                    <b>Ah Huat Workshop Pte Ltd</b>                                     
                                                                </center>                                               
                                                            </div>

                                                        </div>


                                                    </div>
                                                    <!--end tile body-->


                                                </section>
                                            </div><!--Requests-->



                                            <div class="tab-pane fade " id="workshopProfile" >

                                                <section class="tile color transparent-black">
                                                    <div class="tile-header text-center">
                                                        <h3>AH HUAT WORKSHOP PTE LTD</h3>
                                                        <!--<a href="Booking.jsp" class="btn btn-warning" role="button">Book</a>-->
                                                    </div>
                                                    <!--end tile header-->
                                                    <div class="line-across"></div>
                                                    <!-- /tile body -->
                                                    <div class="tile-body">

                                                        <div class="row">
                                                            <strong><center>Opening Hours</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                10am - 7pm (Mon - Sat), By Appt only (Sun). Closed on PHs.
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Address</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                328 Circuit Road S(379489)
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Providing Services</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                Maintenence, Repair and servicing
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Other Brands</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                GlassMechanix
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Website</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                www.ahhuatworkshop.com.sg
                                                            </center>
                                                        </div>
                                                    </div>
                                                    <!--end tile body-->

                                                </section>


                                            </div><!--workshopProfile-->



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
