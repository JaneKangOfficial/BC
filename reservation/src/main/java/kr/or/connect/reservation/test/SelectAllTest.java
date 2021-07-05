package kr.or.connect.reservation.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dto.ReservationInfo;

public class SelectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		ReservationInfoDao reservationInfoDao = ac.getBean(ReservationInfoDao.class);
		
		List<ReservationInfo> list = reservationInfoDao.selectAll();
		
		for(ReservationInfo reservationInfo : list) {
			System.out.println(reservationInfo);
		}
	}
}