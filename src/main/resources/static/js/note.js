
function saveNote() {
	
	let data = {
		title: $('#title').val(),
		content: $('#content').val() 
	};
	
	$.ajax({
		type: 'POST',
		url: '/api/save',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/';		
		},
		
		error: function(e) {
			console.log(e);
			alert(JSON.stringify(e.responseJSON.errorMap));
		}
	});
};

function modifyNote(mId) {
	
	
	let data = {
		id: mId,
		title: $(`#mTitle${mId}`).val(),
		content: $(`#mContent${mId}`).val()
	};
	
	console.log(data);
	
	$.ajax({
		type: 'PUT',
		url: '/api/modify',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/';		
		},
		
		error: function(e) {
			console.log(e);
			alert(JSON.stringify(e.responseJSON.errorMap));
		}
	});
};

function deleteNote(noteId) {
	
	
	let data = {
		id: noteId
	};
	
	$.ajax({
		type: 'DELETE',
		url: '/api/delete',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href='/';
		},
		
		error: function(e) {
			console.log(e);
			alert(JSON.stringify(e.responseJSON.errorMap));
		}
	});
};