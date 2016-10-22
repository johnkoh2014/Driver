<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Workshop Diagnostics</title>
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

                    </div>
                    <!-- /page header -->

                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>
                                <div class="alert alert-success" role="alert">
                                    <h5 class="alert-heading"><center><strong>STATUS:</strong> AT WORKSHOP(DIAGNOSTIC)</center></h5>

                                </div>


                                <section class="tile color transparent-black">



                                    <!-- tile header -->
                                    <div class="tile-header">
                                        <center><h1><strong>VALET</strong> DETAILS</h1></center>
                                        <div class="controls">
                                            <a href="#" class="minimize"><i class="fa fa-chevron-down"></i></a>
                                            <a href="#" class="refresh"><i class="fa fa-refresh"></i></a>

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

                                        <center><h1><strong>FINAL</strong> QUOTATION</h1></center>

                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
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
                                                <a href="#" class="btn btn-lg btn-greensea margin-bottom-20" role="button">Accept</a>                                               
                                                <a href="#" class="btn btn-lg btn-red margin-bottom-20" role="button">Decline</a>                                           
                                                </center>                                               
                                            </div>

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
