layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tableSelect'], function () {
		var layer = layui.layer;
		var $ = layui.$;
		var table = layui.table;
		var form = layui.form;
		var tableSelect = layui.tableSelect;
		var laydate = layui.laydate;


		laydate.render({
			elem: '#start'
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#addtime'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#updateTime'//指定元素

		});

		//新增提交
		form.on('submit(addsubmit)', function (data) {
			var formData = $('#addform').serialize();
			$.post("../insertSecuritiesClosedPayInventory", formData, function (msg) {
				if (msg > 0) {
					table.reload('userTable');
					layer.closeAll();
					layer.msg('添加成功', {
						title: '提示',
						area: ['200px',
							'140px'],
						time: 0,
						btn: ['知道了']
					});
				} else {
					layer.closeAll();
					layer.msg('添加失败', {
						title: '提示',
						area: ['200px',
							'140px'],
						time: 0,
						btn: ['知道了']
					});
				}
			});
			$("#addform")[0].reset();
			return false;
		});

		//修改提交
		form.on('submit(editsubmit)',function () {
			var data = $('#editform').serialize();//获取表单区域所有值
			$.post("../updateSecuritiesClosedPayInventory",data,function(msg){
				if(msg>0){
					table.reload('userTable');
					layer.closeAll();
					layer.msg('修改成功',{
						title : '提示',
						area : [ '200px',
							'140px' ],
						time : 0,
						btn : [ '知道了' ]
					});
				}else{
					layer.closeAll();
					layer.msg('修改失败',{
						title : '提示',
						area : [ '200px',
							'140px' ],
						time : 0,
						btn : [ '知道了' ]
					});
				}

			});
			return false;//解决弹出层闪退问题
		});

		table.render({
			elem: '#userTable',
			url: '../selectSecuritiesClosedPayInventory',
			page: true,
			height: 'full-30',
			toolbar: '#userToolBar',//显示在表头的工具条
			cellMinWidth: 60,
			minLength: 80,
			cols: [
				[
					{type: 'checkbox', fixed: 'left'}
					, {field : 'securitiesClosedPayInventoryId', align : 'center', width : 200, title : '证券存库Id', hide:true}
					, {field : 'fundId', align : 'center', title : '基金代码', hide:true}
					, {field : 'dateTime', align : 'center', title : '业务日期'}
					, {field : 'securitiesId', title : '证券信息表ID ', align : 'center',hide:true}
					, {field : 'securitiesName', title : '证券名称 ', align : 'center'}
					, {field : 'securitiesType', title : '证券应收应付类型', align : 'center',
					templet:function (item) {
						if(item.securitiesType==1){
							return '估值款'
						}
						else if(item.securitiesType==2){
							return '证券清算款'
						}
						else if(item.securitiesType==3){
							return '债券利息'
						}
					}}
					, {field : 'flag', title : '业务状态 ', align : 'center',
					templet : function(item) {
						if (item.flag == 1) {
							return '流入';
						}
						return '流出';
					}
				}
					, {field : 'totalPrice', title : '总金额', align : 'center'}
					, {field : 'securityPeriodFlag', title : '期初标志 ', align : 'center',
					templet : function(item) {
						if (item.securityPeriodFlag == 1) {
							return '是';
						}
						else if(item.securityPeriodFlag == 0) {
							return '否'
						}
					}
				}
					, {fixed : 'right', title : '操作', align : 'center', toolbar : '#barDemo', width : 180}
				]
			]
		});
		//给工具条的按钮添加事件
		table.on('toolbar(userTable)', function (obj) {
			//获取选中复选框的对象，
			var checkStatus = table.checkStatus(obj.config.id);//得到表格选中行的ID
			switch (obj.event) {
				case 'add':
					layer.open({
						type: 1,
						title: '新增证券应收应付库存',
						area: ['893px', '550px'],
						content: $("#addContent")
					});
					form.render();
					//全屏
					/* layer.full(index);*/
					break;
				case 'search':
					var securitiesType = $("#securitiesType").val();
					var dateTime = $("#start").val();
					//表格的重新加载事件
					table.reload('userTable', {
						method: 'post'
						, where: {
							'dateTime': dateTime,
							'securitiesType': securitiesType
						}
						, page: {
							curr: 1
						}
					});
					$("#securitiesType").val(securitiesType);
					$("#start").val(dateTime);
					laydate.render({
						elem: '#start'
					});

					break;
				case 'deleteAll':
					var data = checkStatus.data;
					//    layer.alert(JSON.stringify(data));
					if (data.length == 0) {
						layer.msg("请至少选择一条数据",)
					} else {
						var securitiesClosedPayInventoryIds = [];
						for (var i = 0; i < data.length; i++) {
							securitiesClosedPayInventoryIds.push(data[i].securitiesClosedPayInventoryId);
						}
						layer.confirm('真的删除行么', {icon: 2}, function (index) {
							layer.close(index);
							$.post("../deleteSecuritiesClosedPayInventory", {securitiesClosedPayInventoryIds: securitiesClosedPayInventoryIds.join(',')}, function (msg) {
								table.reload('userTable');
								layer.msg('删除' + checkStatus.data.length + '条记录', {
									title: '提示',
									area: ['200px', '140px'],
									time: 0,
									btn: ['知道了']
								});
							});
						});
					}
					break;
			}
		});
		//给表格编辑，删除按钮添加点击事件
		table.on('tool(userTable)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

			if (layEvent === 'del') { //删除
				layer.confirm('真的删除行么', function (index) {
					obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令
					$.post("../deleteSecuritiesClosedPayInventory", "securitiesClosedPayInventoryIds="+data.securitiesClosedPayInventoryId,function(msg){
						if(msg>0){
							table.reload('userTable');
							layer.closeAll();
							layer.msg('删除成功',{
								title : '提示',
								area : [ '200px',
									'140px' ],
								time : 0,
								btn : [ '知道了' ]
							});
						}else{
							layer.closeAll();
							layer.msg('删除失败',{
								title : '提示',
								area : [ '200px',
									'140px' ],
								time : 0,
								btn : [ '知道了' ]
							});
						}

					});
					return false;
				});
			}
			else if(layEvent=="edit"){
				form.val("editform",data);//第二个参数可以是json字符串也可以是json对象
				layer.open({
					type: 1,
					title: '修改证券应收应付库存',
					area: ['893px', '550px'],
					content: $("#editContent")
				});

			}

		});
		//新增现金账号的下拉表格
		tableSelect.render({
			elem: '#addAccountName',
			checkedKey: 'accountId',
			table: {
				url: '../account/selectAccount',
				cellMinWidth: 60,
				cols: [
					[{type: 'radio'},
						{field: 'accountName', title: '账户名称', width: 200},
						{field: 'blankCardCode', title: '银行卡号', width: 200},
						{field: 'blankName', title: '银行名称'},
						{field: 'accountId', title: '账号Id', hide: true}
					]
				]
			},
			done: function (elem, data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson = [];
				//遍历选中的数据
				$.each(data.data, function (index, item) {
					newJson.push(item.accountName);
					$("#addAccountId").val(item.accountId);//给隐藏域中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})
		//新增证券编号的下拉表格
		tableSelect.render({
			elem: '#addSecuritiesName',
			checkedKey: 'securitiesId',
			table: {
				url: '../selectSecurities',
				cellMinWidth: 60,
				cols: [
					[{type: 'radio'},
						{field: 'securitiesId', title: '证券编号', width: 200},
						{field: 'securitiesName', title: '证券名称', width: 200}
					]
				]
			},
			done: function (elem, data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson = [];
				//遍历选中的数据
				$.each(data.data, function (index, item) {
					newJson.push(item.securitiesName);
					$("#addSecuritiesId").val(item.securitiesId);//给隐藏域中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})

		//修改现金账号的下拉表格
		tableSelect.render({
			elem: '#updateAccountName',
			checkedKey: 'accountId',
			table: {
				url: '../account/selectAccount',
				cellMinWidth: 60,
				cols: [
					[{type: 'radio'},
						{field: 'accountName', title: '账户名称', width: 200},
						{field: 'blankCardCode', title: '银行卡号', width: 200},
						{field: 'blankName', title: '银行名称'},
						{field: 'accountId', title: '账号Id', hide: true}
					]
				]
			},
			done: function (elem, data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson = [];
				//遍历选中的数据
				$.each(data.data, function (index, item) {
					newJson.push(item.accountName);
					$("#updateAccountId").val(item.accountId);//给隐藏域中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})
		//修改证券编号的下拉表格
		tableSelect.render({
			elem: '#updateSecuritiesName',
			checkedKey: 'securitiesId',
			table: {
				url: '../selectSecurities',
				cellMinWidth: 60,
				cols: [
					[{type: 'radio'},
						{field: 'securitiesId', title: '证券编号', width: 200},
						{field: 'securitiesName', title: '证券名称', width: 200}
					]
				]
			},
			done: function (elem, data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson = [];
				//遍历选中的数据
				$.each(data.data, function (index, item) {
					newJson.push(item.securitiesName);
					$("#updateSecuritiesId").val(item.securitiesId);//给隐藏域中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})

	});

function myclose() {
	layer.closeAll();
}

