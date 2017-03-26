(function () {

    $('#sellButton').on('click', onSellClick)

    function onSellClick() {
        const brand = $('#secondhand-brand').val()
        const model = $('#secondhand-model').val()
        console.log(this)
        console.log(1, brand, model);
    }
    //    console.log(2, brand, model);
})()
