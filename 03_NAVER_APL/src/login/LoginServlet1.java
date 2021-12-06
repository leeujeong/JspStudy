package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet1() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String captchaKey = GetKey.getKey();
		response.setContentType("text.html; charset=utf=8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("akert('" + captchaKey + "');");
		out.println("hisetory.back();");
		out.println("</script>");
		out.close();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
