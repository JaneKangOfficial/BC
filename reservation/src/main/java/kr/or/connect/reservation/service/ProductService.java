package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {

	public List<Product> getProductList();
	public Product addProduct(Product product);
	public int updateProduct(Product product);
	public int deleteProduct(Integer id);
	public int deleteProductByCategoryId(Integer categoryId);
	public Product selectProduct(Integer id);
}
