package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.DisplayInfoDaoSqls.*;

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

import kr.or.connect.reservation.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);

    public DisplayInfoDao(DataSource dataSource) {
    	System.out.println("DisplayInfoDao.java => DisplayInfoDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("display_info");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<DisplayInfo> selectAll() {
 		System.out.println("DisplayInfoDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(DisplayInfo displayInfo) {
 		System.out.println("DisplayInfoDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(displayInfo);
 		return insertAction.execute(params);
 	}
 	
 	public int update(DisplayInfo displayInfo) {
 		System.out.println("DisplayInfoDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(displayInfo);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		System.out.println("DisplayInfoDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public DisplayInfo selectById(Integer id) {
 		System.out.println("DisplayInfoDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
