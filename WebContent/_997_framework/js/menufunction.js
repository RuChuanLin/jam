$(document).ready(function(){
    $('ul#menu-funtion li').hover(function(){
        //$('#drop' , this).css('display','block');
         $(this).children('ul').delay(50).slideDown(200);
    }, function(){
         $(this).children('ul').delay(50).slideUp(200);
    });
});