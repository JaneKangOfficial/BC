package kr.or.connect.reservation.dao.sqls;

public class FileInfoDaoSqls {

	public static final String SELECT_ALL = "SELECT id, file_name FROM file_info ORDER BY id";
	
//	public static final String UPDATE = "UPDATE file_info set name = :name WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, file_name FROM file_info ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM file_info WHERE id = :id";

//	public static final String SELECT_COUNT = "SELECT count(*) FROM file_info";
	
}
