{
    const url = window.location.toString(); //取得當前網址
    let itemId = url.substr(url.indexOf('=') + 1);
    itemId = itemId.indexOf('#') === -1 ? itemId : itemId.substr(0, itemId.length - 1);
    $.ajax({
        url: `/Jam/usedItemDetail`,
        type: `POST`,
        dataType: `json`,
        data: { itemId },
    }).done(response => {
        console.log(response);
        $('#secondhand-detail-title').children('h1').html(response[0].title);
        $('#secondhand-detail-seller').html(response[3]);
        $('#secondhand-detail-price').html(response[0].expectedPrice);
        $('#secondhand-detail-brnad').html(response[0].brand);
        $('#secondhand-detail-model').html(response[0].model);
        $('#secondhand-detail-condition').html(response[2]);
        $('#secondhand-detail-usedTime').html(response[0].usedTime);
        $('#secondhand-detail-desc').html(response[0].description);
        $('#secondhand-detail-seller-pic').attr('src', response[4])
        const pic_arr = response[1];
        pic_arr.map(pic => {
            $('.slider-for').append(`<div class="secondhand-full-pic-div"><img class="secondhand-full-pic" src="${pic}"></div>`)
            $('.slider-nav').append(`<div class="secondhand-small-pic-div"><img class="secondhand-small-pic" src="${pic}"></div>`)
        })
    })
}