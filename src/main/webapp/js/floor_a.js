$(function () {

    // $.ajax({
    //     url: "/bookType/getBookTypeList",
    //     type: "post",
    //     dataType: "json",
    //     success: function (msg) {
    //         console.log(msg)
    //         $.each(msg.data.list, function (key, ob) {
    //             bt[ob.btID] = ob.btName;
    //
    //         });
    //         console.log(pr)
    //     }
    // });
    queryPage_book(1);
});


//bookInfo.js
function queryPage_book(page) {
    // alert(name+":参数:");
    // getdp();
    name = $("#TextOne").val()

    $.ajax({
        url: "/floor/getFloorList?" +
            "pageNum=" + page +
            "&pageSize=" + 5,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "fName": name
        }),
        success: function (msg) {
            console.log(msg);
            $("#TableOne").empty();
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#969696;'>\n" +
                "            <th class=\"th\">编号</th>\n" +
                "            <th class=\"th\">楼层名称</th>\n" +
                "            <th class=\"th\">状态</th>\n" +
                "            <th class=\"th\">修改</th>\n" +
                "            <th class=\"th\">删除</th>\n" +
                "        </tr>"
            $("#TableOne").append(th)
            $.each(msg.data.list, function (key, obj) {
                // alert(obj.Staff_Pic);
                var tr = "<tr>";
                tr += " <td class=\"td\">" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.fID + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.fName + "</span> </td>";
                if (obj.fStatus == 1) {
                    tr += " <td class=\"td\" >" +
                        "<span style=\"text-align: center;display:block;\">" +
                        "启用</span> </td>";
                } else if (obj.fStatus == 2) {
                    tr += " <td class=\"td\" >" +
                        "<span style=\"text-align: center;display:block;\">" +
                        "禁用</span> </td>";
                } else {
                    tr += " <td class=\"td\" >" +
                        "<span style=\"text-align: center;display:block;\">" +
                        obj.fStatus + "</span> </td>";
                }

                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"修改\" id=" + obj.fID +
                    " class=\"easyui-linkbutton update \" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.fID + " class=\"delete\"/></span></td>";
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

//获取修改信息
$(document).on("click", ".update", function () {
    var fId = this.id;
    //document.getElementById('fID').setAttribute("disabled","disabled");
    $('#w').window('open');
    $.ajax({
        url: "/floor/getFloor",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "fID": fId
        }),
        dataType: "json",
        success: function (msg) {
            console.log("sssss", msg)
            $("#fID").val(msg.data.fID);
            $("#fName").val(msg.data.fName);
            getss(msg.data.fStatus)

        }
    });
});

function r() {
    //document.getElementById('fID').removeAttribute("disabled");
}

function getss(ss) {
    var status_select = document.getElementById("fStatus")
    if (ss == 1) {
        $("#fStatus option").remove()
        status_select.options.add(new Option("启用", 1))
        status_select.options.add(new Option("禁用", 2))
    } else {
        $("#fStatus option").remove()
        status_select.options.add(new Option("禁用", 2))
        status_select.options.add(new Option("启用", 1))
    }
}

function Update() {
    if ($("#fName").val() != "") {
        var fName = $("#fName").val();
        var fID = $("#fID").val();
        var fStatus = $("#fStatus").val();
        $.ajax({
            url: "/floor/updateFloor",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "fName": fName,
                "fID": fID,
                "fStatus": fStatus
            }),
            success: function (msg) {
                alert(msg.message);
                location.reload(); //刷新当前页面
                //updatePage(last);//添加刷新指向尾页
            }
        });
    } else {
        alert("请正确填写信息");
    }
};

//删除编号
$(document).on("click", ".delete", function () {
    var bID = this.id;
    if (confirm("您确定要删除此书架吗？")) {
        $.ajax({
            url: "/floor/delFloor",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "fID": bID
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