{
    const userId = $.getParameterByName('userId', window.location.toString());
    const mailSubmit = $('#mail-submit');
    mailSubmit.on('click', () => {
        const title = $('#mail-title').val();
        const msg = $('#mail-content').val();
        //會員編輯頁面
        $.ajax({
            url: `/Jam/sendMsg`,
            type: 'POST',
            dataType: `json`,
            data: { title, receiver: userId, msg }
        }).done(response => {
            $('.mailbox-modal').removeClass('is-visible');
            $('.confirm-success').addClass('is-visible');
            console.log('信件已寄出!');
        }).fail(() => {
            console.log('信件寄出失敗!');
        });
    })
}