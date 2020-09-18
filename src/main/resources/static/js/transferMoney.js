layui.use(['element', 'form', 'table', 'layer', 'laydate','tableSelect'], function () {
		var layer = layui.layer;
		var $ = layui.$;
		var table = layui.table;
		var form = layui.form;
		var tableSelect = layui.tableSelect;
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem: '#startDate'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#endDate'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#start'//指定元素
		});
		//表格加载
		table.render({
			elem: '#userTable',
			url: '../transferMoney/selectTransferMoney',
			page: true,
			toolbar: '#userToolBar',//显示在表头的工具条
			cellMinWidth:60,
			height:'full-30',
			cols: [
				[ //表头
					{type: 'checkbox', fixed: 'left'}
					,{field: 'transferMoneyId', title: '划款指令Id',align:'center',hide:true}
					,{field: 'foundId', title: '基金Id',align:'center',hide:true}
					,{field: 'outAccount', title: '划款账户Id',align:'center',hide:true}
					,{field: 'outBlankName', title: '划款账户的银行名称',align:'center',hide:true}
					,{field: 'inAccountId', title: '收款账户Id',align:'center',hide:true}
					,{field: 'inBlankName', title: '收款账户的银行名称',align:'center',hide:true}
					,{field: 'outBlankCardCode', title: '划款账户',align:'center',width: 210}
					,{field: 'inBlankCardCode', title: '接收账户',align:'center',width: 210}
					,{field: 'money', title: '划款金额',align:'center',width:190}
					,{field: 'crossSectionDate', title: '划款日期',width:200,align:'center'}
					,{field: 'accountingDate', title: '到账日期',width:200,align:'center'}
					,{field: 'purpose', title: '划款的用途',align:'center',width: 150,hide:true}
					,{fixed: 'right', title: '操作',width: 215, align:'center', toolbar: '#barDemo'}
				]
			]
		});
		//新增提交
		form.on('submit(addsubmit)', function(data){
			var formData=$('#addform').serialize();
			var startDate=new Date($('#startDate').val()).getTime();//获得划款日期
			var endDate=new Date($('#endDate').val()).getTime();//获得到账日期
			var inBlankCardCode=$('#inBlankCardCode').val();//获得收款账户名称
			var outBlankCardCode=$('#outBlankCardCode').val();//获得划款账户名称
			if(startDate>endDate){
				layer.msg("到账日期不能先于划款日期。请重新选择");

			}
			else if(inBlankCardCode==outBlankCardCode){
				layer.msg("收款账号不能与付款账号相同");
			}
			else {
				$.post("../transferMoney/insertTransferMoney",formData,function(msg){
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
			}
			$("#addform")[0].reset();
			return false;
		});

		//修改提交
		form.on('submit(editsubmit)', function(data){
			var formData=$('#editform').serialize();
			$.post("../user/updateUser",formData,function(msg){
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
		//给工具条的按钮添加事件
		table.on('toolbar(userTable)',function (obj) {
			//获取选中复选框的对象，
			var checkStatus=table.checkStatus(obj.config.id);//得到表格选中行的ID
			switch (obj.event) {
				case 'add':
					var index=layer.open({
						type: 1,
						title: '添加划款指令',
						closeBtn: 1,
						move:false,
						content:$("#addContent"),
						area:['700px','500px'],
						btn:[]
					});
					//全屏
					//layer.full(index);
					break;
				case 'search':
					var start= $("#start").val();
					//表格的重新加载事件
					table.reload('userTable', {
						method: 'post'
						, where: {
							'crossSectionDate': start
						}
						, page: {
							curr: 1
						}
					});
					$("#start").val(start);
					laydate.render({
						elem: '#start'//指定元素
					});
					break;
				case 'deleteAll':
					var data = checkStatus.data;
					//    layer.alert(JSON.stringify(data));
					if(data.length==0){
						layer.msg("请至少选择一条数据",)
					}else
					{
						var transferMoneyIds=[];
						for (var i = 0; i <data.length; i++) {
							transferMoneyIds.push(data[i].transferMoneyId);
						}
						layer.confirm('真的删除行么',{icon: 2}, function(index){
							layer.close(index);
							$.post("../transferMoney/deleteTransferMoney", {transferMoneyIds:transferMoneyIds.join(',')},function(msg){
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
					$.post("../transferMoney/deleteTransferMoney", {"transferMoneyIds":data.transferMoneyId},function(msg){
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
			} else if (obj.event === 'edit') {
				form.val('editform',$.parseJSON(JSON.stringify(data)));
				$('#BTitle').val('中国银行股份有限公司托管及投资则服务部:');
				$('#HTitle').val('敬请贵部根据以下提供的付/收款人名称、开户行、账号、到账日期、币种、和划款金额划款。');
				var index = layer.open({
					type: 1,
					title: '指令设置',
					closeBtn: 1,
					move:false,
					area:['700px','500px'],
					content:$('#editContent')
				});
				form.render();
			};
		})
		//收款账户的下拉列表
		tableSelect.render({
			elem:'#inBlankCardCode',
			checkedKey:'accountId',
			table:{
				url:'../account/selectAccount',
				cellMinWidth: 60,
				cols:[
					[   {type:'radio'},
						{field:'accountName',title:'账户名称',width:100},
						{field: 'blankCardCode',title:'银行卡号',width: 100},
						{field: 'blankName',title: '银行名称'},
						{field: 'accountId',title: '账号Id',hide:true}
					]
				]
			},
			done:function (elem,data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson=[];
				//遍历选中的数据
				$.each(data.data,function (index,item) {
					newJson.push(item.blankCardCode);
					$("#inAccountId").val(item.accountId);//给隐藏域收款账号Id中的val赋值
					$("#inBlankName").val(item.blankName);//给隐藏域收款账户银行名称中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})
		//划款账户的下拉列表
		tableSelect.render({
			elem:'#outBlankCardCode',
			checkedKey:'accountId',
			table:{
				url:'../account/selectAccount',
				cellMinWidth: 60,
				cols:[
					[   {type:'radio'},
						{field:'accountName',title:'账户名称',width:100},
						{field: 'blankCardCode',title:'银行卡号',width: 100},
						{field: 'blankName',title: '银行名称'},
						{field: 'accountId',title: '账号Id',hide:true}
					]
				]
			},
			done:function (elem,data) {
				//elem:返回之前input对象；data:表格返回的选中的数据 []
				var newJson=[];
				//遍历选中的数据
				$.each(data.data,function (index,item) {
					newJson.push(item.blankCardCode);
					$("#outAccountId").val(item.accountId);//给隐藏域划款账号Id中的val赋值
					$("#outBlankName").val(item.blankName);//给隐藏域划款账户银行名称中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})

		//生成指令excel
		form.on('submit(editsubmit)', function(data){
			//$('#outBlankName').val(data.outBlankName);
			var transferMoney=$('#editform').serialize();
			window.location.href="../transferOrderController/export?"+transferMoney;
			$('#editform')[0].reset();  //清空原有数据
			layer.closeAll();
			removeDate();
			return false;
		});

		form.on('select(title)', function(data){
			if($('#orderCheque').val()==1){
				$("#BTitleDiv").css("display","block");
				$("#HTitleDiv").css("display","block");
			}else{
				$("#BTitleDiv").css("display","none");
				$("#HTitleDiv").css("display","none");
			}
		});





	});
function myclose() {
	layer.closeAll();
}

