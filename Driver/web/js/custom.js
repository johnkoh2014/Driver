$(function () {
    $(".sidebar-collapse").click(function () {
        if ($(".navbar").hasClass("collapsed")) {
            $("#sidebar").hide();
            $("body .navbar.navbar-default .navbar-collapse .nav.logout").show();
        } else {
            $("#sidebar").show();
            $("body .navbar.navbar-default .navbar-collapse .nav.logout").hide();
        }
    });
});