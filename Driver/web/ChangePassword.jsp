<%@page import="entity.Driver"%>
<%@include file="Protect.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
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
                <!-- Page content -->
                <div id="content" class="col-md-12">
                    <!-- page header -->
                    <div class="pageheader">

                        <!--<h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i>Get Quotes</h2>-->
                        <div class="margin-top-15 text-center">
                            <h2>My Profile</h2>
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
                                    <div class="tile-header text-center">
                                        <h3>Change Password</h3>
                                    </div>
                                    <!--end tile header-->
                                    <%                                        String currentEmail = driver.getEmail();
                                        String oldPassword = (String) request.getAttribute("oldPassword");
                                        if (oldPassword == null) {
                                            oldPassword = "";
                                        }
                                        String newPassword = (String) request.getAttribute("newPassword");
                                        if (newPassword == null) {
                                            newPassword = "";
                                        }
                                        String confirmPassword = (String) request.getAttribute("confirmPassword");
                                        if (confirmPassword == null) {
                                            confirmPassword = "";
                                        }
                                    %>
                                    <%
                                        String errMsg = (String) request.getAttribute("errMsg");
                                        if (errMsg != null && errMsg.length() > 0) {
                                    %>
                                    <div class="alert alert-danger"><%=errMsg%></div>
                                    <%
                                        }
                                    %>
                                    <!-- /tile body -->
                                    <div class="tile-body">

                                        <form class="form-horizontal" role="form" action="ChangePassword" method="POST">

                                            <div class="form-group">
                                                <label for="input01" class="col-sm-3 control-label">Email</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="input01" name="email" value="<%=currentEmail%>" style="color:white" readonly>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="input02" class="col-sm-3 control-label">Old Password</label>
                                                <div class="col-sm-9">
                                                    <input type="password" class="form-control" id="input02" name="oldPassword" value="<%=oldPassword%>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="input03" class="col-sm-3 control-label">New Password</label>
                                                <div class="col-sm-9">
                                                    <input type="password" class="form-control" id="input03" name="newPassword" value="<%=newPassword%>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="input04" class="col-sm-3 control-label">Confirm New Password</label>
                                                <div class="col-sm-9">
                                                    <input type="password" class="form-control" id="input04" name="confirmPassword" value="<%=confirmPassword%>">
                                                </div>
                                            </div>

                                            <!--form footer for submit-->
                                            <div class="form-group form-footer text-center">
                                                <button type="submit" class="btn btn-primary">Change Password</button>
                                                <button type="reset" class="btn btn-default">Reset</button>
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

        <script src="js/minimal.min.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script>
            $(function () {



            })

        </script>
    </body>
</html>
