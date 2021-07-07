package kr.or.connect.reservation.dao.sqls;

public class DisplayInfoDaoSqls {

	public static final String SELECT_ALL = "SELECT id, product_id, opening_hours, place_name, place_street, tel, homepage, email, create_date, modify_date FROM display_info ORDER BY id";
	
	public static final String UPDATE = "UPDATE display_info set tel = :tel WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, product_id, opening_hours, place_name, place_street, tel, homepage, email, create_date, modify_date FROM display_info ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM display_info WHERE id = :id";

	public static final String SELECT_COUNT = "SELECT count(*) FROM display_info";
	
}
