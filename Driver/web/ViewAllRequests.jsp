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
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li>All Requests</li>
                            <li class="active">Offers</li>
                            <li class="active">Offer Details</li>
                            <li class="active">Booking</li>
                        </ol>
                    </div>
                    <div class="pageheader">
                        <!--<h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i>Get Quotes</h2>-->
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>ALL REQUESTS</h1>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        String success = (String) session.getAttribute("success");

                        if (success != null && !(success.equals("null")) && success.length() > 0) {
                    %>
                    <div class="alert alert-success"><%=success%></div>
                    <%
                            session.setAttribute("success", "");
                        }
                    %>
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
                                    <%
                                        QuotationRequestDAO qDAO = new QuotationRequestDAO();
                                        ArrayList<QuotationRequest> qList = qDAO.getAllRequests(id, token);

                                    %>
                                    <!-- /tile body -->
                                    <div class="tile-body">
                                        <ul class="list-group">
                                            <%                                                if (qList == null || qList.size() == 0) {
                                            %>
                                            <span style="color: white">You have no requests at the moment.</span>
                                            <%
                                            } else {
                                                for (int i = 0; i < qList.size(); i++) {
                                                    QuotationRequest req = qList.get(i);
                                                    String qrName = req.getName();
                                                    int qrId = req.getId();
                                                    int noOffers = req.getNo_of_offers();

                                                    if (noOffers == 0) {%>
                                            <a href="ProcessViewAllRequests?id=<%=qrId%>" class="list-group-item"><b><%=qrName%></b><br/><i>No offer at the moment</i></a>

                                            <%} else {%>
                                            <a href="ProcessViewAllRequests?id=<%=qrId%>" class="list-group-item"><b><%=qrName%></b><br/><i>There are <%=noOffers%> offers for your request</i></a>

                                            <%}
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
        <script type="text/javascript" src="js/intercom.js"></script>
        <script src="js/minimal.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            intercom("<%=name%>", "<%=email%>",<%=id%>, "<%=handphone%>");
        </script>
    </body>
</html>
