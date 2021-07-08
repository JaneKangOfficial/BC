package kr.or.connect.reservation.dao.sqls;

public class PromotionDaoSqls {

	public static final String SELECT_ALL = "SELECT id, product_id FROM promotion ORDER BY id";
	
	public static final String UPDATE = "UPDATE promotion set product_id = :productId WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, product_id FROM promotion ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM promotion WHERE id = :id";

	public static final String SELECT_COUNT = "SELECT count(*) FROM promotion";
	
}
