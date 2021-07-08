package kr.or.connect.reservation.dao.sqls;

public class ProductImageDaoSqls {

	public static final String SELECT_ALL = "SELECT id, product_id, type, file_id FROM product_image ORDER BY id";
	
	public static final String UPDATE = "UPDATE product_image set type = :type WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, product_id, type, file_id FROM product_image ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM product_image WHERE id = :id";

	public static final String SELECT_COUNT = "SELECT count(*) FROM product_image";
	
}
