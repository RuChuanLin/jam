{
    const { img, instrument, place, style, title } = JSON.parse(sessionStorage.getItem('band-Info'));
    $('.profolio-img').attr('src', `images/bandfake/${img}.jpg`);
    $('.band-info').find('dd').eq(0).html(instrument);
    $('.band-info').find('dd').eq(1).html(place);
    $('.band-info').find('dd').eq(2).html(style);
    $('.band-title-show').html(title);
    $('#mail-title').val(`[我想組團] ${title}`);
    $('#mail-recipient').val(`王建華`);

    $('#mail-submit').on('click', function () {
        $('.mailbox-modal').removeClass('is-visible');
        $('.confirm-success').addClass('is-visible');
    })
    $('.form-btn.sendmsg').on('click', function () {
        $('#mail-content').html('嗨!你好!!我對你的團有興趣!!!');

    })
}