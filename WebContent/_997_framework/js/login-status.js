{
    $.ajax({
        url: '/Jam/loadingMember',
        type: 'POST',
        datatype: 'json'
    }).done(response => {
        console.log(response);
        if (response) {
            login_Nav();
        } else {
            logout_Nav();
        }
    })
}