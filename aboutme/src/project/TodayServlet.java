package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Date date_now = new Date(System.currentTimeMillis());
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		out.print("<html>");
		out.print("<head>");
		out.print("<a align=center href=index.html>메인화면</a><br>");
		out.print("</head>");
		out.print("<body>");
		out.print("<p style=\"font-size:2em; margin-top: 25%\"; align=center>현재시간 : " + date_format.format(date_now)+"</p>");
		out.print("</body>");
		out.print("</html>");
		
	}
}
