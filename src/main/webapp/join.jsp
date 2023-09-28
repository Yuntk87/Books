<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<style>
	#join_box {
		border: 1px solid black;
		border-radius: 5px;
		width : 300px;
		margin: 15% auto;
		padding: 10px;
		text-align: center;
	}
	.btnbox {
		margin-top: 30px;
	}
	button {
		font-size: 5px;
	}
</style>
</head>
<body>
	<div id="join_box">
		<form id="joinFrm" action="./join" method="post" onsubmit="return frmChk(this)">
			<h3>회원가입</h3>
			<div>
				<input type="text" placeholder="이름" id="name" name="name" autofocus/>
			</div>
			<div>
				<input type="password" placeholder="비밀번호" id="password" name="password"/>
			</div>
			<div class="btnbox">
				<button type="submit" id="join_sub">가입하기</button>
				<button type="button" id="join" onclick="location.href='./main.jsp'">로그인</button>
			</div>
		</form>
	</div>
</body>
<script>
	function frmChk(frm) {
		if(frm.name.value=="") {
			alert("이름이 입력되지 않았습니다.");
			frm.name.focus();
			return false;
		} else if(frm.password.value=="") {
			alert("비밀번호가 입력되지 않았습니다.");
			frm.password.focus();
			return false;
		}
	}
</script>
</html>