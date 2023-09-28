<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserList</title>
</head>
<body>
<%@ include file="./navi.jsp" %>
	<div id="userListBox" class="wrapper">
		<h2>회원목록</h2>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원이름</th>
				<th>비밀번호</th>
				<th>등록일자</th>
			</tr>	
			<tr>
				<c:choose>
					<c:when test="${empty uList }" >
						<tr><td colspan="4">등록된 회원이 없습니다</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${uList }" var="u">
							<tr>
								<td>${u.user_num }</td>
								<td>${u.name }</td>
								<td>${u.password }</td>
								<td>${u.postDate }</td>
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