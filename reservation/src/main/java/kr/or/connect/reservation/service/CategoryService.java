package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;

public interface CategoryService {

	public List<Category> getCategoryList();
	public Category addCategory(Category category);
	public int deleteCategory(Integer id);
	public Category selectCategory(Integer id);
	
}
