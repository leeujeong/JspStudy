package model;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<MemberDTO> list = MemberDAO.getInstance().memberList();
		JSONArray arr = new JSONArray(list);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(arr);
		
		return null;
	}

}
