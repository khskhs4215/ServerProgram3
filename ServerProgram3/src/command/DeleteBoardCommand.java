package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

			int no = Int.parseInt(request.getParameter("int"));
			
			int result = BoardDAO.getInstance().deleteBoard(no);
			ModelAndView mav = null;
			try {
				if(result == 0) {
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('댓글이 달린 게시글은 삭제할 수 없습니다.");
					out.println("history.back()");
					out.println("</script>");
				} else {
					mav = new ModelAndView("selectListBoardPage.do", true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mav;
			}

}
