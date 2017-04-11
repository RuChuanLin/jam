
{
	//mailbox 返回收件匣
	$('#return-to-mailbox-list-btn').on('click', function () {

		console.log($('.mail-td-sender.nxx_msgSender'));
		$('.mailbox-content-wrapper').hide();
		$('.mailbox-list-wrapper').show();
	});

	$.ajax({
		url: `/Jam/messageBox`,
		type: 'POST',
		dataType: 'json'
	}).done(response => {		
		console.log(response);
		response.msgs.map((msg, i) => {
			console.log(msg, i);
			$('.mailbox-table-body').append(`<tr class="mailbox-list-tr ${i}">
                                <td class="mail-td-delete">
                                    <input name="mail-del" type="checkbox">
                                </td>
                                <td class="mail-td-sender nxx_msgSender">
                                    ${msg.senderAlias}
                                </td>
                                <td class="mail-td-subject nxx_msgTitle">
                                    ${msg.title}
                                </td>
                                <td class="mail-td-date nxx_msgDate">
                                    ${msg.time.year}/${msg.time.month + 1}/${msg.time.dayOfMonth}
                                    <p class="nxx_msgBody" style="display:none;">
                                </td>
                            </tr>`)
		})
		//mailbox-list點擊進入mailbox-content
		$('.mailbox-list-tr').on('click', function (e) {
			// const {title} = $(this)
			// console.log($(e.target));
			// console.log($(e.target).parent());
			// console.log($(e.target).parent().parent());


			// console.log(e.target);
			const n = $(e.target).parent().index() - 1;

			const { title, senderAlias, sender, pk } = response.msgs[n];
			let { article } = response.msgs[n];

			$.getUnreadMsgNumber(pk);
			$('.mailbox-content-header').children('h2').html(`主旨：${title}`)
			$('.mailbox-content-header').children('span').html(`寄件人：${senderAlias}`)
			$('.mailbox-content').children('div').html(article)
			$('.mailbox-list-wrapper').hide();
			$('.mailbox-content-wrapper').show();
			$('.form-btn.mailist-btn.mailbox-reply-btn').on('click', () => {
				let reply = $('#mail-reply-content').val();
				article += `\n\n${reply}`
				console.log(article);
				$.ajax({
					url: `/Jam/sendMsg`,
					type: 'POST',
					dataType: `json`,
					data: { title, receiver: sender, msg: article }
				})
			})
		});
	})


}