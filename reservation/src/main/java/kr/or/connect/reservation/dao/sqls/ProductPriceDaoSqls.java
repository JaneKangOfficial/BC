package kr.or.connect.reservation.dao.sqls;

public class ProductPriceDaoSqls {

	public static final String SELECT_ALL = "SELECT id, product_id, price_type_name, price, discount_rate, create_date, modify_date FROM product_price ORDER BY id";
	
	public static final String UPDATE = "UPDATE product_price set price = :price WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, product_id, price_type_name, price, discount_rate, create_date, modify_date FROM product_price ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM product_price WHERE id = :id";

	public static final String DELETE_BY_PRODUCT_ID = "DELETE FROM product_price WHERE product_id = :productId";
	
	public static final String SELECT_COUNT = "SELECT count(*) FROM product_price";
	
}
