package kr.or.connect.reservation.dao.sqls;

public class DisplayInfoImageDaoSqls {

	public static final String SELECT_ALL = "SELECT id, display_info_id, file_id FROM display_info_image ORDER BY id";
	
	public static final String SELETE_BY_ID = "SELECT id, display_info_id, file_id FROM display_info_image ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM display_info_image WHERE id = :id";

//	public static final String SELECT_COUNT = "SELECT count(*) FROM display_info_image";
	
}
