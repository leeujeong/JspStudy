package Quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz2
 */
@WebServlet("/Quiz2")
public class Quiz2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		
		String from = request.getParameter("from");
		if(from.isEmpty()) {
			from = "이유정";
		}
		String to = request.getParameter("to");
		if(to.isEmpty()) {
			to ="정승호";
		}
		String content = request.getParameter("content");
		if(from.isEmpty()) {
			content = "사랑해!";
		}
		String fileName =  date + "_" + from  + ".txt";
		
		File dir = new File("C:\\SmartWeb0825\\jspstudy\\01_SERVLET\\storage");
		if(dir.exists() ==  false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, fileName);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		bw.write("작성일 : " + date + "\n");
		bw.write("보내는 사람 : " + from  + "\n");
		bw.write("받는 사람 : " + to + "\n");
		bw.write(content+ "\n");
	
		if(bw != null)bw.close();
		
		response.setContentType("text/html; charser=UTF-8");
		PrintWriter out = response.getWriter()
;
		out.println("<script>");
		out.println("alert('"+file.getAbsolutePath() + "파일이 생성되었습니다.');");
		out.println("history.back();");
		out.println("</script>");
		out.close();
	// 작성자 IP 알아내는 법
	//1. 직접 접속한 경우 : request.getRemoteAddr()
	//2. 거쳐서 접속한 경우 : request.getHeader("X-Forwarded-For")
//	String ip = request.getHeader("X-Forwarded-For");
//	if(ip == null) {
//		ip = request.getRemoteAddr();
//				
//	}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
