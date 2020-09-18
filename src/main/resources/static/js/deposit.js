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
			elem: '#end'//指定元素
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#up'//指定元素

		});
		//新增提交
		form.on('submit(addsubmit)', function (data) {
			var formData = $('#addform').serialize();
			$.post("../deposit/insertDeposit", formData, function (msg) {
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

		table.render({
			elem: '#userTable',
			url: '../deposit/selectDeposit',
			page: true,
			height: 'full-30',
			toolbar: '#userToolBar',//显示在表头的工具条
			cellMinWidth: 60,
			minLength: 80,
			cols: [
				[ //表头
					{field: 'businessDate', title: '业务时间', width: 110, align: 'center'},
					{field: 'fundId', title: '基金Id', width: 110, align: 'center', hide: true}
					, {field: 'outAccountId', title: '流出账户Id', width: 150, align: 'center', hide: true}
					, {field: 'outAccountName', title: '流出账户', width: 190, align: 'center'}
					, {field: 'inAccountId', title: '流入账户Id', width: 150, align: 'center', hide: true}
					, {field: 'inAccountName', title: '流入账户', width: 205, align: 'center'}
					, {field: 'depositId', title: '存款业务Id', width: 165, align: 'center', hide: true}
					, {field: 'money', title: '存款金额', width: 110, align: 'center'}
					, {
					field: 'businessType', title: '业务类型', width: 95, align: 'center',
					templet: function (item) {
						if (item.businessType == 1) {
							return '定期三天'
						} else if (item.businessType == 2) {
							return '定期七天'
						} else if (item.businessType == 3) {
							return '活期'
						}
					}
				}
					, {field: 'endDate', title: '到期日期', width: 110, align: 'center'}
					, {
					field: 'flag', title: '是否处理', width: 95, align: 'center',
					templet: function (item) {
						if (item.flag == 0) {
							return '未办理'
						} else if (item.flag == 1) {
							return '已办理'
						}
					}
				}
					, {field: 'right', title: '操作', width: 180, align: 'center', toolbar: '#barDemo'}
				]
			]
		});
		//给工具条的按钮添加事件
		table.on('toolbar(userTable)', function (obj) {
			//获取选中复选框的对象，
			var checkStatus = table.checkStatus(obj.config.id);//得到表格选中行的ID
			switch (obj.event) {
				case 'add':
					var index = layer.open({
						type: 1,
						title: '添加存款业务',
						closeBtn: 1,
						move: false,
						content: $("#addContent"),
						area: ['893px', '550px'],
						btn: []
					});
					form.render();
					//全屏
					/* layer.full(index);*/
					break;
				case 'search':

					var businessType = $("#searchBusinessType").val();
					var dateEnd = $("#start").val();
					//表格的重新加载事件
					table.reload('userTable', {
						method: 'post'
						, where: {
							'businessType': businessType,
							'dateEnd': dateEnd
						}
						, page: {
							curr: 1
						}
					});
					laydate.render({
						elem: '#start'
					});
					$("#searchBusinessType").val(businessType);
					$("#start").val(dateEnd);

					break;
				case 'deleteAll':
					var data = checkStatus.data;
					//    layer.alert(JSON.stringify(data));
					if (data.length == 0) {
						layer.msg("请至少选择一条数据",)
					} else {
						var ids = [];
						for (var i = 0; i < data.length; i++) {
							ids.push(data[i].userId);
						}
						layer.confirm('真的删除行么', {icon: 2}, function (index) {
							layer.close(index);
							$.post("../user/deleteUser", {userId: ids.join(',')}, function (msg) {
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
		table.on('tool(userTable)', function (obj) {
			var data = obj.data;//得到删除行整行的数据
			var endDateHaoMiao = new Date(data.endDate).getTime();//获得到期日期的时间
			var dateTimeHaoMiao = new Date(data.businessDate).getTime();//获得业务日期时间
			var nowTimeHaoMiao = new Date().getTime();//获得当前日期的时间

			/* alert(data.userId);*/
			if (obj.event === 'del') {
				if (data.flag == 1) {
					layer.msg('已处理业务无法删除');
				} else if (data.flag == 0) {
					layer.confirm('真的删除行么', {icon: 1}, function (index) {
						layer.close(index);
						$.post("../deposit/deleteDeposit", "depositId=" + data.depositId, function (msg) {
							if (msg > 0) {
								layer.msg('删除成功');
							} else {
								layer.msg('出现一个错误处理失败');
							}
							table.reload('userTable');
						});


					});
				}
			} else if (obj.event === 'edit') {
				if (data.flag == 1) {
					layer.msg('已处理不可重复操作');
				} else if (endDateHaoMiao > nowTimeHaoMiao && data.businessType != 3) {
					layer.msg('存款未到期无法处理');
				} else {
					layer.confirm('确认对此存款进行到期处理?', {icon: 1}, function (index) {
						layer.close(index);
						$.post("../deposit/updateDeposit", data, function (msg) {
							if (msg > 0) {
								layer.msg('已处理');
							} else {
								layer.msg('出现一个错误处理失败');
							}
						});
						table.reload('userTable');
					});
				}
				layer.full(index);
			}


		})
		//新增流出账号的下拉表格
		tableSelect.render({
			elem: '#insertBlankCardCode',
			checkedKey: 'blankCardCode',
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
					newJson.push(item.blankCardCode);
					$("#insertOutAccountId").val(item.accountId);//给隐藏域中的val赋值
					$("#insertOutAccountName").val(item.accountName);//给账户名称中的val赋值
					$("#outBlankName").val(item.blankName);//给银行名称中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})
		//新增流入账户的下拉表格
		tableSelect.render({
			elem: '#insertInBlankCardCode',
			checkedKey: 'blankCardCode',
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
					newJson.push(item.blankCardCode);
					$("#insertInAccountId").val(item.accountId);//给隐藏域中的val赋值
					$("#insertInAccountName").val(item.accountName);//给账户名称中的val赋值
					$("#inBlankName").val(item.blankName);//给银行名称中的val赋值
				});
				elem.val(newJson.join(","));//给输入框里显示的值赋值

			}
		})


		//定期存款日期
		form.on('select(type)', function(data){
			if ($('#end').val()!=""){
				if ($('#businessType2').val() == 1) {
					day = 3;
					setTimeout(function () {
						var date1 = new Date($('#end').val()).getTime();
						date2 = date1 + 1000 * 60 * 60 * 24 * day;
						var endDate = new Date(date2);
						var endYear = endDate.getFullYear();
						var endMonth = endDate.getMonth() + 1;
						var endday = endDate.getDate();
						var endTime = endYear+"-"+buling(endMonth)+"-"+buling(endday);
						$('#up').val(endTime);
					}, 300);
				} else if ($('#businessType2').val() == 2) {
					day = 7;
					setTimeout(function () {
						var date1 = new Date($('#end').val()).getTime();
						date2 = date1 + 1000 * 60 * 60 * 24 * day;
						var endDate = new Date(date2);
						var endYear = endDate.getFullYear();
						var endMonth = endDate.getMonth() + 1;
						var endday = endDate.getDate();
						var endTime = endYear+"-"+buling(endMonth)+"-"+buling(endday);
						$('#up').val(endTime);
					}, 300);
				}
			}

		});




	});

function myclose() {
	layer.closeAll();
}
function buling(data) {
	if (data < 10) {
		return data = "0" + data;
	} else {
		return data;
	}
};
function myDate() {
	layui.use('form',function () {
		var $=layui.$;
		var a=$('#businessType2').val();

		if($('#businessType2').val()== 1) {

			day = 3;
			setTimeout(function () {
				var date1 = new Date($('#end').val()).getTime();
				date2 = date1 + 1000 * 60 * 60 * 24 * day;
				var endDate = new Date(date2);
				var endYear = endDate.getFullYear();
				var endMonth = endDate.getMonth() + 1;
				var endday = endDate.getDate();
				var endTime = endYear+"-"+buling(endMonth)+"-"+buling(endday);
				$('#up').val(endTime);
			}, 300);
		}
		else if ($('#businessType2').val() == 2) {
			day = 7;
			setTimeout(function () {
				var date1 = new Date($('#end').val()).getTime();
				date2 = date1 + 1000 * 60 * 60 * 24 * day;
				var endDate = new Date(date2);
				var endYear = endDate.getFullYear();
				var endMonth = endDate.getMonth() + 1;
				var endday = endDate.getDate();
				var endTime = endYear+"-"+buling(endMonth)+"-"+buling(endday);
				$('#up').val(endTime);
			}, 300);
		}
	})

};
