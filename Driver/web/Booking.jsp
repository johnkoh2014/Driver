<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
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
                            <h1>MY BOOKING</h1>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        
                    String v_id = request.getParameter("id");
                        int vid = 0;
                        if (v_id.length() > 0) {
                            vid = Integer.parseInt(v_id);
                        }
                    %>
                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->

                            <form class="form-horizontal" role="form" action="SelectValet" method="POST">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div style="color:white"><b>Service Date & Time</b></div>
                                        <div class="form-group col-sm-12">
                                            <div class='input-group date' id='enddatetimepicker'>
                                                <!--<form id='' action="" role="form">-->
                                                <input type='text' name="dateTime" class="form-control dt" readonly/>
                                                <!--</form>-->

                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <section class="tile color transparent-white">
                                    <div class="tile-header">
                                        Would you like to have Valet?
                                    </div>
                                    <!--end tile header-->

                                    <!-- /tile body -->
                                    <div class="tile-body">


                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <input type="radio"  id="input06" value="Yes" name="valet">
                                                <label for="input06" class="control-label">YES</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="radio" id="input07" value="No" name="valet">
                                                <label for="input07" class="control-label">NO</label>
                                            </div>
                                        </div>


                                        <!--form footer for submit-->
                                        <div class="form-group form-footer text-center">
                                            <input type="hidden" value="<%=vid%>" name="<%=vid%>">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                            <button type="reset" class="btn btn-default">Reset</button>

                                        </div>


                                    </div>
                                    <!--end tile body-->


                                </section>
                                <!-- /col 12 -->
                                <!--end form footer-->
                            </form>
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
        <script type="text/javascript" src="js/moment.js"></script> 
        <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script> 

        <script src="js/minimal.min.js"></script>

        <script>
            $(function () {



            })

        </script>
        <!--DATETIME-->
        <script type="text/javascript">
            $(".date").each(function () {
                $(this).datetimepicker({
                    format: 'YYYY-MM-DD HH:mm',
                    minDate: new Date(),
                    sideBySide: true,
                    ignoreReadonly: true
                });
            });</script>
    </body>
</html>
