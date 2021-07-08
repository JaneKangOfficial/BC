package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationInfoPriceDaoSqls.*;

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

import kr.or.connect.reservation.dto.ReservationInfoPrice;

@Repository
public class ReservationInfoPriceDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<ReservationInfoPrice> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoPrice.class);

    public ReservationInfoPriceDao(DataSource dataSource) {
    	System.out.println("ReservationInfoPriceDao.java => ReservationInfoPriceDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info_price");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<ReservationInfoPrice> selectAll() {
 		System.out.println("ReservationInfoPriceDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(ReservationInfoPrice reservationInfoPrice) {
 		System.out.println("ReservationInfoPriceDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
 		return insertAction.execute(params);
 	}
 	
 	public int update(ReservationInfoPrice reservationInfoPrice) {
 		System.out.println("ReservationInfoPriceDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		System.out.println("ReservationInfoPriceDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public ReservationInfoPrice selectById(Integer id) {
 		System.out.println("ReservationInfoPriceDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
