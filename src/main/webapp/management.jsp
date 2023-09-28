<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management</title>
</head>
<body>
<%@ include file="./navi.jsp" %>
	<div id="managementBox" class="wrapper">
		<h2>도서 관리</h2>
		<form id="searchBookFrm" action="./modify">
			<table>
				<tr style="border: none;">
					<td style="border: none;">
						<input type="text" name="bookNum" value="${dto.book_num }">
						<button type="submit">검색</button>
					</td>
				</tr>
			</table>
		</form>
		
		
		<form name="modifyFrm" action="./modify" method="post" onsubmit="return frmChk(this)">
			<table>
			<tr>
				<th>도서번호</th>
				<th>도서이름</th>
				<th>대여자</th>
				<th>등록일자</th>
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
								<input type="text" value="${dto.book_name }" name="bookName">
							</td>
							<td>
								<input type="text" value="${dto.location }" name="location">
							</td>
							<td>
								<input type="text" value="${dto.postDate }" name="postDate" readonly>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tr>
				<tr class="btnbox">
					<td colspan="4">
						<button type="submint">수정</button>
						<button type="button" onclick="delChk(${dto.book_num})">삭제</button>
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
	
	function delChk(num) {
		if(confirm(num + "번 도서를 삭제하시겠습니까?")) {
			window.location.href="./delete?bookNum="+num;
			alert("삭제성공");
		}
	}
</script>
</html>