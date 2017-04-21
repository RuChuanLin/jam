{
    console.log(JSON.parse(sessionStorage.getItem('tutor-Info')));
    const { img, instrument, place, name, title, category } = JSON.parse(sessionStorage.getItem('tutor-Info'));
    $('.tutor-info').find('dd').eq(0).html(instrument);
    $('.tutor-info').find('dd').eq(1).html(place);
    $()

    $('.btn.btn-primary.client-btn.confirm-btn').on('click', function () {
        // $('.btn.btn-primary.client-btn.confirm-btn').attr('disabled', true)
        // $('.btn.btn-primary.client-btn.refuse-btn').attr('disabled', true)
        // $(this).html('答應')
        $(this).attr('disabled', true)
        $(this).next().attr('disabled', false)
        $(this).next().unbind();
        $(this).next().on('click', function () {
            $('.btn.btn-primary.client-btn.confirm-btn').attr('disabled', false)
            $('.btn.btn-primary.client-btn.refuse-btn').attr('disabled', false)
            // $(this).last().html('確認')
            $('.btn.btn-primary.client-btn.refuse-btn').on('click', function () {
                $(this).parent().parent().remove();
            })
        })

    })


    $('.btn.btn-primary.client-btn.refuse-btn').on('click', function () {
        $(this).parent().parent().remove();
    })



}