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
        } else {
            logout_Nav();
        }
    })
}