layui.use(['form'],function(){
    var $ = layui.jquery;
    $.ajax({
        type: 'post',
        url: '../systemMenu/selectSystemMenu',
        dataType:'json',
        success:function (data) {
           /* alert(11)
            alert(data)*/
            var str = "";
            $.each(data,function (index,sysMenuF) {
                if (sysMenuF.parentId===0){
                    str= str+"<li>\n" +
                        "                <a href=\"javascript:;\">\n" +
                        "                    <i class=\"iconfont left-nav-li\" lay-tips=\""+[[sysMenuF.title]]+"\">"+[[sysMenuF.icon]]+"</i>\n" +
                        "                    <cite>"+[[sysMenuF.title]]+"</cite>\n" +
                        "                    <i class=\"iconfont nav_right\">&#xe697;</i></a>\n" +
                        "                <ul class=\"sub-menu\">" ;
                    $.each(data,function (index,sysMenuZ) {
                        if (sysMenuZ.parentId===sysMenuF.functionId){
                            str=str+"<li>\n" +
                                "                        <a onclick=\"xadmin.add_tab('"+[[sysMenuZ.title]]+"','"+[[sysMenuZ.src]]+"')\">\n" +
                                "                            <i class=\"iconfont\">&#xe6a7;</i>\n" +
                                "                            <cite>"+[[sysMenuZ.title]]+"</cite></a>\n" +
                                "                    </li>"
                        }
                    })
                    str = str+"</ul>\n" +
                        "            </li>";
                }
            })
            alert(str);
            $("#nav").append(str);
        }
    });
});