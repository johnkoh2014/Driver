<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Reject Final Quote</title>
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
                            <h1><strong>MY </strong> APPOINTMENTS</h1>

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

                                        <center><strong>CONFIRM REJECT</strong></center>

                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
                                    <!-- /tile body -->
                                    <div class="tile-body">                                       
                                        <form role="form">


                                            <ul class="nolisttypes inlineSelect rowSelect blue">
                                                <li class="title"><h5>Choose the method to collect your car:</h5></li>
                                                <li>
                                                    <div class="checkbox">
                                                        <input type="checkbox" value="1" id="opt01">
                                                        <label for="opt01">Self collect at workshop</label>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="checkbox">
                                                        <input type="checkbox" value="1" id="opt02">
                                                        <label for="opt02">Use valet service(additional $40)</label>
                                                    </div>
                                                </li>
                                               
                                                <div class="form-group form-footer text-center">
                                                    <center>
                                                        <button type="submit" class="btn btn-primary btn-lg">Yes</button>
                                                        <button type="submit" class="btn btn-primary btn-lg">No</button>
                                                    </center>
                                                </div>
                                            </ul>
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

            $('input[type="checkbox"]').on('change', function () {
                $('input[type="checkbox"]').not(this).prop('checked', false);
            });
        </script>
    </body>
</html>

