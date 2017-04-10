{

    if (sessionStorage.getItem('LoginId') === $.getParameterByName('userId', window.location.toString()) || $.getParameterByName('userId', window.location.toString()) === null) {
        $('#edit-member-btn').html(`<button class="edit-btn">
					<i class="fa fa-pencil fa-lg" aria-hidden="true"></i>
				</button>`)
    }
    $.ajax({
        url: '/Jam/goMemberPage',
        type: 'POST',
        datatype: 'json',
        data: { member: sessionStorage.getItem('LoginId') }
    }).done(response => {
        console.log(response);
        // login_Nav();

        $("#member-pic").attr("src", response.Member.pic || '');
        $("#member-name").html(response.Member.alias);
        // $("#member-intro-hide").html();
        $('#fb-loging-name').html(`Hi, ${sessionStorage.getItem('alias')}!`);
        $('#nav-pic').attr('src', sessionStorage.getItem('pic'))
        if (response.Member.url) {
            let url = response.Member.url.split(' ');
            console.log(url);
            $('#media-video-list').empty();
            url.map(v => {
                if (v) {
                    $('#media-video-list').append(`<iframe src="https://www.youtube.com/embed/${v}" frameborder="0" allowfullscreen></iframe>`);
                }
            });
        }
        let { intro } = response.Member;
        if (intro) {
            const intro_show_number = intro.indexOf('\n', intro.indexOf('\n', intro.indexOf('\n') + 1) + 1);
            intro = ReplaceAll(intro, "\n", "<br />");
            console.log(intro);
            if (intro.length > intro_show_number && intro_show_number !== -1) {
                $('#intro-original').html(intro.substr(0, intro_show_number))
                $('#intro-expended').html(intro.substr(intro_show_number))
            } else {
                $('#intro-original').html(intro)
            }
        }

        if (response.Member.instrument) {
            let instrument = response.Member.instrument.split(' ');
            $("#member-instrument").html(instrument.join(' / '));
        }
        function ReplaceAll(strOrg, strFind, strReplace) {
            var index = 0;
            while (strOrg.indexOf(strFind, index) != -1) {
                strOrg = strOrg.replace(strFind, strReplace);
                index = strOrg.indexOf(strFind, index);
            }
            return strOrg
        }
    });
}