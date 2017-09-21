var name = $("#h5-nickname").html();
var time = new Date();
var content = "22";
var img = "";
var body = "<div class='weibo-body' style='display:none' id='test'>"
		+ "<div class='inner'>"
		+ "<div class='head-img'>"
		+ "<img src='/img/logo.jpg' alt='none' class='img-circle body-img'>"
		+ "</div>"
		+ "<div class='other'>"
		+ "<div class='_username'>"
		+ name
		+ "</div>"
		+ "<div class='time'>"
		+ time
		+ "</div>"
		+ "<div class='area'>"
		+ content
		+ "</div>"
		+ "</div>"
		+ "<div class='menu'>"
		+ "<ul>"
		+ "<li> <a href=''><i class='fa fa-star-o'></i><i class='fa fa-star'></i>收藏</a></li>"
		+ "<li> <a href=''><i class='fa fa-share'></i>转发</a></li>"
		+ "<li> <a href=''><i class='fa fa-commenting-o'></i> 回复</a></li>"
		+ "<li> <a href=''><i class='fa fa-thumbs-o-up'></i><i class='fa fa-thumbs-up'></i>点赞</a></li>"
		+ "</ul>" + "</div>" + "</div>" + "</div>";

// 监听textarea内容文本变化，确定是否开放发布按钮
$("#reply-content").on('input', function() {
    if ($.trim($("#reply-content").val()).length == 0) {
        $(".btn-reply").attr({"disabled":"disabled"});
        $(".btn-reply").css("background-color","#FFC09F");
    }else{
        $(".btn-reply").removeAttr("disabled");
        $(".btn-reply").css("background-color","#FF8140");
    }
});

$(".btn-reply").click(function() {

	// 1.对textarea 判空
	// 2.ajax给后台传数据
	var data = {};
	data.userUsername=$("#s-username").val();
	data.userNickname=name;
	data.content=$("#reply-content").val();
	$.ajax({
		url : "",
		type : "post",
		data : data.serialize(),
		datatype : "json",
		success : function(data){
			
		},
		error : function(){
			
		}
	});
	// 3.日期处理，并展示内容
	$("#container").prepend(body);
	$("#test").show("slow");
});