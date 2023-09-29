<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserHistory</title>
</head>
<body>
<%@ include file="./navi.jsp" %>
	<div id="userHistoryBox" class="wrapper">
		<h2>회원이력조회</h2>
		<table>
			<tr>	
				<th>번호</th>
				<th>회원번호</th>
				<th>회원이름</th>
				<th>도서번호</th>
				<th>내용</th>
				<th>등록일자</th>
			</tr>	
			<tr>
				<c:choose>
					<c:when test="${empty hList }" >
						<tr><td colspan="6">회원이력이 없습니다</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${hList }" var="h">
							<tr>
								<td>${h.his_num }</td>
								<td>${h.user_num }</td>
								<td>${h.name }</td>
								<td>${h.book_num }</td>
								<td>${h.return_num == 0? '반납' : '대출'}</td>
								<td>${h.postDate }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</div>
	
	
<%@ include file="./footer.jsp" %>
</body>
</html>