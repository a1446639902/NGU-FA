layui.use(['table', 'form', 'layer','laydate'], function () {
		var table = layui.table;
		var form = layui.form;
		var layer = layui.layer;
		var laydate=layui.laydate;
		var $ = layui.$;
		laydate.render({
			elem:'#addopen'
		});
		laydate.render({
			elem:'#addend'
		});
		laydate.render({
			elem:'#addopen2'
		});
		laydate.render({
			elem:'#addend2'
		});

		table.render({
			elem: '#myTable' //实例化表格的ID名称
			, url: '../account/selectAccount' //接收JSON数据的路径
			, toolbar: '#userToolBar' //开启头部工具栏，并为其绑定左侧模板
			, title: '用户数据表'//表格名称
			, cellMinWidth: 100
			, height:'full-30'
			, cols: [
				[ //表头既列名  title列名名称
					{type: 'checkbox', fixed: 'left'}
					,{field: 'blankCardCode', title: '银行卡号',width:220, align:'center'}
					,{field: 'accountName', title: '账户名称',width:220, align:'center'}
					,{field: 'blankName', title: '银行名称', width:170,align:'center',hide:true}
					,{field: 'deposit', title: '存款类型', width:170,align:'center',
					templet:function (item) {
						if(item.deposit==1){
							return '活期';
						}
						return '定期';
					}
				}
					,{field: 'cardRate', title: '卡号利率%',width:160, align:'center'}
					,{field: 'procisionDays', title: '计息期间',width:160, align:'center',
					templet:function (item) {
						if(item.procisionDays==1){
							return '360天';
						}else if(item.procisionDays==2){
							return '365天';
						}else if(item.procisionDays==3){
							return '366天';
						}
					}}
					,{field: 'openTime', title: '开户时间',width:160, align:'center'}
					,{field: 'endTime', title: '结束时间',width:150, align:'center',hide:true}
					,{field: 'accountDesc', title: '备注', width:150,align:'center',hide:true}
					,{fixed: 'right', title: '操作', align:'center',width:170, toolbar: '#barDemo'}
				]
			]
			, page: true//开启分页
		});
		//给工具条的按钮添加事件
		table.on('toolbar(myTable)', function (obj) {
			var userName = $("#userName").val();
			switch (obj.event) {
				case "search":
					var blankName=$('#blankName').val();
					var accountName=$('#accountName').val();
					table.reload('myTable', {
						method: 'post',
						page: {
							curr: 1
						},
						where:{
							'blankName':blankName,
							'accountName':accountName
						}
					});
					$('#blankName').val(blankName);
					$('#accountName').val(accountName);
					break;

				case "add":
					layer.open({
						type: 1,
						title: '新增现金账户设置',
						area: ['893px', '550px'],
						content: $("#addContent")
					});
					break;
				//删除多行
				case "deleteAll":
					//获得选中的对象
					var checkStatus = table.checkStatus("myTable"); //idTest 即为基础参数 id 对应的值
					// 其中 ID 为基础参数 id 对应的值（见：设定容器唯一ID）
					var accountIds = [];
					var dataArr = checkStatus.data; //获取选中行的数据
					$.each(dataArr, function (i, n) {
						accountIds.push(n.accountId);
					});
					if (dataArr.length == 0) {
						layer.msg("请先选中数据");
					}
					else {
						layer.confirm('真的删除行么', function () {
							layer.close();
							//向服务端发送删除指令
							$.post("../account/deleteAccount","accountId="+accountIds,function(msg){
								if(msg>0){
									table.reload('myTable');
									layer.closeAll();
									layer.msg('删除成功',{
										title : '提示',
										area : [ '200px',
											'140px' ],
										time : 0,
										btn : [ '知道了' ]
									});
								}
								else{
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
					break;
			}
		});
		//给表格编辑，删除按钮添加点击事件
		table.on('tool(myTable)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

			if (layEvent === 'del') { //删除
				layer.confirm('真的删除行么', function (index) {
					obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令
					$.post("../account/deleteAccount", "accountId="+data.accountId,function(msg){
						if(msg>0){
							table.reload('myTable');
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
					title: '修改现金账户设置',
					area: ['893px', '550px'],
					content: $("#editContent")
				});

			}

		});
		//新增提交
		form.on('submit(addsubmit)', function(data){
			var accounts=$('#addform').serialize();
			var addopen=new Date($('#addopen').val()).getTime();//获得开户日期
			var addend=new Date($('#addend').val()).getTime();//获得结束日期
			if(addopen>addend){
				layer.msg("开户日期不能先于结束日期。请重新选择");
			}
			else {
				$.post("../account/insertAccount", accounts, function (msg) {
					if (msg > 0) {
						table.reload('myTable');
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
			}
			$("#addform")[0].reset();
			return false;

		});


		//修改提交
		form.on('submit(editsubmit)',function () {
			var data = $('#editform').serialize();//获取表单区域所有值
			$.post("../account/updateAccount",data,function(msg){
				if(msg>0){
					table.reload('myTable');
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

	})
function myclose() {
	layer.closeAll();
}
