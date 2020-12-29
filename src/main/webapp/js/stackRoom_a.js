var fs = {};
var bt = {};
$(function () {
    $.ajax({
        url: "/floor/getFloorList",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "fName": ""
        }),
        success: function (msg) {
            console.log("ass", msg)
            $.each(msg.data.list, function (key, ob) {
                fs[ob.fID] = ob.fName;
            });
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
        url: "/stackRoom/getStackRoomList?" +
            "pageNum=" + page +
            "&pageSize=" + 5,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "srName": name
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
                var tr = "<tr>";
                tr += " <td class=\"td\">" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.srID + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.srName + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    fs[obj.fID] + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.srStatus + "</span> </td>";
                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"修改\" id=" + obj.srID +
                    " class=\"easyui-linkbutton update \" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.srID + " class=\"delete\"/></span></td>";
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
    var srId = this.id;
    document.getElementById('srID').setAttribute("disabled","disabled");
    $('#w').window('open');
    $.ajax({
        url: "/stackRoom/getStackRoom",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "srID": srId
        }),
        dataType: "json",
        success: function (msg) {
            console.log("sssss", msg)
            $("#srID").val(msg.data.srID);
            $("#srName").val(msg.data.srName);
            getSR(msg.data.fID);
            getss(msg.data.srStatus)

        }
    });
});

function getSR(f) {
    $.ajax({
        url: "/floor/getFloorList",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "fName": ""
        }),
        success: function (msg) {
            console.log("bbbbb", msg)
            var f_select = document.getElementById("fID")
            $("#fID option").remove()
            $.each(msg.data.list, function (key, ob) {
                if (f != 0&&f==ob.fID) {
                    f_select.options.add(new Option(ob.fName, ob.fID,true,true))
                } else {
                    f_select.options.add(new Option(ob.fName, ob.fID))
                }
            });
            console.log(f)
        }
    });
}

function  r(){
    document.getElementById('srID').removeAttribute("disabled");
}

function getss(ss) {
    var status_select = document.getElementById("srStatus")
    if (ss == 1) {
        $("#srStatus option").remove()
        status_select.options.add(new Option("启用", 1))
        status_select.options.add(new Option("禁用", 2))
    } else {
        $("#srStatus option").remove()
        status_select.options.add(new Option("禁用", 2))
        status_select.options.add(new Option("启用", 1))
    }
}

function Update(){
    if ($("#srName").val() != "") {
        var srName = $("#srName").val();
        var srID = $("#srID").val();
        var srStatus = $("#srStatus").val();
        var fID = $("#fID").val();
        $.ajax({
            url: "/stackRoom/updateStackRoom",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "srName": srName,
                "srID": srID,
                "srStatus": srStatus,
                "fID": fID
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
            url: "/stackRoom/delStackRoom",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "srID": bID
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