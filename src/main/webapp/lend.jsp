<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lend</title>
</head>
<body>
<%@ include file="./navi.jsp" %>
	<div id="LendBox" class="wrapper">
		<h2>도서 대출</h2>
		<form name="lendFrm" action="./lendBook" method="post" onsubmit="return frmChk(this)">
			<table>
			<tr>
				<th>도서번호</th>
				<th>도서이름</th>
				<th>대여자</th>
			</tr>	
			<tr>
				<c:choose>
					<c:when test="${empty dto }" >
						<tr><td colspan="4">등록된 도서가 없습니다</td></tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>
								<input type="text" value="${dto.book_num }" name="bookNum" readonly>
							</td>
							<td>
								<input type="text" value="${dto.book_name }" name="bookName" readonly>
							</td>
							<td>
								<input type="text" name="location">
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tr>
				<tr class="btnbox">
					<td colspan="4">
						<button type="submint">대출</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="./footer.jsp" %>
</body>

<script>
	function frmChk(frm) {
		if(frm.location.value=="") {
			alert("대여자가 입력되지 않았습니다.");
			frm.location.focus();
			return false;
		}
	}
</script>
</html>