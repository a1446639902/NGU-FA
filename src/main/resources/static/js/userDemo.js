layui.use(['form', 'table'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;
    table.render({
        elem: '#currentTableId',
        url: 'selectUser',
        toolbar: '#toolbarDemo',
        defaultToolbar: ['filter', 'exports', 'print'],
        height:'full-70',
        cellMinWidth:60,
        cols: [
            [
                {type: "checkbox", width: 50},
                {field: 'userId', title: 'ID', sort: true},
                {field: 'userName', title: '用户名'},
                {field: 'userPwd', title: '密码', sort: true},
                {field: 'roleId', title: '角色ID'},
                {field: 'status', title: '启用状态'},
                {field: 'userInfoDesc', title: '备注', sort: true},
                {title: '操作', minWidth: 100, toolbar: '#currentTableBar', align: "center"}
            ]
        ],
        limits: [10, 15, 20, 25, 50, 100],
        limit: 15,
        page: true,
        skin: 'line'
    });

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = JSON.stringify(data.field);
        layer.alert(result, {
            title: '最终的搜索信息'
        });

        //执行搜索重载
        table.reload('currentTableId', {
            page: {
                curr: 1
            }
            , where: {
                searchParams: result
            }
        }, 'data');

        return false;
    });

    /**
     * toolbar监听事件
     */
    table.on('toolbar(currentTableFilter)', function (obj) {
        if (obj.event === 'add') {  // 监听添加操作
            var index = layer.open({
                title: '添加用户',
                type: 2,
                shade: 0.2,
                maxmin:true,
                shadeClose: true,
                area: ['100%', '100%'],
                content: 'page/addUserDemo',
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        } else if (obj.event === 'delete') {  // 监听删除操作
            var checkStatus = table.checkStatus('currentTableId')
                , data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        }
    });

    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });

    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {

            var index = layer.open({
                title: '编辑用户',
                type: 2,
                shade: 0.2,
                maxmin:true,
                shadeClose: true,
                area: ['100%', '100%'],
                content: '../page/table/edit.html',
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
            return false;
        } else if (obj.event === 'delete') {
            var name=obj.data.userName;
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: 'post',
                    url: './deleteUser',
                    data: {"userId":obj.data.userId},
                    success:function (object) {
                        if (object.msg==='success'){
                            obj.del();
                            layer.msg("用户 "+name+" 删除成功");
                        }else {
                            layer.msg("用户 "+name+" 删除失败");
                        }
                    }
                })
                layer.close(index);
            });
        }
    });

});