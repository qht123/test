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
<title>添加人员</title>
<style type="text/css">
.layui-input{
	margin:5px;
}
</style>
</head>
<body>
	<div class="" title="修改商品类型">
		<form action="" class="layui-form" method="post" id="fm"
			style="text-align: center; align-self: center; align-content: center;">
			<input type="hidden" id="tid" name="tid" value="${data.tid}">
			<table cellpadding="10px" style="margin-left: 70px">
				<tr>
					<td>商品类型名:</td>
					<td><input name="tname" id="tname" class=" textbox" value="${data.tname}"
						data-options="required:true" missingMessage="商品类型名必填"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="layui-btn"
						type="submit" lay-submit lay-filter="add" value="修改"></td>
				</tr>
			</table>
		</form>

	</div>
	</div>
	<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 10px;
	padding: 10px;
	box-sizing: content-box;
}
</style>
<script type="text/javascript">
function child(data){
	$("#tname").val(data.tname);
	$("#tid").val(data.tid);
}
</script>

<script type="text/javascript">
	 $(function  () {
         layui.use('form', function(){
           var form = layui.form;
           //监听提交
           form.on('submit(add)', function(data){
        	   var param=data.field;//定义临时变量获取表单提交过来的数据，非json格式
               console.log(JSON.stringify(param));//测试是否获取到表单数据，调试模式下在页面控制台查看
               $.ajax({
                   url:"/ssm/type/update.action",
                   type:'post',//method请求方式，get或者post
                   dataType:'json',//预期服务器返回的数据类型
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