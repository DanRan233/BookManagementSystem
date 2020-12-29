var sr = {};
var bt = {};
$(function () {
    $.ajax({
        url: "/stackRoom/getStackRoomList",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "srName": ""
        }),
        success: function (msg) {
            console.log("ass", msg)
            $.each(msg.data.list, function (key, ob) {
                sr[ob.srID] = ob.srName;
            });
            console.log(sr)
        }
    });

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
        url: "/bookRack/getBookRackList?" +
            "pageNum=" + page +
            "&pageSize=" + 5,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "brName": name,
            "status": 1
        }),
        success: function (msg) {
            console.log(msg);
            $("#TableOne").empty();
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#969696;'>\n" +
                "            <th class=\"th\">编号</th>\n" +
                "            <th class=\"th\">书架名称</th>\n" +
                "            <th class=\"th\">所属书库</th>\n" +
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
                    obj.brID + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.brName + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    sr[obj.srID] + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.brStatus + "</span> </td>";
                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"修改\" id=" + obj.brID +
                    " class=\"easyui-linkbutton update \" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.brID + " class=\"delete\"/></span></td>";
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
    var brId = this.id;
    document.getElementById('brID').setAttribute("disabled","disabled");
    $('#w').window('open');
    $.ajax({
        url: "/bookRack/getBookRack",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "brID": brId
        }),
        dataType: "json",
        success: function (msg) {
            console.log("sssss", msg)
            $("#brID").val(msg.data.brID);
            $("#brName").val(msg.data.brName);
            getSR(msg.data.srID);
            getss(msg.data.brStatus)

        }
    });
});

function getSR(sr) {
    $.ajax({
        url: "/stackRoom/getStackRoomList",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "srName": ""
        }),
        success: function (msg) {
            console.log("bbbbb", msg)
            var sr_select = document.getElementById("srID")
            $("#srID option").remove()
            $.each(msg.data.list, function (key, ob) {
                if (sr != 0&&sr==ob.srID) {
                    sr_select.options.add(new Option(ob.srName, ob.srID,true,true))
                } else {
                    sr_select.options.add(new Option(ob.srName, ob.srID))
                }
            });
            console.log(sr)
        }
    });
}

function  r(){
    document.getElementById('brID').removeAttribute("disabled");
}

function getss(ss) {
    var status_select = document.getElementById("brStatus")
    if (ss == 1) {
        $("#brStatus option").remove()
        status_select.options.add(new Option("启用", 1))
        status_select.options.add(new Option("禁用", 2))
    } else {
        $("#brStatus option").remove()
        status_select.options.add(new Option("禁用", 2))
        status_select.options.add(new Option("启用", 1))
    }
}

function Update(){
    if ($("#brName").val() != "") {
        var brName = $("#brName").val();
        var brID = $("#brID").val();
        var brStatus = $("#brStatus").val();
        var srID = $("#srID").val();
        $.ajax({
            url: "/bookRack/updateBookRack",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "brName": brName,
                "brID": brID,
                "brStatus": brStatus,
                "srID": srID
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
            url: "/bookRack/delBookRack",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "brID": bID
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