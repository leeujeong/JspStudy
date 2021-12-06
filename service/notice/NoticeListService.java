package service.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import common.Page;
import dao.NoticeDao;
import dto.Notice;

public class NoticeListService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		//상세보기 할때 session에 올려둔 notice를 제거
		Notice notice = (Notice)session.getAttribute("notice");
		if(notice != null) {
			session.removeAttribute("notice");
		}
		//상세 보기할때 session에 올려둔 open 제거
		if(session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		//1 .전체 공지사항 갯수 구하기
		int totalRecord = NoticeDao.getInstance().selectTotalCount();
		
		//2. 현제 페이지 번호 확인하기
		//  1) page가 안넘어오면 page=1로 처리함.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		//3. 페이징에 필요한 모든 계산 처리하기
		Page p = new Page();
		p.setPageEntity(totalRecord, page);
		
		//4. String으로 < 1 2 3 4 5 > 만들기 
		String pageEntity = p.getPageEntity("list.notice");
		
		//beginRefcord ~ endRecord 목록 가져오기
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRecord", p.getBeginRecord());
		map.put("endRecord", p.getEndRecord());
		
		List<Notice> list = NoticeDao.getInstance().selectNoticeList(map);
		
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("pageEntity", pageEntity);
		request.setAttribute("list", list);
		request.setAttribute("startNum", totalRecord- (page -1) * p.getRecordPerPage()); //각페이지 게시글 시작번호
		
		return new ModelAndView("notice/list.jsp", false);
	}

}
