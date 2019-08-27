<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>增加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body layadmin-themealias="default">

	<div class="layui-form" lay-filter="layuiadmin-form-useradmin"
		id="layuiadmin-form-useradmin" style="padding: 20px 0 0 0;">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="username" lay-verify="required"
					placeholder="请输入用户名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="text" name="phone" lay-verify="phone"
					placeholder="请输入号码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" lay-filter="sex">
			<label class="layui-form-label">选择权限</label>
			<div class="layui-input-block">
				<input type="radio" name="power" value="男" title="男" checked="">
				<div class="layui-unselect layui-form-radio layui-form-radioed">
					<i class="layui-anim layui-icon"></i>
					<div>男</div>
				</div>
				<input type="radio" name="power" value="女" title="女">
				<div class="layui-unselect layui-form-radio">
					<i class="layui-anim layui-icon"></i>
					<div>女</div>
				</div>
			</div>
		</div>
		<div >
			  <button type="button" class="layui-btn layui-btn-warm">确认</button>
   			  <button type="button" class="layui-btn layui-btn-danger">取消</button>
		</div>
	</div>


	<script>
		
	</script>


</body>
</html>