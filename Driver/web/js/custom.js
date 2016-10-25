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
        if ($("body").hasClass("mobile-device")) {
            $("#content").show();
            if ($(".navbar").hasClass("collapsed")) {
                if (screen.width <= 1024) {
                    $("#content").css("padding-left", "55px");
                }
                if (screen.width <= 667) {
                    $(".mobile-brand").show();
                    $("#sidebar").hide();
                    $("body .navbar.navbar-default .navbar-collapse .nav.logout").show();
                }
            } else {
                if (screen.width <= 1024) {
                    $("#content").show();
                    $("#content").css("padding-left", "265px");
                }
                if (screen.width <= 667) {
                    $("#content").hide();
                    $(".mobile-brand").hide();
                    $("#sidebar").show();
                    $("body .navbar.navbar-default .navbar-collapse .nav.logout").hide();
                }
            }
        }
    });
});
//$(window).onload(function(){
//    $("#navbar").addClass("collapsed");
//});
$(function () {
    if (screen.width <= 1024 && screen.width > 717) {
        setTimeout(function () {
//            $('#navbar').addClass('collapsed');
//            $(".navbar .navbar-header").css("width","250px");
        }, 1500);
    }
});
