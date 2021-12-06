package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commom.ModelAndView;

public interface SService {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
