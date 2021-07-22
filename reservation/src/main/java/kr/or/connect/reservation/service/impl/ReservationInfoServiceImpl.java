package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationInfoService;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService{

	@Autowired
	ReservationInfoDao reservationInfoDao;

	@Override
//	public List<ReservationInfo> getReservationInfoList(Integer id) {
	public List<ReservationInfo> getReservationInfoList() {
		System.out.println("ReservationInfoServiceImpl.java => getReservationInfoList");
		List<ReservationInfo> list = reservationInfoDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public ReservationInfo addReservationInfo(ReservationInfo reservationInfo) {
		System.out.println("ReservationInfoServiceImpl.java => addReservationInfo");
		int id = reservationInfoDao.insert(reservationInfo);
		reservationInfo.setId(id);
		return reservationInfo;
	}

	@Override
	@Transactional(readOnly=false)
	public int updateReservationInfo(ReservationInfo reservationInfo) {
		System.out.println("ReservationInfoServiceImpl.java => updateReservationInfo");
		int updateReservationInfo = reservationInfoDao.update(reservationInfo);
		return updateReservationInfo;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteReservationInfo(Integer id) {
		System.out.println("ReservationInfoServiceImpl.java => deleteReservationInfo");
		int deleteReservationInfo = reservationInfoDao.deleteById(id);
		return deleteReservationInfo;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteReservationInfoByProductId(Integer productId) {
		System.out.println("ReservationInfoServiceImpl.java => deleteReservationInfoByProductId");
		int deleteReservationInfoByProductId = reservationInfoDao.deleteByProductId(productId);
		return deleteReservationInfoByProductId;
	}

	@Override
	public ReservationInfo selectReservationInfo(Integer id) {
		System.out.println("ReservationInfoServiceImpl.java => selectReservationInfo");
		ReservationInfo selectReservationInfo = reservationInfoDao.selectById(id);
		return selectReservationInfo;
	}

}
