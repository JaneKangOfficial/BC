package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getProductList() {
		System.out.println("ProductServiceImpl.java => getProductList");
		List<Product> list = productDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public Product addProduct(Product product) {
		System.out.println("ProductServiceImpl.java => addProduct");
		int id = productDao.insert(product);
		product.setId(id);
		return product;
	}

	@Override
	@Transactional(readOnly=false)
	public int updateProduct(Product product) {
		System.out.println("ProductServiceImpl.java => updateProduct");
		int updateProduct = productDao.update(product);
		return updateProduct;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteProduct(Integer id) {
		System.out.println("ProductServiceImpl.java => deleteProduct");
		int deleteProduct = productDao.deleteById(id);
		return deleteProduct;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteProductByCategoryId(Integer categoryId) {
		System.out.println("ProductServiceImpl.java => deleteProductByCategoryId");
		int deleteProductByCategoryId = productDao.deleteByCategoryId(categoryId);
		return deleteProductByCategoryId;
	}

	@Override
	public Product selectProduct(Integer id) {
		System.out.println("ProductServiceImpl.java => selectProduct");
		Product selectProduct = productDao.selectById(id);
		return selectProduct;
	}
	
}
