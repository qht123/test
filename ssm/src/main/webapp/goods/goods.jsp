<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/ssm/assets/css/layui.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="/ssm/layui/layui.js"></script>
<script type="text/javascript" src="/ssm/js/jquery.js"></script>

<title>Insert title here</title>
</head>
<!--头部工具栏-->
<script type="text/html" id="toolbarDemo">
	<div class="layui-inline">
       <label class="layui-form-label">商品名</label>
       <div class="layui-input-inline">
          <input style="height:38px;" type="text" name="gname" id="gname" placeholder="请输入商品名" autocomplete="off" class="layui-input-inline ">
          <button class="layui-btn layuiadmin-btn-goodsadmin" lay-event="find">查询</button>
          <button class="layui-btn layuiadmin-btn-goodsadmin" lay-event="add">添加</button>
       </div>
    </div>
</script>
<script type="text/html" id="barDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
    <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
  </div>
</script>
<body>
<table id="demo" lay-filter="test"></table>
<script>
//JS 调用：
function render(table){
	table.render({
		  elem: '#demo'
		  ,url: 'selAll.action'
			//头部工具栏
        ,toolbar: '#toolbarDemo'
	  	  ,title: '商品数据表'
	  	  ,height:'500px'
	  	  ,method:"post"
	  	  ,where:{txt:'tttttaa'}
		  ,cols: [[
		  {field:'gid', title:'编号', width:80}
		  ,{field:'gname', title:'名称', width:80}
		  ,{field:'gbprice', title:'进价', width:80}
		  ,{field:'gsprice', title:'售价', width:80}
		  ,{field:'gnum', title:'库存', width:80}
		  ,{field:'gsumprice', title:'总价', width:80}
		  ,{field:'gclassname', title:'类型', width:80}
		  ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
		  ]]
		  ,page: true
		  ,parseData: function(res){ //res 即为原始返回的数据
		    return {
		      "code": 0, //解析接口状态
		      "msg": "", //解析提示文本
		      "count": res.count, //解析数据长度
		      "data": res.data//解析数据列表
		    };
		  }
	})
}

function find(table,data){
	table.render({
		  elem: '#demo'
		  ,url: 'goodsFind.action'
			//头部工具栏
      ,toolbar: '#toolbarDemo'
	  	  ,title: '商品数据表'
	  	  ,height:'440px'
	  	  ,method:"post"
	  	  ,where:{gname:data}
		  ,cols: [[
		  {field:'gid', title:'编号', width:80}
		  ,{field:'gname', title:'名称', width:80}
		  ,{field:'gbprice', title:'进价', width:80}
		  ,{field:'gsprice', title:'售价', width:80}
		  ,{field:'gnum', title:'库存', width:80}
		  ,{field:'gsumprice', title:'总价', width:80}
		  ,{field:'gclassname', title:'类型', width:80}
		  ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
		  ]]
		  ,page: true
		  ,parseData: function(res){ //res 即为原始返回的数据
		    return {
		      "code": 0, //解析接口状态
		      "msg": "", //解析提示文本
		      "count": res.count, //解析数据长度
		      "data": res.data//解析数据列表
		    };
		  }
	})
}

function edit(data){
	//页面层
    layer.open({
        type: 2,
        title: '修改',
        shadeClose: true,
        shade: false,
        //maxmin: true, //开启最大化最小化按钮
        area: ['400px', '400px'],
        resize:false,//窗口大小可变
        content: '/ssm/goods/goodsEdit.jsp?',
        success: function(layero, index){
            var iframe = window['layui-layer-iframe' + index];
            iframe.child(data)
        }	    
      });
}

function add(){
	//页面层
    layer.open({
        type: 2,
        title: '增加表',
        shadeClose: true,
        shade: false,
        //maxmin: true, //开启最大化最小化按钮
        area: ['400px', '430px'],
        resize:false,
        content: '/ssm/goods/goodsAdd.jsp'
      });
}

function del(data){
	layer.confirm('真的删除行么', function(index){
        //关闭该 confirm 窗口
        layer.close(index);
        $.ajaxSettings.async = false;//设置为同步请求，不加这句可能会出错。
        //post请求,第一个参数为目标地址，第二个为提交参数，第三个为返回时执行的行数，第四个为数据格式写json
        $.post("del.action", {"cmd":"del","gid":data.gid}, function (data) { 
        }, "json");
        layer.alert("已删除姓名为"+data.gname+"的行");
        $(".layui-laypage-btn").click();
    });
}

function showtable(){
	layui.use('table', function(){
	  	var table = layui.table;
	  	render(table);
		//监听事件tool为行监听事件，toolbar为头监听事件
		
		table.on('tool(test)', function(obj){
		  var data = obj.data;
		  switch(obj.event){
		    case 'delete':
		      del(data);
		    break;
		    case 'update':
		      edit(data);
		    break;
		  };
		});
		
	  	table.on('toolbar(test)', function(obj){
	  	  var data = obj.data;
	  	  switch(obj.event){
	  	    case 'find':
	  	      layer.alert($("#gname").val());
	  	      find(table,$("#gname").val());
	  	    break;
	  	    case 'add':
	  	      add();
	  	    break;
	  	  };
	  	});
		
	});
}
showtable();
</script>
</body>
</html>





