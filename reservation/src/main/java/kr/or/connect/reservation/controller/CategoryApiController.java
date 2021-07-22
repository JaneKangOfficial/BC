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

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path="/category")
public class CategoryApiController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="id", required=false, defaultValue="0") int id) {
		System.out.println("CategoryApiController.java => list");
		
		List<Category> list = categoryService.getCategoryList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@GetMapping("/{id}")
	public Category select(@PathVariable(name="id") int id) {
		System.out.println("CategoryApiController.java => select");
		
		Category select = categoryService.selectCategory(id);
		
		return select;
	}
	

}
