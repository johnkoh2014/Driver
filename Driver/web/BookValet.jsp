<%@page import="java.sql.Timestamp"%>
<%@page import="entity.Vehicle"%>
<%@page import="entity.Offer"%>
<%@page import="dao.OfferDAO"%>
<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book a Valet</title>
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
                            <h1>BOOK VALET</h1>

                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        String isValet = (String) session.getAttribute("isValet");
                        int offerId = (Integer) session.getAttribute("offerId");
                        int workshopId = (int) session.getAttribute("workshopId");
                        String serviceStartTime = (String) session.getAttribute("serviceStartTime");
                        String serviceEndTime = (String) session.getAttribute("serviceEndTime");
                        String puTime = (Timestamp) session.getAttribute("pickupTime") + "";
                        String pickupTime = puTime.substring(0,puTime.lastIndexOf("."));
                        String appointmentTime = (Timestamp) session.getAttribute("appointmentTime") + "";
                        String postal = (String) session.getAttribute("postal");
                        String address = (String) session.getAttribute("address");

                        OfferDAO oDAO = new OfferDAO();
                        Offer offer = oDAO.retrieveOfferById(id, token, offerId);

                        String wsAddressPostal = offer.getShopAddress();
                        String wsAddress = wsAddressPostal.substring(0, wsAddressPostal.lastIndexOf(" "));
                        String wsPostal = wsAddressPostal.substring(wsAddressPostal.lastIndexOf(" ") + 1);
                        Vehicle vehicle = offer.getVehicle();
                        String make = vehicle.getMake();
                        String model = vehicle.getModel();
                        int year = vehicle.getYear();
                        String noPlate = vehicle.getPlateNumber();

                    %>
                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>

                                <section class="tile color transparent-black">
                                    <div class="tile-header">

                                        <center><h5>DETAILS</h5></center>

                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <form class="form-horizontal" role="form" action="BookValet" method="POST">

                                            <div>
                                                <div class="row">
                                                    <h1><center><strong>$40</strong></center></h1>

                                                    <h4><center><Strong>Date and Time of Pickup</Strong></center></h4>

                                                    <center>
                                                        <h4><%=pickupTime%></h4>
                                                        <h4><strong>Confirmed Car</strong></h4>
                                                        <h4><%=year%> <%=make%> <%=model%> <%=noPlate%></h4>
                                                    </center>
                                                </div>

                                                <div class="row">
                                                    <div>
                                                    </div>
                                                    <!--end tile header-->
                                                    <div class="form-group">
                                                        <label for="input01" class="col-sm-2 control-label" style="color:white">Address</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" style="color:white;" id="input01" name="address" value="<%=address%>" readonly>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="input02" class="col-sm-2 control-label" style="color:white">Postal</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="input02" style="color:white;" name="postal" value="<%=postal%>" readonly>
                                                        </div>
                                                    </div>

                                                    <!--end tile body-->


                                                </div>
                                            </div>
                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <input type="hidden" name="offerId" value="<%=offerId%>"/>
                                                <input type="hidden" name="workshopId" value="<%=workshopId%>"/>
                                                <input type="hidden" name="serviceStartTime" value="<%=serviceStartTime%>"/>
                                                <input type="hidden" name="serviceEndTime" value="<%=serviceEndTime%>"/>
                                                <input type="hidden" name="appointmentTime" value="<%=appointmentTime%>"/>
                                                <input type="hidden" name="wsAddress" value="<%=wsAddress%>"/>
                                                <input type="hidden" name="wsPostal" value="<%=wsPostal%>"/>
                                                <input type="hidden" name="pickupTime" value="<%=pickupTime%>"/>
                                                <input type="hidden" name="price" value="40"/>
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
                <script type="text/javascript" src="js/custom.js"></script>

        <script>
                                        $(function () {



                                        })

        </script>
    </body>
</html>
