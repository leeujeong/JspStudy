package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.StudentDao;
import dto.Student;

public class StudentDetailService implements StudentService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sno = request.getParameter("sno");
		if(sno == null) sno = "99999";
	
		Student student = StudentDao.getInstance().selectStudentBySno(sno);
		
		request.setAttribute("student", student);
		
		return new ModelAndView("views/StudentDetail.jsp", false);
		
	}

}
