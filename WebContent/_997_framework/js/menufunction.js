$(document).ready(function () {
    const SECONDHAND_URL = 'secondhand_view.html';
    const SHOPPING_URL = 'shopping_view.html';
    const TUTOR_URL = 'tutor_view.html';
    const BAND_URL = 'band_view.html';
    Object.defineProperty(Object.prototype, 'toSubMenu', {
        value: function (url) {
            const self = this;
            let result = new String();
            for (let val in self) {
                result += `<li><a href="/Jam/${url}?category=${val}">${self[val]}</a></li>`;
            }
            return result;
        },
        enumerable: false
    });

    Object.defineProperty(Object.prototype, 'toSubSubMenu', {
        value: function (url, musicIn) {
            const self = this;
            let result = new String();
            for (let loca in self) {
                result += `<li><a href="/Jam/${url}?loca=${loca}">${self[loca]}</a>
                <ul>`
                for (let mus in musicIn) {
                    result += `<li><a href="/Jam/${url}?loca=${loca}&category=${mus}">${musicIn[mus]}</a></li>`

                }
                result += `</ul>
                </li>`;
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

    const location = {
        'north': '北部',
        'mid': '中部',
        'south': '南部',
        'east': '東部',
    }


    const tutorInstuments = {
        'guitar': '吉他類',
        'bass': '貝斯類',
        'drumsNpercussion': '鼓及打擊類',
        'keyboardNsync': '鍵盤與合成器類',
        'strings': '古典弦樂類',
        'wind': '管樂類',
        'dj-controller': 'DJ混音類',
        'recording': '錄音編曲類',
        'other': '其他'
    }

    const bandInstuments = {
        'guitar': '吉他類',
        'bass': '貝斯類',
        'drumsNpercussion': '鼓及打擊類',
        'keyboardNsync': '鍵盤與合成器類',
        'strings': '古典弦樂類',
        'wind': '管樂類',
        'dj-controller': 'DJ鼓機類',
        'vocal': '人聲類',
        'other': '其他'
    }

    let $menu = $('ul#menu-funtion');
    $menu.html(`<li><a href="/Jam/${SECONDHAND_URL}">Jam二手</a>
						<ul class="drop">
							${musicInstuments.toSubMenu(`${SECONDHAND_URL}`)}
						</ul>
					</li>
					<li><a href="/Jam/${SHOPPING_URL}">Jam新品</a>
						<ul class="drop">
							${musicInstuments.toSubMenu(`${SHOPPING_URL}`)}
						</ul>
					</li>
					<li><a href="/Jam/${TUTOR_URL}">Jam教學</a>
                        <ul class="drop">
							${location.toSubSubMenu(`${TUTOR_URL}`, tutorInstuments)}
						</ul>
                    </li>
					<li><a href="/Jam/${BAND_URL}">Jam組團</a>
                        <ul class="drop">
							${location.toSubSubMenu(`${BAND_URL}`, bandInstuments)}
						</ul>
                    </li>`)
    let $subMenu = $menu.children('li');
    $subMenu.hover(function () {
        //$('#drop' , this).css('display','block');
        $(this).children('ul').slideDown(200);
    }, function () {
        $(this).children('ul').slideUp(50);
    });
    let $subSubMenu = $subMenu.children('ul').children('li');
    $subSubMenu.hover(function () {

        //$('#drop' , this).css('display','block');
        $(this).children('ul').slideDown(200);
    }, function () {
        $(this).children('ul').slideUp(50);
    })
});