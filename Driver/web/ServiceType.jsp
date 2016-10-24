<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Offers - Maintenance</title>
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
                <%                    String service = (String) session.getAttribute("service");
                    String vid = (String) session.getAttribute("vid");
                %>
                <!-- Page content -->
                <div id="content" class="col-md-12">
                    <!-- page header -->
                    <div class="pageheader">
                        <div class="breadcrumbs">
                            <ol class="breadcrumb">
                                <li><a href="Request.jsp">Select Vehicle</a></li>
                                <li><a href="Service.jsp">Service</a></li>
                                <li>Service Type</li>
                                <li class="active">Request Summary</li>
                            </ol>
                        </div>
                        <!--<h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i>Get Quotes</h2>-->
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>GET OFFERS</h1>
                            <%if (service.equals("Maintenance")) {%>
                            <h5>What maintenance can we do for you?</h5>
                            <%} else if (service.equals("Tyre/Wheel Service")) {%>
                            <h5>Tyre/Wheel Service</h5>
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
                                    <a href="ProcessServiceType?type=General Maintenance" class="list-group-item">General Maintenance</a>
                                    <a href="ProcessServiceType?type=Oil and Filter Service" class="list-group-item">Oil and Filter Service</a>
                                    <a href="ProcessServiceType?type=Brake Services" class="list-group-item">Brake Services</a>
                                    <a href="ProcessServiceType?type=Fluids and Flushes" class="list-group-item">Fluids and Flushes</a>
                                    <%} else if (service.equals("Tyre/Wheel Service")) {%>
                                    <a href="ProcessServiceType?type=Change Tyre" class="list-group-item">Change Tyre</a>
                                    <a href="ProcessServiceType?type=Change Rims" class="list-group-item">Change Rims</a>
                                    <a href="ProcessServiceType?type=Tyre Rotation" class="list-group-item">Tyre Rotation</a>
                                    <a href="ProcessServiceType?type=Tyre Installation" class="list-group-item">Tyre Installation</a>
                                    <a href="ProcessServiceType?type=Others" class="list-group-item">Others</a>
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
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            $(function () {



            })

        </script>
    </body>
</html>
