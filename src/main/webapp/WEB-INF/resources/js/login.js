$(function(){
	
	let confirmPw = $('#confirmPassword');
	let signUpBtn = $('#signUpButton');
	var passwordInput = $('#password');
	let signUpForm =$('signup');	
	let matchPwError =$('matchPwError');
	let loginForm =$('loginForm');
	let emailForm =$('emailForm');

	
	signUpBtn.on('click', function(event){
		if(confirmPw.val()!=passwordInput.val()){
			event.preventDefault();
			console.log('zle hasla');
			console.log(passwordInput.val());
			console.log(confirmPw.val());
			console.log(loginForm.val());
			console.log(emailForm.val());
		}else{
			console.log('dobre hasla');
		}
	})
	
})