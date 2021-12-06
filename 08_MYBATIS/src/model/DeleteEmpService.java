package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDao;

public class DeleteEmpService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//삭제할 사원번호 null
		Optional<String> optNum = Optional.ofNullable(request.getParameter("num"));
		Long num = Long.parseLong(optNum.orElse("0"));
		
		//DB접속을 위해서 DAO
		EmpDao dao = EmpDao.getInstance();
		int result = dao.deleteEmp(num);
		
		PrintWriter out = response.getWriter();
		
		//DML작업후에는 redirect해야한다.
		//자바스크립트의 location.href는 redirect이동과 같은 역할이다.
		if(result > 0) {
			out.println("<script>");
			out.println("alert('삭제 성공');");
			out.println("location.href='/MYBATIS/selectEmpList.do';");
			out.println("</script>");
			out.close();
		}else {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		//삭제 작업의 성공과 실패 모두 응답으로 처리했으므로 이동이 끝난 상황이다. 이런경우 controller에 null을 반환한다.
				
		return null;
	}

}
