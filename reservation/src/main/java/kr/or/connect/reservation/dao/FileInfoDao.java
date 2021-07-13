package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.FileInfoDaoSqls.*;

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

import kr.or.connect.reservation.dto.FileInfo;

@Repository
public class FileInfoDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
    private RowMapper<FileInfo> rowMapper = BeanPropertyRowMapper.newInstance(FileInfo.class);

    public FileInfoDao(DataSource dataSource) {
    	System.out.println("FileInfoDao.java => FileInfoDao");
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("file_info");
    }
    
 // static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
 	public List<FileInfo> selectAll() {
 		System.out.println("FileInfoDao.java => selectAll");
 		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
 	}
    
 	public int insert(FileInfo fileInfo) {
 		System.out.println("FileInfoDao.java => insert");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfo);
 		return insertAction.execute(params);
 	}
 /*	
 	public int update(FileInfo fileInfo) {
 		System.out.println("FileInfoDao.java => update");
 		SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfo);
 		return jdbc.update(UPDATE, params);
 	}
 */	
 	public int deleteById(Integer id) {
 		System.out.println("FileInfoDao.java => deleteById");
 		Map<String, ?> params = Collections.singletonMap("id", id);
 		return jdbc.update(DELETE_BY_ID, params);
 	}
 	
 	public FileInfo selectById(Integer id) {
 		System.out.println("FileInfoDao.java => selectById");
 		try {
 			Map<String, ?> params = Collections.singletonMap("id", id);
 			return jdbc.queryForObject(SELETE_BY_ID, params, rowMapper);
 		}catch(EmptyResultDataAccessException e) {
 			return null;
 		}
 	}

}
