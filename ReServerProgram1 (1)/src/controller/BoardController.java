package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardListService;
import model.BoardService;
import model.BoardViewService;
import model.DeleteBoardService;
import model.InsertBoardService;
import model.InsertReplyService;
import model.UpdateService;

@WebServlet("*.do")


public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();                     /*   /BATCH/student/list.do   */    
		String contextPath = request.getContextPath();                   /*   /BATCH                   */
		String command = requestURI.substring(contextPath.length() + 1); /*   student/list.do          */
		
		ModelAndView mav = null;
		BoardService service = null;
		
		switch (command) {
		case "boardList.do" :
			service = new BoardListService();
			break;
		case "view.do" :
			service = new BoardViewService();
			break;
		case "insertForm.do" :
			mav = new ModelAndView("views/insert.jsp", false);
			break;
		case "insert.do" :
			service = new InsertBoardService();
			break;
		case "delete.do" :
			service = new DeleteBoardService();
			break;
		case "insertReply.do" :
			service = new InsertReplyService();
			break;
		case "updateBoardHit.do" :
			service = new UpdateService();
			break;
		}
		
		if (service != null) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}