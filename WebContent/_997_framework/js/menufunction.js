$(document).ready(function () {
    Object.defineProperty(Object.prototype, 'toSubMenu', {
        value: function () {
            const self = this;
            let result = new String();
            for (let val in self) {
                result += `<li><a href="/Jam/secondhand_view.html?category=${val}">${self[val]}</a></li>`;
            }
            return result;
        },
        enumerable: false
    });


    const musicInstuments = {
        'guitar': '吉他類',
        'bass': '貝斯類',
        'drumsNpercussion': '鼓及打擊類',
        'keyboardNsync': '鍵盤與合成器類',
        'strings': '古典弦樂類',
        'wind': '管樂類',
        'amp': '音箱類',
        'dj-controller': 'DJ控制器類',
        'effect': '效果器類',
        'recording': '錄音界面類',
        'other': '其他'
    }




    let $menu = $('ul#menu-funtion');
    $menu.html(`<li><a href="/Jam/secondhand_view.html">Jam二手</a>
						<ul class="drop">
							 ${musicInstuments.toSubMenu()}
						</ul>
					</li>
					<li><a href="#">Jam新品</a>
						<ul class="drop">
							${musicInstuments.toSubMenu()}
						</ul>
					</li>
					<li><a href="#">Jam教學</a></li>
					<li><a href="#">Jam組團</a></li>`)
    let $subMenu = $menu.children('li');
    $subMenu.hover(function () {
        //$('#drop' , this).css('display','block');
        $(this).children('ul').delay(50).slideDown(200);
    }, function () {
        $(this).children('ul').delay(50).slideUp(200);
    });
});