//$(function () {
//    $(".sidebar-collapse").click(function () {
//        if ($(".navbar").hasClass("collapsed")) {
//            $("#sidebar").hide();
//            $(".mobile-brand").show();
//            if (screen.width < 1240) {
//                $("body .navbar.navbar-default .navbar-collapse .nav.logout").show();
//            }
//        } else {
//            $("#sidebar").show();
//            $("body .navbar.navbar-default .navbar-collapse .nav.logout").hide();
//            $(".mobile-brand").hide();
//        }
//    });
//});
$(document).ready(function () {
    $(".sidebar-collapse").click(function () {
        if ($(".navbar").hasClass("collapsed")) {
            $("#sidebar").hide();
            $(".mobile-brand").show();
            if (screen.width < 1240) {
                $("body .navbar.navbar-default .navbar-collapse .nav.logout").show();
            }
        } else {
            $("#sidebar").show();
            $("body .navbar.navbar-default .navbar-collapse .nav.logout").hide();
            $(".mobile-brand").hide();
        }
    });
});