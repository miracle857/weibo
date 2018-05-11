$(".fol").click(function(){
	let url = "";
	let _this = this;
	let userid = $(this).attr("userid");
	let type = $(this).attr("type");
	if(type == "follow"){
		url = "/op/follow/id/"+userid+".do";
	}else if(type == "unfollow"){
		url = "/op/unfollow/id/"+userid+".do";
	}else{
		return false;
	}
	
	$.ajax({
		url : url,
		type : "post",
		data : {},
		datatype : "json",
		success : function(data){
			if(data.success){
				layer.msg(data.message, {icon: 1});
				if(type == "follow"){
					$(_this).attr("type","unfollow");
					$(_this).html("取消关注");
					$(_this).prev().removeClass("glyphicon-plus");
					$(_this).prev().addClass("glyphicon-remove");
				}else{
					// 取消关注
					$(_this).attr("type","follow");
					$(_this).html("关注");
					$(_this).prev().removeClass("glyphicon-remove");
					$(_this).prev().addClass("glyphicon-plus");
					
					// 若，当前是自己的信息，并且是在操作关注列表
					// 若取消关注，则删除此DIV
					if(btnVue.gzChoiced == true && $("#ifMyself").val()){
						$("#"+userid).fadeOut(1000,function(){
							$(this).remove();
						});
					}
				}
			}else{
				layer.msg(data.message, {icon: 5});
			}
		},
		error : function(){
			
		}
	});
});