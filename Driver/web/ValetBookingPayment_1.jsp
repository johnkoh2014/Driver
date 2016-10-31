<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valet Payment</title>
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

                                <section class="tile color transparent-black">
                                    <div class="tile-header">

                                        <center>Payment Details</center>

                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <%                                            String errorMsg = (String) session.getAttribute("errorMsg");
                                            String successMsg = (String) session.getAttribute("successMsg");
                                            if (errorMsg != null) {
                                                out.print(errorMsg);
                                                out.print((String) session.getAttribute("token"));
                                            }
                                            if (successMsg != null) {
                                                out.print(successMsg);
                                            }
                                            int requestId = (int) session.getAttribute("requestId");
                                        %>
                                        <!--<form class="form-horizontal" id="payment-form" role="form" action="PaymentServlet" method="POST">-->
                                        <form class="form-horizontal" id="payment-form" role="form" action="ProxyPayment" method="POST">

                                            <fieldset>
                                                <!--                                         <legend>Payment</legend>-->
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="card-holder-name">Name on Card</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="form-control" id="card-holder-name" placeholder="Card Holder's Name">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="card-number">Card Number</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="form-control" name="card-number" data-stripe="number"id="card-number" placeholder="Debit/Credit Card Number">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="expiry-month">Expiration Date</label>
                                                    <div class="col-sm-9">
                                                        <div class="row">
                                                            <div class="col-xs-3">
                                                                <input type="text" class="form-control" data-stripe="exp-month" id="expiry-month" placeholder="Month">

                                                            </div>
                                                            <div class="col-xs-3">
                                                                <input type="text" class="form-control" data-stripe="exp-year" id="expiry-year" placeholder="Year">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="cvc">Card CVC</label>
                                                    <div class="col-sm-3">
                                                        <input type="text" class="form-control" data-stripe="cvc" id="cvc" placeholder="Security Code">
                                                    </div>
                                                </div>

                                            </fieldset>

                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <input type="hidden" name="service"value="">
                                                <input type="hidden" name="type" value="">
                                                <input type="hidden" name="requestId" value="<%=requestId%>">
                                                <button type="submit" id="submitBtn" class="btn btn-warning">Book Now!</button>
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
        <script type="text/javascript" src="js/intercom.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script src="js/minimal.min.js"></script>
        <script>
            intercom("<%=name%>", "<%=email%>",<%=id%>, "<%=handphone%>");
        </script>
    </body>
</html>
