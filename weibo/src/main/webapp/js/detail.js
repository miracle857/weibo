

$(".op").bind("click",function(){
	console.log(this);
	let url = $(this).attr("url");
	console.log(url)
	$.ajax({
		url : url,
		type : "post",
		data : {},
		datatype : "json",
		success : function(data){
			if(data.success){
				alert(data.message)
				//layer.msg(data.message, {icon: 1});
				
				setTimeout(function(){
					window.location.reload();
				},750);
			}else{
				alert(data.message)
			}
		},
		error : function(e){
			console.log(e);
		}
	});
})

