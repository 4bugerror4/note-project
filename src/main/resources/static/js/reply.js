function replySave() {
	let data = {
		boardId: $('#boardId').val(),
		comment: $('#comment').val()
	}
	
	console.log(data);
	
	$.ajax({
		type: 'POST',
		url: '/api/reply/save',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/board/' + data.boardId;
		},
		
		error: function(e) {
			console.log(e);
			alert(e);
		}
	});
};

function replyModify(replyId, boardId) {
	let data = {
		replyId: replyId,
		comment: $(`#mComment${replyId}`).val()
	}
	
	console.log(data);
	
	$.ajax({
		type: 'PUT',
		url: '/api/reply/modify',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/board/' + boardId;
		},
		
		error: function(e) {
			console.log(e);
			alert(e);
		}
	});
};

function replyDelete(replyId) {
	
	let boardId = $('#boardId').val();
	
	let data = {
		id: replyId
	}
	
	console.log(data);
	
	$.ajax({
		type: 'DELETE',
		url: '/api/reply/delete',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/board/' + boardId;
		},
		
		error: function(e) {
			console.log(e);
			alert(e);
		}
	});
};

function replyChild(replyId) {
	
	let data = {
		replyId: replyId,
		boardId: $('#boardId').val(),
		comment: $(`#child${replyId}`).val()
	}
	
	console.log(data);
	
	$.ajax({
		type: 'POST',
		url: '/api/reply/child/save',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/board/' + data.boardId;
		},
		
		error: function(e) {
			console.log(e);
			alert(e);
		}
	});
};

