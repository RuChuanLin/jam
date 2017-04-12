{
    //取得URL查詢字串的正則表示式
    $.getParameterByName = function (name, url = window.location.toString()) {
        if (!url) {
            url = window.location.href;
        }
        name = name.replace(/[\[\]]/g, "\\$&");
        let regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }

    // 神奇小按鈕
    $.fn.extend({
        onMagicClick: function (obj) {
            return this.click(function () {
                for (item in obj) {
                    $(`#${item}`).val(`${obj[item]}`)
                }
            });
        }
    })

    //計算新信數量
    $.getUnreadMsgNumber = function (msgId = -1) {
        $.ajax({
            url: `/Jam/msgRead`,
            type: `POST`,
            dataType: `json`,
            data: { msgId }
        }).done(response => {
            console.log(response);
            $('.badge').html(response.unreadMsgNumber);
            response.unreadMsgNumber === 0 ? $('.badge').hide() : $('.badge').show();
        })
    }


    // 購物車
    $.setShoppingCart = function () {
        $('.cd-cart-container').html(`<a href="#0" class="cd-cart-trigger">
		Cart
		<ul class="count"> <!-- cart items count -->
			<li>0</li>
			<li>0</li>
		</ul> <!-- .count -->
	</a>
        <div class="cd-cart">
            <div class="wrapper">
                <header>
                    <h2>購物車</h2>
                    <span class="undo">物品已移除 <a href="#0">上一步</a></span>
                </header>

                <div class="body">
                    <ul>
                        <!-- products added to the cart will be inserted here using JavaScript -->
                    </ul>
                </div>
                <footer>
                    <a href="#0" class="checkout"><em>前往結帳 - NT<span>0</span></em></a>
                </footer>
            </div>
        </div>`)

    }

}