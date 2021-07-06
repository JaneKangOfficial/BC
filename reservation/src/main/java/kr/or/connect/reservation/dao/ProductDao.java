package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ProductDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Product;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    public ProductDao(DataSource dataSource) {
    	System.out.println("ProductDao.java => ProductDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("product");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<Product> selectAll() {
 		System.out.println("ProductDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(Product product) {
 		System.out.println("ProductDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
 		return insertAction.execute(params);
 	}
 	
 	public int update(Product product) {
 		System.out.println("ProductDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		System.out.println("ProductDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public int deleteByCategoryId(Integer categoryId) {
 		System.out.println("ProductDao.java => deleteByCategoryId");
 		Map<String, ?> params = Collections.singletonMap("categoryId", categoryId);
 		return jdbc.update(DELETE_BY_CATEGORY_ID, params);
 	}
 	
 	public Product selectById(Integer id) {
 		System.out.println("ProductDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
