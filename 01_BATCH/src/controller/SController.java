package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commom.ModelAndView;
import model.SService;


@WebServlet("*.do")
public class SController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath =request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		ModelAndView mod = null;
		SService sService = null;
		switch(command) {
		case "studentlist.do" :
			
			break;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
