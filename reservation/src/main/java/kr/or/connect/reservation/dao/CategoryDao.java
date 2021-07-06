package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.CategoryDaoSqls.*;

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

import kr.or.connect.reservation.dto.Category;

@Repository
public class CategoryDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

    public CategoryDao(DataSource dataSource) {
    	System.out.println("CategoryDao.java => CategoryDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("category");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<Category> selectAll() {
 		System.out.println("CategoryDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(Category category) {
 		System.out.println("CategoryDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
 		return insertAction.execute(params);
 	}
 	
 	public int update(Category category) {
 		System.out.println("CategoryDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		System.out.println("CategoryDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public Category selectById(Integer id) {
 		System.out.println("CategoryDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
