$(document).ready(function() {
	$("#shouye").on("click", function() {
		//首页
		$("#shouye1").css("display", "block").siblings().css("display", "none"); //首页显示其他页面隐藏
	});
	$("#ck_tushu").on("click", function() {
		//查看图书
		$("#ck_tushu1").css("display", "block").siblings().css("display", "none");
		$("#ck_tushu1 td,tr,th").remove();
		$("#ck_tushu1 table").append("<tr><th>编号</th><th>书名</th><th>作者</th><th>出版日期</th><th>借阅</th></tr>");
		getBookList();
	});
	$("#ck_yuyue").on("click", function() {
		//查看预约
		$("#ck_yuyue1").css("display", "block").siblings().css("display", "none");
	});
	$("#ck_guihuan").on("click", function() {
		//查看归还
		$("#ck_guihuan1").css("display", "block").siblings().css("display", "none");
	});
	$("#weiyue").on("click", function() {
		//违约记录
		$("#weiyue1").css("display", "block").siblings().css("display", "none");
	});
	$("#guihuan").on("click", function() {
		//归还图书
		$("#guihuan1").css("display", "block").siblings().css("display", "none");
	});
	$("#denglu").on("click", function() {
		//用户登录
		$("#denglu1").css("display", "block").siblings().css("display", "none");
	});
});
var u = "192.168.137.51";//服务器地址
$("#subit").on("click", function() {
	//登录部分写在外面,点击登录按钮
	console.log($("#user").val());
	console.log($("#password").val());
	$.ajax({
		type: "post",
//		url: "http://192.168.43.181:8080/stu/login", //我的手机
		url: "http://"+u+":8080/stu/login", //我的电脑
		
		async: true,
		contentType: "application/json",
		dataType: "json",
		data: JSON.stringify({
			"sID": $("#user").val(),
			"password": $("#password").val()
		}),
		success: function(msg) {
			console.log(msg);
			if(msg.code == 2001) {
				alert(msg.message);
				$("#top_3 p").remove();
				$("#top_3").css("display", "block");
				$("#top_3").append("<p>"+$("#user").val()+"</p><p>欢迎欢迎！</p>");
				$("#shouye1").css("display", "block").siblings().css("display", "none"); //首页显示其他页面隐藏
				return false;
			} else {
				alert(msg.message);
				return false;
			}
		},
	});
});

function getBookList() {
	//ajax  查看图书页面 ，返回数组,增加数组信息
	$.ajax({
		type: "post",
		url: "http://"+u+":8080/book/getBookList", //我的电脑
		async: true,
		contentType: "application/json",
		dataType: "json",
		data: JSON.stringify({
			"bNumber": "",
			"bName": "",
			"status": 1
		}),
		success: function(msg) {
			console.log(msg);
			for(var i = 0; i < msg.data.list.length; i++) {
//				console.log(msg.data[i]);
				$("#ck_tushu1 table").append("<tr>"+
				"<td>"+msg.data.list[i].bNumber+"</td>"+
				"<td>"+msg.data.list[i].bName+"</td>"+
				"<td>"+msg.data.list[i].author+"</td>"+
				"<td>"+msg.data.list[i].pubDate+"</td>"+
				"<td><input type='button' value='借阅' onclick='jieYue()'></input></td>"+
				"</tr>");
			}
		},
	});
}

function jieYue(){
	//点击借阅，调用此方法
	console.log("aaas");
}

function lun_bo(){
	console.log($("#lun_bo").css("left"));
	var a = parseInt($("#lun_bo").css("left"));
//	console.log(a);
	var index = 500;
	for(var i=0;i<$("#lun_bo img").length;i++){
		var b = a -500;
	}
}
setInterval(lun_bo,2000);
