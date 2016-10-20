

/*=============================================================
    Authour URI: www.binarytheme.com
    License: Commons Attribution 3.0

    http://creativecommons.org/licenses/by/3.0/

    100% To use For Personal And Commercial Use.
    IN EXCHANGE JUST GIVE US CREDITS AND TELL YOUR FRIENDS ABOUT US
   
    ========================================================  */


(function ($) {
    "use strict";
    var mainApp = {

        main_fun: function () {
            /*====================================
             CUSTOM LINKS SCROLLING FUNCTION 
            ======================================*/

            $('a[href*=#]').click(function () {
                if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '')
               && location.hostname == this.hostname) {
                    var $target = $(this.hash);
                    $target = $target.length && $target
                    || $('[name=' + this.hash.slice(1) + ']');
                    if ($target.length) {
                        var targetOffset = $target.offset().top;
                        $('html,body')
                        .animate({ scrollTop: targetOffset }, 800); //set scroll speed here
                        return false;
                    }
                }
            });
          
       


            /*====================================
               WRITE YOUR SCRIPTS BELOW 
           ======================================*/
            

        },
        
        main_loadLeaderboard: function () {
            $.ajax({
                url: "fetchtopusersservlet",
                type: 'GET',
                dataType: 'json',
         
                success: function (dataJson) {
                	$.each(dataJson.users, function (key, user) {
                		var list = document.getElementById('usersList');
                		var entry = document.createElement('li');
                		entry.appendChild(document.createTextNode(user.email + "-" + user.points + "pts"));
                		list.appendChild(entry);
                    });
                },
            });
        }, 

        initialization: function () {
            mainApp.main_fun();

        }

    }
    // Initializing ///

    $(document).ready(function () {
        mainApp.main_fun();
        mainApp.main_loadLeaderboard();
    });

}(jQuery));



