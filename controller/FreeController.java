package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.free.FreeDeleteService;
import service.free.FreeFindService;
import service.free.FreeInsertService;
import service.free.FreeListService;
import service.free.FreeService;
import service.free.FreeUpdateService;
import service.free.FreeViewService;
import service.free.ReplyInsertService;


@WebServlet("*.free")
public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FreeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//JSP 요청확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() +1);
		
	
		FreeService service= null;

		ModelAndView mav = null;
 
		switch(command) {
		case "list.free" :
			service = new FreeListService();
			break;
		case "insertForm.free" :
			mav = new ModelAndView("free/insert.jsp", false);
			break;
		case "insert.free" :
			service = new FreeInsertService();
			break;
		case "view.free" :
			service = new FreeViewService();
			break;
		case "updateForm.free" :
			mav = new ModelAndView("free/update.jsp", false);
			break;
		case "update.free" :
			service = new FreeUpdateService();
			break;
		case "delete.free" :
			service = new FreeDeleteService();
			break;
		case "insertReply.free":
			service = new ReplyInsertService();
			break;
		case "find.free" :
			service = new FreeFindService();
			break;

		}
		
		//service가 사용되지 않은 경우(단순이동) service실행이 불가능
		if(service != null) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//mav가 null인경우
		//1. model(service)에서 응답으로 이동하는경우
		//2. model(service)이 ajax 응답을 하는경우
		if(mav == null) {
			return;
		}
		//mav가 null이 아닌경우 : MVC패턴으로 페이지 이동있음
		if(mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		}else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
