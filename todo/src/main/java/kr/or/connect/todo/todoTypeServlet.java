package kr.or.connect.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/todoType")
public class todoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public todoTypeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		
		System.out.println("Type : " + type + " / ID : " + id);
		
		TodoDto dto = new TodoDto();
		dto.setId(id);
		
		if(type == ("TODO")) {
			dto.setType("DOING");
		} else if (type == ("DOING")) {
			dto.setType("DONE");
		}
		
		TodoDao dao = new TodoDao();
		Object result = dao.updateTodo(dto);
		
		System.out.println("RESULT : " + result);
		
		response.sendRedirect("/main.jsp");
		
	}

}
