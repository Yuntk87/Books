<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist</title>
</head>
<body>
<%@ include file="./navi.jsp" %>
	<div id="registBox" class="wrapper">
		<h2>도서 등록</h2>
		<form name="registFrm" action="./regist" method="post" onsubmit="return frmChk(this)">
			<table>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr class="btnbox">
					<td colspan="2">
						<button type="submint">등록</button>
						<button type="reset">다시쓰기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="./footer.jsp" %>
</body>

<script>
	function frmChk(frm) {
		if(frm.bookName.value=="") {
			alert("도서명이 입력되지 않았습니다.");
			frm.bookName.focus();
			return false;
		}
	}
</script>
</html>