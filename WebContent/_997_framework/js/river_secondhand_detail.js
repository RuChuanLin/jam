{
    const itemId = getParameterByName('itemId', window.location.toString());
    $.ajax({
        url: `/Jam/usedItemDetail`,
        type: `POST`,
        dataType: `json`,
        data: { itemId },
    }).done(response => {
        console.log(response);
        const { usedItem, pics, status, seller, sellerPic, bidderList } = response;
        $('#secondhand-detail-title').children('h1').html(usedItem.title);
        $('#secondhand-detail-seller').html(seller).attr('href', `member.html?userId=${usedItem.seller}`);
        $('#secondhand-detail-price').html(usedItem.expectedPrice);
        $('#secondhand-detail-brnad').html(usedItem.brand);
        $('#secondhand-detail-model').html(usedItem.model);
        $('#secondhand-detail-condition').html(status);
        $('#secondhand-detail-usedTime').html(usedItem.usedTime);
        $('#secondhand-detail-desc').html(usedItem.description);
        $('#secondhand-detail-seller-pic').attr('src', sellerPic)
        const pic_arr = pics;
        pic_arr.map(pic => {
            $('.slider-for').append(`<div class="secondhand-full-pic-div"><img class="secondhand-full-pic" src="${pic}"></div>`)
            $('.slider-nav').append(`<div class="secondhand-small-pic-div"><img class="secondhand-small-pic" src="${pic}"></div>`)
        })

        //如果登入的不是自己頁面的判斷式
        if (window.location.toString().indexOf('Jam/secondhand_detail.html') !== -1) {
            $('#mail-recipient').val(seller);
            $('#mail-title').val(`[我想買] ${usedItem.title}`);
            function getBidBtn(status) {
                $('.detail-show-op-buy').html(`<button class="btn btn-primary buy-btn ${status === 1 ? "cancel" : status === 0 ? "buy" : "sold"}" ${status === -1 || status === 2 ? "disabled" : ""}>${status === 2 ? "您已得標!" : status === 1 ? "已下標" : status === 0 ? "出價購買" : "已售出"}</button>`)
            }
            getBidBtn(0);
            bidderList.map(bid => {
                if (bid.userId == sessionStorage.getItem("LoginId")) {
                    getBidBtn(bid.status);
                    return;
                }
            })
            //站內信
            $('#mail-submit').on('click', () => {
                const msg = $('#mail-content').val();
                $.ajax({
                    url: `/Jam/sendMsg`,
                    type: 'POST',
                    dataType: `json`,
                    data: { title: usedItem.title, receiver: usedItem.seller, msg }
                }).done(response => {
                    console.log('信件已寄出!');
                }).fail(() => {
                    console.log('信件寄出失敗!');
                });
            });
            //下標
            $('.detail-show-op-buy').on('click', '.buy', () => {
                $.ajax({
                    url: `/Jam/newBid`,
                    type: `POST`,
                    dataType: `json`,
                    data: { itemId, bidded: false }
                }).done(() => {
                    getBidBtn(1);
                })
            })
            $('.detail-show-op-buy').on('click', '.cancel', () => {
                $.ajax({
                    url: `/Jam/newBid`,
                    type: `POST`,
                    dataType: `json`,
                    data: { itemId, bidded: true }
                }).done(() => {
                    getBidBtn(0);
                })
            })
        }
        else {
            //自己的頁面
            produceList(bidderList);

            $('.detail-client-info-wrapper').on('click', '.btn.btn-primary.client-btn.confirm-btn', function () {
                console.log(this, $(this));
                const bidder = $(this).attr('class').substr($(this).attr('class').lastIndexOf(' ') + 1);
                $.ajax({
                    url: `/Jam/confirmBid`,
                    type: `POST`,
                    dataType: `json`,
                    data: { decision: 1, bidder, itemId }
                }).done(response => {
                    let { bidderList } = response;
                    console.log(bidderList);
                    $('.detail-client-info-wrapper').empty();
                    produceList(bidderList);
                })
            });

            $('.detail-client-info-wrapper').on('click', '.btn.btn-primary.client-btn.refuse-btn.cancel', function () {
                $.ajax({
                    url: `/Jam/confirmBid`,
                    type: `POST`,
                    dataType: `json`,
                    data: { decision: -1, itemId }
                }).done(response => {
                    let { bidderList } = response;
                    $('.detail-client-info-wrapper').empty();
                    produceList(bidderList);
                })
            })
            $('.detail-client-info-wrapper').on('click', '.btn.btn-primary.client-btn.refuse-btn.reject', function () {
                const bidder = $(this).attr('class').substr($(this).attr('class').lastIndexOf(' ') + 1);
                $.ajax({
                    url: `/Jam/confirmBid`,
                    type: `POST`,
                    dataType: `json`,
                    data: { decision: -2, bidder, itemId }
                }).done(response => {
                    let { bidderList } = response;
                    $('.detail-client-info-wrapper').empty();
                    produceList(bidderList);
                })
            })
            function produceList(bidderList) {
                let temp = '';
                bidderList.map(bid => {
                    temp += `<div class="detail-client-info">
                        <img class="member-small-pic" src="${bid.pic}">
                        <a href="member.html?userId=${bid.userId}">${bid.alias}</a> 想跟您購買此商品
                        <div class="client-btn-wrapper">
                            <button class="btn btn-primary client-btn confirm-btn ${bid.userId}" ${bid.status === 1 ? "" : "disabled"}>${bid.status === 2 ? "已確認!" : "確認"}</button>
                            <button class="btn btn-primary client-btn refuse-btn ${bid.status === 2 ? "cancel" : "reject"} ${bid.userId}" ${bid.status === -1 ? "disabled" : ""}>${bid.status === 2 ? "取消" : "拒絕"}</button>
                        </div>
                    </div>`
                })
                $('.detail-client-info-wrapper').html(temp);
            }

            $('#secondhand-detail-edit').on('click', () => {
                window.location.assign(`/Jam/secondhand_edit.html?itemId=${usedItem.usedItemId}`);

            })
        }
    })
}