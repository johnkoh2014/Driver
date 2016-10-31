<%@page import="entity.ValetRequest"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Appointment"%>
<%@page import="dao.AppointmentDAO"%>
<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Appointments</title>
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
                            <h1>MY BOOKINGS</h1>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%                        AppointmentDAO aDAO = new AppointmentDAO();
                        ArrayList<Appointment> aList = aDAO.getAppointments(id, token);
                        String success = (String) session.getAttribute("success");
                        if (success != null && success.length() > 0) {
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
                                        <center><h5>BOOKING & VALET DETAILS</h5></center>
                                    </div>
                                    <!--end tile header-->
                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <div class="list-group">

                                            <%
                                                if (aList == null || aList.size() == 0) {
                                            %>
                                            <span style="color: white">You have no bookings at the moment.</span>

                                            <%
                                            } else {
                                                for (Appointment appointment : aList) {
                                                    String start = appointment.getAppointmentStart() + "";
                                                    String startDate = start.substring(0, start.indexOf(" "));
                                                    String sTime = start.substring(start.indexOf(" "));
                                                    String startTime = sTime.substring(0, sTime.lastIndexOf("."));
                                                    String shopName = appointment.getShopName();
                                                    int offerStatus = appointment.getOfferStatus();
                                                    int scheduleId = appointment.getId();

                                                    ValetRequest vr = appointment.getToValet();
                                                    String pickup = "";
                                                    String pickupDate = "";
                                                    String pickupTime = "";
                                                    String url = "#";
                                                    int valetRequestStatus = 0;
                                                    if (vr != null) {
                                                        pickup = vr.getScheduledPickUpTime() + "";
                                                        pickupDate = pickup.substring(0, pickup.indexOf(" "));
                                                        String pTime = pickup.substring(pickup.indexOf(" "));
                                                        pickupTime = pTime.substring(0, pTime.lastIndexOf("."));
                                                        valetRequestStatus = vr.getStatus();
                                                        url = "ProcessAppointments?valetRequestStatus=" + valetRequestStatus + "&offerStatus=" + offerStatus + "&scheduleId=" + scheduleId;
                                                    }

                                                    ValetRequest returnVr = appointment.getReturnValet();
                                                    String returnPickup = "";
                                                    String returnPickupDate = "";
                                                    String returnPickupTime = "";
                                                    if (returnVr != null) {
                                                        returnPickup = returnVr.getScheduledPickUpTime() + "";
                                                        returnPickupDate = returnPickup.substring(0, returnPickup.indexOf(" "));
                                                        String pTime = returnPickup.substring(returnPickup.indexOf(" "));
                                                        returnPickupTime = pTime.substring(0, pTime.lastIndexOf("."));
                                                    }
//                                                    if (valetRequestStatus == 1) {
//                                                        url = "WaitingForValet.jsp";
//                                                    } else if (valetRequestStatus == 2 || valetRequestStatus == 3 || valetRequestStatus == 4 || valetRequestStatus == 5) {
//                                                        url = "ViewValetStatus.jsp";
//                                                    } else if (valetRequestStatus == 6) {
//                                                        if (offerStatus == 3 || offerStatus == 4) {
//                                                            url = "WorkshopDiagnosis.jsp";
//                                                        } else if (offerStatus == 5 || offerStatus == 6) {
//                                                            url = "WorkshopStartServicing.jsp";
//                                                        } else if (offerStatus == 7) {
//                                                            url = "WorkshopCompleteServicing.jsp";
//                                                        }
//                                                    }


                                            %>

                                            <a href="<%=url%>" class="list-group-item"><p><b><%=shopName%></b></p>
                                                Service Date: <%=startDate%><br/>
                                                Service Time: <%=startTime%><br/>
                                                <p></p>
                                                <%if (vr != null) {%>
                                                <p><b>VALET</b></p>
                                                Pickup Date: <%=pickupDate%><br/> 
                                                Pickup Time:<%=pickupTime%><br/> 
                                                <%}%>
                                                <p></p>
                                                <%if (returnVr != null) {%>
                                                <p><b>RETURN VALET</b></p>
                                                Pickup Date: <%=returnPickupDate%><br/> 
                                                Pickup Time:<%=returnPickupTime%><br/> 
                                                <%}%>
                                            </a>
                                            <%
                                                    }
                                                }
                                            %>
                                            <!--<a href="#" class="list-group-item"><b>KGC WORKSHOP PTE LTD</b>
                                                <p>Tuesday, 13 July 2016</p>
                                                <p>4:00pm</p>
                                                <i>Click to view more info</i>
                                            </a>-->
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
        <script type="text/javascript" src="js/intercom.js"></script>
        <script src="js/minimal.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            intercom("<%=name%>", "<%=email%>",<%=id%>, "<%=handphone%>");
        </script>
    </body>
</html>
