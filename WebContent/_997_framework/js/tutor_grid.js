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
  $item.append('<img class="tutor-thumbnail-image" src="_996_image/user.png" alt="Image" /><div class="caption view-caption"><h4 class="tutor-place">台北/板橋</h4><h4 class="tutor-instrument">民謠吉他</h4><h3 class="tutor-name">江吉米</h3></div>');
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