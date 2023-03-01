
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
		},
		
		error: function(e) {
			console.log(e);
		}
	});
};