package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationUserCommentDaoSqls.*;

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

import kr.or.connect.reservation.dto.ReservationUserComment;

@Repository
public class ReservationUserCommentDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<ReservationUserComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);

    public ReservationUserCommentDao(DataSource dataSource) {
    	System.out.println("ReservationUserCommentDao.java => ReservationUserCommentDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_user_comment");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<ReservationUserComment> selectAll() {
 		System.out.println("ReservationUserCommentDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(ReservationUserComment reservationUserComment) {
 		System.out.println("ReservationUserCommentDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationUserComment);
 		return insertAction.execute(params);
 	}
 	
 	public int update(ReservationUserComment reservationUserComment) {
 		System.out.println("ReservationUserCommentDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationUserComment);
 		return jdbc.update(UPDATE, params);
 	}
 	
 	public int deleteById(Integer id) {
 		System.out.println("ReservationUserCommentDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public ReservationUserComment selectById(Integer id) {
 		System.out.println("ReservationUserCommentDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
