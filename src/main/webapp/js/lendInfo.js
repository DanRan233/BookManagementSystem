$(function () {
    QueryLendInfo(1);
});

function QueryLendInfo(page) {
    name = $("#TextOne").val()
    $.ajax({
        url: "/lend/getLendList?"+
            "pageNum=" + page +
            "&pageSize=" + 5 ,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            "bID":name,
            "lStatus":3
        }),
        dataType: "json",
        success: function (msg) {

            $("#TableOne").empty();
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#969696;'>\n" +
                "            <th id=\"North_th-Two\" class=\"th\">书籍编号</th>\n" +
                "            <th id=\"North_th-Three\" class=\"th\">应还日期</th>\n" +
                "            <th id=\"North_th-Three\" class=\"th\">归还</th>\n" +
                "        </tr>"
            $("#TableOne").append(th)
            $.each(msg.data.list, function (key, obj) {
                var tr = "<tr>";
                tr += " <td class=\"td\">" +
                    "<span id=\"Staff_Code\" name=\"Staff_Code\"style=\"text-align: center;display:block;\">" +
                    obj.bID + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span id=\"Staff_No\" name=\"Staff_No\"style=\"text-align: center;display:block;\">" +
                    obj.lDate + "</span> </td>";
                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"归还\" id=" + obj.bID +
                    " class=\"easyui-linkbutton ret \" /></span></td>";
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
    QueryLendInfo(page);
}

//
$(document).on("click", ".ret", function () {
    var bID = this.id;
    if(confirm("您确定要归还该书本吗？")){
        $.ajax({
            url: "/return/addReturn",
            type: "post",
            async: true,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                "bID":bID
            }),
            dataType: "json",
            success: function (msg) {
                alert(msg.message)
                QueryLendInfo(1);
                console.log(msg)
            }
        });
    }else {

    }

});