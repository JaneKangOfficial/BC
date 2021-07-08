package kr.or.connect.reservation.dao.sqls;

public class ReservationUserCommentDaoSqls {

	public static final String SELECT_ALL = "SELECT id, product_id, score, comment, create_date, modify_date FROM reservation_user_comment ORDER BY id";
	
	public static final String UPDATE = "UPDATE reservation_user_comment set comment = :comment WHERE id = :id";
	
	public static final String SELETE_BY_ID = "SELECT id, product_id, score, comment, create_date, modify_date FROM reservation_user_comment ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM reservation_user_comment WHERE id = :id";

	public static final String SELECT_COUNT = "SELECT count(*) FROM reservation_user_comment";
	
}
