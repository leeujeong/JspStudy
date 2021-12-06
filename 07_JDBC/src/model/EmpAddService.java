package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;
import dto.EmpDTO;

public class EmpAddService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setName(name);
		
		EmpDAO empDAO = EmpDAO.getInstance();
		int result = empDAO.insertEmp(empDTO);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if(result > 0) {
				out.println("<script>");
				out.println("alert('등록성공');");
				out.println("location.href='/07_JDBC/selectList.emp';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('사원등록이 실패했습니다');");
				out.println("history.back()");
				out.println("</script>");
			}	
		}catch (Exception e) {
				e.printStackTrace();
			} 
		return null;
	}

}