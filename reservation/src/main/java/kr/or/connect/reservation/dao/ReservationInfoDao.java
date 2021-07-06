package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationInfoDaoSqls.DELETE_BY_ID;
import static kr.or.connect.reservation.dao.sqls.ReservationInfoDaoSqls.SELECT_ALL;
import static kr.or.connect.reservation.dao.sqls.ReservationInfoDaoSqls.SELETE_BY_ID;
import static kr.or.connect.reservation.dao.sqls.ReservationInfoDaoSqls.UPDATE;

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
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<ReservationInfo> selectAll() {
 		System.out.println("ReservationInfoDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(ReservationInfo reservationInfo) {
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
 		return insertAction.execute(params);
 	}
 	
 	public int update(ReservationInfo reservationInfo) {
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public ReservationInfo selectById(Integer id) {
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
