{
    $.ajax({
        url: '/Jam/loadingMember',
        type: 'POST',
        datatype: 'json'
    }).done(response => {
        console.log(response);
        if (response) {
            console.log(response);
            login_Nav();
            // $('#nav-pic').attr("src", sessionStorage.getItem('pic') || '');
            // $('#fb-loging-name').html(`Hi, ${sessionStorage.getItem('alias')}!`);
        } else {
            logout_Nav();
        }
    })
}