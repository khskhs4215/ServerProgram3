<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(function(){
			const f = $('#f');
			const title = $('#title');
			const author = $('#author');
			f.submit(function(event){
				if (author.val() == '') {
					alert('비정상적인 접근입니다.');
					history.back();
				} else if (title.val() == '') {
					alert('제목은 필수입니다.');
					title.focus();
					event.preventDefault();
					return false;
				}
			})
		})
	</script>
</head>
<body>
	<div class="container">
		<h1>게시글 작성하기</h1>
		<form action="insertBoard.jsp" id="f" method="post">
			<label>작성자</label><input type="text" name="author" id="author" value="${loginDTO.id}" readonly><br><br>
			<label>제목</label><input type="text" name="title" id="title" value="새 글입니다."><br><br>
			<textarea name="content" placeholder="새 내용입니다."></textarea><br><br>
			<button>작성하기</button>
			<input type="reset" value="작성초기화">
			<input type="button" value="목록보기" onclick="location.href='boardList.jsp'">
		</form>
	</div>
</body>
</html>