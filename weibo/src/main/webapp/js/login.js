$(function() {

	$("input[name!='remember']").focus(function() {
		$(this).css("border", "1px solid green");
	});
	$("input[name!='remember']").blur(function() {
		$(this).css("border", "1px solid #E5E5E5");
	});
	
});

function toForgetPassword() {
	$(".login-form").css("display", "none");
	$(".register-form").css("display", "none");
	$(".forget-form").css("display", "");
}
function backToLogin() {
	$(".login-form").css("display", "");
	$(".register-form").css("display", "none");
	$(".forget-form").css("display", "none");
}
function toRegister() {
	$(".login-form").css("display", "none");
	$(".register-form").css("display", "");
	$(".forget-form").css("display", "none");
}

$("#login-submit-btn").click(login);
function login(){
	
	$.ajax({
		url : "/login.do",
		type : 'post',
		data : $('#login-form').serialize(),
		dataType : 'json',
		success : function(data) {
			if (data.success) {
				if($("#remeberMe").prop('checked')){
					setCookie("username",$("input[name=username]").val(),30);
					setCookie("pwd",$("input[name=password]").val(),30);
				}
				layer.msg('登录成功！', {icon: 1});
				setTimeout(function(){
					window.location.href="/index.do";
				},750);
			} else {
				layer.msg(data.message, {icon: 5});
			}
		},
		error : function(e) {

		}
	});
}

function register() {
	
	//TODO  表单数据校验  1.密码长度  2.用户名长度  3.密码是否相同  4.邮箱是否格式正确
	
	$.ajax({
		url : "/register.do",
		type : 'post',
		data : $('#register-form').serialize(),
		dataType : 'json',
		success : function(data) {
			if (data.success) {
				layer.msg('注册成功！', {icon: 1});
				setTimeout(function(){
					location.reload();
				},2000);
			} else {
				$("input[name=password]").val('');
				$("input[name=rpassword]").val('');
				layer.msg(data.message, {icon: 5});
			}
		},
		error : function(e) {

		}
	});
}

$(".back-btn").click(backToLogin);
$("#register-submit-btn").click(register);

function setCookie(c_name,value,expiredays){
	var exdate=new Date()
	exdate.setDate(exdate.getDate()+expiredays)
	document.cookie=c_name+ "=" +escape(value)+
	((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}