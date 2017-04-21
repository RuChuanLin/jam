//-------------- window scrolling bottom get item 
$(window).scroll(function () {
  // 當卷軸滾到下面時:

  if ($(document).height() - $(window).height() - $(document).scrollTop() < 250) {
    let category_query = $.getParameterByName('category');
    let location_query = $.getParameterByName('loca');
    Band_Array.map(band => {
      let {
        img,
        title,
        place,
        style,
        instrument,
        category,
        location
      } = band;
      if (!location_query || (category === category_query && location === location_query)) {
        var $item = $(`<div class="thumbnail preview-thumbnail"></div>`);
        $item.append(`<img class="tutor-thumbnail-image" src="images/bandfake/${img}.jpg" alt="Image" />
            <div class="caption view-caption">
                <h4 class="thumbnail-title">${title}</h4>
                <h4 class="band-place">${place}</h4>
                <h4 class="band-style">${style}</h4>
                <h4 class="band-instrument"><span class="band-wanted">徵 </span>${instrument}</h4>
             </div>`);

        $grid.append($item).isotope('appended', $item);
      }
      //  $grid.append(getBandInfo(band)).isotope('appended',getBandInfo(band))
    });

  }
});
const Band_Array = [{
  img: '13',
  title: '新北徵求吉他',
  place: '土城區',
  style: '搖滾 流行',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '14',
  title: '新竹千跪萬求',
  place: '新竹市',
  style: 'jazz/電子',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'

},
{
  img: '15',
  title: '台北瞪鞋噪音',
  place: '台北士林',
  style: '不限',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '16',
  title: '台北彩虹copy團,徵人',
  place: '台北 木柵',
  style: '日系搖滾',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '17',
  title: '宜蘭誠徵CVOER彈唱~街頭玩耍!',
  place: '宜蘭',
  style: '樂風不限',
  instrument: '木吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '18',
  title: '台北流行搖滾創作團',
  place: '台北內湖區',
  style: '流行搖滾',
  instrument: '主奏電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '19',
  title: '貓打樹 徵人',
  place: '台北',
  style: 'jazz',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '20',
  title: '三生有幸誠徵節奏吉他',
  place: '台北',
  style: 'matal',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '21',
  title: '奇克拿樂團 徵人',
  place: '台北',
  style: '搖滾',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '22',
  title: '虎克幫樂團',
  place: '桃園地區',
  style: '搖滾',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '23',
  title: '台北旋律死亡金屬',
  place: '台北',
  style: '旋律死亡金屬',
  instrument: '電吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '24',
  title: '宜蘭號街頭演出',
  place: '宜蘭',
  style: '輕音樂',
  instrument: '木吉他',
  category: 'guitar',
  location: 'north'
},
{
  img: '25',
  title: '踢公北啊~請賜我貝斯手吧~~',
  place: '台中',
  style: '瞪鞋',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '26',
  title: '虎克幫樂團',
  place: '台中',
  style: '美式搖滾',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '27',
  title: '宅錄創作徵合作電貝斯',
  place: '南投',
  style: '日系',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '28',
  title: '貓打樹 徵人',
  place: '台中',
  style: 'jazz',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '29',
  title: '奇克拿樂團 徵人',
  place: '台中',
  style: '瞪鞋',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '30',
  title: '濛濛搭樂團 找貝斯',
  place: '彰化',
  style: '鄉村',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '31',
  title: '彰化普渡團 找貝斯',
  place: '台中',
  style: '民俗風金屬',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '32',
  title: '給點機會 台中作場團',
  place: '台中',
  style: '流行 搖滾',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '34',
  title: '東海學生新手團就缺你了',
  place: '台中',
  style: '樂風不限',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '35',
  title: '台中最ㄎ一ㄤ雷鬼',
  place: '台中',
  style: '雷鬼',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '36',
  title: '教練我想找貝斯',
  place: '台中',
  style: 'Funk',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '37',
  title: '春哥的夢想',
  place: '台中',
  style: 'Ska',
  instrument: '電貝斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '1',
  title: '台北創作團 造夢人 誠徵鼓手',
  place: '高雄',
  style: 'Rock/Pop',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '2',
  title: '怕胖團缺你一個胖子唷',
  place: '台南',
  style: 'Punk',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '3',
  title: '熱血創作團缺雙踏鼓手',
  place: '高雄',
  style: '速度金屬',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '4',
  title: '高應大學生團',
  place: '高雄',
  style: '搖滾 流行',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '5',
  title: '高雄急徵鼓手演出',
  place: '高雄',
  style: '搖滾 流行',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '6',
  title: '想太多樂團',
  place: '高雄',
  style: 'jazz',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '7',
  title: '我好餓樂團徵Cajon',
  place: '高雄',
  style: '不插電',
  instrument: '木箱鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '8',
  title: '屏東鼓手給徵一起Jam',
  place: '屏東',
  style: '搖滾 流行',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '9',
  title: '台南最瞎趴',
  place: '台南',
  style: '台式搖滾',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '10',
  title: '沒有未來 缺打擊',
  place: '高雄',
  style: 'jazz',
  instrument: '手鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '11',
  title: '來來來都來',
  place: '高雄',
  style: '英式搖滾 / 迷幻',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '12',
  title: '林老師的鞭子 找鼓手',
  place: '高雄',
  style: '鞭擊金屬',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  location: 'south'
},
]


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
//糾團主旨超過字數排版
$(function () {
  var len = 15; // 超過40個字以"..."取代
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
// let category = $.getParameterByName('category') ? $.getParameterByName('category') : undefined;
// if(category){
//   Band_Array.map(band=>{

//   })
// }
let category_query = $.getParameterByName('category');
let location_query = $.getParameterByName('loca');
Band_Array.map(band => {
  let {
    img,
    title,
    place,
    style,
    instrument,
    category,
    location
  } = band;
  if (!location_query || (category === category_query && location === location_query)) {
    var $item = $(`<div class="thumbnail preview-thumbnail" data-img="${img}" data-title="${title}" data-place="${place}" data-style="${style}" data-instrument="${instrument}"></div>`);
    $item.append(`<img class="tutor-thumbnail-image" src="images/bandfake/${img}.jpg" alt="Image" />
            <div class="caption view-caption">
                <h4 class="thumbnail-title">${title}</h4>
                <h4 class="band-place">${place}</h4>
                <h4 class="band-style">${style}</h4>
                <h4 class="band-instrument"><span class="band-wanted">徵 </span>${instrument}</h4>
             </div>`);

    $grid.append($item).isotope('appended', $item);
  }



  //  $grid.append(getBandInfo(band)).isotope('appended',getBandInfo(band))
});

$('.thumbnail.preview-thumbnail').on('click', function () {
  sessionStorage.setItem('band-Info', JSON.stringify($(this).data()));
  window.location.assign('/Jam/band_detail.html');
})
