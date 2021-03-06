package ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet7
 */
@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet7() {
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
		
		// String 변수 파라미터:getParameter()
		
		String name= request.getParameter("name");
		String pw = request.getParameter("pw");
		String secret = request.getParameter("secret");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String info = request.getParameter("info");
		
		//String[]배열 파라미터 : getPrarameterValues()
		
		String[] nicknames = request.getParameterValues("nicknames");
		String[] hobbies = request.getParameterValues("hobbies");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
