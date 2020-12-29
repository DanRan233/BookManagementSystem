$(function () {
    queryPageapp(1);
});

function queryPageapp(page) {
    name = $("#TextOne").val()
    $.ajax({
        url: "/app/getAppointmentList?"+
            "pageNum=" + page +
            "&pageSize=" + 5 ,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "bID": name,
            "appStatus": 2
        }),
        success: function (msg) {
            console.log(msg)
            $("#TableOne").empty();
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#969696;'>\n" +
                "            <th id=\"North_th-Two\" class=\"th\">书籍编号</th>\n" +
                "            <th id=\"North_th-Three\" class=\"th\">截止日期</th>\n" +
                "            <th id=\"North_th-Nine\" class=\"th\">借出</th>\n" +
                "            <th id=\"North_th-Ten\" class=\"th\">取消预约</th>\n" +
                "        </tr>"
            $("#TableOne").append(th)
            $.each(msg.data.list, function (key, obj) {
                var tr = "<tr>";
                tr += " <td class=\"td\">" +
                    "<span id=\"Staff_Code\" name=\"Staff_Code\"style=\"text-align: center;display:block;\">" +
                    obj.bID + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span id=\"Staff_No\" name=\"Staff_No\"style=\"text-align: center;display:block;\">" +
                    obj.appDate + "</span> </td>";
                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"借出\" id=" + obj.bID + " class=\"easyui-linkbutton lend\" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"取消\" id=" + obj.bID + " class=\"ret\"/></span></td>";
                tr += "</tr>";
                $("#TableOne").append(tr);
                $("#total").text(msg.data.total); //总条数
                $("#li_One input").attr("data", 1); //首页
                $("#li_Two input").attr("data", msg.data.prePage); //上一页
                $("#li_Three input").val(msg.data.pageNum); //当前页
                $("#li_Four input").attr("data", msg.data.nextPage); //下一页
                $("#li_Five input").attr("data", msg.data.pages); //尾页
            });

        }
    });
}

//改变页面
function changePage(obj) {
    var page = $(obj).attr("data"); //取出data属性值
    queryPageapp(page);
}


//取消预约
$(document).on("click", ".ret", function () {
    var bID = this.id;
    if (confirm("您确定要取消预约吗？")) {
        $.ajax({
            url: "/app/updateAppointment",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "bID":bID,
                "appStatus":1
            }),
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
                queryPageapp(1); //刷新当前页面
            }
        });
    } else {
        return false;
    }
});

//借出书籍
$(document).on("click", ".lend", function () {
    var bID = this.id;
    if (confirm("您确定要借出此书吗？")) {
        $.ajax({
            url: "/lend/addLend",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "bID":bID
            }),
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
                queryPageapp(1);
            }
        });
    } else {
        return false;
    }
});