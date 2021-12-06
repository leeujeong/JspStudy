package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.member.MemberIdCheckService;
import service.member.MemberJoinService;
import service.member.MemberLeaveService;
import service.member.MemberLoginService;
import service.member.MemberLogoutService;
import service.member.MemberService;


@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//JSP 요청확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() +1);
		
	
		MemberService service= null;

		ModelAndView mav = null;
 
		switch(command) {
		case "login.member" :
			service = new MemberLoginService();
			break;
		case "logout.member":
			service = new MemberLogoutService();
			break;
		case "joinForm.member":
			mav = new ModelAndView("member/join.jsp", false);
			break;
		case "join.member" :
			service = new MemberJoinService();
			break;
		case "idCheck.member" :
			service = new MemberIdCheckService();
			break;
		case "leave.member" :
			service = new MemberLeaveService();
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
