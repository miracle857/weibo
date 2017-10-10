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
		+ "<br><br>"
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
$(".btn-reply").attr({"disabled":"disabled"});
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
	$.ajax({
		url : "/w/publish.do",
		type : "post",
		data : {
			userUsername:$("#s-username").val(),
			userNickname:name,
			content:$("#reply-content").val()
		},
		datatype : "json",
		success : function(data){
			// 3.日期处理，并展示内容
			$("#container").prepend(getWeibo(data));
			$("#test").show("slow");
			$("#reply-content").val('');
		},
		error : function(){
			
		}
	});
});

function getWeibo(data){
	var time = FormatDateTime(data.body.publishTime);
	var name = data.body.userNickname;
	var content = data.body.content;
	var img = data.body.userHeadimg;
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
		+ "<br><br>"
		+ "</div>"
		+ "</div>"
		+ "<div class='menu'>"
		+ "<ul>"
		+ "<li> <a href=''><i class='fa fa-star-o'></i><i class='fa fa-star'></i>收藏</a></li>"
		+ "<li> <a href=''><i class='fa fa-share'></i>转发</a></li>"
		+ "<li> <a href=''><i class='fa fa-commenting-o'></i> 回复</a></li>"
		+ "<li> <a href=''><i class='fa fa-thumbs-o-up'></i><i class='fa fa-thumbs-up'></i>点赞</a></li>"
		+ "</ul>" + "</div>" + "</div>" + "</div>";
	
	return body;
}