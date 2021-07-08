package kr.or.connect.reservation.dao.sqls;

public class ReservationInfoPriceDaoSqls {

	public static final String SELECT_ALL = "SELECT id, reservation_info_id, product_price_id, count FROM reservation_info_price ORDER BY id";
	
	public static final String UPDATE = "UPDATE reservation_info_price set product_price_id = :productPriceId WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, reservation_info_id, product_price_id, count FROM reservation_info_price ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM reservation_info_price WHERE id = :id";

	public static final String SELECT_COUNT = "SELECT count(*) FROM reservation_info_price";
	
}
