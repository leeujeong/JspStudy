package service.notice;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.NoticeDao;
import dao.ReplyDao;
import dto.Reply;

public class DeleteNoticeService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//삭제할 게시글에 번호
		Long nNo = Long.parseLong(request.getParameter("nNo"));
		
		//삭제할 게시글에 댓글 유무 확인하기
		List<Reply> replyList = ReplyDao.getInstance().selectReplyList(nNo);
		PrintWriter out = response.getWriter();

		//댓글이 없으면 삭제 진행
		if(replyList.size() == 0) {
			int result = NoticeDao.getInstance().deleteNotice(nNo);
			
			if(result>0) {
				out.println("<script>");
				out.println("alert('공지사항 삭제 성공')");
				out.println("location.href='list.notice'");
				out.println("</script>");
				out.close();
			}else {
				out.println("<script>");
				out.println("alert('공지사항 삭제 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		}else { //댓글 있을때
			out.println("<script>");
			out.println("alert('댓글이 달린 게시글은 삭제 불가.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		return null;
	}

}
