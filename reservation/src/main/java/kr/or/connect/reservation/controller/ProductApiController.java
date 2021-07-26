package kr.or.connect.reservation.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path="/product")
public class ProductApiController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public Product insert(@RequestBody Product product) {
		Product addProduct = productService.addProduct(product);
		
		return addProduct;
	}
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="id", required=false, defaultValue="0") int id) {
		System.out.println("ProductApiController.java => list");
		
		List<Product> list = productService.getProductList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@GetMapping("/{id}")
	public Product select(@PathVariable(name="id") int id) {
		System.out.println("ProductApiController.java => select");
		
		Product select =productService.selectProduct(id);
		
		return select;
	}
	
	@PutMapping("/{id}")
	public int update(@PathVariable(name="id") Product product) {
		System.out.println("ProductApiController.java => update");
		
		int update = productService.updateProduct(product);
		
		return update;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable(name="id") int id) {
		System.out.println("ProductApiController.java => delete");
		
		int delete = productService.deleteProduct(id);
		
		return Collections.singletonMap("success", delete > 0 ? "true" : "false");
	}
}
