layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#test'
        ,url:'./selectUser'
        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页

        }
        ,cols: [[
            {field:'userId', width:80, title: 'ID', sort: true}
            ,{field:'userName', width:100, title: '用户名'}
            ,{field:'userPwd', width:80, title: '密码', sort: true}
            ,{field:'roleId', width:80, title: '角色ID'}
            ,{field:'status', title: '状态', minWidth: 150}
            ,{field:'userInfoDesc', width:80, title: '备注', sort: true}
        ]]

    });
});