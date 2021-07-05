package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationInfoDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationInfo;

@Repository
public class ReservationInfoDao {

	private NamedParameterJdbcTemplate jdbc;
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
    
//    public List<ReservationInfo> selectAll(Integer start, Integer limit) {
//    	System.out.println("ReservationInfoDao.java => selectAll(start, limit)");
//    		Map<String, Integer> params = new HashMap<>();
//    		params.put("start", start);
//    		params.put("limit", limit);
//        return jdbc.query(SELECT_PAGING, params, rowMapper);
//    }

}
