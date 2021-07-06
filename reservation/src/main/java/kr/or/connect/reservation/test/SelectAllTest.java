package kr.or.connect.reservation.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;

public class SelectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
/*		
		ReservationInfoDao reservationInfoDao = ac.getBean(ReservationInfoDao.class);
		List<ReservationInfo> list = reservationInfoDao.selectAll();
		
		for(ReservationInfo reservationInfo : list) {
			System.out.println(reservationInfo);
		}
*/		
/*		
		ProductDao productDao = ac.getBean(ProductDao.class);
		List<Product> list = productDao.selectAll();
		
		for(Product product : list) {
			System.out.println(product);
		}
*/		
		CategoryDao categoryDao = ac.getBean(CategoryDao.class);
		List<Category> list = categoryDao.selectAll();
		
		for(Category category : list) {
			System.out.println(category);
		}
		
	}
}