package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class Circle implements Shape {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strRadius = request.getParameter("radius");
		double radius = Double.parseDouble(strRadius);
		
		double area = Math.PI * radius * radius;
		
		request.setAttribute("area", area);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView("views/circle.jsp");
		modelAndView.setRedirect(false);
		
		return modelAndView;
		

	}

}
