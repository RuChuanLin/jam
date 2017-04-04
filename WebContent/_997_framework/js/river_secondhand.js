{
    $('#sellButton').on('click', onSellClick);

    $('.secondhand-edit-upload-pic').change(function () {
        const self = this;
        const input = $(self).children('input')[0];
        if (input.files && input.files[0]) {
            var FR = new FileReader();
            console.log(FR.readyState);
            FR.onload = function (e) {
                $(self).children('label').children('img').attr("src", e.target.result);
            };
            FR.readAsDataURL(input.files[0]);
        }
    })
    function onSellClick() {
        const [brand, model, condition, age, title, price, category, desc] = [$('#secondhand-brand').val(), $('#secondhand-model').val(), $('#secondhand-condition').val(), $('#secondhand-age').val(), $('#secondhand-title').val(), $('#secondhand-price').val(), $('#secondhand-category').val(), $('#secondhand-edit-description').val()]
        const pic_arr = [];
        $('.secondhand-edit-upload-pic img').map((n, pic) => {
            if ($(pic).attr('src').substr(0, 10) === `data:image`) {
                pic_arr.push($(pic).attr('src'));
            } else {
                pic_arr.push('');
            }
        });
        $.ajax({
            url: '/Jam/usedItemPublish',
            type: 'POST',
            data: { brand, model, status: condition, usedTime: age, title, expectedPrice: price, category, description: desc, pic_arr },
            dataType: 'json'
        }).done(() => {
            window.location.assign("/Jam/secondhand_view.html");
        });
    }
}
