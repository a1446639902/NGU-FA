$(function () {
    $.ajax({
        url:'../fund/selectFund',
        dataType:'json',
        type:'post',
        data:{page:1,limit:10},
        success:function(obj){
            $('#fundName').empty();
            $.each(obj.data,function(index,item){
                $('#fundName').append(new Option(item.fundName,item.fundId));//往下拉菜单里添加元素
                alert(item.fundName);
            });
            alert(11);
            form.render();//菜单渲染 把内容加载进去

        }
    })

})