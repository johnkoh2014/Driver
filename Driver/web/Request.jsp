<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Quotes</title>
        <jsp:include page="include/head.jsp"/>
    </head>
    <body class="bg-1">

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
                            <h2>Get Quotes</h2>
                        </div>
                    </div>
                    <!-- /page header -->
                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>
                                <div class="margin-top-15 text-center">
                                    <a href="AddCar.jsp" class="btn btn-primary" role="button">Add Car</a>
                                </div>
                                <div class="text-center margin-15 full-width">
                                    <div class="btn-group margin-bottom-20" style="width:100%">
                                        <button type="button" class="btn btn-default dropdown-toggle" style="width:100%" data-toggle="dropdown">
                                            Choose a vehicle to service <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu" style="width:100%">
                                            <li>
                                                <a href="#">
                                                    <div class="carItem">
                                                        <div class="col-sm-6 car">
                                                            AUDI TT
                                                        </div>
                                                        <div class="col-sm-5 car">
                                                            SKJ 1234 Z
                                                        </div>
                                                        <div class="caret-right"></div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li class="line-across-dark"></li>
                                            <li>
                                                <a href="#">
                                                    <div class="carItem">
                                                        <div class="col-sm-6 car">
                                                            AUDI TT
                                                        </div>
                                                        <div class="col-sm-5 car">
                                                            SKJ 1234 Z
                                                        </div>
                                                        <div class="caret-right-dark"></div>
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>






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
