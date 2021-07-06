package kr.or.connect.reservation.dao.sqls;

public class CategoryDaoSqls {

	public static final String SELECT_ALL = "SELECT id, name FROM category ORDER BY id";
	
	public static final String UPDATE = "UPDATE category set name = :name WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, name FROM category ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM category WHERE id = :id";

	public static final String SELECT_COUNT = "SELECT count(*) FROM category";
	
}
