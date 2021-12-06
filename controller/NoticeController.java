package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.notice.DeleteNoticeService;
import service.notice.InsertNoticeService;
import service.notice.NoticeFindService;
import service.notice.NoticeListService;
import service.notice.NoticeService;
import service.notice.NoticeViewService;
import service.notice.UpdateNoticeService;


@WebServlet("*.notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//JSP 요청확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() +1);
		
		//모든 Model은 인터페이스NoticeModel을 구현하므로 NoticeService타입의 객체이다.
		NoticeService service= null;
		//단순이동을 요청하고 모든 Model(service)는 modelAndView 를 반환하므로  modelAndView 객체 선언
		ModelAndView mav = null;
		
		//해당 요청을 처리할  Model(Service)선택. 
		switch(command) {
		case "list.notice" :
			service = new NoticeListService();
			break;
		case "view.notice" : 
			service = new NoticeViewService();
			break;
		case "insertForm.notice" : 
			mav = new ModelAndView("notice/insert.jsp",false);
			break;
		case "insert.notice" :
			service = new InsertNoticeService();
			break;
		case "updateForm.notice" : 
			mav = new ModelAndView("notice/update.jsp", false);
			break;
		case "update.notice" :
			service = new UpdateNoticeService();
			break;
		case "delete.notice" :
			service = new DeleteNoticeService();
			break;
		case "find.notice" :
			service = new NoticeFindService();
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
