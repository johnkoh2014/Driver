<%@page import="entity.Offer"%>
<%@page import="dao.OfferDAO"%>
<%@page import="entity.QuotationRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.QuotationRequestDAO"%>
<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Requests</title>
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

                                    </div>
                                    <!--end tile header-->
                                    <%                                        String qr_Id = (String) session.getAttribute("qrId");
                                        int qrId = 0;
                                        if (qr_Id.length() > 0) {
                                            qrId = Integer.parseInt(qr_Id);
                                        }
                                        QuotationRequestDAO qDAO = new QuotationRequestDAO();
                                        OfferDAO oDAO = new OfferDAO();
                                        ArrayList<Offer> oList = oDAO.getOffers(id, token, qrId);

                                    %>
                                    <!-- /tile body -->
                                    <div class="tile-body">
                                        <ul class="list-group">
                                            <%                                                if (oList == null || oList.size() == 0) {
                                            %>
                                            <span style="color: white">You have no offer for this request at the moment.</span>
                                            <%
                                            } else {
                                                for (int i = 0; i < oList.size(); i++) {
                                                    Offer offer = oList.get(i);
                                                    String shopName = offer.getShopName();
                                                    double min = offer.getInitialMinPrice();
                                                    String minPrice = min + "0";
                                                    double max = offer.getInitialMaxPrice();
                                                    String maxPrice = max + "0";
                                                    int oId = offer.getId();
                                                    double dPrice = offer.getDiagnosticPrice();
                                                    String diagnosticPrice = dPrice + "0";

                                                    if (dPrice == 0.0) {%>
                                            <a href="ProcessViewOffers?id=<%=oId%>" class="list-group-item"><b><%=shopName%></b><br/><span style="color:blue">Quotation Price: $<%=minPrice%> - $<%=maxPrice%></span><br/><i>Click to view profile and quote</i></a>
                                                    <% } else {%>
                                            <a href="ProcessViewOffers?id=<%=oId%>" class="list-group-item"><b><%=shopName%></b><br/><span style="color:blue">Diagnostic Price: $<%=diagnosticPrice%></span><br/><i>Click to view profile and quote</i></a>

                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                        </ul>

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
