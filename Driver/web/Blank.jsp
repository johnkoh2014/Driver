<%@page import="entity.Driver"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Offers</title>
        <jsp:include page="include/head.jsp"/>
    </head>
    <body class="bg-1">

        <!-- Preloader -->
        <div class="mask"><div id="loader"></div></div>
        <!--/Preloader -->

        <!-- Wrap all page content here -->
        <div id="wrap">




            <!-- Make page fluid -->
            <div class="row">





                <!-- Fixed navbar -->
                <%@include file="include/topbar.jsp"%>
                <!-- Fixed navbar end -->






                <!-- Page content -->
                <div id="content" class="col-md-12">









                    <!-- page header -->
                    <div class="pageheader">


                        <h2><i class="fa fa-file-o" style="line-height: 48px;padding-left: 2px;"></i> Blank Page <span>// Place subtitle here...</span></h2>


                        <div class="breadcrumbs">
                            <ol class="breadcrumb">
                                <li>You are here</li>
                                <li><a href="index.html">Minimal</a></li>
                                <li><a href="#">Example Pages</a></li>
                                <li class="active">Blank Page</li>
                            </ol>
                        </div>


                    </div>
                    <!-- /page header -->






                    <!-- content main container -->
                    <div class="main">




                        <!-- row -->
                        <div class="row">

                            <form class="form-horizontal" role="form" action="Test" method="POST">
                                <!-- col 12 -->
                                <div class="col-md-12">
                                    <div style="color:white"><b>Service Date</b></div>
                                    <div class="form-group col-sm-12">
                                        <div class='input-group date' id='date'>
                                            <!--<form id='' action="" role="form">-->
                                            <input type='text' name="dateTime" id="dateInput" class="form-control dt" readonly/>
                                            <!--</form>-->

                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                    <div style="color:white"><b>Available Service Time</b></div>
                                    <div class="form-group col-sm-12">
                                        <div class='input-group date col-xs-12 ' id='time'>
                                            <select class="chosen-select chosen-transparent form-control" name="time"></select>
                                            <!--<form id='' action="" role="form">-->
                                            <!--<input type='text' name="dateTime" class="form-control dt" id="inputTime" readonly/>-->
                                            <!--</form>-->

                                            <!--                                        <span class="input-group-addon">
                                                                                        <span class="glyphicon glyphicon-calendar"></span>
                                                                                    </span>-->
                                        </div>
                                    </div>

                                    <div id="text"></div>





                                </div>
                                <!-- /col 12 -->
                                <input type="submit"/>
                            </form>


                        </div>
                        <!-- /row -->



                    </div>
                    <!-- /content container -->






                </div>
                <!-- Page content end -->




                <div id="mmenu" class="right-panel">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs nav-justified">
                        <li class="active"><a href="#mmenu-users" data-toggle="tab"><i class="fa fa-users"></i></a></li>
                        <li class=""><a href="#mmenu-history" data-toggle="tab"><i class="fa fa-clock-o"></i></a></li>
                        <li class=""><a href="#mmenu-friends" data-toggle="tab"><i class="fa fa-heart"></i></a></li>
                        <li class=""><a href="#mmenu-settings" data-toggle="tab"><i class="fa fa-gear"></i></a></li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div class="tab-pane active" id="mmenu-users">
                            <h5><strong>Online</strong> Users</h5>

                            <ul class="users-list">

                                <li class="online">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/ici-avatar.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Ing. Imrich <strong>Kamarel</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Ulaanbaatar, Mongolia</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="online">
                                    <div class="media">

                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/arnold-avatar.jpg" alt>
                                        </a>
                                        <span class="badge badge-red unread">3</span>

                                        <div class="media-body">
                                            <h6 class="media-heading">Arnold <strong>Karlsberg</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Bratislava, Slovakia</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>

                                    </div>
                                </li>

                                <li class="online">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/peter-avatar.jpg" alt>

                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Peter <strong>Kay</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Kosice, Slovakia</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="online">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/george-avatar.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">George <strong>McCain</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Prague, Czech Republic</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="busy">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar1.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Lucius <strong>Cashmere</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Wien, Austria</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="busy">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar2.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Jesse <strong>Phoenix</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Berlin, Germany</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                            </ul>

                            <h5><strong>Offline</strong> Users</h5>

                            <ul class="users-list">

                                <li class="offline">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar4.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Dell <strong>MacApple</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Paris, France</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="offline">
                                    <div class="media">

                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar5.jpg" alt>
                                        </a>

                                        <div class="media-body">
                                            <h6 class="media-heading">Roger <strong>Flopple</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Rome, Italia</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>

                                    </div>
                                </li>

                                <li class="offline">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar6.jpg" alt>

                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Nico <strong>Vulture</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Kyjev, Ukraine</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="offline">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar7.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Bobby <strong>Socks</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Moscow, Russia</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="offline">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar8.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Anna <strong>Opichia</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Budapest, Hungary</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                            </ul>

                        </div>

                        <div class="tab-pane" id="mmenu-history">
                            <h5><strong>Chat</strong> History</h5>

                            <ul class="history-list">

                                <li class="online">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/ici-avatar.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Ing. Imrich <strong>Kamarel</strong></h6>
                                            <small>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="busy">
                                    <div class="media">

                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/arnold-avatar.jpg" alt>
                                        </a>
                                        <span class="badge badge-red unread">3</span>

                                        <div class="media-body">
                                            <h6 class="media-heading">Arnold <strong>Karlsberg</strong></h6>
                                            <small>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>

                                    </div>
                                </li>

                                <li class="offline">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/peter-avatar.jpg" alt>

                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Peter <strong>Kay</strong></h6>
                                            <small>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit </small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                            </ul>

                        </div>

                        <div class="tab-pane" id="mmenu-friends">
                            <h5><strong>Friends</strong> List</h5>
                            <ul class="favourite-list">

                                <li class="online">
                                    <div class="media">

                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/arnold-avatar.jpg" alt>
                                        </a>
                                        <span class="badge badge-red unread">3</span>

                                        <div class="media-body">
                                            <h6 class="media-heading">Arnold <strong>Karlsberg</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Bratislava, Slovakia</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>

                                    </div>
                                </li>

                                <li class="offline">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar8.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Anna <strong>Opichia</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Budapest, Hungary</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="busy">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/random-avatar1.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Lucius <strong>Cashmere</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Wien, Austria</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                                <li class="online">
                                    <div class="media">
                                        <a class="pull-left profile-photo" href="#">
                                            <img class="media-object" src="assets/images/ici-avatar.jpg" alt>
                                        </a>
                                        <div class="media-body">
                                            <h6 class="media-heading">Ing. Imrich <strong>Kamarel</strong></h6>
                                            <small><i class="fa fa-map-marker"></i> Ulaanbaatar, Mongolia</small>
                                            <span class="badge badge-outline status"></span>
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>

                        <div class="tab-pane pane-settings" id="mmenu-settings">
                            <h5><strong>Chat</strong> Settings</h5>

                            <ul class="settings">

                                <li>
                                    <div class="form-group">
                                        <label class="col-xs-8 control-label">Show Offline Users</label>
                                        <div class="col-xs-4 control-label">
                                            <div class="onoffswitch greensea">
                                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="show-offline" checked="">
                                                <label class="onoffswitch-label" for="show-offline">
                                                    <span class="onoffswitch-inner"></span>
                                                    <span class="onoffswitch-switch"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="form-group">
                                        <label class="col-xs-8 control-label">Show Fullname</label>
                                        <div class="col-xs-4 control-label">
                                            <div class="onoffswitch greensea">
                                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="show-fullname">
                                                <label class="onoffswitch-label" for="show-fullname">
                                                    <span class="onoffswitch-inner"></span>
                                                    <span class="onoffswitch-switch"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="form-group">
                                        <label class="col-xs-8 control-label">History Enable</label>
                                        <div class="col-xs-4 control-label">
                                            <div class="onoffswitch greensea">
                                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="show-history" checked="">
                                                <label class="onoffswitch-label" for="show-history">
                                                    <span class="onoffswitch-inner"></span>
                                                    <span class="onoffswitch-switch"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="form-group">
                                        <label class="col-xs-8 control-label">Show Locations</label>
                                        <div class="col-xs-4 control-label">
                                            <div class="onoffswitch greensea">
                                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="show-location" checked="">
                                                <label class="onoffswitch-label" for="show-location">
                                                    <span class="onoffswitch-inner"></span>
                                                    <span class="onoffswitch-switch"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="form-group">
                                        <label class="col-xs-8 control-label">Notifications</label>
                                        <div class="col-xs-4 control-label">
                                            <div class="onoffswitch greensea">
                                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="show-notifications">
                                                <label class="onoffswitch-label" for="show-notifications">
                                                    <span class="onoffswitch-inner"></span>
                                                    <span class="onoffswitch-switch"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="form-group">
                                        <label class="col-xs-8 control-label">Show Undread Count</label>
                                        <div class="col-xs-4 control-label">
                                            <div class="onoffswitch greensea">
                                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="show-unread" checked="">
                                                <label class="onoffswitch-label" for="show-unread">
                                                    <span class="onoffswitch-inner"></span>
                                                    <span class="onoffswitch-switch"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </li>

                            </ul>

                        </div><!-- tab-pane -->

                    </div><!-- tab-content -->
                </div>






            </div>
            <!-- Make page fluid-->




        </div>
        <!-- Wrap all page content end -->



        <section class="videocontent" id="video"></section>



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
        <script type="text/javascript" src="js/jquery.videobackground.js"></script>
        <script type="text/javascript" src="js/jquery.blockUI.js"></script>
        <script type="text/javascript" src="js/moment.js"></script> 
        <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script> 

        <script src="js/minimal.min.js"></script>

        <script>
            $(function () {




            })

        </script>
        <!--DATETIME-->
        <script type="text/javascript">

            $("#date").datetimepicker({
                format: 'YYYY-MM-DD',
                minDate: new Date(),
                ignoreReadonly: true
            });
