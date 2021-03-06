<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Offers</title>
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
                            <li><a href="Request.jsp">Select Vehicle</a></li>
                            <li>Service</li>
                            <li class="active">Summary</li>
                        </ol>
                    </div>
                    <div class="pageheader">
                        <!--<h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i>Get Quotes</h2>-->
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>GET OFFERS</h1>
                            <h5>Step 2 of 4: Choose a service</h5>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        
                        String success = (String) session.getAttribute("success");

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
                                <%                                    //String vid = request.getParameter("vehicle");
//                                    String vid = (String)session.getAttribute("vid"); 
//                                    session.setAttribute("vid", vid);
%>
                                <div class="list-group">
                                    <a href="ProcessService?service=Maintenance" class="list-group-item">Maintenance</a>
                                    <a href="ProcessService?service=Tyre/Wheel Service" class="list-group-item">Tyre/Wheel Service</a>
                                    <a href="ProcessService?service=Car Grooming" class="list-group-item">Car Grooming</a>
                                    <a href="ProcessService?service=Air Conditioning" class="list-group-item">Air Conditioning</a>
                                    <a href="ProcessService?service=Battery" class="list-group-item">Battery</a>
                                    <a href="ProcessService?service=Others" class="list-group-item">Others</a>
                                    <!--                                   </div>
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
            </div>
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
