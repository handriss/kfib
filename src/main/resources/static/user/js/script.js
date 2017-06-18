/*  ------------------
 Remove Preloader
 ------------------  */

$(window).load(function () {
    $('#preloader').delay(350).fadeOut('slow', function () {
        $('.profile-page, .resume-page, .contact-page, .project-page, .donate-page, .press-page').hide();
    });
});

$(document).ready(function () {

    $('.profile-page, .resume-page, .contact-page, .project-page, .donate-page, .press-page, .close-btn').hide();
    // $('.resume-page, .contact-page, .project-page, .donate-page, .close-btn').hide();
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
        hideMenu();
    });

    // Show Relative Page Onclick

    $('.menu div.profile-btn').on('click', function () {
        showAboutUs();
        history.pushState(
            {page: '/aboutus'},
            'KFIB | Rólunk',
            '/aboutus'
        );
    });

    $('.menu div.resume-btn').on('click', function () {
        showData();
        history.pushState(
            {page: '/data'},
            'KFIB | Adatok',
            '/data'
        );
    });

    $('.menu div.press-btn').on('click', function () {
        showPress();
        history.pushState(
            {page: '/press'},
            'KFIB | Sajtó',
            '/press'
        );
    });

    $('.menu div.press-btn').on('click', function () {

        $('.press-page').fadeIn(1200);
    });

    $('.menu div.portfolio-btn').on('click', function () {
        showProjects();
        history.pushState(
            {page: '/projects'},
            'KFIB | Projektek',
            '/projects'
        );
    });

    $('.menu div.contact-btn').on('click', function () {
        showContact();
        history.pushState(
            {page: '/contact'},
            'KFIB | Kapcsolat',
            '/contact'
        );
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
        showMainPage();
    });

    // console.log(window.location.pathname);


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

    setTimeout(function(){
        switch(window.location.pathname){

            case "/projects":
                showProjects();
                break;

            case "/data":
                showData();
                break;

            case "/press":
                showPress();
                break;

            case "/aboutus":
                showAboutUs();
                break;

            case "/contact":
                showContact();
                break;

            default:
                showMainPage();
        }
    }, 1000);


    window.addEventListener('popstate', function(event){

        switch(event.state.page){

            case "/main":
                showMainPage();
                break;

            case "/projects":
                showProjects();
                break;

            case "/data":
                showData();
                break;

            case "/press":
                showPress();
                break;

            case "/aboutus":
                showAboutUs();
                break;

            case "/contacts":
                showContact();
                break;

        }

        event.preventDefault();
    });
});

function showMainPage(){
    history.pushState(
        {page: '/main'},
        'KFIB | Budapest',
        '/'
    );

    $('.close-btn').hide();

    $('.home-page').css({
        visibility: 'visible'
    });

    $('.introduction, .menu').animate({
        left: 0
    }, 1000, 'easeOutQuart');

    $('.profile-page').css({
        visibility: 'hidden'
    });
    $('.resume-page').css({
        visibility: 'visible'
    });
    $('.project-page').css({
        visibility: 'visible'
    });
    $('.contact-page').css({
        visibility: 'visible'
    });
    $('.donate-page').css({
        visibility: 'visible'
    });
    $('.press-page').css({
        visibility: 'visible'
    });

    $('.profile-page, .resume-page, .project-page, .contact-page, .donate-page, .press-page').fadeOut(800);
}

function showAboutUs(){
    hideMenu();
    $('.donate-page').css({
        visibility: 'hidden'
    });
    $('.profile-page').css({
        visibility: 'visible'
    });
    $('.profile-page').fadeIn(1200);
}

function showData(){
    hideMenu();
    $('.resume-page').fadeIn(1200);
}

function showPress(){
    hideMenu();
    $('.press-page').fadeIn(1200);
}

function showProjects(){
    hideMenu();
    $('.project-page').fadeIn(1200);
}

function showContact(){
    hideMenu();
    $('.donate-page').css({
        visibility: 'hidden'
    });
    $('.contact-page').css({
        visibility: 'visible'
    });
    $('.contact-page').fadeIn(1200);
}

function hideMenu(){
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
}

/*  --------------------------------
 Selector button code on the projects page
 --------------------------------  */

$(function () {
    $('.button-checkbox').each(function () {

        // Settings
        var $widget = $(this),
            $button = $widget.find('button'),
            $checkbox = $widget.find('input:checkbox'),
            color = $button.data('color'),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };

        // Event Handlers
        $button.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });
        $checkbox.on('change', function () {
            updateDisplay();
        });

        // Actions
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $button.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $button.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$button.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $button
                    .removeClass('btn-default')
                    .addClass('btn-' + color + ' active');
            }
            else {
                $button
                    .removeClass('btn-' + color + ' active')
                    .addClass('btn-default');
            }
        }

        // Initialization
        function init() {

            updateDisplay();

            // Inject the icon if applicable
            if ($button.find('.state-icon').length == 0) {
                $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
            }
        }
        init();
    });
});