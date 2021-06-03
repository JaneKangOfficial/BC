package kr.or.connect.todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/todoAdd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json");
		
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence").trim());
		
		System.out.println("title : " + title + " name : " + name + " sequence : " + sequence);

		TodoDto dto = new TodoDto();
		
		dto.setTitle(title);
		dto.setName(name);
		dto.setSequence(sequence);
		
		TodoDao dao = new TodoDao();
		int add = dao.addTodo(dto);

		request.setAttribute("add", add);
		
		response.sendRedirect("/todo/main");
	}


}
