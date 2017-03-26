(function () {

    // $('#secondhand-brand').on('change', () => {
    //     return $('#secondhand-brand').val();
    // })
    // var model = $('#secondhand-model').html()
    // console.log(brand)
    $('#sellButton').on('click', onSellClick)

    function onSellClick() {
        // console.log(brand);
        let brand = $('#secondhand-brand').val()
        let model = $('#secondhand-model').val()
        console.log(this)
        console.log(1, brand, model);
    }
    //    console.log(2, brand, model);
})()
