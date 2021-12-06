package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.StudentDao;

public class StudentDeleteService implements StudentService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Optional<String> optSno = Optional.ofNullable(request.getParameter("sno"));
		String sno = optSno.orElse("99999");
		
		int result = StudentDao.getInstance().deleteStudent(sno);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('삭제 성공')");
			out.println("location.href='/BATCH/studentList.do'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
