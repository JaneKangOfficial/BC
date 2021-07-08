package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ProductPriceDaoSqls.*;

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

import kr.or.connect.reservation.dto.ProductPrice;

@Repository
public class ProductPriceDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    public ProductPriceDao(DataSource dataSource) {
    	System.out.println("ProductPriceDao.java => ProductPriceDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("product_price");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<ProductPrice> selectAll() {
 		System.out.println("ProductPriceDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(ProductPrice productPrice) {
 		System.out.println("ProductPriceDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(productPrice);
 		return insertAction.execute(params);
 	}
 	
 	public int update(ProductPrice productPrice) {
 		System.out.println("ProductPriceDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(productPrice);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		System.out.println("ProductPriceDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public int deleteByProductId(Integer productId) {
 		System.out.println("ProductDao.java => deleteByProductId");
 		Map<String, ?> params = Collections.singletonMap("productId", productId);
 		return jdbc.update(DELETE_BY_PRODUCT_ID, params);
 	}
 	
 	public ProductPrice selectById(Integer id) {
 		System.out.println("ProductPriceDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
