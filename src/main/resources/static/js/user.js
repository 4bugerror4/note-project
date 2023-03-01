function userJoin() {
	
	let data = {
		username: $('#username').val(),
		password: $('#password').val(),
		email: $('#email').val(),
	};
	
	$.ajax({
		type: 'POST',
		url: '/api/join',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert(res.msg);
			location.href="/auth/login";
		},
		
		error: function(e) {
			console.log(e);
			alert(JSON.stringify(e.responseJSON.errorMap));
		}
	});
} ;