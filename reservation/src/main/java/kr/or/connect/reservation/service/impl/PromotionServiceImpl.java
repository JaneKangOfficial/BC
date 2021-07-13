package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

public class PromotionServiceImpl implements PromotionService{

	@Autowired
	PromotionDao promotionDao;

	@Override
	public List<Promotion> getPromotionList() {
		System.out.println("PromotionServiceImpl.java => getPromotionList");
		List<Promotion> list = promotionDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public Promotion addProduct(Promotion promotion) {
		System.out.println("PromotionServiceImpl.java => addProduct");
		int id = promotionDao.insert(promotion);
		promotion.setId(id);
		return promotion;
	}

	@Override
	@Transactional(readOnly=false)
	public int updatePromotion(Promotion promotion) {
		System.out.println("PromotionServiceImpl.java => updatePromotion");
		int updatePromotion = promotionDao.update(promotion);
		return updatePromotion;
	}

	@Override
	@Transactional(readOnly=false)
	public int deletePromotion(Integer id) {
		System.out.println("PromotionServiceImpl.java => deletePromotion");
		int deletePromotion = promotionDao.deleteById(id);
		return deletePromotion;
	}

	@Override
	public Promotion selectPromotion(Integer id) {
		System.out.println("PromotionServiceImpl.java => selectPromotion");
		Promotion selectProtmoion = promotionDao.selectById(id);
		return selectProtmoion;
	}

}
