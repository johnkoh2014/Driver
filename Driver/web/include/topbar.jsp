<%
    Driver driver = (Driver) session.getAttribute("loggedInUser");
    int id = driver.getId();
    String token = driver.getToken();
    String email = driver.getEmail();
    String name = driver.getName();
%>
<div class="navbar navbar-default navbar-fixed-top navbar-transparent-black mm-fixed-top" role="navigation" id="navbar">



    <!-- Branding -->
    <div class="navbar-header col-md-2">
        <a class="navbar-brand" href="Request.jsp"></a>
        <div class="sidebar-collapse">
            <a href="#">
                <i class="fa fa-bars"></i>
            </a>
        </div>
    </div>
    <!-- Branding end -->


    <!-- .nav-collapse -->
    <div class="navbar-collapse">

        <!-- Page refresh -->
<!--        <ul class="nav navbar-nav refresh">
            <li class="divided">
                <a href="#" class="page-refresh"><i class="fa fa-refresh"></i></a>
            </li>
        </ul>-->
        <!-- /Page refresh -->

        <!-- Quick Actions -->
        <ul class="nav navbar-nav quick-actions">

            <li class="dropdown divided user" id="current-user">
                <div class="profile-photo">
                </div>
                <a class="dropdown-toggle options" data-toggle="dropdown" href="#">
                    <%=name%><i class="fa fa-caret-down"></i>
                    <!--<i class="fa fa-caret-down"></i>-->
                </a>

                <ul class="dropdown-menu arrow settings dropdown-menu-right" style="z-index: 9999;">

                    <li>
                        <a href="Profile.jsp"><i class="fa fa-user"></i> Profile</a>
                    </li>

                    <li>
                        <a href="ChangePassword.jsp"><i class="fa fa-key"></i> Change Password</a>
                    </li>

                    <li class="divider"></li>

                    <li>
                        <a href="Logout.jsp"><i class="fa fa-power-off"></i> Logout</a>
                    </li>
                </ul>
            </li>

        </ul>
        <!-- /Quick Actions -->
        
        <!--Mobile Logout-->
        <ul class="nav navbar-nav logout">
            <li class="">
                <!--<a href="#" class="page-refresh"><i class="fa fa-refresh"></i></a>-->
                <a href="Logout.jsp"><i class="fa fa-power-off"></i></a>
            </li>
        </ul>
        <!--/Mobile Logout-->
        
        <%@include file="leftbar.jsp"%>
        <!--End Leftbar-->


    </div>
    <!--/.nav-collapse -->
    
    
    

</div>
