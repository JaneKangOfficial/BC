package kr.or.connect.reservation.dao.sqls;

public class ReservationUserCommentImageDaoSqls {

	public static final String SELECT_ALL = "SELECT id, reservation_info_id, reservation_user_comment_id, file_id FROM reservation_user_comment_image ORDER BY id";
	
	public static final String SELETE_BY_ID = "SELECT id, reservation_info_id, reservation_user_comment_id, file_id FROM reservation_user_comment_image ORDER BY id WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM reservation_user_comment_image WHERE id = :id";

}
