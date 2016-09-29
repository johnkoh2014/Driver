<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book a Valet</title>
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
                            <h1>BOOK VALET</h1>

                        </div>
                    </div>
                    <!-- /page header -->

                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>

                                <section class="tile color transparent-black">
                                    <div class="tile-header">

                                        <center>DETAILS</center>

                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
                                    <!-- /tile body -->
                                    <div class="tile-body"action="#" onsubmit="if (document.getElementById('agree').checked) {
                                                                return true;
                                                            } else {
                                                                alert('Please indicate that you have read and agree to the Terms and Conditions and Privacy Policy');
                                                                return false;
                                                            }">

                                        <form class="form-horizontal" role="form" action="" method="POST">

                                            <div class="notification">
                                                <div class="row">
                                                    <h1><center><strong>$40</strong></center></h1>

                                                    <h4><center><Strong>Time and Date of Pickup</Strong></center></h4>

                                                    <center>
                                                        <h4>2nd June 2016 12:30pm</h4>
                                                        <h4><strong>Confirmed car</strong></h4>
                                                        <h4>2007 Suzuki Swift SGW6529Z</h4>
                                                    </center>
                                                </div>

                                                <div class="row">


                                                </div>

                                                <div class="notification notification-info">
                                                    <h4><center><strong>ADDRESS</strong></center></h4>
                                                    <center>326 Clementi Avenue 5 #06-185</center>
                                                </div>

                                                <div class="notification notification-info">
                                                    <h4><center><strong>POSTAL CODE</strong></center></h4>
                                                    <center>Singapore 120326</center>
                                                    
                                                </div>
                                                
                                                <div class="notification notification-info">
                                                    <center><input type="checkbox" name="checkbox" value="check" id="agree" /> I have read and agree to the terms and conditions</center>
<!--                                                        <input type="submit" name="submit" value="submit" />-->
                                                </div>
                                            </div>
                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <input type="hidden" name="service"value="">
                                                <input type="hidden" name="type" value="">
                                                <button type="submit" class="btn btn-primary">Book Now!</button>
<!--                                                <button type="reset" class="btn btn-default">Reset</button>-->
                                            </div>
                                            <!--end form footer-->
                                        </form>


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

        <script>
                                                        $(function () {



                                                        })

        </script>
    </body>
</html>
