<%@page import="entity.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Valet</title>
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
                            <h2>Book Valet</h2>
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
                                    <div class="tile-body text-center"action="#" onsubmit="if (document.getElementById('agree').checked) {
                                                return true;
                                            } else {
                                                alert('Please indicate that you have read and agree to the Terms and Conditions and Privacy Policy');
                                                return false;
                                            }">




                                        <h2><center><strong>$40</strong></center></h2>
                                        <p></p>
                                        <center><b>VALET CHARGE</b></center>
                                        <p></p>
                                        <center><b>Workshop Appointment</b></center>
                                        <p></p>
                                        <center><b>2:30PM</b></center>
                                        <p></p>
                                        <center>Thursday, 13th October 2016</center>
                                        <p></p>
                                        <div class="line-across"></div>
                                        <form class="form-horizontal" role="form" action="EditProfile" method="POST">

                                            <div class="form-group">
                                                <center><label for="input01" class="col-sm-2 control-label">Address</label></center>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="input01" name="address" value="">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <center><label for="input02" class="col-sm-2 control-label">Postal Code</label></center>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="input02" name="postalCode" value="">
                                                </div>
                                            </div>

                                            <div class="notification">
                                                <center><input type="checkbox" name="checkbox" value="check" id="agree" /> I have read and agree to the terms and conditions</center>
                                                <!--                                                        <input type="submit" name="submit" value="submit" />-->
                                            </div>

                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <button type="submit" class="btn btn-primary">FIND VALET!</button>
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
