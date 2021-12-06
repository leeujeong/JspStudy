package service.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface FreeService {

	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//response에서 String 사용하므료 예외처리를 해줘야한다. 매번 하기 귀찮으니까 throws excetion을 해줌
}
