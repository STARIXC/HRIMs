<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>



            jQuery(document).ready(function () {
                // initiate layout and plugins

                $("ul li").on("click", function () {
                    $("ul li").removeClass("active");
                    $(this).addClass("active");
                });


            });
        </script>
    </head>
    <body>
        <div id="sidebar" class='active'>
            <div class="sidebar-wrapper active">
                <div class="sidebar-header" >
                    <div class="top-left-part">
                        <!-- Logo -->
                        <a class="logo me-4" href="index.jsp">
                            <!-- Logo icon image, you can use font-icon also --><b>
                                <!--This is dark logo icon-->
                                <img  src="assets/images/logo_.png" alt="home" class="dark-logo img-fluid img-responsive">
                            </b>
                            <!-- Logo text image you can use text also -->
                            <span class="hidden-xs">

                            </span> </a>
                    </div>

                </div>
                <div class="sidebar-menu">
                    <ul class="menu">
                        <li class="sidebar-item"><a href="index.jsp"
                                                    class='sidebar-link'> <i class="fa fa-home text-primary"></i>
                                <span>Dashboard</span>
                            </a></li>
                        <li class="sidebar-item  has-sub"><a href="#"
                                                             class='sidebar-link'> <i class="mdi mdi-key-plus text-primary"></i>
                                <span>Administration</span>
                            </a>
                            <ul class="submenu ">
                                <li><a href="update_password.jsp"><i class="linea-icon linea-basic fa-fw"></i> Change Password</a></li>

                            </ul></li>
                        <li class="sidebar-item "><a href="apply_leave.jsp"
                                                     class='sidebar-link'> <i class="fa fa-plane text-primary"></i>
                                <span>Apply Leave</span>
                            </a></li>
                        <li class="sidebar-item "><a href="leave_status.jsp"
                                                     class='sidebar-link'> <i class="fa fa-plane text-primary"></i>
                                <span>Leave Status</span>
                            </a></li>
                        <li class="sidebar-item  has-sub"><a href="#"
                                                             class='sidebar-link'> <i class="fa fa-table text-primary"></i>
                                <span>Timesheets</span>
                            </a>
                            <ul class="submenu ">
                                <li><a href="timesheet_log.jsp">Timesheet Form</a></li>
                                <li><a href="manage_timesheet.jsp">Timesheet Logs</a></li>
                            </ul></li>
                        <li class="sidebar-item"><a href="./Logout" class='sidebar-link'> <i class="fa fa-lock"></i>
                                <span class="title">Log Out</span>
                            </a></li>

                    </ul>
                </div>
                <button class="sidebar-toggler btn x">
                    <i data-feather="x"></i>
                </button>
            </div>
        </div> 
    </body>
</html>
