layui.use(['element', 'form', 'table', 'layer', 'laydate','tableSelect'], function () {
		var layer = layui.layer;
		var $ = layui.$;
		var table = layui.table;
		var form = layui.form;
		var tableSelect = layui.tableSelect;
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem: '#start'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#end'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#end1'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#end2'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#up'//指定元素
		});
		//新增提交
		form.on('submit(addsubmit)', function(data){
			var formData=$('#addform').serialize();
			$.post("../bankTreasurer/insertBankTreasurer",formData,function(msg){
				if(msg>0){
					table.reload('userTable');
					layer.closeAll();
					layer.msg('添加成功',{
						title : '提示',
						area : [ '200px',
							'140px' ],
						time : 0,
						btn : [ '知道了' ]
					});
				}else{
					layer.closeAll();
					layer.msg('添加失败',{
						title : '提示',
						area : [ '200px',
							'140px' ],
						time : 0,
						btn : [ '知道了' ]
					});
				}
			});
			$("#addform")[0].reset();
			return false;
		});
		//修改提交
		form.on('submit(editsubmit)', function(data){
			var formData=$('#editform').serialize();
			$.post("../bankTreasurer/updateBankTreasurer",formData,function(msg){
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
			return false;
		});
		table.render({
			elem: '#userTable',
			url: '../bankTreasurer/selectBankTreasurer',
			page: true,
			height:'full-30',
			toolbar: '#userToolBar',//显示在表头的工具条
			minLength:80,
			cellMinWidth:60,
			cols: [
				[ //表头
					{type: 'checkbox', fixed: 'left'}
					,{field: 'bankTreasurerId', title: '资金调拨Id', width:150,align:'center',hide:true}
					,{field: 'fundId', title: '基金Id', width:150,align:'center',hide:true}
					,{field: 'accountId', title: '现金账户Id', width:120,align:'center',hide:true}
					,{field: 'accountName', title: '现金账户名称', width:200,align:'center'}
					,{field: 'allocatingType', title: '调拨类型', width:150,align:'center'
					,templet:function (item) {
						if(item.allocatingType==1){
							return '存款利息';
						}
						else if(item.allocatingType==2){
							return  '申购赎回清算款';
						}
						else if(item.allocatingType==3){
							return '买卖交易清算款';
						}
						else if(item.allocatingType==4){
							return '债券利息';
						}
						else if(item.allocatingType==5){
							return '存款业务';
						}
						else if(item.allocatingType==6){
							return '两费';
						}
					}}
					,{field: 'flag', title: '调拨方向', width: 120,align:'center'
					,templet:function (item) {
						if(item.flag==1){
							return '流入';
						}
						else if(item.flag==-1){
							return  '流出';
						}

					}}
					,{field: 'totalPrice', title: '调拨总数额', width: 150,align:'center'}
					,{field: 'dateTime', title: '业务日期', width:120,align:'center'}
					,{field: 'dbTime', title: '调拨日期', width:120,align:'center'}
					,{field: 'businessId', title: '业务标号', width:120,align:'center',hide:true}
					,{field: 'bankTreasurerDesc', title: '备注', width:120,align:'center',hide:true}
					,{field: 'right', title: '操作',width: 187, align:'center', toolbar: '#barDemo'}
				]
			]
		});
		//给工具条的按钮添加事件
		table.on('toolbar(userTable)',function (obj) {
			//获取选中复选框的对象，
			var checkStatus=table.checkStatus(obj.config.id);//得到表格选中行的ID
			switch (obj.event) {
				case 'add':
					var index=layer.open({
						type: 1,
						title: '添加资金调拨',
						closeBtn: 1,
						move:false,
						content:$("#addContent"),
						area: ['893px', '550px'],
						btn:[]
					});
					break;
				case 'search':
					var dbTime=$("#start").val();
					var allocatingType= $("#allocatingType").val();
					var flag=$("#flag").val();
					//表格的重新加载事件
					table.reload('userTable', {
						method: 'post'
						, where: {
							'dbTime': dbTime,
							'allocatingType': allocatingType,
							'flag': flag
						}
						, page: {
							curr: 1
						}
					});
					$("#start").val(dbTime);
					$("#allocatingType").val(allocatingType);
					$("#flag").val(flag);
					//执行一个laydate实例
					laydate.render({
						elem: '#start'//指定元素
					});
					break;
				case 'deleteAll':
					var checkStatus = table.checkStatus("userTable"); //idTest 即为基础参数 id 对应的值
					var data = checkStatus.data;
					//    layer.alert(JSON.stringify(data));
					if(data.length==0){
						layer.msg("请至少选择一条数据",)
					}else
					{
						var bankTreasurerIds=[];
						for (var i = 0; i <data.length; i++) {
							bankTreasurerIds.push(data[i].bankTreasurerId);
						}
						layer.confirm('真的删除行么',{icon: 2}, function(index){
							layer.close(index);
							$.post("../bankTreasurer/deleteBankTreasurer", {bankTreasurerIds:bankTreasurerIds.join(',')},function(msg){
								table.reload('userTable');
								layer.msg('删除'+checkStatus.data.length+'条记录', {
									title:'提示',
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
		table.on('tool(userTable)', function(obj) {
			var data = obj.data;//得到删除行整行的数据
			if (obj.event === 'del') {
				layer.confirm('真的删除行么',{icon: 2}, function(index){
					layer.close(index);
					$.post("../bankTreasurer/deleteBankTreasurer", {"bankTreasurerIds":data.bankTreasurerId},function(msg){
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
			else if (obj.event === 'edit') {
				form.val("editform",data);//第二个参数可以是json字符串也可以是json对象
				var index = layer.open({
					type: 1,
					title: '修改资金调拨',
					closeBtn: 1,
					move:false,
					area: ['893px', '550px'],
					content:$('#editContent')
				});

			};
		});
		//修改的下拉表格
		tableSelect.render({
			elem:'#updateAccountName',
			checkedKey:'accountName',
			table:{
				url:'../account/selectAccount',
				cellMinWidth: 60,
				cols:[
					[   {type:'radio'},
						{field:'accountName',title:'账户名称',width:100},
						{field: 'blankCardCode',title:'银行卡号',width: 100},
						{field: 'blankName',title: '银行名称'},
						{field: 'accountId',title: '账号Id',hidden:true}
					]
				]
			},
			done:function (elem,data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson=[];
				//遍历选中的数据
				$.each(data.data,function (index,item) {
					newJson.push(item.accountName);
					$("#updateAccountId").val(item.accountId);//给隐藏域中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})
		//新增的下拉表格
		tableSelect.render({
			elem:'#insertAccountName',
			checkedKey:'accountName',
			table:{
				url:'../account/selectAccount',
				cellMinWidth: 60,
				cols:[
					[   {type:'radio'},
						{field:'accountName',title:'账户名称',width:100},
						{field: 'blankCardCode',title:'银行卡号',width: 100},
						{field: 'blankName',title: '银行名称'},
						{field: 'accountId',title: '账号Id',hidden:true}
					]
				]
			},
			done:function (elem,data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson=[];
				//遍历选中的数据
				$.each(data.data,function (index,item) {
					newJson.push(item.accountName);
					$("#insertAccountId").val(item.accountId);//给隐藏域中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})





	});
function myclose() {
	layer.closeAll();
}

