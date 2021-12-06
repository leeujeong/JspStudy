package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;

public class BoardViewService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long no = Long.parseLong(request.getParameter("no"));
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("open") == null) {
			BoardDAO.getInstance().updateBoardHit(no);
			session.setAttribute("open", true);
		}
		
		request.setAttribute("board",BoardDAO.getInstance().selectBoardView(no));
		request.setAttribute("replyList", BoardDAO.getInstance().selectReplyList(no));
		
		return new ModelAndView("views/reply.jsp", false);
		}
	}