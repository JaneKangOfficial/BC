package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationInfoDaoSqls.*;

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

import kr.or.connect.reservation.dto.ReservationInfo;

@Repository
public class ReservationInfoDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);

    public ReservationInfoDao(DataSource dataSource) {
    	System.out.println("ReservationInfoDao.java => ReservationInfoDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<ReservationInfo> selectAll() {
 		System.out.println("ReservationInfoDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(ReservationInfo reservationInfo) {
 		System.out.println("ReservationInfoDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
 		return insertAction.execute(params);
 	}
 	
 	public int update(ReservationInfo reservationInfo) {
 		System.out.println("ReservationInfoDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		System.out.println("ReservationInfoDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public int deleteByProductId(Integer productId) {
 		System.out.println("ReservationInfoDao.java => deleteByProductId");
 		Map<String, ?> params = Collections.singletonMap("productId", productId);
 		return jdbc.update(DELETE_BY_PRODUCT_ID, params);
 	}
 	
 	public ReservationInfo selectById(Integer id) {
 		System.out.println("ReservationInfoDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
