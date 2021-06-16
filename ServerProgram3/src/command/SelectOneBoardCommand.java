package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

public class SelectOneBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		int no = Int.parseInt(request.getParameter("no"));
		
		
		BoardDTO dto = BoardDAO.getInstance().selectOneBoardByNo(no);
		
		
		BoardDAO.getInstance().updateHit(no);
		
		
		request.setAttribute("dto", dto);

		
		ModelAndView mav = new ModelAndView("/board/viewBoard.jsp", false);  // forward
		return mav;
		
	}

}
