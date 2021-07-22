package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.ReservationInfo;

import java.util.List;

public interface ReservationInfoService {

//	public List<ReservationInfo> getReservationInfoList(Integer id);
	public List<ReservationInfo> getReservationInfoList();
	public ReservationInfo addReservationInfo(ReservationInfo reservationInfo);
	public int updateReservationInfo(ReservationInfo reservationInfo);
	public int deleteReservationInfo(Integer id);
	public int deleteReservationInfoByProductId(Integer productId);
	public ReservationInfo selectReservationInfo(Integer id);
}
