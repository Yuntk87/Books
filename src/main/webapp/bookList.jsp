<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookList</title>
</head>
<body>
<%@ include file="./navi.jsp" %>

	<div id="bookListBox" class="wrapper">
		<h2>도서목록</h2>
		<table>
			<tr>
				<th>도서번호</th>
				<th>도서이름</th>
				<th>대여자</th>
				<th>등록일자</th>
				<th></th>
			</tr>	
			<tr>
				<c:choose>
					<c:when test="${empty bList }" >
						<tr><td colspan="4">등록된 도서가 없습니다</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${bList }" var="b">
							<tr>
								<td>${b.book_num }</td>
								<td>
									<a href="./modify?bookNum=${b.book_num }">${b.book_name }</a>
								</td>
								<td>${b.location }</td>
								<td>${b.postDate }</td>
								<td>
									<input type="button" value="대출" onClick="location.href='./lendBook?bookNum=${b.book_num }'" ${b.chk_num eq 1? 'disabled' : '' }>
									<input type="button" value="반납" onClick="location.href='./return?bookNum=${b.book_num }'+'&location=${b.location }'" ${b.chk_num eq 0? 'disabled' : '' }>
								</td>
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