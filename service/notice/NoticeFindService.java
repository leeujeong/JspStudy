package service.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import common.Page;
import dao.NoticeDao;
import dto.Notice;

public class NoticeFindService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//검색
		//파라미터 처리
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		
		//DB로 보낼 HashMap
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("query", "%" + query + "%");	//wildcard문자 붙여서 전송

		//1 .검색된 공지사항 갯수 구하기
		int totalRecord = NoticeDao.getInstance().selectFindCount(map);
		
		//2. 현제 페이지 번호 확인하기
		//  1) page가 안넘어오면 page=1로 처리함.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		//3. 페이징에 필요한 모든 계산 처리하기
		Page p = new Page();
		p.setPageEntity(totalRecord, page);
		
		//4. String으로 < 1 2 3 4 5 > 만들기 
		String pageEntity = p.getPageEntity("find.notice?column=" + column + "&query=" + query);
		
		//DB로 보낼 beginRecord, endRecord작업
		map.put("beginRecord", p.getBeginRecord() + "");
		map.put("endRecord", p.getEndRecord()+"");
		
		
		List<Notice> list =NoticeDao.getInstance().findNotice(map);
		
		//list.jsp로 보낼 데이터
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("pageEntity", pageEntity);
		request.setAttribute("startNum",totalRecord - (page-1) * p.getRecordPerPage());
		request.setAttribute("list",list);
		
		return new ModelAndView("notice/list.jsp",false);
	}

}
