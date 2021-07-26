package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/promotion")
public class PromotionApiController {

	@Autowired
	PromotionService promotionService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="id", required=false, defaultValue="0") int id) {
		System.out.println("PromotionApiController.java => list");
		
		List<Promotion> list = promotionService.getPromotionList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@GetMapping("/{id}")
	public Promotion select(@PathVariable(name="id") int id) {
		System.out.println("PromotionApiController.java => select");
		
		Promotion select = promotionService.selectPromotion(id);
		
		return select;
	}
	
	
}