//            $("#time").datetimepicker({
//                format: 'LT',
////                focusOnShow, true,
////                minDate: strTime,
//                stepping: 30,
//                ignoreReadonly: true
//            });
//            var date = new Date();
//            var hours = date.getHours();
//            var minutes = date.getMinutes();
//            var ampm = hours >= 12 ? 'PM' : 'AM';
//            hours = hours % 12;
//            hours = hours ? hours : 12; // the hour '0' should be '12'
//            minutes = minutes < 10 ? '0' + minutes : minutes;
//            var strTime = hours + ':' + minutes + ' ' + ampm;
//            console.log(strTime);
//            $("#inputTime").val(strTime);
        </script>
        <script>
            $('#date').on('dp.show dp.update dp.change', function (e) {
//                alert(e.date.format());
                var val = $("#dateInput").val();
                $.ajax({
                    type: 'POST',
                    url: 'http://119.81.43.85/erp/schedule/get_available_timeslots',
                    crossDomain: true,
                    data: {
                        "token": "<%=token%>",
                        "user_id": "<%=id%>",
                        "shop_id": "1",
                        "date": val
                    },
                    dataType: 'json',
                    success: function (data) {
                        var availTime = '<select class="chosen-select chosen-transparent form-control" name="time">';
                        $.each(data.payload.available_timeslots, function () {
                            var time = this.replace(",", "-");
                            availTime += '<option value = "' + time + '">' + time + '</option>'
                        });
                        availTime += '</select>';
                        console.log(availTime);
                        document.getElementById("time").innerHTML = availTime;
                    },
                    error: function (data) {
                        console.log(data);
                    }
                });
            });
        </script>
    </body>
</html>
