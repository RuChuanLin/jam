//-------------- window scrolling bottom get item 
$(window).scroll(function () {
  // 當卷軸滾到下面時:

  if ($(document).height() - $(window).height() - $(document).scrollTop() < 250) {
    let category_query = $.getParameterByName('category');
    let location_query = $.getParameterByName('loca');
    Totur_Array.map(tutor => {
      let {
        img,
        place,
        instrument,
        name,
        category,
        location
      } = tutor;
      if (!location_query || (category === category_query && location === location_query)) {
        var $item = $(`<div class="thumbnail preview-thumbnail"></div>`);
        $item.append(`<img class="tutor-thumbnail-image" src="_996_image/tutorfake/${category}/${img}.jpg" alt="Image" />
            <div class="caption view-caption">
                <h4 class="tutor-place">${place}</h4>
                <h4 class="tutor-instrument">${instrument}</h4>
                <h4 class="tutor-name">${name}</h4>
             </div>`);

        $grid.append($item).isotope('appended', $item);
      }
      //  $grid.append(getBandInfo(tutor)).isotope('appended',getBandInfo(tutor))
    });

  }
});
const Totur_Array = [{
  img: '1',
  place: '永和',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '游老師',
  location: 'north'
},
{
  img: '2',
  place: '淡水/北投',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: 'Jimmy',
  location: 'north'
},
{
  img: '3',
  place: '桃園',
  instrument: '電吉他/民謠吉他',
  name: '春哥',
  category: 'guitar',
  location: 'north'
},
{
  img: '4',
  place: '台北',
  instrument: '電吉他/民謠吉他',
  name: 'Steve Vai',
  category: 'guitar',
  location: 'north'
},
{
  img: '5',
  place: '土城區',
  instrument: '電吉他/民謠吉他',
  name: '陳信安',
  category: 'guitar',
  location: 'north'
},
{
  img: '6',
  place: '汐止',
  instrument: '電吉他/民謠吉他',
  name: 'Micheal',
  category: 'guitar',
  location: 'north'
},
{
  img: '7',
  place: '台北市/新北市',
  instrument: '電吉他/民謠吉他',
  name: 'Mike',
  category: 'guitar',
  location: 'north'
},
{
  img: '8',
  place: '台北市/新北市',
  instrument: '電吉他/民謠吉他',
  name: 'Stanley Liao',
  category: 'guitar',
  location: 'north'
},
{
  img: '9',
  place: '中和/永和',
  instrument: '電吉他/民謠吉他',
  name: 'Ken Hsia',
  category: 'guitar',
  location: 'north'
},
{
  img: '10',
  place: '土城區',
  instrument: '電吉他/民謠吉他',
  name: 'Steve Vai',
  category: 'guitar',
  location: 'north'
},
{
  img: '11',
  place: '中和/永和',
  instrument: '電吉他/民謠吉他',
  name: '夏老師',
  category: 'guitar',
  location: 'north'
},
{
  img: '12',
  place: '台北市/新北市',
  instrument: '電吉他/民謠吉他',
  name: '小馬老師',
  category: 'guitar',
  location: 'north'
},
{
  img: '13',
  place: '土城/新莊',
  instrument: '電吉他/民謠吉他',
  name: '大明老師',
  category: 'guitar',
  location: 'north'
},
{
  img: '14',
  place: '木柵/景美',
  instrument: '屋客麗麗/民謠吉他',
  name: '小鴻老師',
  category: 'guitar',
  location: 'north'
},
{
  img: '15',
  place: '台北市區',
  instrument: '電吉他/民謠吉他',
  name: '大寶',
  category: 'guitar',
  location: 'north'
},
{
  img: '16',
  place: '台北市/新北市',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '陳信豪',
  location: 'north'
},
{
  img: '17',
  place: '台北',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '信哥',
  location: 'north'
},
{
  img: '18',
  place: '士林/北投',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '小北',
  location: 'north'
},
{
  img: '19',
  place: '宜蘭',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: 'Stanphenie',
  location: 'north'
},
{
  img: '20',
  place: '淡水/北投',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '陳老師',
  location: 'north'
},
{
  img: '21',
  place: '汐止',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '游老師',
  location: 'north'
},
{
  img: '22',
  place: '新竹',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '石頭',
  location: 'north'
},
{
  img: '23',
  place: '桃園',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: '怪獸',
  location: 'north'
},
{
  img: '24',
  place: '板橋/永和',
  instrument: '電吉他/民謠吉他',
  category: 'guitar',
  name: 'Bill',
  location: 'north'
},
{
  img: '1',
  place: '台中',
  instrument: '電bass',
  category: 'bass',
  name: 'Bill',
  location: 'mid'
},
{
  img: '2',
  place: '彰化',
  instrument: '電bass',
  category: 'bass',
  name: '游老師',
  location: 'mid'
},
{
  img: '3',
  place: '南投',
  instrument: '電bass',
  name: '馬可斯',
  category: 'bass',
  location: 'mid'
},
{
  img: '4',
  place: '台中',
  instrument: '電Bass/Double Bass',
  name: '小陳',
  category: 'bass',
  location: 'mid'
},
{
  img: '5',
  place: '台中',
  instrument: '電bass',
  name: '阿田老師',
  category: 'bass',
  location: 'mid'
},
{
  img: '6',
  place: '台中',
  instrument: '電bass',
  name: 'SonYa',
  category: 'bass',
  location: 'mid'
},
{
  img: '7',
  place: '彰化',
  instrument: '電bass',
  name: 'Kai',
  category: 'bass',
  location: 'mid'
},
{
  img: '8',
  place: '台中',
  instrument: '電bass',
  name: 'Lee',
  category: 'bass',
  location: 'mid'
},
{
  img: '9',
  place: '南投',
  instrument: '電bass',
  name: 'Ken',
  category: 'bass',
  location: 'mid'
},
{
  img: '10',
  place: '彰化',
  instrument: '電bass',
  name: '游老師',
  category: 'bass',
  location: 'mid'
},
{
  img: '11',
  place: '台中',
  instrument: '電bass',
  name: '比利',
  category: 'bass',
  location: 'mid'
},
{
  img: '12',
  place: '台中',
  instrument: '電bass',
  name: 'Marcus',
  category: 'bass',
  location: 'mid'
},
{
  img: '13',
  place: '台中',
  instrument: '電bass',
  name: '黃老師',
  category: 'bass',
  location: 'mid'
},
{
  img: '14',
  place: '南投',
  instrument: '電bass',
  name: '小鴻老師',
  category: 'bass',
  location: 'mid'
},
{
  img: '15',
  place: '彰化',
  instrument: '電bass',
  name: 'Miller',
  category: 'bass',
  location: 'mid'
},
{
  img: '16',
  place: '苗栗/三義',
  instrument: '電bass',
  category: 'bass',
  name: '黃老師',
  location: 'mid'
},
{
  img: '17',
  place: '台中',
  instrument: '電bass',
  category: 'bass',
  name: '游老師',
  location: 'mid'
},
{
  img: '18',
  place: '彰化',
  instrument: '電bass',
  category: 'bass',
  name: '黃老師',
  location: 'mid'
},
{
  img: '19',
  place: '台中',
  instrument: '電bass',
  category: 'bass',
  name: '游老師',
  location: 'mid'
},
{
  img: '20',
  place: '台中/豐原',
  instrument: '電bass',
  category: 'bass',
  name: '黃老師',
  location: 'mid'
},
{
  img: '21',
  place: '彰化',
  instrument: '電bass',
  category: 'bass',
  name: '夏老師',
  location: 'mid'
},
{
  img: '22',
  place: '台中/后里',
  instrument: '電bass',
  category: 'bass',
  name: '游老師',
  location: 'mid'
},
{
  img: '23',
  place: '台中',
  instrument: '電bass',
  category: 'bass',
  name: '劉老師',
  location: 'mid'
},
{
  img: '24',
  place: '彰化',
  instrument: '電bass',
  category: 'bass',
  name: '劉老師',
  location: 'mid'
},
{
  img: '1',
  place: '高雄/鳳山',
  instrument: '爵士鼓/木箱鼓',
  category: 'drumsNpercussion',
  name: '格非老師',
  location: 'south'
},
{
  img: '2',
  place: '屏東',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: '游老師',
  location: 'south'
},
{
  img: '3',
  place: '台南',
  instrument: '爵士鼓',
  name: '劉老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '4',
  place: '高雄',
  instrument: '爵士鼓',
  name: '如川老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '5',
  place: '台南',
  instrument: '爵士鼓',
  name: '海睿老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '6',
  place: '高雄',
  instrument: '爵士鼓',
  name: '展輝老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '7',
  place: '台南',
  instrument: '爵士鼓',
  name: '資閩老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '8',
  place: '高雄',
  instrument: '爵士鼓',
  name: '阿銘',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '9',
  place: '屏東',
  instrument: '爵士鼓',
  name: '小輝老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '10',
  place: '台南',
  instrument: '爵士鼓',
  name: '猛哥',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '11',
  place: '高雄',
  instrument: '爵士鼓',
  name: '阿陳',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '12',
  place: '台南',
  instrument: '爵士鼓',
  name: '游老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '13',
  place: '高雄',
  instrument: '爵士鼓',
  name: '灰仔',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '14',
  place: '高雄',
  instrument: '爵士鼓',
  name: '小黑老師',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '15',
  place: '屏東',
  instrument: '爵士鼓',
  name: '蕭敬騰',
  category: 'drumsNpercussion',
  location: 'south'
},
{
  img: '16',
  place: '高雄',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: '彬哥',
  location: 'south'
},
{
  img: '17',
  place: '高雄',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: '小虎老師',
  location: 'south'
},
{
  img: '18',
  place: '高雄',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: '月亮老師',
  location: 'south'
},
{
  img: '19',
  place: '高雄',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: '錢老師',
  location: 'south'
},
{
  img: '20',
  place: '台南',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: 'Steve',
  location: 'south'
},
{
  img: '21',
  place: '屏東',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: 'Nick葛',
  location: 'south'
},
{
  img: '22',
  place: '屏東',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: 'Lisa Xiao',
  location: 'south'
},
{
  img: '23',
  place: '高雄',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: 'Nina Wei',
  location: 'south'
},
{
  img: '24',
  place: '台南',
  instrument: '爵士鼓',
  category: 'drumsNpercussion',
  name: '游老師',
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

let category_query = $.getParameterByName('category');
let location_query = $.getParameterByName('loca');
Totur_Array.map(tutor => {
  let {
   img,
    place,
    instrument,
    name,
    category,
    location
  } = tutor;

  if (!location_query || (category === category_query && location === location_query)) {
    var $item = $(`<div class="thumbnail preview-thumbnail"  data-img="${img}" data-place="${place}" data-name="${name}" data-instrument="${instrument}" data-category="${category}"></div>`);
    $item.append(`<img class="tutor-thumbnail-image" src="_996_image/tutorfake/${category}/${img}.jpg" alt="Image" />
            <div class="caption view-caption">
                <h4 class="tutor-place">${place}</h4>
                <h4 class="tutor-instrument">${instrument}</h4>
                <h4 class="tutor-name">${name}</h4>
             </div>`);

    $grid.append($item).isotope('appended', $item);
  }

});

$('.thumbnail.preview-thumbnail').on('click', function () {
  sessionStorage.setItem('tutor-Info', JSON.stringify($(this).data()));
  if ($(this).data().name === '格非老師') {
    window.location.assign('/Jam/tutor_detail_self.html');
  } else {
    window.location.assign('/Jam/tutor_detail.html');
  }

})