package com.rz.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.rz.domain.User;
import com.rz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(User user) {
		jdbcTemplate.update("insert into jdbc_user(name,age) values(?,?) ", user.getName(),user.getAge());
	}
	

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from jdbc_user  where name=?",name);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from jdbc_user  where id=?",id);
	}

	@Override
	public int getAllUsers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(1) from jdbc_user", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
        jdbcTemplate.update("delete from jdbc_user");
	}



	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		
		
//		org.springframework.jdbc.IncorrectResultSetColumnCountException: Incorrect column count: expected 1, actual 3
//		这种反射类型的是将每一个数据列返回为T类型，故出错，因此此方法只支持这种基本数据类型的（如Integer,String等等），不支持自己定义复杂类型的Bean实体。因此可以返回单列的（例如count(*) 和 某一列值等等）。
//		List<User> list = jdbcTemplate.queryForList("select * from jdbc_user", User.class);
//      解决如下:
		List<User> list = jdbcTemplate.query("select * from jdbc_user",new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				return user;
			}
			
		});
		
		return list;
	}


	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		User user =jdbcTemplate.queryForObject("select * from jdbc_user where id=?",new Object[]{id},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				return user;
			}
		});
		return user;
	}

}
