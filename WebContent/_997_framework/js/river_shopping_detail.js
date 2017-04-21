{
    var slickInint = function () {
        $('.slider-for').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
            fade: true,
            asNavFor: '.slider-nav'
        });
        $('.slider-nav').slick({
            slidesToShow: 3,
            slidesToScroll: 1,
            asNavFor: '.slider-for',
            dots: true,
            centerMode: true,
            centerPadding: '40px',
            focusOnSelect: true
        });
    }

    const itemId = $.getParameterByName('itemId');
    $.ajax({
        url: `/Jam/newItemDetail`,
        type: `POST`,
        dataType: `json`,
        data: { itemId },
    }).done(response => {
        console.log(response);
        let { brand, category, intro, itemCount, model, newItemId, onSale, price, sold, title } = response.NewItem;
        const { pics } = response;
        console.log(brand, category, intro, itemCount, model, newItemId, onSale, price, sold, title);
        $('.detail-show.title').children('h1').html(title);
        // $('#secondhand-detail-seller').html(seller).attr('href', `member.html?userId=${usedItem.seller}`);
        $('#shopping-detail-price').html(price);
        $('.shopping-price').html(`NT${price}`);
        $('.detail-show-op-buy').html(`<button class="btn btn-primary buy-btn add-to-cart-btn" data-id="${newItemId}" data-price="${price}" data-title="${title}" data-pic="${pics[0]}">加入購物車</button>`)
        $('#shopping-detail-brand').html(brand);
        $('#shopping-detail-model').html(model);
        // $('#secondhand-detail-condition').html(status);
        // $('#secondhand-detail-usedTime').html(usedItem.usedTime);
        // $('#secondhand-detail-desc').html(usedItem.description);
        // $('#secondhand-detail-seller-pic').attr('src', sellerPic)

        pics.map(pic => {
            // console.log($('.slider-for').slickAdd(`<div class="secondhand-full-pic-div"><img class="secondhand-full-pic" data-lazy="${pic}"></div>`)
            // );
            // slickInint();
           $('.slider-for').slick('slickAdd', `<div class="secondhand-full-pic-div"><img class="secondhand-full-pic" src="${pic}"></div>`)
           $('.slider-nav').slick('slickAdd', `<div class="secondhand-small-pic-div"><img class="secondhand-small-pic" src="${pic}"></div>`)
            // $('.slider-for').slickAdd(`<div class="secondhand-full-pic-div"><img class="secondhand-full-pic" src="${pic}"></div>`)
            //$('.slider-nav').slickAdd(`<div class="secondhand-small-pic-div"><img class="secondhand-small-pic" src="${pic}"></div>`)
            //  $('.slider-for').append(`<div class="secondhand-full-pic-div"><img class="secondhand-full-pic" src="${pic}"></div>`)
            //  $('.slider-nav').append(`<div class="secondhand-small-pic-div"><img class="secondhand-small-pic" src="${pic}"></div>`)
        })


    })
}