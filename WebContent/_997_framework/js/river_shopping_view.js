{
    const category = $.getParameterByName('category');
    console.log(category);

    $.ajax({
        url: `/Jam/newItemView`,
        type: `GET`,
        dataTypa: `json`,
        data: { category }
    }).done(response => {
        console.log(response);
        response.map(newItem => {
            if (typeof newItem !== 'number') {
                let $items = getSeconhandElement(newItem[0].title, newItem[0].price, newItem[1])
                $items.on('click', function () {
                    GoNewItemDetail(newItem[0].newItemId, newItem[0].seller)
                })
                $grid.append($items).isotope('appended', $items)
            } else {
                $(window).on('scroll', function () {
                    // test Json Text to set
                    if ($(document).height() - $(window).height() - $(document).scrollTop() < 100 && newItem > 0) {
                        $.ajax({
                            url: '/Jam/newItemView',
                            type: 'GET',
                            dataType: 'json',
                            data: { currentPage: newItem, category }
                        }).done(response => {
                            console.log(response);
                            response.map(newItem => {
                                if (typeof newItem !== 'number') {
                                    let $items = getSeconhandElement(newItem[0].title, newItem[0].price, newItem[1])
                                    $items.on('click', function () {
                                        GonewItemDetail(newItem[0].newItemId)
                                    })
                                    $grid.append($items).isotope('appended', $items)
                                } else if (typeof newItem === 'number' && newItem < 0) {
                                    $(window).unbind('scroll')
                                }
                            })
                        })
                    }
                });
            }
        })
    })

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

    function GoNewItemDetail(newItem, seller) {
        console.log(newItem, seller, sessionStorage.getItem('LoginId'));
        window.location.assign(`/Jam/shopping_detail.html?itemId=${newItem}`);
    }

    function onnewItemLoading(arg) {
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


}