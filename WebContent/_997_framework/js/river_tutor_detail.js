{
    console.log(JSON.parse(sessionStorage.getItem('tutor-Info')));
    const { img, instrument, place, name, title, category } = JSON.parse(sessionStorage.getItem('tutor-Info'));
    $('.profolio-img').attr('src', `_996_image/tutorfake/${category}/${img}.jpg`);
    $('.tutor-info').find('dd').eq(0).html(instrument);
    $('.tutor-info').find('dd').eq(1).html(place);
    $('.tutor-info').find('dd').eq(2).html(instrument);
    $('.detail-show-op.tutor-op').children('a').html(name)
    $('#mail-recipient').val(name);

    $('#mail-submit').on('click', function () {
        $('.mailbox-modal').removeClass('is-visible');
        $('.confirm-success').addClass('is-visible');
    })
    $('.form-btn.sendmsg').on('click', function () {

        $('#mail-title').val('你好!!!');
        $('#mail-content').html('嗨!你好!!我想要和你預約教學!!!!');

    })

    $('.btn.btn-primary.buy-btn').on('click', function () {
        $(this).attr('disabled', true).html('已預約')

    })
}