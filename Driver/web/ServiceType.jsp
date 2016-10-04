<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Offers - Maintenance</title>
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
                <%
                    String service = request.getParameter("service");
                    String vid = request.getParameter("vehicle");
                %>
                <!-- Page content -->
                <div id="content" class="col-md-12">
                    <!-- page header -->
                    <div class="pageheader">

                        <!--<h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i>Get Quotes</h2>-->
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>GET OFFERS</h1>
                            <%if (service.equals("Maintenance")) {%>
                            <h5>What maintenance can we do for you?</h5>
                            <%} else if (service.equals("Tyre / Wheel Service")) {%>
                            <h5>Tyre / Wheel Service</h5>
                            <%}%>

                        </div>
                    </div>
                    <!-- /page header -->
                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>
                                <div class="list-group">
                                    <%if (service.equals("Maintenance")) {%>
                                    <a href="RequestSummary.jsp?service=Maintenance&type=General Maintenance&vehicle=<%=vid%>" class="list-group-item">General Maintenance</a>
                                    <a href="RequestSummary.jsp?service=Maintenance&type=Oil and Filter Service&vehicle=<%=vid%>" class="list-group-item">Oil and Filter Service</a>
                                    <a href="RequestSummary.jsp?service=Maintenance&type=Brake Services&vehicle=<%=vid%>" class="list-group-item">Brake Services</a>
                                    <a href="RequestSummary.jsp?service=Maintenance&type=Fluids and Flushes&vehicle=<%=vid%>" class="list-group-item">Fluids and Flushes</a>
                                    <%} else if (service.equals("Tyre/Wheel Service")) {%>
                                    <a href="RequestSummary.jsp?service=Tyre/Wheel Service&type=Change Tyre&vehicle=<%=vid%>" class="list-group-item">Change Tyre</a>
                                    <a href="RequestSummary.jsp?service=Tyre/Wheel Service&type=Change Rims&vehicle=<%=vid%>" class="list-group-item">Change Rims</a>
                                    <a href="RequestSummary.jsp?service=Tyre/Wheel Service&type=Tyre Rotation&vehicle=<%=vid%>" class="list-group-item">Tyre Rotation</a>
                                    <a href="RequestSummary.jsp?service=Tyre/Wheel Service&type=Tyre Installation&vehicle=<%=vid%>" class="list-group-item">Tyre Installation</a>
                                    <a href="RequestSummary.jsp?service=Tyre/Wheel Service&type=Others&vehicle=<%=vid%>" class="list-group-item">Others</a>
                                    <%}%>
                                </div>
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
