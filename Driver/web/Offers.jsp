<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Requests</title>
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
                            <h1>ALL REQUESTS</h1>
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
                                        <div class="tile-widget">
                                            <div class="row">
                                                <div class="col-sm-12 col-xs-12 text-right">
                                                    <div class="btn-group btn-group-justified table-options desktopOnly">
                                                        <ul class="nav nav-pills tabpager text-center">
                                                            <li class="w50 active arrange-center"><a href="#Requests" data-toggle="pill">REQUESTS</a></li>
                                                            <li class="w50 arrange-center"><a href="#Offers" data-toggle="pill">OFFERS</a></li>
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

                                            <div class="tab-pane fade active in" id="Requests" >
                                                <ul class="list-group">
                                                    <li class="list-group-item"><b>General Diagnostic</b><br/><i>No offer at the moment</i></li>
                                                    <li class="list-group-item"><b>General Diagnostic</b><br/><i>There are offers for your request</i></li>
                                                </ul>
                                            </div><!--Requests-->



                                            <div class="tab-pane fade " id="Offers" >
                                                <div class="list-group">
                                                    <a href="OfferDetails.jsp?id=" class="list-group-item"><b>AH HUAT WORKSHOP PTE LTD</b><br/><span style="color:blue">$60 - $80</span><br/><i>Click to view profile and quote</i></a>
                                                    <a href="OfferDetails.jsp?id=" class="list-group-item"><b>DYNAMICS MECHANICS</b><br/><span style="color:blue">$70 - $120</span><br/><i>Click to view profile and quote</i></a>
                                                </div>
                                            </div><!--Offers-->



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

        <script>
            $(function () {



            })

        </script>
    </body>
</html>
