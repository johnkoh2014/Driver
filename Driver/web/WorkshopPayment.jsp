<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Workshop Payment</title>
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
                            <h1><strong>Workshop</strong> Payment</h1>

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

                                        <center>PAYMENT DETAILS</center>

                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <form class="form-horizontal" role="form" action="" method="POST">

                                            
                                                <div class="row">
                                                    <h1><center><strong>$120</strong></center></h1>

                                                    
                                                </div>

                                                <form class="form-horizontal" role="form" action="" method="POST">
                                                    <fieldset>
<!--                                                <legend>Payment</legend>-->
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="card-holder-name">Name on Card</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="form-control" name="card-holder-name" id="card-holder-name" placeholder="Card Holder's Name">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="card-number">Card Number</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="form-control" name="card-number" id="card-number" placeholder="Debit/Credit Card Number">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="expiry-month">Expiration Date</label>
                                                    <div class="col-sm-9">
                                                        <div class="row">
                                                            <div class="col-xs-3">
                                                                <select class="form-control col-sm-2" name="expiry-month" id="expiry-month">
                                                                    <option>Month</option>
                                                                    <option value="01">Jan (01)</option>
                                                                    <option value="02">Feb (02)</option>
                                                                    <option value="03">Mar (03)</option>
                                                                    <option value="04">Apr (04)</option>
                                                                    <option value="05">May (05)</option>
                                                                    <option value="06">June (06)</option>
                                                                    <option value="07">July (07)</option>
                                                                    <option value="08">Aug (08)</option>
                                                                    <option value="09">Sep (09)</option>
                                                                    <option value="10">Oct (10)</option>
                                                                    <option value="11">Nov (11)</option>
                                                                    <option value="12">Dec (12)</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-xs-3">
                                                                <select class="form-control" name="expiry-year">
                                                                    <option value="13">2013</option>
                                                                    <option value="14">2014</option>
                                                                    <option value="15">2015</option>
                                                                    <option value="16">2016</option>
                                                                    <option value="17">2017</option>
                                                                    <option value="18">2018</option>
                                                                    <option value="19">2019</option>
                                                                    <option value="20">2020</option>
                                                                    <option value="21">2021</option>
                                                                    <option value="22">2022</option>
                                                                    <option value="23">2023</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="cvv">Card CVV</label>
                                                    <div class="col-sm-3">
                                                        <input type="text" class="form-control" name="cvv" id="cvv" placeholder="Security Code">
                                                    </div>
                                                </div>
<!--                                                <div class="form-group">
                                                    <div class="col-sm-offset-3 col-sm-9">
                                                        <button type="button" class="btn btn-success">Pay Now</button>
                                                    </div>
                                                </div>-->
                                            </fieldset>
           
                                            
                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <input type="hidden" name="service"value="">
                                                <input type="hidden" name="type" value="">
                                                <button type="submit" class="btn btn-warning">Pay Now!</button>
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
