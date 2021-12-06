package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class UpdateService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long no = Long.parseLong(request.getParameter("no"));
		BoardDAO.getInstance().updateBoardHit(no);
		
		return null;
	}

}
