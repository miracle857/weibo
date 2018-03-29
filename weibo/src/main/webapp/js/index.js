/**
 * 保存每条微博回复框子的 开闭情况。
 */
var _map = new Map();

$(document).ready(function(){
	//listWeibo(1);
	
	$("#container").empty();
	
		$.ajax({
			url : "/w/list.do",
			type : "post",
			data : {
				page:1,
				pagesize:10
			},
			datatype : "json",
			success : function(data){
				
				// 到时候删除分页。。。先这样用着
				createPage(data);
				
				$(data.rows).each(function(idx,item){
					_map.put(item.uuid,'close');
					$("#container").append(getWeibo(item));
					
					$(".shown").show();
				});
			},
			error : function(){
				
			}
		});
})



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
			console.log(getWeibo(data.body));
			$("#container").prepend(getWeibo(data.body));
			$(".shown").show("slow");
			$("#reply-content").val('');
			
			// 4.判断长度，如果>10 ， 则删除最后一个元素
		},
		error : function(){
			
		}
	});
});

function listWeibo(page){
	//event.preventDefault();
	
	$("#container").empty();
	
	$.ajax({
		url : "/w/list.do",
		type : "post",
		data : {
			page:page,
			pagesize:10
		},
		datatype : "json",
		success : function(data){
			
			// 到时候删除分页。。。先这样用着
			createPage(data);
			
			$(data.rows).each(function(idx,item){
				_map.put(item.uuid,'close');
				$("#container").append(getWeibo(item));
				
				$(".shown").show();
			});
		},
		error : function(){
			
		}
	});
}


function getWeibo(data){
	var time = FormatDateTime(data.publishTime);
	var uuid = data.uuid;
	var name = data.userNickname;
	var content = data.content;
	var img = data.userHeadimg;
	var body = "<div class='weibo-body shown' style='display:none' id="+uuid+">"
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
		+ "<li> <a href='' class='four_a'><i class='fa fa-star-o'></i><i class='fa fa-star'></i>收藏</a></li>"
		+ "<li> <a href='' class='four_a'><i class='fa fa-share'></i>转发</a></li>"
		+ "<li> <a href='javascript:getReply(\""+uuid+"\")' class='four_a'><i class='fa fa-commenting-o'></i> 回复</a></li>"
		+ "<li> <a href=''><i class='fa fa-thumbs-o-up' class='four_a'></i><i class='fa fa-thumbs-up'></i>点赞</a></li>"
		+ "</ul>" + "</div>" + "</div>" + "</div>";
	
	return body;
}


function createPage(data){
	var page = data.page;
	var pageTotal = data.pageCount;
	var interval = data.pageSize;
	if(pageTotal < data.pageSize){
		interval = pageTotal;
	}
	// 删除分页栏
	if(data.page == null || data.page <= 0 || page>data.pageCount){
		return;
	}
	$(".pagination").empty();
	// 构建首页 和 尾页
	$(".pagination").append($("<li><a href='javascript:listWeibo(1)'>首页</a></li>"));
	
	if(data.page == 1 || data.page == 2){
		if(data.page == 2){
			$(".pagination").append($("<li><a href='javascript:listWeibo("+(page-1)+")' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>"));
		}
		for(var z=1;z<=interval;z++){
			createLi(z,page);
		}
		if(page+1 <= pageTotal){
			$(".pagination").append($("<li><a href='javascript:listWeibo("+(page+1)+")' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>"));
		}
	}else if(data.page <= data.pageCount && data.page >= data.pageCount-1){
		$(".pagination").append($("<li><a href='javascript:listWeibo("+(page-1)+")' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>"));
		for(var z=data.pageCount-(interval-1);z<=data.pageCount;z++){
			createLi(z,page);
		}
		if(data.page != data.pageCount){
			$(".pagination").append($("<li><a href='javascript:listWeibo("+(page+1)+")' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>"));
		}
	}else{
		$(".pagination").append($("<li><a href='javascript:listWeibo("+(page-1)+")' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>"));
		for(var z=data.page-2;z<=data.page+2;z++){
			createLi(z,page);
		}
		$(".pagination").append($("<li><a href='javascript:listWeibo("+(page+1)+")' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>"));
	}
	
	$(".pagination").append($("<li><a href='javascript:listWeibo("+data.pageCount+")'>尾页</a></li>"));
}

function createLi(z,page){
	if(z == page){
		$(".pagination").append($("<li><a href='javascript:listWeibo("+z+")' class='curr_page'>"+z+"</a></li>"));
	}else{
		$(".pagination").append($("<li><a href='javascript:listWeibo("+z+")'>"+z+"</a></li>"));
	}
}



