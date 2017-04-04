//-------------- window scrolling bottom get item 
$.ajax({
  url: '/Jam/usedItemView',
  type: 'GET',
  dataType: 'json'
}).done(response => {
  console.log(response)
  response.map(usedItem => {
    if (typeof usedItem !== 'number') {
      let $items = getSeconhandElement(usedItem[0].title, usedItem[0].expectedPrice, usedItem[1])
      $items.on('click', function () {
        GoUsedItemDetail(usedItem[0].usedItemId)
      })
      $grid.append($items).isotope('appended', $items)
    } else {
      $(window).on('scroll', function () {
        // test Json Text to set
        if ($(document).height() - $(window).height() - $(document).scrollTop() < 100 && usedItem > 0) {
          $.ajax({
            url: '/Jam/usedItemView',
            type: 'GET',
            dataType: 'json',
            data: { currentPage: usedItem }
          }).done(response => {
            console.log(response);
            response.map(usedItem => {
              if (typeof usedItem !== 'number') {
                let $items = getSeconhandElement(usedItem[0].title, usedItem[0].expectedPrice, usedItem[1])
                $items.on('click', function () {
                  GoUsedItemDetail(usedItem[0].usedItemId)
                })
                $grid.append($items).isotope('appended', $items)
              } else if (typeof usedItem === 'number' && usedItem < 0) {
                $(window).unbind('scroll')
              }
            })
          })
        }
      });
    }
  })
});

//------------ add element-item
$('.append-button').on('click', function () {
  // create new item elements
  for (var n = 1; n <= 12; n++) {
    var $items = getSeconhandElement(n);
    // append elements to container
    $grid.append($items)
      // add and lay out newly appended elements
      .isotope('appended', $items);
  }
});

function getSeconhandElement(title, price, pic) {
  var $item = $(`<div class="thumbnail preview-thumbnail"></div>`);
  $item.append(`<img class="secondhand-thumbnail-image" src="${pic}" alt="Image" />
            <div class="caption view-caption">
                <h4 class="secondhand-title">${title}</h4>
                <h3 class="secondhand-price">NT ${price} 元</h3>
            </div>`);
  return $item;
}

function GoUsedItemDetail(usedItem) {
  window.location.assign(`/Jam/secondhand_detail.html?itemId=${usedItem}`);
}

function onUsedItemLoading(arg) {
  return new Promise((resolve, reject) => {
    console.log(arg);
  })
}

// loading動畫
$(document).ajaxStart(function () {
  $("#loading-ajax").css("display", "block");
});
$(document).ajaxComplete(function () {
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


//商品主旨超過字數排版
$(function () {
  var len = 40; // 超過40個字以"..."取代
  $(".secondhand-title").each(function (i) {
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
  fitRows: {
    columnWidth: 70
  },
  filter: function () {
    return qsRegex ? $(this).text().match(qsRegex) : true;
  }
});

// use value of search field to filter
var $quicksearch = $('.quicksearch').keyup(debounce(function () {
  qsRegex = new RegExp($quicksearch.val(), 'gi');
  $grid.isotope();
}, 200));

// debounce so filtering doesn't happen every millisecond
function debounce(fn, threshold) {
  var timeout;
  return function debounced() {
    if (timeout) {
      clearTimeout(timeout);
    }
    function delayed() {
      fn();
      timeout = null;
    }
    timeout = setTimeout(delayed, threshold || 100);
  };
}

