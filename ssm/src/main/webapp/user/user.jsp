<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/ssm/js/jquery.js"  ></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">

function userAdd(){
	location.href="/ssm/user/userAdd.jsp";
}

function userUpdata(uid){
	location.href="/ssm/user/edit.action?uid=" + uid;
}
	
function userFind(){
	var uname = document.getElementById("uname").value;
	alert(uname);
	$.ajaxSettings.async = false;//设置为同步请求，不加这句可能会出错。
	$.post("/ssm/user/userFind.action", {"uname":uname}, function (data) {
		alert("OK");
	    $("table tbody").empty();
	    alert(data[0].uname);
		for(var i = 0;i<data.length;i++){
			var u = data[i];
			if(u.sex == "1"){
				u.sex = "男";
			}else{
				u.sex = "女";
			}
			if(u.power == "1"){
				u.power = "管理员";
			}else{
				u.power = "操作员";
			}
			var t =	$("<tr align='center' "+
					"<td>"+u.uid+"</td>"+
			        "<td>"+u.uname+"</td>"+
			        "<td>"+u.pwd+"</td>"+
					"<td>"+u.sex+"</td>"+
					"<td>"+u.age+"</td>"+
					"<td>"+u.birth+"</td>"+
					"<td>"+u.power+"</td>"+
					"<td>"+u.sales+"</td>"+
					"<td><input style='width:60px;height: 30px' type='button' class='btn btn-danger' value='删除' onclick='deleteById(${user.uid},${user.power})' ></td>"+
					"<td><input style='width:60px;height: 30px'  type='button' class='btn btn-primary' onclick='userUpdata(${user.uid},${user.power},${user.age},${user.birth},${user.sex})' value='修改'></td>"+
			        "</tr> ");
			$("table tbody").append(t);
		}
    }, "json");
    
}

	
</script>
<body>
	<div align="center" >
	 	
	 	<input  type="button" value="添加" onclick="userAdd()">
	 	<input type="text" class="uname" style="display: inline-block;width: 250px;" class="form-control " placeholder="输入操作员姓名" name="uname" id="uname" value=""  />
		<input class="btn btn-primary active" type="button" value="查询" onclick="userFind()">
	</div>
    <table class="tablelist" >
    	<thead >
    	<tr align="center">
        <th>用户ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>出生日期</th>
        <th>权限</th>
        <th>销售额</th>
        <th>删除</th>
        <th>修改</th>
        </tr>
        </thead>
        <tbody>
        
       	<c:forEach items="${users}" var= "user" varStatus="vs">
       	<tr align="center"   >
       	<td>${user.uid}---${vs.index}</td>
        <td>${user.uname}</td>
        <td>${user.pwd}</td>
        <td>${user.sex}</td>
		<td>${user.age}</td>
		<td>${user.birth}</td>
		<td>${user.power}</td>
		<td>${user.sales}</td>
		<td><form action="del.action" method="post" class="fm1" >
			<input type="hidden" name="uid" value="${user.uid}" />
			<input style="width:60px;height: 30px" type="submit" class="btn btn-danger" value="删除" >
		</form></td>
		<td><input style="width:60px;height: 30px"  type="button" class="btn btn-primary" onclick="userUpdata(${user.uid})" value="修改"></td>
        </tr> 
       	</c:forEach>
        
        </tbody>
    </table>
    
</body>
</html>