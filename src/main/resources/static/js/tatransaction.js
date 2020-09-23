layui.use(['element', 'form', 'table', 'layer', 'laydate','upload'], function () {
	var layer = layui.layer;
	var $ = layui.$;
	var table = layui.table;
	var form = layui.form;
	var formSelects = layui.formSelects;
	var laydate = layui.laydate;
	var upload = layui.upload;
	//执行一个laydate实例
	laydate.render({
		elem: '#start' //指定元素
	});
	//执行一个laydate实例
	laydate.render({
		elem: '#start1' //指定元素
	});
	//执行一个laydate实例
	laydate.render({
		elem: '#start2' //指定元素
	});

	//新增提交
	form.on('submit(addsubmit)', function(data){
		var formData=$('#addform').serialize();
		alert("表单数据：" + formData);

		$.post("../insertTatTransaction",formData,function(msg){
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
		return false;
	});
	//修改提交
	form.on('submit(editsubmit)', function(data){
		var formData=$('#editform').serialize();
		alert("修改提交的数据：" + formData);
		$.post("../updateTaTransaction",formData,function(msg){
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
		url: '../selectTaTransaction',
		page: true,
		height: 'full-30',
		toolbar: '#userToolBar',//显示在表头的工具条
		minLength:80,
		cellMinWidth:60,
		cols: [
			[ //表头
				{type: 'checkbox', fixed: 'left'}
				,{field: 'taTransactionId', title: '交易数据编号', width:110, align:'center'}
				,{field: 'fundId', title: '基金', width:110, align:'center'}
				,{field: 'accountId', title: '现金账户', width: 110, align:'center'}
				,{field: 'dateTime', title: '交易日期', width:110, align:'center'}
				,{field: 'fundNum', title: '数量', width: 110, align:'center'}
				,{field: 'balanceDate', title: '结算日期', width:110, align:'center'}
				,{field: 'totalMoney', title: '总金额', width: 110, align:'center'}
				,{field: 'actualMoney', title: '实际金额', width: 110, align:'center'}
				,{field: 'price', title: '单价', width: 110, align:'center'}
				,{field: 'cost', title: '费用', width: 110, align:'center'}
				,{field: 'agencies', title: '代销机构' , width: 110, align:'center' ,templet:function (item) {
					if (item.agencies=='1'){
						return '建设银行';
					}else if (item.agencies=='2'){
						return '工商银行';
					}else if (item.agencies=='3'){
						return '农业银行';
					}
				}}
				,{field: 'transactionType',title:'类型' ,width: 110,align :'center',templet:function (item) {
					if (item.transactionType=='1'){
						return '认购';
					}else if (item.transactionType=='2'){
						return '申购';
					}else if (item.transactionType=='3'){
						return '赎回';
					}
				}}
				,{field: 'transactionStatus',title:'状态' ,width: 110,align :'center',templet:function (item) {
					if(item.transactionStatus=='1'){
						return '已结算';
					}else  if(item.transactionStatus=='0'){
						return '未结算';
					}
				}}
				,{fixed: 'right', title: '操作',width: 150, align:'center', toolbar: '#barDemo'}
			]
		]
	});
	//文件上传
	upload.render({
		elem: '#addSG'
		,url: '/uploadTA' //改成您自己的上传接口
		,data: {}
		,accept: 'file'     //允许上传的文件类型
		,acceptMime: 'application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
		,exts: 'xls|xlsx'   //文件后缀
		,size: 10000           //最大允许上传的文件大小
		,done: function(res, index, upload){ //上传后的回调
			layer.alert(res.msg);
			table.reload('userTable', {});
			return;
		}
	});
	//给工具条的按钮添加事件
	table.on('toolbar(userTable)',function (obj) {
		//获取选中复选框的对象，
		var checkStatus=table.checkStatus(obj.config.id);//得到表格选中行的ID
		switch (obj.event) {
			case 'add':
				var index=layer.open({
					type: 1,
					title: '添加交易数据',
					closeBtn: 1,
					move:false,
					content:$("#addContent"),
					btn:[],
					area:['800px','610px']
				});

				form.render();
				//全屏
				// layer.full(index);
				break;
			case 'search':
				alert("搜索");
				var dateTime= $("#start").val();
				var transactionStatus= $("#transactionStatus").val();
				var transactionType=$("#transactionType").val();
				alert(dateTime);
				alert(transactionStatus);
				alert(transactionType);
				//表格的重新加载事件
				table.reload('userTable', {
					method: 'post'
					, where: {
						'dateTime': dateTime,
						'transactionStatus':transactionStatus,
						'transactionType':transactionType
					}
					, page: {
						curr: 1
					}
				});
				$("#start").val(dateTime);
				$("#transactionStatus").val(transactionStatus);
				$("#transactionType").val(transactionType);
				break;
			case 'deleteAll':
				var data = checkStatus.data;
				//    layer.alert(JSON.stringify(data));
				if(data.length==0){
					layer.msg("请至少选择一条数据",)
				}else
				{
					var ids=[];
					for (var i = 0; i <data.length; i++) {
						ids.push(data[i].taTransactionId);
					}
					layer.confirm('真的删除行么',{icon: 2}, function(index){
						layer.close(index);
						$.post("../deleteTaTransaction", {taTransactionId:ids.join(',')},function(msg){
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
		alert(data.taTransactionId);
		if (obj.event === 'del') {
			if (data.transactionStatus == 1) {
				layer.msg('已处理业务无法删除');
			} else if (data.transactionStatus == 0){
				layer.confirm('真的删除行么',{icon: 2}, function(index){
					layer.close(index);
					$.post("../deleteTaTransaction", {taTransactionId:data.taTransactionId+""},function(msg){
						table.reload('userTable');
					});

				});
			}


		} else if (obj.event === 'edit') {
			alert(JSON.stringify(data));

			form.val('editform',$.parseJSON(JSON.stringify(data)));
			var index = layer.open({
				type: 1,
				title: '修改交易信息',
				closeBtn: 1,
				move:false,
				area:['800px','610px'],

				content:$('#editContent')
			});

			form.render();
			//layer.full(index);
		};
	})
});

function quxiao() {
	layer.closeAll();
}