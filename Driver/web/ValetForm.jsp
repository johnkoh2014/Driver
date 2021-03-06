<%@page import="entity.Offer"%>
<%@page import="dao.OfferDAO"%>
<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
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
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="ViewAllRequests.jsp">All Requests</a></li>
                            <li><a href="ViewOffers.jsp">Offers</a></li>
                            <li><a href="OfferDetails.jsp">Offer Details</a></li>
                            <li><a href="Booking.jsp">Booking</a></li>
                            <li>Valet</li>
                            <li class="active">Confirm Valet</li>
                        </ol>
                    </div>
                    <div class="pageheader">
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>MY VALET BOOKING</h1>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        String isValet = (String) session.getAttribute("isValet");
                        int offerId = (Integer) session.getAttribute("offerId");
                        int workshopId = (Integer) session.getAttribute("workshopId");
                        String serviceStartTime = (String) session.getAttribute("serviceStartTime");
                        String serviceEndTime = (String) session.getAttribute("serviceEndTime");
                        String driverInitialComment = (String) session.getAttribute("driverInitialComment");

                        OfferDAO oDAO = new OfferDAO();
                        Offer offer = oDAO.retrieveOfferById(id, token, offerId);
                        String wsAddress = offer.getShopAddress();
                    %>
                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->

                            <form class="form-horizontal" role="form" action="SubmitValet" method="POST">
                                <section class="tile color transparent-white">
                                    <div class="tile-header">
                                    </div>
                                    <!--end tile header-->

                                    <!-- /tile body -->
                                    <div class="tile-body">


                                        <div class="form-group">
                                            <label for="input01" class="col-sm-2 control-label">Pickup Address</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" style="color:white;" id="input01" name="address" required>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="input01" class="col-sm-2 control-label">Pickup Postal</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" style="color:white;" id="input01" name="postal" required>
                                            </div>
                                        </div>


                                        <!--form footer for submit-->
                                        <div class="form-group form-footer text-center">
                                            <input type="hidden" value="<%=serviceStartTime%>" name="serviceStartTime">
                                            <input type="hidden" value="<%=serviceEndTime%>" name="serviceEndTime">
                                            <input type="hidden" value="<%=wsAddress%>" name="wsAddress">
                                            <input type="hidden" value="<%=workshopId%>" name="workshopId">
                                            <input type="hidden" value="<%=offerId%>" name="offerId">
                                            <input type="hidden" value="<%=driverInitialComment%>" name="driverInitialComment">
                                            <button type="submit" class="btn btn-primary">Submit</button>

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
        <script type="text/javascript" src="js/intercom.js"></script>
        <script src="js/minimal.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            $(function () {
//                document.getElementById("valetYes").disabled = true;
            })

        </script>
        <!--DATETIME-->
        <script type="text/javascript">
            $(".date").each(function () {
                $(this).datetimepicker({
                    format: 'YYYY-MM-DD HH',
                    minDate: new Date(),
                    ignoreReadonly: true
                });
            });</script>
        <script>
            intercom("<%=name%>", "<%=email%>",<%=id%>, "<%=handphone%>");
        </script>
    </body>
</html>
