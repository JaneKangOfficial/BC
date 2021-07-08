package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationUserCommentImageDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationUserCommentImage;

@Repository
public class ReservationUserCommentImageDao {

	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationUserCommentImage> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImage.class);

    public ReservationUserCommentImageDao(DataSource dataSource) {
    	System.out.println("ReservationUserCommentImageDao.java => ReservationUserCommentImageDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<ReservationUserCommentImage> selectAll() {
 		System.out.println("ReservationUserCommentImageDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int deleteById(Integer id) {
 		System.out.println("ReservationUserCommentImageDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public ReservationUserCommentImage selectById(Integer id) {
 		System.out.println("ReservationUserCommentImageDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
