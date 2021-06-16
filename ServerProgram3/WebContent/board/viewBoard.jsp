<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("utf-8"); %>

	<jsp:param value="${dto.idx}번 게시글" name="title" />



<script>
	$(document).ready(function(){
		const delete_btn = $('#delete_btn');
		delete_btn.click(function(){
			if (confirm('게시글을 삭제할까요?')) {
				location.href='/ServerProgram3/deleteBoard.do?no=${dto.no}';
			}
		})
	})
</script>
<div class="board_view">
	<div class="board_content">
		<p class="title">작성자</p>
		${dto.author}<br><br>
		<p class="title">작성자IP</p>
		${dto.ip}<br><br>
		
		<p class="title">조회수</p>
		${dto.hit}<br><br>
		<p class="title">제목</p>
		${dto.title}<br><br>
		<p class="title">내용</p>
		<pre>${dto.content}</pre><br><br>	
	</div>
	
</div>
<div>	
		<input type="button" value="목록보기" onclick="location.href=/ServerProgram3/selectBoardList.do">
		<input type="button" value="삭제하기" id="delete_btn">
</div>

<div class="reply_form">
	<form action="/ServerProgram3/insertReply.do" method="post">
		 
		<textarea name="content" placeholder="댓글을 입력하세요."></textarea>
		<textarea name="text" placeholder="작성자."></textarea>
		<button>작성</button>
	</form>
</div>

<div class="reply_list">	
	<table>
		<tbody>
			<c:forEach var="replyDTO" items="${replyLlist}">
				<tr>
					<td>${replyDTO.content}</td>
					<td>${replyDTO.author}</td>
					<td>${replyDTO.ip}</td>
					<td>${replyDTO.postdate}</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

