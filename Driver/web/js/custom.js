$(function () {
    $(".sidebar-collapse").click(function () {
        if ($(".navbar").hasClass("collapsed")) {
            $("#sidebar").hide();
            if (screen.width < 1240) {
                $("body .navbar.navbar-default .navbar-collapse .nav.logout").show();
            }
        } else {
            $("#sidebar").show();
            $("body .navbar.navbar-default .navbar-collapse .nav.logout").hide();
        }
    });
});