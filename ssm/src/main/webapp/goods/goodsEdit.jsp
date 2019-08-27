<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href="/ssm/assets/css/layui.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="/ssm/layui/layui.js"></script>
<script type="text/javascript" src="/ssm/js/jquery.js"></script>
<style type="text/css">
.layui-input{
	margin:5px;
}
 .layer-ext-myskin .layui-layer-content {
        overflow: visible;
}
</style>
<title>添加人员</title>
</head>
<body>
	<div class="" title="添加人员">
		<form action="" class="layui-form " method="post" id="fm"
			style="text-align: center; align-self: center; align-content: center;">
			<input type="hidden" name="gsumprice" id="gsumprice">
			<input type="hidden" name="gid" id="gid">
			<table cellpadding="5" style="margin-left: 70px">
				<tr>
					<td>商品名:</td>
					<td><input name="gname"  id="gname" class="layui-input" value=""
						data-options="required:true" missingMessage="商品类型名"></td>
				</tr>
				<tr>
					<td>商品进价:</td>
					<td><input name="gbprice"  id="gbprice" class="layui-input" value=""
						data-options="required:true" missingMessage="商品进价"></td>
				</tr>
				<tr>
					<td>进货数量:</td>
					<td><input name="gnum"  id="gnum" class="layui-input" value=""
						data-options="required:true" missingMessage="进货数量"></td>
				</tr>
				<tr><td>销售价格:</td>
					<td><input type="text" class="layui-input" name="gsprice" id="gsprice"></td></tr>
				<tr>
					<td>进货类型：</td>
					<td align="center"><select  class="layui-form" name="gclassid" id="gclassid">
					   
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="layui-btn"
						type="submit" lay-submit lay-filter="add" value="修改"></td>
				</tr>
			</table>
		</form>

	</div>
	<script type="text/javascript">
	var gn;
	function child(data){
		$("#gid").val(data.gid);
		$("#gname").val(data.gname);
		$("#gbprice").val(data.gbprice);
		$("#gnum").val(data.gnum);
		$("#gsprice").val(data.gsprice);
		gn = data.gclassname;
	}
	
	layui.use('form', function(){
	    getType();
	});
	 
	function getType(){
	    $.ajax({
	        url:'/ssm/goods/getType.action',
	        async:false,//设置为同步请求，不加这句可能会出错
	        type:'post',//method请求方式，get或者post
            dataType:'json',//预期服务器返回的数据类型
            contentType: "application/json; charset=utf-8",
	        success:function(res){
	        	
                for(var i =0;i<res.type.length;i++){
                	if(gn!=res.type[i].tname)
                    	$("#gclassid").append("<option value=\""+res.type[i].tid+"\">"+res.type[i].tname+"</option>");
                	else $("#gclassid").append("<option selected='selected' value=\""+res.type[i].tid+"\">"+res.type[i].tname+"</option>");
                }
                //重新渲染
                layui.form.render("select");
	        }
	    });
	}
	</script>
	<script type="text/javascript">
	 $(function  () {
         layui.use('form', function(){
           var form = layui.form;
           //监听提交
           form.on('submit(add)', function(data){
        	   var param=data.field;//定义临时变量获取表单提交过来的数据，非json格式
        	   var b = $("#gbprice").val();
        	   var n = $("#gnum").val();
        	   param.gsumprice=b*n;
               console.log(JSON.stringify(param));//测试是否获取到表单数据，调试模式下在页面控制台查看
               $.ajax({
                   url:"/ssm/goods/update.action",
                   type:'post',//method请求方式，get或者post
                   dataType:'json',//预期服务器返回的数据类型
                   async:false,//设置为同步请求，不加这句可能会出错
                   data:JSON.stringify(param),//表格数据序列化
                   contentType: "application/json; charset=utf-8",
                   success:function(res){//res为相应体,function为回调函数 
                     //$("#res").click();//调用重置按钮将表单数据清空
                	   window.parent.layer.closeAll();
                	   window.parent.$(".layui-laypage-btn").click();
                   },
                   error:function(){
                	   layer.closeAll();
                   }
                 });
               //return false;
               });//end form
               
        	 });//end layui.use
           });
	</script>
</body>
</html>