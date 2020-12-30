var pr = {};
var bt = {};
$(function () {
    $.ajax({
        url: "/press/getPressList",
        type: "post",
        dataType: "json",
        success: function (msg) {
            console.log(msg)
            $.each(msg.data.list, function (key, ob) {
                pr[ob.prID] = ob.prName;
            });
            console.log(pr)
        }
    });

    $.ajax({
        url: "/bookType/getBookTypeList",
        type: "post",
        dataType: "json",
        success: function (msg) {
            console.log(msg)
            $.each(msg.data.list, function (key, ob) {
                bt[ob.btID] = ob.btName;

            });
            console.log(pr)
        }
    });
    queryPage_book(1);
});

function getdp() {
    $.ajax({
        url: "/press/getPressList",
        type: "post",
        dataType: "json",
        success: function (msg) {
            $.each(msg.data, function (key, ob) {
                pr[ob.prID] = ob.prName;
            });
        }
    });

    // $.ajax({
    //     url: "/book/getPos",
    //     type: "post",
    //     dataType: "json",
    //     success: function (msg) {
    //         $.each(msg.data, function (key, ob) {
    //             pos[ob.posId] = ob.posName;
    //
    //         });
    //     }
    // });
}

//bookInfo.js
function queryPage_book(page) {
    // alert(name+":参数:");
    // getdp();
    name = $("#TextOne").val()

    $.ajax({
        url: "/book/getBookList?" +
            "pageNum=" + page +
            "&pageSize=" + 5 ,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "bName": name,
            "status": 1
        }),
        success: function (msg) {
            console.log(msg);
            $("#TableOne").empty();
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#969696;'>\n" +
                "            <th class=\"th\">识别ID</th>\n" +
                "            <th class=\"th\">编号</th>\n" +
                "            <th class=\"th\">名称</th>\n" +
                "            <th class=\"th\">作者</th>\n" +
                "            <th class=\"th\">出版日期</th>\n" +
                "            <th class=\"th\">状态</th>\n" +
                "            <th class=\"th\">出版社</th>\n" +
                "            <th class=\"th\">类型</th>\n" +
                "            <th class=\"th\">所属书架</th>\n" +
                "            <th class=\"th\">修改</th>\n" +
                "            <th class=\"th\">删除</th>\n" +
                "        </tr>"
            $("#TableOne").append(th)
            $.each(msg.data.list, function (key, obj) {
                // alert(obj.Staff_Pic);
                var tr = "<tr>";
                tr += " <td class=\"td\">" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.bID + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.bNumber + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.bName + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.author + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.pubDate + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.status + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    pr[obj.prID] + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    bt[obj.btID] + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.brID + "</span> </td>";

                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"预约\" id=" + obj.bID +
                    " class=\"easyui-linkbutton app \" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"借出\" id=" + obj.bID + " class=\"lend\"/></span></td>";
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

// 更改页面
function updatePage(obj) {
    var page = $(obj).attr("data"); //取出data属性值
    queryPage_book(page, 1);
}

//
$(document).on("click", ".app", function () {
    var bID = this.id;
    if(confirm("您确定要预约该书本吗？")){
        $.ajax({
            url: "/app/addAppointment",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "bID":bID,
                "appStatus":99
            }),
            dataType: "json",
            success: function (msg) {
                alert(msg.message)
                queryPage_book(1);
                console.log(msg)
            }
        });
    }else {

    }

});


//借出书籍
$(document).on("click", ".lend", function () {
    getdp();
    var bID = this.id;
    if (confirm("您确定要借出此书吗？")) {
        $.ajax({
            url: "/lend/addLend",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "bID":bID,
                "lStatus":3
            }),
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
                queryPage_book(1);
            }
        });
    } else {
        return false;
    }
});