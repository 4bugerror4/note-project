
function boardSave() {
	
	let data = {
		title: $('#title').val(),
		content: $('#content').val()
	};
	
	console.log(data);
	
	$.ajax({
		type: 'POST',
		url: '/api/board/save',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/board';
		},
		
		error: function(e) {
			console.log(e);
			alert(JSON.stringify(e.responseJSON.errorMap));
		}
	});
}

function boardModify() {
	
	let data = {
		id: $('#id').val(),
		title: $('#title').val(),
		content: $('#content').val()
	};
	
	console.log(data);
	
	$.ajax({
		type: 'PUT',
		url: '/api/board/modify',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/board';
		},
		
		error: function(e) {
			console.log(e);
			alert(JSON.stringify(e.responseJSON.errorMap));
		}
	});
}

function boardDelete() {
	
	let data = {
		id: $('#id').val()
	};
	
	console.log(data);
	
	$.ajax({
		type: 'DELETE',
		url: '/api/board/delete/' + data.id,
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/board';
		},
		
		error: function(e) {
			console.log(e);
			alert(JSON.stringify(e.responseJSON.errorMap));
		}
	});
}