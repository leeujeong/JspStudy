package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.Circle;
import model.Rectangle;
import model.Shape;

@WebServlet("*.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyController() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		
		Shape shape = null;
		
		ModelAndView modelAndView = null;
		
		switch(command) {
		case "rectangle.do" :
			shape = new Rectangle();
			break;
		case "cicle.do" :
			shape = new Circle();
			break;
		case "input.do" : 
			modelAndView = new ModelAndView();
			modelAndView.setView("views/input.jsp");
			modelAndView.setRedirect(true);
			break;
		}

		if (shape != null) {
			modelAndView = shape.execute(request, response);
		}
		//modelAndView가 없는경우 (Model이 직접 결과를 반환하는 경우 =>response를 직접 작업하는 경우) (ajax처리)
		if(modelAndView == null) {
			
			return;
		}
		
		//modelAndView가 있는경우 ( ajax 처리가 아닌 모든경우)
		if(modelAndView.isRedirect()) {
			response.sendRedirect(modelAndView.getView());
		}else {
			request.getRequestDispatcher(modelAndView.getView()).forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
