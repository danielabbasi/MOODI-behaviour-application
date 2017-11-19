/**
 * Created by c1443907 on 17/11/2017.
 */
$(document).ready(function () {
    $("fa-times").click(function () {
        $(".sidebarMenu").addClass("hide_menu");
        $(".toggleMenu").addClass("opacity_one")
        
    });

    $(".toggleMenu").click(function () {
        $(".sidebarMenu").removeClass("hide_menu");
        $(".toggleMenu").removeClass("opacity_one")

    });


    
})