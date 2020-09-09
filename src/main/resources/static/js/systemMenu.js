layui.use(function(){
    var $ = layui.jquery;
    $.ajax({
        type: 'post',
        url: 'systemMenu/selectSystemMenu',
        success:function (obj) {
            var str = "";
            for (var systemMenuFu in obj) {
                if (systemMenuFu.parentId=0){
                   str= str+"         <li>\n" +
                       "                <a href=\"javascript:;\">\n" +
                       "                    <i class=\"iconfont left-nav-li\" lay-tips=\""+[[systemMenuFu.title]]+"\">"+[[systemMenuFu.icon]]+"</i>\n" +
                       "                    <cite>"+[[systemMenuFu.title]]+"</cite>\n" +
                       "                    <i class=\"iconfont nav_right\">&#xe697;</i></a>";

                   for (var systemMenuZi in obj){
                       if (systemMenuZi.parentId=systemMenuFu.functionId){
                           str=str+"<ul class=\"sub-menu\">\n" +
                               "                    <li>\n" +
                               "                        <a onclick=\"xadmin.add_tab('"+[[systemMenuZi.title]]+"','"+[[systemMenuZi.src]]+"')\">\n" +
                               "                            <i class=\"iconfont\">&#xe6a7;</i>\n" +
                               "                            <cite>"+[[systemMenuZi.title]]+"</cite></a>\n" +
                               "                    </li>\n" +
                               "                </ul>\n" +
                               "            </li>"
                       }
                   }
                }
            }
            $("#nav").append(str);
        }
    })
});