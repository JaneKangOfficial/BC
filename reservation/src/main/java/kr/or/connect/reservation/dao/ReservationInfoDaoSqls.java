package kr.or.connect.reservation.dao;

public class ReservationInfoDaoSqls {

	public static final String SELECT_ALL = "SELECT id, product_id, display_info_id, reservation_name, reservation_tel, reservation_email, reservation_date, cancel_flag, create_date, modify_date FROM reservation_info ORDER BY id";
	
	public static final String UPDATE = "UPDATE reservation_info set reservation_date = :reservationDate WHERE id = :id";
	
	public static final String SELETE_BY_ROLE_ID = "SELECT id, product_id, display_info_id, reservation_name, reservation_tel, reservation_email, reservation_date, cancel_flag, create_date, modify_date FROM reservation_info WHERE id = :id";

	public static final String DELETE_BY_ROLE_ID = "DELETE FROM reservation_info WHERE id = :id";

	public static final String DELETE_BY_ID = "DELETE FROM reservation_info WHERE id = :id";
	
	public static final String SELECT_COUNT = "SELECT count(*) FROM reservation_info";
	
	public static final String SELECT_PAGING = "SELECT id, reservation_name, display_info_id, reservation_date FROM reservation_info ORDER BY id DESC limit :start, :limit";
}

/*
	reservation_user_comment_image;
	reservation_user_comment;
	reservation_info_price;
	reservation_info;
	promotion;
	product_price;
	product_image;
	display_info_image;
	display_info;
	product;
	file_info;
	category;
*/