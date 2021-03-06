<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Summary</title>
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
                <%                        //String service = request.getParameter("service");
                    //String type = request.getParameter("type");
                    //String vid = request.getParameter("vehicle");
                    String service = (String) session.getAttribute("service");
                    String type = (String) session.getAttribute("type");
                    String vid = (String) session.getAttribute("vid");
                    if (type == null) {
                        type = "";
                    }
                %>
                <div id="content" class="col-md-12">
                    <!-- page header -->
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="Request.jsp">Select Vehicle</a></li>
                            <li><a href="Service.jsp">Service</a></li>
                                <%if (service.equals("Maintenance") || service.equals("Tyre/Wheel Service")) {%>
                            <li><a href="ServiceType.jsp.jsp">Service Type</a></li>
                                <%}%>
                            <li>Summary</li>
                        </ol>
                    </div>
                    <div class="pageheader">
                        <!--<h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i>Get Quotes</h2>-->
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>REQUEST SUMMARY</h1>
                            <h5>Step 4 of 4: Submit Request</h5>
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
                                        <h3><%=service%>
                                            <%if (type.length() > 0) {%>
                                            - <%=type%>
                                            <%
                                                }
                                            %>    
                                        </h3>
                                    </div>
                                    <!--end tile header-->
                                    <div class="line-across"></div>
                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <form class="form-horizontal" role="form" action="SubmitOffer" method="POST">

                                            <div class="form-group">
                                                <label for="input02" class="col-sm-2 control-label">Additional Description</label>
                                                <div class="col-sm-10">
                                                    <textarea class="form-control" id="input02" rows="5" name="description"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="input03" class="col-sm-2 control-label">Mileage</label>
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" id="input03" name="mileage">
                                                </div>
                                            </div>

                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <input type="hidden" name="service"value="<%=service%>">
                                                <input type="hidden" name="type" value="<%=type%>">
                                                <input type="hidden" name="id" value="<%=vid%>">
                                                <button type="submit" class="btn btn-primary">Get Offers</button>

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
        <script src="js/minimal.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            intercom("<%=name%>", "<%=email%>",<%=id%>, "<%=handphone%>");
        </script>
    </body>
</html>
