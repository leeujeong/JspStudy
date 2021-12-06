package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.ReplyDTO;

public class InsertReplyService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		String ip = request.getRemoteAddr();
		Long board_no = Long.parseLong(request.getParameter("boardNo"));
		
		ReplyDTO reply = new ReplyDTO();
		reply.setContent(content);
		reply.setAuthor(author);
		reply.setIp(ip);
		reply.setBoard_no(board_no);
		
		int result = BoardDAO.getInstance().insertReply(reply);
		
		PrintWriter out = response.getWriter();
		
		if(result >0) {
			out.println("<script>");
			out.println("alert('댓글이 등록되었습니다.')");
			out.println("location.href='view.do?no=" + board_no +"'");
			out.println("</script>");
			
		}else {
			out.println("<script>");
			out.println("alert('댓글이 등록되지 않았습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}
}