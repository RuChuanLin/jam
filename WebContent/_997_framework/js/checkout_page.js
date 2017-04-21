$(document).ready(function (e) {
    const cartItem = JSON.parse(sessionStorage.getItem('cartItem'))
    console.log(cartItem);
    $('#checkout-btn').on('click', () => {
        sessionStorage.removeItem('cartItem');
    })
    let totalPrice = 0;
    cartItem.map(ci => {
        totalPrice += ci.price * ci.quantity;
        $('.shopping-list').find('table').append(`<tbody>
                            <tr>
                                <td>
                                    <a href="">${ci.title}</a>
                                </td>
                                <td>${ci.quantity}</td>
                                <td><span class="note">NT.</span>${ci.price}</td>
                                <td><span class="note">NT.</span>${ci.price * ci.quantity}</td>
                            </tr>
                        </tbody>`)
    })
    $('.shopping-list').find('table').append(`<tbody>
                            <tr>
                                <td>
                                </td>
                                <td></td>
                                <td class="td-total-price"><span class="note">總金額</span></td>
                                <td class="td-total-price"><span class="note">NT.</span>${totalPrice}</td>
                            </tr>
                        </tbody>`)

    $('#checkout-btn').click(() => {
        $('.booking-detail-inputs').hide();
        $('.booking-details').show();
        $('.checkout-btn').hide();
        bookingInfo();
    })
    $('#checkout-return-btn').click(() => {
        window.location.assign("http://localhost:8080/Jam/shopping_view.html");
    })

    function bookingInfo() {
        let name = $('#checkout-name').val();
        let phone = $('#checkout-phone').val();
        let zip = $('#checkout-zip').val();
        let address = $('#checkout-address').val();

        $('.booking-details-dl').append(`<dt>收貨人姓名：</dt><dd>${name}</dd><dt>收貨人聯絡電話：</dt><dd>${phone}</dd><dt>收貨地址：</dt><dd>${zip} ${address}</dd>`);


    }


})