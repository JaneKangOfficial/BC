package kr.or.connect.reservation.dao.sqls;

public class ProductDaoSqls {

	public static final String SELECT_ALL = "SELECT id, category_id, description, content, event, create_date, modify_date FROM product ORDER BY id";
	
	public static final String UPDATE = "UPDATE product set content = :content WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, category_id, description, content, event, create_date, modify_date FROM product ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM product WHERE id = :id";

	public static final String DELETE_BY_CATEGORY_ID = "DELETE FROM product WHERE category_id = :categoryId";
	
	public static final String SELECT_COUNT = "SELECT count(*) FROM product";
	
}
