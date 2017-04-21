jQuery(document).ready(function ($) {
	console.log($);
	$.setShoppingCart();
	var cartWrapper = $('.cd-cart-container');
	console.log(665656);
	//product id - you don't need a counter in your real project but you can use your real product id
	var productId = 0;

	if (cartWrapper.length >= 0) {
		console.log('ffffffff');
		//store jQuery objects
		var cartBody = cartWrapper.find('.body')
		var cartList = cartBody.find('ul').eq(0);
		var cartTotal = cartWrapper.find('.checkout').find('span');
		var cartTrigger = cartWrapper.children('.cd-cart-trigger');
		var cartCount = cartTrigger.children('.count')
		var addToCartBtn = $('.add-to-cart-btn');
		var undo = cartWrapper.find('.undo');
		var undoTimeoutId;
		let cartLength = sessionStorage.getItem('cartItem') ? JSON.parse(sessionStorage.getItem('cartItem')).length : 0;
		console.log(cartLength);
		if (cartLength === 0) { cartWrapper.addClass('empty') }
		let cartItem_arr = 1;
		cartItem_arr = JSON.parse(sessionStorage.getItem('cartItem'));
		console.log(cartItem_arr);
		console.log(22);
		let totalPrice = 0;
		if (cartItem_arr) {
			cartCount.find('li').eq(0).html(cartLength)
			console.log(33);
			cartWrapper.removeClass('empty');
			cartItem_arr.map(cItem => {
				let { title, id, price, pic } = cItem;
				totalPrice += price;
				var productAdded = $(getProductAdded(id, title, price, pic));
				cartList.prepend(productAdded);
			})

			updateCartTotal(totalPrice, true)
		}

		//add product to cart
		$('.detail-show-op-buy').on('click', function (event) {
			console.log(11232);
			console.log(this);
			console.log($(this));
			event.preventDefault();
			addToCart($('.add-to-cart-btn'));

		});

		//open/close cart
		cartTrigger.on('click', function (event) {
			event.preventDefault();
			toggleCart();
		});

		//close cart when clicking on the .cd-cart-container::before (bg layer)
		cartWrapper.on('click', function (event) {
			if ($(event.target).is($(this))) toggleCart(true);
		});

		//delete an item from the cart
		cartList.on('click', '.delete-item', function (event) {
			event.preventDefault();
			removeProduct($(event.target).parents('.product'), $(this));
		});

		//update item quantity
		cartList.on('change', 'select', function (event) {
			quickUpdateCart();
		});

		//reinsert item deleted from the cart
		undo.on('click', 'a', function (event) {
			clearInterval(undoTimeoutId);
			event.preventDefault();
			cartList.find('.deleted').addClass('undo-deleted').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function () {
				$(this).off('webkitAnimationEnd oanimationend msAnimationEnd animationend').removeClass('deleted undo-deleted').removeAttr('style');
				quickUpdateCart();
			});
			undo.removeClass('visible');
		});
	}

	function toggleCart(bool) {
		var cartIsOpen = (typeof bool === 'undefined') ? cartWrapper.hasClass('cart-open') : bool;

		if (cartIsOpen) {
			cartWrapper.removeClass('cart-open');
			//reset undo
			clearInterval(undoTimeoutId);
			undo.removeClass('visible');
			cartList.find('.deleted').remove();

			setTimeout(function () {
				cartBody.scrollTop(0);
				//check if cart empty to hide it
				if (Number(cartCount.find('li').eq(0).text()) == 0) cartWrapper.addClass('empty');
			}, 500);
		} else {
			cartWrapper.addClass('cart-open');
		}
	}

	function addToCart(trigger) {
		var cartIsEmpty = cartWrapper.hasClass('empty');
		console.log(trigger.data());
		const { title, price, id, pic } = trigger.data();


		//update cart product list
		addProduct(title, price, id, pic);
		//update number of items 
		updateCartCount(cartIsEmpty);
		//update total price
		updateCartTotal(trigger.data('price'), true);
		//show cart
		cartWrapper.removeClass('empty');
	}

	function addProduct(title, price, id, pic) {
		//this is just a product placeholder
		//you should insert an item with the selected product info
		//replace productId, productName, price and url with your real product info
		productId = productId + 1;
		let quantity = 1;
		let arr = [];
		if (sessionStorage.getItem('cartItem')) {
			arr = JSON.parse(sessionStorage.getItem('cartItem'));
		}

		let obj = { id, title, price, quantity, pic };
		arr.push(obj);
		sessionStorage.setItem('cartItem', JSON.stringify(arr))
		console.log(JSON.parse(sessionStorage.getItem('cartItem')));
		var productAdded = $(getProductAdded(id, title, price, pic));
		cartList.prepend(productAdded);
	}

	function removeProduct(product, removeBtn) {
		console.log(product);
		const removeId = $(removeBtn).data('id');
		clearInterval(undoTimeoutId);
		cartList.find('.deleted').remove();

		var topPosition = product.offset().top - cartBody.children('ul').offset().top,
			productQuantity = Number(product.find('.quantity').find('select').val()),
			productTotPrice = Number(product.find('.price').text().replace('NT', '')) * productQuantity;

		product.css('top', topPosition + 'px').addClass('deleted');

		//update items count + total price
		updateCartTotal(productTotPrice, false);
		updateCartCount(true, -productQuantity);
		undo.addClass('visible');

		//wait 8sec before completely remove the item
		undoTimeoutId = setTimeout(function () {
			undo.removeClass('visible');
			cartList.find('.deleted').remove();
			let arr = JSON.parse(sessionStorage.getItem('cartItem'));
			console.log(arr);
			arr.map((ci, i) => {
				if (ci.id === removeId) {
					arr.splice(i, 1)
				}
			})
			sessionStorage.setItem('cartItem', JSON.stringify(arr))
		}, 3000);
	}

	function quickUpdateCart() {
		var quantity = 0;
		var price = 0;

		cartList.children('li:not(.deleted)').each(function () {

			var singleQuantity = Number($(this).find('select').val());
			quantity = quantity + singleQuantity;
			let item_obj = { id: $(this).find('a').eq(2).data().id, quantity }
			console.log(item_obj);
			price = price + singleQuantity * Number($(this).find('.price').text().replace('NT', ''));
		});

		cartTotal.text(price);
		cartCount.find('li').eq(0).text(quantity);
		cartCount.find('li').eq(1).text(quantity + 1);
	}

	function updateCartCount(emptyCart, quantity) {
		if (typeof quantity === 'undefined') {
			var actual = Number(cartCount.find('li').eq(0).text()) + 1;
			var next = actual + 1;

			if (emptyCart) {
				cartCount.find('li').eq(0).text(actual);
				cartCount.find('li').eq(1).text(next);
			} else {
				cartCount.addClass('update-count');

				setTimeout(function () {
					cartCount.find('li').eq(0).text(actual);
				}, 150);

				setTimeout(function () {
					cartCount.removeClass('update-count');
				}, 200);

				setTimeout(function () {
					cartCount.find('li').eq(1).text(next);
				}, 230);
			}
		} else {
			var actual = Number(cartCount.find('li').eq(0).text()) + quantity;
			var next = actual + 1;

			cartCount.find('li').eq(0).text(actual);
			cartCount.find('li').eq(1).text(next);
		}
	}

	function updateCartTotal(price, bool) {
		bool ? cartTotal.text((Number(cartTotal.text()) + Number(price))) : cartTotal.text((Number(cartTotal.text()) - Number(price)));
	}


	function getProductAdded(id, title, price, pic) {
		return `<li class="product"><div class="product-image"><a href="#0">
		<img class="cart-img" src="${pic}" alt="placeholder"></a></div>
		<div class="product-details"><h3><a href="#0">${title}</a></h3>
		<span class="price">NT${price}</span><div class="actions">
		<a href="#0" data-id="${id}" class="delete-item">刪除</a><div class="quantity">
		<label for="cd-product-${id}">數量</label><span class="select">
		<select id="cd-product-${id}" name="quantity">${[1, 2, 3, 4, 5, 6, 7, 8, 9].map(n => `<option value="${n}">${n}</option>`)}</select></span></div></div></div></li>`
	}
});