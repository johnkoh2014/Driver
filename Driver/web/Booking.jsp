<%@page import="entity.Offer"%>
<%@page import="dao.OfferDAO"%>
<%@page import="entity.Driver"%>
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
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="ViewAllRequests.jsp">All Requests</a></li>
                            <li><a href="ViewOffers.jsp">Offers</a></li>
                            <li><a href="OfferDetails.jsp">Offer Details</a></li>
                            <li>Booking</li>
                        </ol>
                    </div>
                    <div class="pageheader">
                        <div class="margin-top-15 text-center" style="color:white">
                            <h1>MY BOOKING</h1>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        String o_id = (String) session.getAttribute("oId");
                        int offerId = 0;
                        if (o_id.length() > 0) {
                            offerId = Integer.parseInt(o_id);
                        }
                        OfferDAO oDAO = new OfferDAO();
                        Offer offer = oDAO.retrieveOfferById(id, token, offerId);
                        int wId = offer.getWorkshopId();

                        String error = (String) request.getAttribute("fail");
                        if (error != null && error.length() > 0) {
                    %>
                    <div class="alert alert-danger"><%=error%></div> 
                    <%
                        }
                    %>
                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->

                            <form class="form-horizontal" role="form" action="SelectValet" method="POST">
                                <div class="row">
                                    <div class="col-sm-12">

                                    </div>
                                </div>
                                <section class="tile color transparent-white">
                                    <div class="tile-header">

                                    </div>
                                    <!--end tile header-->

                                    <!-- /tile body -->
                                    <div class="tile-body">
                                        <div style="color:white"><b>Service Date</b></div>
                                        <div class="form-group col-sm-12">
                                            <div class='input-group date' id='date'>
                                                <!--<form id='' action="" role="form">-->
                                                <input type='text' name="date" class="form-control dt" readonly style="color: white"/>
                                                <!--</form>-->

                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
                                        <div style="color:white"><b>Service Time</b></div>
                                        <div class="form-group col-sm-12">
                                            <div class='input-group date' id='time'>
                                                <!--<form id='' action="" role="form">-->
                                                <input type='text' name="time" class="form-control dt" id="inputTime" readonly style="color: white"/>
                                                <!--</form>-->

                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-time"></span>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="margin-top-15"><b>Would you like to have Valet?</b></div>
                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <input type="radio"  id="valetYes" value="true" name="valet" >
                                                <label for="valetYes" class="control-label">YES (Coming Soon)</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="radio" id="valetNo" value="false" name="valet" checked="checked">
                                                <label for="valetNo" class="control-label">NO</label>
                                            </div>
                                            <div class="col-xs-12">
                                                <b>Remarks: </b><textarea class="form-control" id="comment" rows="5" name="comment"></textarea>
                                            </div>
                                        </div>


                                        <!--form footer for submit-->
                                        <div class="form-group form-footer text-center">
                                            <input type="hidden" value="<%=offerId%>" name="offerId">
                                            <input type="hidden" value="<%=wId%>" name="wId">
                                            <input type="hidden" value="<%=id%>" name="userId">
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
//            $(".date").each(function () {
//                $(this).datetimepicker({
//                    format: 'YYYY-MM-DD HH',
//                    minDate: new Date(),
//                    ignoreReadonly: true
//                });
//            });
            $("#date").datetimepicker({
                format: 'YYYY-MM-DD',
                minDate: new Date(),
                ignoreReadonly: true
            });
            $("#time").datetimepicker({
                format: 'LT',
//                focusOnShow, true,
//                minDate: strTime,
                stepping: 30,
                ignoreReadonly: true
            });
            var date = new Date();
            var hours = date.getHours();
            var minutes = date.getMinutes();
            var ampm = hours >= 12 ? 'PM' : 'AM';
            hours = hours % 12;
            hours = hours ? hours : 12; // the hour '0' should be '12'
            minutes = minutes < 10 ? '0' + minutes : minutes;
            var strTime = hours + ':' + minutes + ' ' + ampm;
            $("#inputTime").val(strTime);
        </script>
        <script>
            intercom("<%=name%>", "<%=email%>",<%=id%>, "<%=handphone%>");
        </script>
    </body>
</html>
