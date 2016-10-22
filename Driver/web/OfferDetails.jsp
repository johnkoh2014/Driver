<%@page import="entity.Offer"%>
<%@page import="entity.Driver"%>
<%@page import="dao.OfferDAO"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
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
                            <h1>BOOKING</h1>
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
                                                            <li class="w45 active arrange-center"><a href="#offerDetails" data-toggle="pill">OFFER DETAILS</a></li>
                                                            <li class="w45 arrange-center"><a href="#workshopProfile" data-toggle="pill">WORKSHOP PROFILE</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--end tile header-->
                                    <%                                        String offerId = request.getParameter("id");
                                        int oId = 0;
                                        if (offerId.length() > 0) {
                                            oId = Integer.parseInt(offerId);
                                        }
                                        OfferDAO oDAO = new OfferDAO();
                                        Offer offer = oDAO.retrieveOfferById(id, token, oId);
                                        String shopName = offer.getShopName();
                                        double min = offer.getInitialMinPrice();
                                        String minPrice = min + "0";
                                        double max = offer.getInitialMaxPrice();
                                        String maxPrice = max + "0";
                                        double dPrice = offer.getDiagnosticPrice();
                                        String diagnosticPrice = dPrice + "0";
                                        String serviceName = offer.getServiceName();
                                        String openingHour = offer.getOpeningHour();
                                        String shopAddress = offer.getShopAddress();
                                        String shopCategory = offer.getShopCategory();
                                        String brandsCarried = offer.getBrandsCarried();
                                        String website = offer.getWebsite();

                                    %>
                                    <!-- /tile body -->
                                    <div class="tile-body">
                                        <div class="tab-content">
                                            <div class="tab-pane fade active in" id="offerDetails" >
                                                <section class="tile color transparent-black">
                                                    <div class="tile-header text-center">
                                                        <h3><%=shopName%></h3>
                                                    </div>
                                                    <!--end tile header-->
                                                    <div class="line-across"></div>
                                                    <!-- /tile body -->
                                                    <div class="tile-body">
                                                        <div class="text-center">

                                                            <% if (dPrice == 0.0) {%>
                                                            <h3>Quotation Price: $<%=minPrice%> - $<%=maxPrice%></h3>
                                                            <% } else {%>
                                                            <h3>Diagnostic Price: $<%=diagnosticPrice%></h3>
                                                            <% }%>
                                                            
                                                            <br/>
                                                            <h5><%=serviceName%></h5>
                                                        </div>
                                                        <div class="margin-top-15 text-center">
                                                            <a href="Booking.jsp?id=<%=offerId%>" class="btn btn-blue">BOOK AN APPOINTMENT</a>
                                                        </div>

                                                    </div>
                                                    <!--end tile body-->

                                                </section>
                                            </div><!--offerDetails-->



                                            <div class="tab-pane fade " id="workshopProfile" >
                                                <section class="tile color transparent-black">
                                                    <div class="tile-header">
                                                        <div>
                                                            <h3><%=shopName%></h3>
                                                        </div>
                                                        <div>
                                                            <a href="Booking.jsp?id=<%=offerId%>" class="btn btn-blue">BOOK AN APPOINTMENT</a>
                                                        </div>
                                                        <!--end tile header-->
                                                    </div>
                                                    <div class="line-across"></div>
                                                    <!-- /tile body -->
                                                    <div class="tile-body">
                                                        <div>
                                                            <h5><b>OPENING HOURS</b></h5>
                                                            <%=openingHour%>
                                                            <!--10am - 7pm (Mon - Sat), By Appt only (Sun). Closed on PHs.-->
                                                        </div>
                                                        <br/>
                                                        <div>
                                                            <h5><b>ADDRESS</b></h5>
                                                            <%=shopAddress%>
                                                        </div>
                                                        <br/>
                                                        <div>
                                                            <h5><b>PROVIDING SERVICES</b></h5>
                                                            <%=shopCategory%>
                                                        </div>
                                                        <br/>
                                                        <div>
                                                            <h5><b>OTHER BRANDS</b></h5>
                                                            <%=brandsCarried%>
                                                        </div>
                                                        <br/>
                                                        <div>
                                                            <h5><b>WEBSITE</b></h5>
                                                            <a href="<%=website%>" target="_blank"><%=website%></a>
                                                        </div>
                                                        <br/>

                                                    </div>
                                                    <!--end tile body-->

                                                </section>
                                            </div><!--workshopProfile-->



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
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            $(function () {



            })

        </script>
    </body>
</html>
