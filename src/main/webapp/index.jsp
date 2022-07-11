
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>UTJ HR Management System</title>
        <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/bootstrap-toggle.min.css">
        <link rel="stylesheet" href="assets/css/toggle.css">
        <link rel="stylesheet" href="assets/vendor/DataTables/datatables.css">
        <script defer src="assets/fontawesome/js/all.min.js"></script>
        <link rel="stylesheet" href="assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/js/jquery.waypoints.js"></script>
        <script src="assets/js/jquery.counterup.min.js"></script>
        <script src="assets/vendor/calender/lib/jquery-ui.min.js"></script>
        <script src="assets/js/pages/dashboard.js"></script>
        <script type="text/javascript" src="https://unpkg.com/default-passive-events"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font@6.5.95/css/materialdesignicons.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <style>
            /*for yellow bg*/

            .navbar-header {
                background: #222a48;
            }
            #side-menu li a {
                color: #fff;
                border-left: 0px solid #2f323e;
            }
            .top-left-part .dark-logo {
                display: block;

            }
            .tiMenu{
                color: #fff;
            }
            .sidebar {
                background: #27333e;
                ;
                box-shadow: 1px 0px 20px rgba(0, 0, 0, 0.08);
            }
            .hideMenu{
                color: #fff;
            }
            #side-menu ul > li > a.active {
                color: #EDDF10;
                font-weight: 400;
            }
            #side-menu ul > li > a:hover {
                color: #fff;
            }
            /*for yellow bg*/

            .bg-title .breadcrumb {
                background: 0 0;
                margin-bottom: 0;
                float: none;
                padding: 0;
                margin-bottom: 9px;
                font-weight: 700;
                color: #777;
            }

            .select2-container .select2-selection--single .select2-selection__rendered {
                height: auto;
                margin-top: -6px;
                padding-left: 0;
                padding-right: 0;
            }

            .select2-container .select2-selection--single {
                box-sizing: border-box;
                cursor: pointer;
                display: block;
                height: 35px;
            }

            .select2-container--default .select2-selection--single, .select2-selection .select2-selection--single {
                border: 1px solid #d2d6de;
                border-radius: 0;
                padding: 8px 11px;
            }

            .select2-container--default .select2-selection--single .select2-selection__arrow {
                height: 26px;
                position: absolute;
                top: 4px;
                right: 1px;
                width: 20px;
            }

            .breadcrumbColor a {
                color: #41b3f9 !important;
            }

            tr td {
                color: black !important;
            }

            .tr_header {
                background-color: #EDF1F5;
            }

            table.dataTable thead th, table.dataTable thead td {
                padding: 10px 18px;
                border-bottom: 1px solid #e4e7ea;
            }

            .btnColor {
                color: #fff !important;
            }

            .validateRq {
                color: red;
            }

            .panel .panel-heading {
                border-radius: 0;
                font-weight: 500;
                font-size: 16px;
                padding: 10px 25px;
            }

            .btn_style {
                width: 106px;
            }

            .error {
                color: red;
            }


        </style>
    </head>
    <body>
        <style>
            .box {
                position: relative;
                background: #ffffff;
                width: 100%;
            }
            .box-body {
                border-top-left-radius: 0;
                border-top-right-radius: 0;
                border-bottom-right-radius: 3px;
                border-bottom-left-radius: 3px;
                padding: 10px;
            }
            .profile-user-img {
                margin: 0 auto;
                width: 100px;
                padding: 3px;
                border: 3px solid #d2d6de;
            }
            .noticeBord{
                overflow-x: hidden;
                height: 210px;
            }
        </style>
        <%
            String id = (String) session.getAttribute("userid");
            if (id != null) {
        %>
        <div id="app">
            <!-- BEGIN SIDEBAR MENU -->         
            <%@include file="/_includes/sidebar.jsp"%>
            <!-- END SIDEBAR MENU -->
            <div id="main">
                <nav class="navbar navbar-header navbar-expand navbar-light">
                    <a class="sidebar-toggler" href="#"><span
                            class="navbar-toggler-icon"></span></a>
                    <button class="btn navbar-toggler" type="button"
                            data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul
                            class="navbar-nav d-flex align-items-center navbar-light ms-auto">

                            <li class="dropdown"><a href="#" data-bs-toggle="dropdown"
                                                    class="nav-link dropdown-toggle nav-link-lg nav-link-user">
                                    <div class="avatar me-1">
                                        <img src="assets/images/admin.png" alt="" srcset="">
                                    </div>
                                    <div class="d-none d-md-block d-lg-inline-block">
                                        Hi,
                                        <%
                                            if (session.getAttribute("userid") != null) {
                                                out.println(session.getAttribute("fullname").toString());
                                            }
                                        %>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-end">
                                    <a class="dropdown-item" href="update.jsp"><i
                                            data-feather="user"></i> Account</a> <a class="dropdown-item"
                                                                            href="update_password.jsp"><i data-feather="settings"></i>
                                        Settings</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="./Logout"><i
                                            data-feather="log-out"></i> Logout</a>
                                </div></li>
                        </ul>
                    </div>
                </nav>
                <div class="main-content container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <ol class="breadcrumb">
                                <li class="active breadcrumbColor"><a href="#"><i class="fa fa-home"></i> Dashboard</a></li>
                            </ol>
                        </div>
                    </div>

                    <section class="section">
                        <div class="row">

                            <!-- employe attendance  -->
                            <div class="col-md-6 col-sm-12 col-lg-6">
                                <div class="card">
                                    <div class="card-header" style="text-transform: uppercase">July 2022, Attendance </div>
                                    <div class="table-responsive">
                                        <table class="table table-hover manage-u-table">
                                            <thead>
                                                <tr>
                                                    <th class="text-center"> # </th>
                                                    <th> Date </th>
                                                    <th> In time </th>
                                                    <th> Out Time</th>
                                                    <th> Late </th>
                                                    <th> Status </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td colspan="8">No data available</td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <!-- end attendance  -->

                            <div class="col-md-6">
                                <div class="card">
                                    <div class="p-30">
                                        <div class="row">
                                            <div class="col col-sm-4">
                                                <img src="assets/images/profilePic.png" alt="varun" class="img-thumbnail img-fluid">
                                            </div>
                                            <div class="col col-sm-8">
                                                <h2 class="m-b-0">  <%
                                                    if (session.getAttribute("userid") != null) {
                                                        out.println(session.getAttribute("fullname").toString());
                                                    }
                                                    %></h2>
                                                <h4>Executive Assistant</h4><a href="profile.jsp" class="btn btn-rounded btn-success"><i class="ti-user m-r-5"></i> PROFILE </a></div>
                                        </div>
                                        <div class="row text-center m-t-30">
                                            <div class="col-6 b-r">
                                                <h2>0</h2>
                                                <h4>LEAVE CONSUME</h4>
                                            </div>

                                            <div class="col-6">
                                                <h2>0</h2>
                                                <h4>AWARD</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="m-t-10">
                                </div>
                            </div>


                        </div>
                        <div class="row">
                            <div class="col-md-12 col-lg-6 col-sm-12">
                                <div class="white-box">
                                    <h3 class="box-title">notice board</h3>
                                    <hr>
                                    <div class="noticeBord">
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>By ajay tambe..</h5><span class="time">Published Date:  26 May 2022 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: test..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/8" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>testttcs..</h5><span class="time">Published Date:  23 Mar 2022 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: gthnbhtn..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/7" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>Hi..</h5><span class="time">Published Date:  13 Dec 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: 12..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/6" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>General Circular..</h5><span class="time">Published Date:  06 Dec 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: Must Wear Employment Card in the office..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/5" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>test..</h5><span class="time">Published Date:  26 Nov 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: test<br>..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/4" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>tes..</h5><span class="time">Published Date:  28 Jul 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: test..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/3" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>Soluta iure porro ut..</h5><span class="time">Published Date:  26 May 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: zbcb..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/2" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                               <div class="col-md-12 col-lg-6 col-sm-12">
                                <div class="white-box">
                                    <h3 class="box-title">Upcoming Holidays</h3>
                                    <hr>
                                    <div class="noticeBord">
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>By ajay tambe..</h5><span class="time">Published Date:  26 May 2022 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: test..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/8" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>testttcs..</h5><span class="time">Published Date:  23 Mar 2022 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: gthnbhtn..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/7" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>Hi..</h5><span class="time">Published Date:  13 Dec 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: 12..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/6" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>General Circular..</h5><span class="time">Published Date:  06 Dec 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: Must Wear Employment Card in the office..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/5" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>test..</h5><span class="time">Published Date:  26 Nov 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: test<br>..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/4" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>tes..</h5><span class="time">Published Date:  28 Jul 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: test..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/3" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                        <div class="comment-center p-t-10">
                                            <div class="comment-body">
                                                <div class="user-img"> <i style="font-size: 31px" class="icon-folder-alt text-danger"></i></div>
                                                <div class="mail-contnet">
                                                    <h5>Soluta iure porro ut..</h5><span class="time">Published Date:  26 May 2021 </span>
                                                    <br><span class="mail-desc">
                                                        notice.pulished_by: SKT sdfsd<br>
                                                        Description: zbcb..
                                                    </span>
                                                    <a href="http://hrms.braintricker.com/notice/2" class="btn m-r-5 btn-rounded btn-outline btn-danger">Read More</a> </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
 </div>

                    </section>
                </div>
            </div>
        </div>

        <!-- JavaScript files-->
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/vendor/popper.js/umd/popper.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendor/jquery.cookie/jquery.cookie.js"></script>
        <script src="assets/vendor/chart.js/Chart.min.js"></script>
        <script src="assets/vendor/jquery-validation/jquery.validate.min.js"></script>

        <script src="assets/vendor/additional/additional.js"></script>
        <script src="assets/js/feather-icons/feather.min.js"></script>
        <script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
        <script src="assets/js/app.js"></script>
        <script src="assets/vendors/chartjs/Chart.min.js"></script>
        <script src="assets/vendors/apexcharts/apexcharts.min.js"></script>
        <script src="assets/js/pages/dashboard.js"></script>
        <script src="assets/js/main.js"></script>

        <%
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>