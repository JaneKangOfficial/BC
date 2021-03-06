package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	@Transactional	//read only
	public List<Category> getCategoryList() {
		System.out.println("CategoryServiceImpl.java => getCategoryList");
		List<Category> list = categoryDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public Category addCategory(Category category) {
		System.out.println("CategoryServiceImpl.java => addCategory");
		int id = categoryDao.insert(category);
		category.setId(id);
		return category;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteCategory(Integer id) {
		System.out.println("CategoryServiceImpl.java => deleteCategory");
		int deleteCategory = categoryDao.deleteById(id);
		return deleteCategory;
	}

	@Override
	public Category selectCategory(Integer id) {
		System.out.println("CategoryServiceImpl.java => selectCategory");
		Category selectCategory = categoryDao.selectById(id);
		return selectCategory;
	}
}
