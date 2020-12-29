
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
        url: "/adm/getAdmList?" +
            "pageNum=" + page +
            "&pageSize=" + 5,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "admName": name
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
                    obj.admID + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.admName + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.tel + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.pID + "</span> </td>";
                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"修改\" id=" + obj.admID +
                    " class=\"easyui-linkbutton update \" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.admID + " class=\"delete\"/></span></td>";
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
    var sId = this.id;
    document.getElementById('admID').setAttribute("disabled","disabled");
    $('#w').window('open');
    $.ajax({
        url: "/adm/getAdm",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "admID": sId
        }),
        dataType: "json",
        success: function (msg) {
            console.log("sssss", msg)
            $("#admID").val(msg.data.admID);
            $("#admName").val(msg.data.admName);
            $("#tel").val(msg.data.tel);

        }
    });
});

function getSR(dep) {
    // $.ajax({
    //     url: "/department/getDepartmentList",
    //     type: "post",
    //     async: true,
    //     contentType: "application/json",
    //     dataType: "json",
    //     data: JSON.stringify({
    //         "depName": ""
    //     }),
    //     success: function (msg) {
    //         console.log("bbbbb", msg)
    //         var dep_select = document.getElementById("depID")
    //         $("#depID option").remove()
    //         $.each(msg.data.list, function (key, ob) {
    //             if (dep != 0&&dep==ob.depID) {
    //                 dep_select.options.add(new Option(ob.depName, ob.depID,true,true))
    //             } else {
    //                 dep_select.options.add(new Option(ob.depName, ob.depID))
    //             }
    //         });
    //         console.log(dep)
    //     }
    // });
}

function  r(){
    document.getElementById('admID').removeAttribute("disabled");
}

function getss(ss) {
    // var status_select = document.getElementById("status")
    // if (ss == 1) {
    //     $("#status option").remove()
    //     status_select.options.add(new Option("启用", 1))
    //     status_select.options.add(new Option("禁用", 2))
    // } else {
    //     $("#status option").remove()
    //     status_select.options.add(new Option("禁用", 2))
    //     status_select.options.add(new Option("启用", 1))
    // }
}

function Update(){
    if ($("#sName").val() != "") {
        var admID = $("#admID").val();
        var admName = $("#admName").val();
        var status = $("#password").val();
        var tel = $("#tel").val();
        $.ajax({
            url: "/adm/updateAdm",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "admID": admID,
                "admName": admName,
                "password": status,
                "tel": tel
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
            url: "/adm/deleteAdm",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "admID": bID
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