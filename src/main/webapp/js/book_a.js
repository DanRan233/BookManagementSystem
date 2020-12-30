var pr = {};
var bt = {};
var br = {}
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


//bookInfo.js
function queryPage_book(page) {
    // alert(name+":参数:");
    // getdp();
    name = $("#TextOne").val()

    $.ajax({
        url: "/book/getBookList?" +
            "pageNum=" + page +
            "&pageSize=" + 5,
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
                    "<input type=\"button\"value =\"修改\" id=" + obj.bID +
                    " class=\"easyui-linkbutton update \" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.bID + " class=\"del\"/></span></td>";
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
    document.getElementById('brID').setAttribute("disabled", "disabled");
    $('#w').window('open');
    $.ajax({
        url: "/book/getBook",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "bID": brId
        }),
        dataType: "json",
        success: function (msg) {
            console.log("sssss", msg)
            $("#bID").val(msg.data.bID);
            $("#bName").val(msg.data.bName);
            $("#bNumber").val(msg.data.bNumber);
            $("#author").val(msg.data.author);
            $("#pubDate").val(msg.data.pubDate);
            $("#brID").val(msg.data.brID);
            getSR(msg.data.prID);
            getss(msg.data.btID)

        }
    });
});

function getSR(sr) {
    $.ajax({
        url: "/press/getPressList",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "srName": ""
        }),
        success: function (msg) {
            console.log("bbbbb", msg)
            var sr_select = document.getElementById("prID")
            $("#prID option").remove()
            $.each(msg.data.list, function (key, ob) {
                if (sr != 0 && sr == ob.srID) {
                    sr_select.options.add(new Option(ob.prName, ob.prID, true, true))
                } else {
                    sr_select.options.add(new Option(ob.prName, ob.prID))
                }
            });
            console.log(sr)
        }
    });
}

function r() {
    document.getElementById('brID').removeAttribute("disabled");
}

function getss(sr,br) {
    $.ajax({
        url: "/bookType/getBookTypeList",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "srName": ""
        }),
        success: function (msg) {
            console.log("bbbbb", msg)
            var sr_select = document.getElementById("btID")
            $("#btID option").remove()
            $.each(msg.data.list, function (key, ob) {
                if (br != 0 && br == ob.sbtID) {
                    sr_select.options.add(new Option(ob.btName, ob.btID, true, true))
                } else {
                    sr_select.options.add(new Option(ob.btName, ob.btID))
                }
            });
            console.log(sr)
        }
    });
    $.ajax({
        url: "/bookRack/getBookRackList",
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "brName": ""
        }),
        success: function (msg) {
            console.log(msg)
            var sr_select = document.getElementById("brID")
            $.each(msg.data.list, function (key, ob) {
                $("#brID option").remove()
                $.each(msg.data.list, function (key, ob) {
                    if (sr != 0 && sr == ob.brID) {
                        sr_select.options.add(new Option(ob.brName, ob.brID, true, true))
                    } else {
                        sr_select.options.add(new Option(ob.brName, ob.brID))
                    }
                });

            });
            console.log(pr)
        }
    });
}

function Update() {
    if ($("#bName").val() != "") {
        var bID = $("#bID").val();
        var bName = $("#bName").val();
        var bNumber = $("#bNumber").val();
        var author = $("#author").val();
        var pubDate = $("#pubDate").val();
        var brID = $("#brID").val();
        var btID = $("#btID").val();
        var prID = $("#prID").val();
        $.ajax({
            url: "/book/updateBook",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "bID": bID,
                "bName": bName,
                "bNumber": bNumber,
                "author": author,
                "pubDate": pubDate,
                "brID": brID,
                "btID": btID,
                "prID": prID,
                "status": 1
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