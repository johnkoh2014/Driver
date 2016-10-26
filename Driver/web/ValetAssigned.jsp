<%@page import="entity.ValetDriver"%>
<%@page import="entity.ValetRequest"%>
<%@page import="entity.Appointment"%>
<%@page import="dao.AppointmentDAO"%>
<%@page import="entity.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay to Confirm Valet</title>
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
                        <div class="margin-top-15 text-center">
                            <h2>Valet Payment</h2>
                        </div>
                    </div>
                    <!-- /page header -->
                    <%--
                    <%
                        
                        String currentEmail = driver.getEmail();
                        String newEmail = (String) request.getAttribute("newEmail");
                        if (newEmail == null) {
                            newEmail = "";
                        }
                        String hpNo = driver.getHandphone();
                    %>
                    --%>
                    <%
                    int scheduleId = (int) session.getAttribute("scheduleId");
                    AppointmentDAO aDAO = new AppointmentDAO();
                    Appointment appointment = aDAO.getAppointmentById(id, token, scheduleId);
                    ValetDriver vDriver = appointment.getValetDriver();
                    String valetHp = vDriver.getHandphone();
                    String valetName = vDriver.getName();
                    %>

                    <!-- content main container -->
                    <div class="main">
                        <!-- row -->
                        <div class="row">
                            <!-- col 12 -->
                            <div>

                                <section class="tile color transparent-black">
                                    <!-- /tile body -->
                                    <div class="tile-body">
                                        <div class="text-center">           
                                            <h3><b>You have been assigned a Valet!</b></h3>   
                                            <p></p>
                                            Please proceed to make payment.
                                            <p></p>
                                            <a href="ValetBookingPayment.jsp" class="btn btn-primary" role="button">Pay to Confirm</a>
                                        </div>

                                        <div class="tab-content">

                                            <div class="tab-pane fade active in" id="offerDetails" >
                                                <div class="notification">
                                                    <div class="row">
                                                        <strong><center>VALET DETAILS</center></strong>
                                                    </div>
                                                    <div class="row">
                                                        <center><img src="images/joshua.jpg" class="img-thumbnail-small" alt="Valet Profile Pic" width="304" height="236"></center>
                                                    </div>
                                                    <p> </p>
                                                    <div class="row">
                                                        <strong><center>Name</center></strong>
                                                    </div>
                                                    <div class="row">
                                                        <center>
                                                            <%=valetName%>
                                                        </center>
                                                    </div>

                                                    <div class="row">
                                                        <strong><center>Contact</center></strong>
                                                    </div>
                                                    <div class="row">
                                                        <center>
                                                            <%=valetHp%>
                                                        </center>
                                                    </div>

                                                </div>

                                            </div><!--Requests-->



                                            <div class="tab-pane fade " id="workshopProfile" >
                                                <!--                                                <div class="list-group">
                                                                                                    <a href="OfferDetails.jsp?id=" class="list-group-item"><b>AH HUAT WORKSHOP PTE LTD</b><br/><span style="color:blue">$60 - $80</span><br/><i>Click to view profile and quote</i></a>
                                                                                                    <a href="OfferDetails.jsp?id=" class="list-group-item"><b>DYNAMICS MECHANICS</b><br/><span style="color:blue">$70 - $120</span><br/><i>Click to view profile and quote</i></a>
                                                                                                </div>-->

                                                <section class="tile color transparent-black">
                                                    <div class="tile-header text-center">
                                                        <h3>AH HUAT WORKSHOP PTE LTD</h3>
                                                        <a href="Booking.jsp" class="btn btn-warning" role="button">Book</a>
                                                    </div>
                                                    <!--end tile header-->
                                                    <div class="line-across"></div>
                                                    <!-- /tile body -->
                                                    <div class="tile-body">

                                                        <div class="row">
                                                            <strong><center>Opening Hours</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                10am - 7pm (Mon - Sat), By Appt only (Sun). Closed on PHs.
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Address</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                328 Circuit Road S(379489)
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Providing Services</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                Maintenence, Repair and servicing
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Other Brands</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                GlassMechanix
                                                            </center>
                                                        </div>

                                                        <div class="row">
                                                            <strong><center>Website</center></strong>
                                                        </div>
                                                        <div class="row">
                                                            <center>
                                                                www.ahhuatworkshop.com.sg
                                                            </center>
                                                        </div>
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

        <script>
            $(function () {



            })

        </script>
    </body>
</html>
