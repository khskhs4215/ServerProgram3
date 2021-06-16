<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
	$(document).ready(function(){		
		const new_btn = $('#new_btn');
		new_btn.click(function(){
			location.href = '/ServerProgram3/goinsertBoard.do';
		})
		
	})
</script>
</head>
<body>
		<input type="button" value="새글쓰기" id="new_btn">
		<br><br>
		
		<p>전체 게시글 : ${totalRecord}개</p>
		<table>
		<thead>
			<tr>
				<td>게시글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>최종수정일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}" varStatus="k">				
				<c:if test="${dto.state == 0}">
				<tr>
					<td>${seq - k.index}</td>
					<td><a href="/ServerProgram3/selectOneBoard.do">${dto.title}</a></td>
					<td>${dto.author}</td>
					<td>${dto.date}</td>
					<td>${dto.hit}</td>					
				</tr>
				</c:if>
			</c:forEach>
		</tbody>		
	</table>
</body>
</html>