//-------------- window scrolling bottom get item 
$(window).scroll(function () {
  // 當卷軸滾到下面時:
  if ($(document).height() - $(window).height() - $(document).scrollTop() < 250) {
    //以下為假資料請自行改寫
    for (var n = 1; n <= 12; n++) {
      var $items = createTutorElement(n);
      // append elements to container
      $grid.append($items)
        // isotope的新增方法
        .isotope('appended', $items);
    }
  }
});
//假資料生成方法

function createTutorElement(n) {
  var $item = $('<div class="thumbnail preview-thumbnail"></div>');
  $item.append('<img class="tutor-thumbnail-image" src="images/test/b01.jpg" alt="Image" /><div class="caption view-caption"><h4 class="thumbnail-title">台北練功團</h4><h4 class="band-place">士林/信義</h4><h4 class="band-style">indie Rock/後搖</h4><h4 class="band-instrument"><span class="band-wanted">徵 </span>電貝斯、主唱</h4></div>');
  return $item;
}
// loading動畫
 $(document).ajaxStart(function(){
        $("#loading-ajax").css("display", "block");
    });
    $(document).ajaxComplete(function(){
        $("#loading-ajax").css("display", "none");
    });
//back-to-top
if ($('#back-to-top').length) {
    var scrollTrigger = 100, // px
        backToTop = function () {
            var scrollTop = $(window).scrollTop();
            if (scrollTop > scrollTrigger) {
                $('#back-to-top').addClass('is-visible');
            } else {
                $('#back-to-top').removeClass('is-visible');
            }
        };
    backToTop();
    $(window).on('scroll', function () {
        backToTop();
    });
    $('#back-to-top').on('click', function (e) {
        e.preventDefault();
        $('html,body').animate({
            scrollTop: 0
        }, 700);
    });
}
//糾團主旨超過字數排版
$(function () {
  var len = 40; // 超過40個字以"..."取代
  $(".thumbnail-title").each(function (i) {
    if ($(this).text().length > len) {
      $(this).attr("title", $(this).text());
      var text = $(this).text().substring(0, len - 1) + "...";
      $(this).text(text);
    }
  });
});


//-------以下為前端搜尋版本  可以更改為後端搜尋版本----- 
// quick search regex
var qsRegex;

// init Isotope
var $grid = $('.grid').isotope({
  itemSelector: '.preview-thumbnail',
  layoutMode: 'fitRows',
  fitRows:{
    columnWidth:70
  },
  filter: function() {
    return qsRegex ? $(this).text().match( qsRegex ) : true;
  }
});

// use value of search field to filter
var $quicksearch = $('.quicksearch').keyup( debounce( function() {
  qsRegex = new RegExp( $quicksearch.val(), 'gi' );
  $grid.isotope();
}, 200) );

// debounce so filtering doesn't happen every millisecond
function debounce( fn, threshold ) {
  var timeout;
  return function debounced() {
    if ( timeout ) {
      clearTimeout( timeout );
    }
    function delayed() {
      fn();
      timeout = null;
    }
    timeout = setTimeout( delayed, threshold || 100 );
  };
}