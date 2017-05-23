/*  ------------------
 Remove Preloader
 ------------------  */

$(window).load(function () {
    $('#preloader').delay(350).fadeOut('slow', function () {
        $('.profile-page, .resume-page, .contact-page, .project-page, .donate-page').hide();
    });
});

$(document).ready(function () {

    $('.profile-page, .resume-page, .contact-page, .project-page, .donate-page').hide();
    $('.close-btn').hide();
    'use strict';

    /*  ---------------------
     Homepage Responsive
     ---------------------  */


    function homepageResponsive() {

        // Homepage Main Portions Responsive

        var windowsWidth = $(window).width(),
            windowsHeight = $(window).height();

        if (windowsWidth > windowsHeight) {

            $('.introduction , .menu').css({
                width: '50%',
                height: '100%'
            });

        } else {

            $('.introduction , .menu').css({
                width: '100%',
                height: '50%'
            });

        }

        // Homepage Profile Image Responsive

        var introWidth = $('.introduction').width(),
            introHeight = $('.introduction').height(),
            bgImage = $('.introduction').find('img');

        if (introWidth > introHeight) {

            bgImage.css({
                width: '100%',
                height: 'auto'
            });

        } else {

            bgImage.css({
                width: 'auto',
                height: '100%'
            });

        }

    }

    $(window).on('load resize', homepageResponsive);

    /*  --------------
     Menu Settings
     --------------  */

    // Hide Menu

    $('.menu > div').on('click', function () {

        $('.close-btn').show();

        var introWidth = $('.introduction').width(),
            menuWidth = $('.menu').width();

        $('.introduction').animate({
            left: '-' + introWidth
        }, 1000, 'easeOutQuart');
        $('.menu').animate({
            left: menuWidth
        }, 1000, 'easeOutQuart', function () {
            $('.home-page').css({
                visibility: 'hidden'
            });
        });

    });

    // Show Reletive Page Onclick

    $('.menu div.profile-btn').on('click', function () {
        $('.donate-page').css({
            visibility: 'hidden'
        });
        $('.profile-page').css({
            visibility: 'visible'
        });
        $('.profile-page').fadeIn(1200);
    });

    $('.menu div.resume-btn').on('click', function () {
        $('.resume-page').fadeIn(1200);
    });

    $('.menu div.portfolio-btn').on('click', function () {
        $('.project-page').fadeIn(1200);
    });

    $('.menu div.contact-btn').on('click', function () {
        $('.donate-page').css({
            visibility: 'hidden'
        });
        $('.contact-page').css({
            visibility: 'visible'
        });
        $('.contact-page').fadeIn(1200);
    });

    $('.donate, .fa-cc-paypal').on('click', function () {
        $('.profile-page, .contact-page').css({
            visibility: 'hidden'
        });
        $('.donate-page').css({
            visibility: 'visible'
        });

        $('.donate-page').fadeIn(1200);
    });


    // Close Button, Hide Menu

    $('.close-btn').on('click', function () {

        $('.close-btn').hide();

        $('.home-page').css({
            visibility: 'visible'
        });
        $('.introduction, .menu').animate({
            left: 0
        }, 1000, 'easeOutQuart');
        $('.profile-page, .resume-page, .project-page, .contact-page, .donate-page').fadeOut(800);
    });

    /*  --------------------------------
     Maximize Services Items Height
     --------------------------------  */

    function maximizeHeight() {

        var minHeight = 0;

        $('.services').each(function () {

            var maxHeight = $(this).height();

            if (maxHeight > minHeight) {
                minHeight = maxHeight;
            }

        });

        $('.services').height(minHeight);
    }

    maximizeHeight();

    $(window).on('resize', maximizeHeight);

    /*  ----------------------------------------
     Tooltip Starter for Social Media Icons
     ----------------------------------------  */

    $('.intro-content .social-media [data-toggle="tooltip"]').tooltip({
        placement: 'bottom'
    });

    $('.contact-details .social-media [data-toggle="tooltip"]').tooltip();

    $('.project-tag [data-toggle="tooltip"]').tooltip();


});