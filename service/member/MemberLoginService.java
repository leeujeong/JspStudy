package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberLoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pw  = request.getParameter("pw");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		//id,pw가 일치하는 회원 조회
		Member loginUser = MemberDao.getInstance().selectMember(member);

		
		//id,pw 일치하는 회원 있으면
		if(loginUser != null) {
			//회원정보를 session에 loginUser로 저장
			request.getSession().setAttribute("loginUser", loginUser);
			//로그인 기록 남기기
			MemberDao.getInstance().loginLog(id);
			//index.jsp로 redirect 이동
			return new ModelAndView("index.jsp", true);
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 이름을 확인하세요')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}

}
