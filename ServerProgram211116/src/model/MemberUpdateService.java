package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberUpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		Long point = Long.parseLong(request.getParameter("point"));
		
		String grade = null;
		if(point >=5000) {
			grade = "vip";
		}else if(point >= 4000) {
			grade = "gold";
		}else if(point >=3000) {
			grade = "silver";
		}else {
			grade = "bronze";
		}
		
		MemberDTO member = new MemberDTO();
		member.setGrade(grade);
		member.setName(name);

		
		int result = MemberDAO.getInstance().updateMember(member);
		
		return null;
	}

}
