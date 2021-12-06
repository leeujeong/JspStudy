package service.board;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import common.ModelAndView;

public interface BoardService {

	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
