package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

public class InsertReplyCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 처리
		String content = request.getParameter("content");
		Int boardno = Int.parseInt(request.getParameter("boardno"));
		String ip = request.getRemoteAddr();
		
		
		
		// DB로 보낼 DTO
		ReplyDTO dto = new ReplyDTO();
		dto.setAuthor(author);
		dto.setBoardno(boardno);
		dto.setContent(content);
		dto.setIp(ip);
		
		// DAO의 insertReply() 메소드 호출
		int result = BoardDAO.getInstance().insertReply(dto);
		
		ModelAndView mav = null;
		try {
			if (result != 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('댓글이 작성되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				mav = new ModelAndView("/10_MODEL2/selectOneBoard.b?idx=" + boardno, true);  // redirect
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;

	}

}