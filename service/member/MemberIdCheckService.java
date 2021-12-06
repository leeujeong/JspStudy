package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberIdCheckService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		Member member = new Member();
		member.setId(id);
		
		//가입하려는 아이디를 가진 회원 확인 
		Member user = MemberDao.getInstance().selectMember(member);
		
		//반환할 JSON 데이터
		//가입하려는 아이디를 가진회원이 없으면 (가입해도되는 아이디) {"result" : true}데이터를   ajax 로 반환
		JSONObject obj = new JSONObject();
		obj.put("result", user == null);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
		return null;
	}

}