function getReply(uuid){
	if(_map.get(uuid) == 'close'){
		// 1.打开回复框，同时请求回复信息
		// 2. 设置为打开
		_map.removeByKey(uuid);
		_map.put(uuid,'open');
		
		// 补上 回复小版块
		$("#"+uuid).append(getReplyHtml(uuid));
		
		// 监听textarea 输入框内容，判定是否开放按钮
		$("textarea[id="+uuid+"]").on('input', function() {
		    if ($.trim($("textarea[id="+uuid+"]").val()).length == 0) {
		        $("button[id="+uuid+"]").attr({"disabled":"disabled"});
		        $("button[id="+uuid+"]").css("background-color","#FFC09F");
		    }else{
		    	$("button[id="+uuid+"]").removeAttr("disabled");
		    	$("button[id="+uuid+"]").css("background-color","#FF8140");
		    }
		});
		
		
		$.ajax({
			url : "/r/getReply.do",
			type : "post",
			data : {
				page:1,
				pagesize:10,
				weiboUuid:uuid
			},
			datatype : "json",
			success : function(data){
				
				// 不分頁了先
				//createPage(data);
				$(data.rows).each(function(idx,item){
					
					$("#"+uuid+" .replyArea .replyShow").append(getReplyContenet(item));
					
				});
			},
			error : function(){
				
			}
		});
		
		
	}else{
		// 1.删除回复框
		// 2.设置为关闭
		_map.removeByKey(uuid);
		_map.put(uuid,'close');
		$("#"+uuid+" .replyArea").remove();
	}
	
}


function getReplyContenet(data){
	var uuid = data.uuid;
	var name = data.userNickname;
	var content = data.content;
	var date = FormatDateTime(data.publishtime);
	var body = `<div id=`+uuid+`>
					<!-- 头像 -->
					<div style="float: left;clear: both;display: block; margin-left: 10px;margin-top: 0px;">
						<img src="./img/logo.jpg" alt="none" class="img-circle reply-img">
						<div style="clear: both;"></div>
					</div>
					<!-- 评论内容 -->
					<div style="height: 50px;">
                        <a href="" class="username_a">`
							+name+
                        `</a>
                        <span>
                          :`+content+`
                        </span>
                        <div style="font-size: 10px;color: #CC33FF;margin-left: 50px;">
                          	`+date+`
                        </div>
					</div>
				</div>`;
	return body;
}



// 每个微博下的评论按钮调用
// 参数为 weiboUuid
function replyWeibo(weiboUuid){
	// 1.取对应button的textarea
	var content = $("textarea[id="+weiboUuid+"]").val();
	// TODO 2.判空
	var name =  "mxh";
	// ajax给后台传数据
	$.ajax({
		url : "/r/replyWeibo.do",
		type : "post",
		data : {
			userUsername:$("#s-username").val(),
			userNickname:name,
			weiboUuid:weiboUuid,
			content:content
		},
		datatype : "json",
		success : function(data){
			// 3.日期处理，并展示内容
			if(data.success == true){
				$("#"+weiboUuid+" .replyArea .replyShow").append(getReplyContenet(data.body));
				
				// 清空内容，关闭按钮
				$("textarea[id="+weiboUuid+"]").val('');
				$("button[id="+weiboUuid+"]").attr({"disabled":"disabled"});
		        $("button[id="+weiboUuid+"]").css("background-color","#FFC09F");
			}
			
			// 4.判断长度，如果>10 ， 则删除最后一个元素
		},
		error : function(){
			
		}
	});
}



function getReplyHtml(uuid){
	// data 为 Reply
	var weiboUuid = uuid;
	var body = ` <div class='replyArea'>
           			
           				<!-- 回复区 -->
           				<div>
           					<!-- 头像 -->
           					<div style="float: left; margin-top: 10px;margin-left: 10px;">
           						<img src="./img/logo.jpg" alt="none" class="img-circle reply-img">
           					</div>
           					<!-- input -->
           					<div style="">
           						<textarea name="" id=\"`+weiboUuid+`\" style="height:40px;width:520px; margin: 9px; resize: none; border: 1px solid #FFC09F;"></textarea>

           					</div>
           					<div style="display: block; ">
           						<button id=\"`+weiboUuid+`\" type="button" class="btn-reply_2" onclick='replyWeibo(\"`+weiboUuid+`\")'>评论</button>
           					</div>
           					
           				</div>
           				<div style="padding-left: 5%;padding-right: 5%;">
           					<hr style="text-align: center; border:0;background-color:#87BADB;height:1px;" >
           				</div>
           				<!-- 展示区域 -->
           				<div class='replyShow'>
                   			<!-- head，预留区域 -->
           					<div></div>

           				</div>
           			</div>`
	return body;
}

