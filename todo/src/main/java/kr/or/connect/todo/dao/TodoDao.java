package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.todo.dto.TodoDto;

public class TodoDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public List <TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 get 검색 성공!!!");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
			System.out.println("드라이버 get 검색 실패!!!" + ce);
		}
		
		String sql = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate DESC";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			System.out.println("드라이버 get 접속 성공!!!");
			
			try(ResultSet rs = ps.executeQuery()) {
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String name = rs.getString("name");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type");
					Date regdate = rs.getDate("regdate");
					
					TodoDto dto = new TodoDto(id, title, name, sequence, type, regdate);
					list.add(dto);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 get 접속 실패!!!" + e);
		}
	
		return list;
	}
	
	
	// try-with resource 이용
	public int addTodo(TodoDto todoDto) {
		System.out.println("TodoDao addTodo");
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 add 검색 성공!!!");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
			System.out.println("드라이버 add 검색 실패!!!");
		}
		
		String sql = "INSERT INTO todo(title, name, sequence) VALUES(?,?,?)";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			System.out.println("드라이버 add 접속 성공!!!");
			ps.setString(1, todoDto.getTitle());
			ps.setString(2, todoDto.getName());
			ps.setInt(3, todoDto.getSequence());
			
			insertCount = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 add 접속 실패!!!"+e);
		}
		
		return insertCount;
	}
	

	public int updateTodo(TodoDto todoDto) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 update 검색 성공!!!");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
			System.out.println("드라이버 update 검색 실패!!!");
		}
		
		String sql = "UPDATE todo SET name = ?, regDate = ?, title = ?, type = ? WHERE id = ?";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			System.out.println("드라이버 update 접속 성공!!!");
			
			ps.setString(1, todoDto.getName());
			ps.setDate(2, todoDto.getRegdate());
			ps.setString(3, todoDto.getTitle());
			ps.setString(4, todoDto.getType());
			
			updateCount = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 update 접속 실패!!!" + e);
		}
		
		return updateCount;
	}
}