<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Car</title>
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
                            <h2>Add New Car</h2>
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
                                    <div class="tile-header text-center">
                                    </div>
                                    <!--end tile header-->

                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <form class="form-horizontal" role="form" action="" method="POST">

                                            <div class="form-group">
                                                <label for="input01" class="col-sm-2 control-label">Make</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="input01" name="carMake">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="input02" class="col-sm-2 control-label">Model</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="input02" name="carModel">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="input03" class="col-sm-2 control-label">Year of Manufacture</label>
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" id="input03" name="manufactureYear">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="input04" class="col-sm-2 control-label">Plate Number</label>
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" id="input04" name="plateNumber">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="input05" class="col-sm-2 control-label">Car Color</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="input05" name="carColor">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Transmission Type</label>
                                                <div class="col-sm-2">
                                                    <input type="radio"  id="input06" value="Automatic" name="transmission">
                                                    <label for="input06" class="control-label">Automatic</label>
                                                </div>
                                                <div class="col-sm-2">
                                                    <input type="radio" id="input07" value="Manual" name="transmission">
                                                    <label for="input07" class="control-label">Manual</label>
                                                </div>
                                            </div>
                                            
                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <button type="submit" class="btn btn-primary">Submit</button>
                                                <button type="reset" class="btn btn-default">Reset</button>
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
