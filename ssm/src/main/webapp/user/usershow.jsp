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
       <label class="layui-form-label">用户名</label>
       <div class="layui-input-inline">
          <input style="height:38px;" type="text" name="uname" id="uname" placeholder="请输入用户名" autocomplete="off" class="layui-input-inline ">
          <button class="layui-btn layuiadmin-btn-useradmin" lay-event="find">查询</button>
          <button class="layui-btn layuiadmin-btn-useradmin" lay-event="add">添加</button>
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
	  	  ,title: '用户数据表'
	  	  ,height:'500px'
	  	  ,method:"post"
	  	  ,where:{txt:'tttttaa'}
		  ,cols: [[
		  {field:'uid', title:'编号', width:80}
		  ,{field:'uname', title:'姓名', width:80}
		  ,{field:'pwd', title:'密码', width:120}
		  ,{field:'sex', title:'性别', width:80}
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
		  ,url: 'userFind.action'
			//头部工具栏
      ,toolbar: '#toolbarDemo'
	  	  ,title: '用户数据表'
	  	  ,height:'400px'
	  	  ,method:"post"
	  	  ,where:{uname:data}
		  ,cols: [[
		  {field:'uid', title:'编号', width:80}
		  ,{field:'uname', title:'姓名', width:80}
		  ,{field:'pwd', title:'密码', width:120}
		  ,{field:'sex', title:'性别', width:80}
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
        title: '很多时候，我们想最大化看，比如像这个页面。',
        shadeClose: true,
        shade: false,
        //maxmin: true, //开启最大化最小化按钮
        area: ['400px', '400px'],
        resize:false,//窗口大小可变
        content: '/ssm/user/userEdit.jsp?',
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
        title: '很多时候，我们想最大化看，比如像这个页面。',
        shadeClose: true,
        shade: false,
        //maxmin: true, //开启最大化最小化按钮
        area: ['400px', '400px'],
        resize:false,
        content: '/ssm/user/userAdd.jsp'
      });
}

function del(data){
	layer.confirm('真的删除行么', function(index){
        //关闭该 confirm 窗口
        layer.close(index);
        $.ajaxSettings.async = false;//设置为同步请求，不加这句可能会出错。
        //post请求,第一个参数为目标地址，第二个为提交参数，第三个为返回时执行的行数，第四个为数据格式写json
        $.post("del.action", {"cmd":"del","uid":data.uid}, function (data) { 
        }, "json");
        layer.alert("已删除姓名为"+data.uname+"的行");
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
	  	      layer.alert($("#uname").val());
	  	      find(table,$("#uname").val());
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





