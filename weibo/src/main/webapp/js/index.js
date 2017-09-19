var body = "<div class='weibo-body' style='display:none' id='test'>" +
"<div class='inner'>" +
"<div class='head-img'>" +
"<img src='/img/logo.jpg' alt='none' class='img-circle body-img'>" +
"</div>" +
"<div class='other'>" +
"<div class='_username'>" +
"name" +
"</div>" +
"<div class='time'>" +
"今天18：00" +
"</div>" +
"<div class='area'>" +
"这里是weibo内容区" +
"<br><br><br><br><br>" +
"1" +
"</div>" +
"</div>" +
"<div class='menu'>" +
"<ul>" +
"<li> <a href=''><i class='fa fa-star-o'></i><i class='fa fa-star'></i>收藏</a></li>" +
"<li> <a href=''><i class='fa fa-share'></i>转发</a></li>" +
"<li> <a href=''><i class='fa fa-commenting-o'></i> 回复</a></li>" +
"<li> <a href=''><i class='fa fa-thumbs-o-up'></i><i class='fa fa-thumbs-up'></i>点赞</a></li>" +
"</ul>" +
"</div>" +
"</div>" +
"</div>";

$(".btn-reply").click(function(){
	$("#container").prepend(body);
	$("#test").show("slow");
    

});