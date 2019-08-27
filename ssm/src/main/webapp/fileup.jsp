<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/ssm/js/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<button onclick="findFile()" >浏览</button>
<button onclick="uptoFile()" >上传</button>
<form method="post" action="user/uptoFile.action" enctype="multipart/form-data" style="display: none">
	<input type="file" name="fl">
</form>
<div>
	<img class="upimg" src="">
</div>

<script type="text/javascript">
function findFile(){
	$("[name=fl]")[0].click();
}

function uptoFile(){
var formData = new FormData();
    formData.append("filett",$("[name=fl]")[0].files[0]);
    $.ajax({
        url:'user/uptoFile.action',
        type:'post',
        data: formData,
        processData: false,  // 告诉jQuery不要去处理发送的数据
        contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
        success:function(res){
           $(".upimg").attr("src",res);
        }
    });
}
</script>
</body>
</html>