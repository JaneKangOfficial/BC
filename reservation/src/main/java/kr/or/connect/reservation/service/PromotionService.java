package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Promotion;

public interface PromotionService {

	public List<Promotion> getPromotionList();
	public Promotion addProduct(Promotion promotion);
	public int updatePromotion(Promotion promotion);
	public int deletePromotion(Integer id);
	public Promotion selectPromotion(Integer id);
}
